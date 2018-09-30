<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src=" https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>

</script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=44cc7c0f5f9097e79084faaa33f4f6be&libraries=services,clusterer,drawing"></script>


<style>
.hover {
	max-width: 400px;
	height: 80px;
	line-height: 80px;
	margin: 20px auto;
	background-color: #ffffff;
	text-align: center;
	transition: all 0.8s, color 0.3s 0.3s;
	color: 504f4f;
	cursor: pointer;
}

.hover:hover {
	color: #efefef;
}
</style>


<div class="wrapper">
	<div class="main">
		<div class="section">
			<div class="container-fluid">

				<div class="col-md-6 col-12 ml-auto mr-auto text-center">

					<div class="row" style="margin-top: 40px"></div>



					<div class="row" style="margin: 5px; padding: 10px;">
						<div class="col-lg-9">
							<input type="text" id="event_keyword_input"
								class="form-control border-input" placeholder="검색어를 입력하세요.." />&nbsp;&nbsp;
						</div>

						<div class="col-lg-3">
							<button id="event_search_btn" class="btn btn-warning"
								style="width: 100%">
								<i class="nc-icon nc-zoom-split">&nbsp;검색하기</i>
							</button>
						</div>

					</div>

					<div class="row">


						<div class="col-12">
							<select id="event_local_list" class="selectpicker"
								onchange="onChangeSelect()" data-width="100%"
								data-style="select-with-transition btn-primary btn-round"
								title="지역" data-size="7">
								<option disabled>지역</option>
							</select>

						</div>



						<div class="col-12" style="padding: 10px">

							<button id="btn_find_min_dist" class="btn w-100">내 위치 기준
								검색</button>


						</div>


					</div>





					<div class="container" style="margin: 10px">
						<div class="row w-100">
							<div id="map" style="width: 100%; height: 400px;"
								class="text-center"></div>

						</div>
					</div>



				</div>


				<div class="container">
					<div class="row" style="padding: 30px">

						<table class="table">

							<thead>
								<tr>
									<th class="text-center" style="width: 10%">No</th>
									<th style="width: 30%">이름</th>
									<th style="width: 50%">주소</th>
									<th style="width: 10%">분류</th>

								</tr>

							</thead>
							<tbody id="table_body">
								<tr id="place_row">
									<td class="text-center" id="row_num"></td>
									<td class="hover" id="row_name" style="font-weight: bold"></td>
									<td id="row_address"></td>
									<td id="row_type"></td>
									<td id="row_id" style="display: none"></td>
								</tr>





							</tbody>


						</table>


					</div>

				</div>
			</div>
		</div>
	</div>
</div>




<script>

	//Global Variable
	
	var map;
	var clusterer;
	var isFirst = true;

	$(document).ready(
			function() {

				
				
				$("#basic_navbar").removeClass("navbar-transparent").addClass(
						"fixed-top").addClass("bg-danger");
				
				

				createMap();
				initMap(getLocationInfo(null, "none"));
			
				getLocalList();

				$("#event_search_btn").on('click', function() {

					var selected = $("#event_keyword_input").val().trim();
					if (!selected || selected === "") {
						alert("검색어를 입력해 주세요");
						return;

					}
					getPlaceList(selected, "search");
					createMap();
					initMap(getLocationInfo(selected, "search"));

				});
				
				
				$("#btn_find_min_dist").on('click', function(){				
					 minDistanceFinder();					
				});
				
				
				

			});

	//AJAX --> 전시관 selector init
	//key --> ep_id, ep_name, ep_type, ep_subtype, epl_addressroad

	function onChangeSelect() {
		var selected = $("#event_local_list option:selected").text();
		createMap();
		getPlaceList(selected, "location");
		initMap(getLocationInfo(selected, "location"));

	};

	function getLocalList() {

		//AJAX --> 지역 selector init
		var $localList = $("#event_local_list");

		$.ajax({

					type : "GET",
					data : "",
					url : "/museum/getLocalList",
					dataType : "json",
					success : function(json) {

						var list = json;

						for (var i = 0; i < list.length; ++i) {

							$localList.append(new Option(list[i], list[i],
									true, true));

						}
						$localList.selectpicker('val', '지역');
						$localList.selectpicker('refresh');

					},
					error : function(xhr, status, error) {

						alert("Local Connection Fail!");

					}

				});

	}

	function getPlaceList(keyword, token) {

		$.ajax({

			type : "POST",
			data : {
				keyword : keyword,
				token : token
			},
			url : "/museum/getPlaceFullList",
			dataType : "json",
			success : function(result) {

				renderRows(result);

			},
			error : function(xhr, status, error) {

				alert("Send fail! --> : " + error + " - " + xhr.status);

			}

		});

	}
	
	
	function getPlaceListByIds(keyword) {
		
		console.log(JSON.stringify(keyword));

		$.ajax({

			type : "POST",
			data : {
				keyword : JSON.stringify(keyword)
			},
			url : "/museum/getPlaceFullListByIds",
			dataType : "json",
			success : function(result) {

				renderRows(result);

			},
			error : function(xhr, status, error) {

				alert("Send fail! --> : " + error + " - " + xhr.status);

			}

		});

	}

	function renderRows(list) {

		var $body = $("#table_body");
		var $temp = $("#place_row").clone();

		$body.empty();

		for (var i = 0; i < list.length; ++i) {

			var $element = $temp.clone();

			var index = list[i];

			$element.find("#row_num").html(i + 1);
			$element.find("#row_name").html(index.EP_NAME);
			$element.find("#row_address").html(index.EPL_ADDRESSROAD);
			$element.find("#row_type").html((index.EP_TYPE).trim());
			$element.find("#row_id").html(index.EP_ID);

			$body.append($element);

			$element.find("#row_name").on(
					'click',
					function() {

						$(location).attr(
								'href',
								'/museum/findMuseumDetailView?id='
										+ $(this).parents("#place_row").find(
												"#row_id").html());

					});

			$("#event_local_list").selectpicker('val', '지역');
			$("#event_local_list").selectpicker('refresh');

		}

	}
	
	function createMap(){
		
		
		//Daum Map
		map = new daum.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
			center : new daum.maps.LatLng(36.2683, 127.6358), // 지도의 중심좌표 
			level : 14
		// 지도의 확대 레벨 
		});

		// 마커 클러스터러를 생성합니다 
		clusterer = new daum.maps.MarkerClusterer({
			map : map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
			averageCenter : true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
			minLevel : 10
		// 클러스터 할 최소 지도 레벨 
		});
		
		
		
	}
	


	//지도를 초기화 시키는 함수
	function initMap(data) {
		

	//마커들을 저장할 변수
		var markers = $(data).map(
						function(i, position) {
							//마커를 하나 새로 만드는데, 위치값을 지정하고 클릭이 가능하게 설정함.
							var marker = new daum.maps.Marker(
									{
										position : new daum.maps.LatLng(
												position.LAT,
												position.LNG),
										clickable : true
									});
							

							//띄울 인포윈도우 정의
							var iwContent = '<div style="padding:5px;">'
									+ '<a href="/museum/findMuseumDetailView?id='
									+ position.ID
									+ '">'
									+ position.NAME
									+ '</a><br/>'
									+ position.ADDRESS
									+ '</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
							iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다
							
							

							// 인포윈도우를 생성합니다
							var infowindow = new daum.maps.InfoWindow(
									{
										content : iwContent,
										removable : iwRemoveable
									});

							// 마커에 클릭이벤트를 등록합니다
							daum.maps.event.addListener(marker,
									'click', function() {
										// 마커 위에 인포윈도우를 표시합니다

										infowindow.open(map,
												marker);
									});

							//생성된 마커를 반환합니다.
							return marker;
						});

		// 마커 클러스터러에 클릭이벤트를 등록합니다
		// 마커 클러스터러를 생성할 때 disableClickZoom을 true로 설정하지 않은 경우
		// 이벤트 헨들러로 cluster 객체가 넘어오지 않을 수도 있습니다
		daum.maps.event.addListener(clusterer, 'clusterclick',
				function(cluster) {

					// 현재 지도 레벨에서 1레벨 확대한 레벨
					var level = map.getLevel() - 1;

					// 지도를 클릭된 클러스터의 마커의 위치를 기준으로 확대합니다
					map.setLevel(level, {
						anchor : cluster.getCenter()
					});
				});

		//클러스터에 마커들을 저장합니다.
		clusterer.addMarkers(markers);
		
		if(!isFirst){
		
		var list =data;
		var centerIndex = parseInt(list.length/2);
		map.setLevel(map.getLevel()-3, {anchor: new daum.maps.LatLng(list[centerIndex].LAT, list[centerIndex].LNG)});
		}else{
			isFirst = false;
		}
		

	}
	
	function displayMyLocation(lat, lon){
		
		console.log('---------------- ' + lat + "   " + lon)
		 var locPosition = new daum.maps.LatLng(lat, lon); // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
         var message = '<div style="padding:5px;">여기에 계신가요?!</div>'; // 인포윈도우에 표시될 내용입니다
     
     // 마커와 인포윈도우를 표시합니다
     displayMarker(locPosition, message);
		
		
	}
	
	
	function displayMarker(locPosition, message) {

	    // 마커를 생성합니다
	    var marker = new daum.maps.Marker({  
	        map: map, 
	        position: locPosition
	    }); 
	    
	    var iwContent = message, // 인포윈도우에 표시할 내용
	        iwRemoveable = true;

	    // 인포윈도우를 생성합니다
	    var infowindow = new daum.maps.InfoWindow({
	        content : iwContent,
	        removable : iwRemoveable
	    });
	    
	    // 인포윈도우를 마커위에 표시합니다 
	    infowindow.open(map, marker);
	    
	    // 지도 중심좌표를 접속위치로 변경합니다
	    map.setCenter(locPosition);     
	    console.log("level : " + map.getLevel());
	    map.setLevel(map.getLevel()-5);
	}    
	
	
	function getLocationInfo(key, tok){
		
		
		//Ajax를 통해 좌표 데이터 map를 전송받는다.

		var result;
		
		$.ajax({
					url : "/museum/getGeoLocation",
					type : "GET",
					data : {
						token : tok,
						keyword : key
					},
					dataType : "json",
					async : false,
					success : function(data) {
						//요청에 성공하면 DB에서 꺼낸 데이터를 json 형식으로 응답 받는다.
						
						result = data;

					},
					error : function(xhr, status, error) {
						//요청에 실패하면 에러코드 출력  
						alert("에러코드 : " + xhr.status +  + error);
					}

				});
		
		return result;
		
		
		
	}
	
	


	function minDistanceFinder() {

		
		if (navigator.geolocation) { // GPS를 지원하면
			navigator.geolocation.getCurrentPosition(function(position) {
				console.log(position.coords.latitude + ' '
						+ position.coords.longitude);
				
				compareDistance(position.coords.latitude, position.coords.longitude);
				
			}, function(error) {
				console.error(error);
			}, {
				enableHighAccuracy : true,
				maximumAge : 0,
				timeout : Infinity
			});
		} else {
			alert('GPS를 지원하지 않습니다');
		}
	}
	
	function compareDistance(standX, standY){
		
		$.ajax({
			url : "/museum/getGeoLocation",
			type : "GET",
			data : {token : "none", keyword : ""},
			dataType : "json",
			success : function(data) {
				//요청에 성공하면 DB에서 꺼낸 데이터를 json 형식으로 응답 받는다.
				
				
				
				var list = data;
				console.log(list.length);
				var min_id;
				var min_dist=999999999999999999999;
				var temp;
				var container = new Array();
				var idContainer = new Array();
				var interval = 20; 
				var clone=list[0];
				
				for(var i=0; i<list.length; ++i){
					
					temp = calculateDistance(standX, standY, list[i].LAT, list[i].LNG);

					
					if(temp<interval){
						

						container.push(list[i]);
						idContainer.push(list[i].ID);
						
						
					}		
					
				}
			
 				createMap();
 				initMap(container);
 				displayMyLocation(standX,standY);
 				getPlaceListByIds(idContainer);
 
				
				
				
				
			}, error : function(xhs, status, error){
				
				alert("error! " + status + error);
				
			
			}
			});
		
		
		
		
	}

	
	
	/* 최단거리 탐색 */
	

 		 function toRad(value){
			 
			 return value * Math.PI / 180;
			 
		 }
	    

	    function calculateDistance(lat1, lon1, lat2, lon2) {
		      var R = 6371; // km
		      var dLat = toRad(lat2-lat1);
		      var dLon = toRad(lon2-lon1); 
		      var a = Math.sin(dLat/2) * Math.sin(dLat/2) + Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) * Math.sin(dLon/2) * Math.sin(dLon/2); 
		      var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
		      var d = R * c;
		      return d;
		    } 
	    
	    

	  
	 
	
</script>