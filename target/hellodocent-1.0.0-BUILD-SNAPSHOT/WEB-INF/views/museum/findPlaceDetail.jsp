
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=44cc7c0f5f9097e79084faaa33f4f6be&libraries=services,clusterer,drawing"></script>
<script src=" https://code.jquery.com/jquery-3.3.1.min.js"></script>

<%
Map<String, String> container = new HashMap<>();
container = (Map<String, String>)request.getAttribute("container");

Iterator<String> iter = container.keySet().iterator();

		for(;iter.hasNext();){
		String key = iter.next();
		System.out.println("KEY : " + key);
		System.out.println("가지고 있는 값 : " + container.get(key));
			
			
		}

%>


<style>
.map_wrap {
	position: relative;
	overflow: hidden;
	width: 100%;
	height: 350px;
}

.radius_border {
	border: 1px solid #919191;
	border-radius: 5px;
}

</style>


<div class="sidebar-collapse">

	<div class="page-header page-header-xs"
		style="background-image: url('${pageContext.request.contextPath}/resources/assets/img/museum/museum_background.jpg');">
		<div class="filter"></div>
	</div>
	<div class="main">
		<div class="section">
			<div class="container">




				<div class="col w-100 text-center">
					<h2>${container.EP_NAME}</h2>
					<br /> <br />
					<hr />
					<div class="col w-75 center-block" style="margin: 0 auto;">
						<p>${container.EP_INTRODUCE}</p>
					</div>

					<hr />
					<div class="row">

						<div class="col-sm-4">
							<h5>운영 시간</h5><br/>
							<p>평일 : ${container.EP_OPERTIMESTART} 부터 ${container.EP_OPERTIMEEND}</p><br/>
							<p>주말 : ${container.EP_OPERTIMEWKSTART} 부터  ${container.EP_OPERTIMEWKEND}</p>
							
						</div>

						<div class="col-sm-4">
							<h5>휴관일</h5><br/>
							<p>${container.EP_CLOSEINFO}</p>
							
						</div>

						<div class="col-sm-4">
							<h5>요금</h5><br/>
							<p> 성인 : ${container.EPC_ADULT} </p><br/>
							<p> 청소년 :  ${container.EPC_TEENAGER} </p><br/>
							<p> 어린이 :  ${container.EPC_CHILD} </p>
						</div>

					</div>

				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row w-75" style="margin: 0 auto;">
			<div class="map_wrap">
				<div id="map"
					style="width: 100%; height: 100%; position: relative; overflow: hidden;"></div>
			</div>

			<div class="row" style="padding: 10px">

				<button id="traffic_info_btn" class="btn" style="margin-right: 5px">실시간 교통정보</button>
				<button id="find_road_btn" class="btn">길찾기</button>


			</div>


		</div>
	</div>

	<div class="section">
		<div class="container">




			<hr />
			<p>
				더 많은 정보를 보고 싶다면? <a class="link-danger" href="${container.EP_URL}">여기를 클릭하세요.</a>
			</p>
			<hr />
			<div class="faq">
				<h4>추가 정보</h4>
				<br />

				<div id="acordeon">
					<div id="accordion" role="tablist" aria-multiselectable="true">
						<div class="card no-transition">
							<div class="card-header card-collapse" role="tab" id="headingOne">
								<h5 class="mb-0 panel-title">
									<a class="collapsed" data-toggle="collapse"
										data-parent="#accordion" href="#collapseOne"
										aria-expanded="false" aria-controls="collapseOne"> 교통정보 <i
										class="nc-icon nc-minimal-down"></i>
									</a>
								</h5>
							</div>
							<div id="collapseOne" class="collapse" role="tabpanel"
								aria-labelledby="headingOne">
								<div class="card-body">${container.EP_TRAFFIC}</div>
							</div>
							<div class="card-header card-collapse" role="tab" id="headingTwo">
								<h5 class="mb-0 panel-title">
									<a class="collapsed" data-toggle="collapse"
										data-parent="#accordion" href="#collapseTwo"
										aria-expanded="false" aria-controls="collapseTwo"> 편의시설 <i
										class="nc-icon nc-minimal-down"></i>
									</a>
								</h5>
							</div>
							<div id="collapseTwo" class="collapse" role="tabpanel"
								aria-labelledby="headingTwo">
								<div class="card-body">${container.EP_FACILITIES}</div>
							</div>
							<div class="card-header card-collapse" role="tab"
								id="headingThree">
								<h5 class="mb-0 panel-title">
									<a class="collapsed" data-toggle="collapse"
										data-parent="#accordion" href="#collapseThree"
										aria-expanded="false" aria-controls="collapseThree"> 기타 <i
										class="nc-icon nc-minimal-down"></i>
									</a>
								</h5>
							</div>
							<div id="collapseThree" class="collapse" role="tabpanel"
								aria-labelledby="headingThree">
								<div class="card-body"></div>
							</div>
						</div>
					</div>
					<!--  end acordeon -->
				</div>
			</div>
			
		</div>
	</div>
	<div class="section section-dark">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h4>Similar Products</h4>
					<br />
				</div>
				<div class="col-md-4 col-sm-4">
					<div class="card card-product card-plain">
						<div class="card-image">
							<a href="#paper-kit"> <img
								src="${pageContext.request.contextPath}/resources/assets/img/balmain-1.jpg"
								alt="Rounded Image" class="img-rounded img-responsive">
							</a>
							<div class="card-body">
								<div class="card-description">
									<h5 class="card-title">Double Breasted Mini Dress</h5>
									<p class="card-description">Dresses & Skirts</p>
								</div>
								<div class="actions">
									<h5>1.300 &euro;</h5>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-4">
					<div class="card card-product card-plain">
						<div class="card-image">
							<a href="#paper-kit"> <img
								src="${pageContext.request.contextPath}/resources/assets/img/balmain-2.jpg"
								alt="Rounded Image" class="img-rounded img-responsive">
							</a>
							<div class="card-body">
								<div class="card-description">
									<h5 class="card-title">Chrystal Dress</h5>
									<p class="card-description">Dresses & Skirts</p>
								</div>
								<div class="actions">
									<h5>1.500 &euro;</h5>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-4">
					<div class="card card-product card-plain">
						<div class="card-image">
							<a href="#paper-kit"> <img
								src="${pageContext.request.contextPath}/resources/assets/img/balmain-3.jpg"
								alt="Rounded Image" class="img-rounded img-responsive">
							</a>
							<div class="card-body">
								<div class="card-description">
									<h5 class="card-title">Chrystal Skirt</h5>
									<p class="card-description">Only on demand</p>
								</div>
								<div class="actions">
									<h5>1.200 &euro;</h5>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>

<script>
	var container = document.getElementById('map');
	var trafficIsClicked = false;
	var options = {
		center : new daum.maps.LatLng("${container.EPL_LOCATIONX}", "${container.EPL_LOCATIONY}"),
		level : 3
	};

	var map = new daum.maps.Map(container, options);

	var markerPosition = new daum.maps.LatLng("${container.EPL_LOCATIONX}", "${container.EPL_LOCATIONY}");

	var marker = new daum.maps.Marker({

		position : markerPosition

	});

	marker.setMap(map);

	// 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
	var mapTypeControl = new daum.maps.MapTypeControl();

	// 지도에 컨트롤을 추가해야 지도위에 표시됩니다
	// daum.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
	map.addControl(mapTypeControl, daum.maps.ControlPosition.TOPRIGHT);

	// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
	var zoomControl = new daum.maps.ZoomControl();
	map.addControl(zoomControl, daum.maps.ControlPosition.RIGHT);

	function addTrafficInfo() {

		
		if (trafficIsClicked) {

			map.removeOverlayMapTypeId(daum.maps.MapTypeId.TRAFFIC);
			trafficIsClicked = false;

		} else {

			map.addOverlayMapTypeId(daum.maps.MapTypeId.TRAFFIC);
			trafficIsClicked = true;

		}
	}

	$("#find_road_btn").on('click', function(){
		
	window.open("http://map.daum.net/link/to/"+"${container.EPL_ADDRESSROAD}"+","+"${container.EPL_LOCATIONX}"+","+"${container.EPL_LOCATIONY}");
		
	});
	
	 $("#traffic_info_btn").on('click', function() {

		addTrafficInfo();

	});
</script>