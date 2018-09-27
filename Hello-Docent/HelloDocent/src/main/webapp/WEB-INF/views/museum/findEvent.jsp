<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src=" https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="bootstrap-datetimepicker.de.js" charset="UTF-8"></script>


<c:set var="now" value="<%=new Date()%>" />



<div class="wrapper">
	<div class="main">
		<div class="section">
			<div class="container">
			<div class="col-md-6 col-12 ml-auto mr-auto text-center">
				<div class="row" style="height:50px"></div>

					<h1 class="discover-title" style="margin: 15px">
						<small>전시/행사 검색</small>
					</h1>


				<div class="row" style="height:50px"></div>



					<div class="row text-center" style="margin: 2px">

						<div class="col-12 dropdown">


							<div class="input-group date" id="datetimepicker">
								<input type="text" class="form-control datetimepicker" data-date-format="YYYY-MM-DD" 
									/>
								<div class="input-group-append">
									<span class="input-group-text"><span
										class="glyphicon glyphicon-calendar"><i
											class="fa fa-calendar" aria-hidden="true"></i></span> </span>
								</div>
							</div>

						</div>

					</div>


					<!-- 검색 입력창 -->


					<div class="row" style="margin: 10px">
						<div class="col-lg-8">
							<input type="text" id="event_keyword_input"
								class="form-control border-input" placeholder="검색어를 입력하세요.." />&nbsp;&nbsp;
						</div>

						<div class="col-lg-4">
							<button id="event_search_btn" class="btn btn-warning"
								style="width: 100%">
								<i class="nc-icon nc-zoom-split">&nbsp;검색하기</i>
							</button>
						</div>

					</div>

					<div class="row" style="margin-bottom: 5px; padding : 5px">


						<!-- 전시행사 분류 -->


						<div class="col-lg-5" style="margin-bottom: 5px">

							<select id="event_type_list" class="selectpicker"
								data-width="100%"
								data-style="select-with-transition btn-primary btn-round"
								title="전시 분류" data-size="7">
								<option disabled>전시 분류</option>
								<option value="박물관">역사</option>
								<option value="미술관">미술</option>

							</select>

						</div>


						<!-- 지역 리스트 -->


						<div class="col-lg-7">
							<select id="event_local_list" class="selectpicker" onchange="onChangeSelect()"
								data-width="100%"
								data-style="select-with-transition btn-primary btn-round"
								title="지역" data-size="7"
						
								>
								<option disabled>지역</option>
							</select>

						</div>
					</div>


					<!-- 전시관 리스트 -->

					<div class="row" style="margin-bottom: 5px;">
						<div class="col-12">
							<select id="event_place_list" class="selectpicker"
								data-width="100%"
								data-style="select-with-transition btn-primary btn-round"
								title="전시관" data-size="12">
								<option disabled>전시관</option>

							</select>
						</div>
					</div>
				</div>
			</div>




				<div class="row" style="height:50px"></div>


			<div class="container">
				
				<div class="row" id="event_container">

		<c:set var="image_container" value="null" />


			<c:forEach var="event" items="${events}">


						<c:choose>
							<c:when test="${empty event.de_image}">
								<c:set var="image_container"
									value="${pageContext.request.contextPath}/resources/assets/img/defaults/noimage1.png" />
							</c:when>
							<c:otherwise>
								<c:set var="image_container" value="${event.de_image}" />
							</c:otherwise>
						</c:choose>


					<div class="col-md-3 col-sm-6" id="event_element">
						<div class="card text-center">
							<div class="card-image">
							

							
								<img src="${image_container}" onError="this.onerror=null;this.src='${pageContext.request.contextPath}/resources/assets/img/defaults/noimage1.png';"
									alt="Image" class="img-rounded img-responsive" id="event_image">
								</a>
								<div class="card-body details-center">
									<a href="${event.de_url}" id="event_url">
										<div class="author text-center">		
											<div class="text">
												<span class="name" id="event_title">${event.de_title}</span>
												<div class="meta" id="event_Date">
												<fmt:formatDate value="${event.de_startDate}"
											pattern="yyyy-MM-dd" />
										~
										<fmt:formatDate value="${event.de_endDate}"
											pattern="yyyy-MM-dd" /></div>
											
											<div class="meta" id="event_placeName">
											
											${event.de_refName}
											
											</div>
											
											</div>
										</div>
									</a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
				</div>

			<!-- Progress bar (기본값 hidden) -->

				<div class="row" style="display:none" id="interval_progressBar">
					<div class="col-md-12 text-center ml-auto mr-auto">
						<div class="preloader">
							<div class='uil-reload-css'>
								<div></div>
							</div>
							<h5>Loading More</h5>
						</div>
					</div>
				</div>

			</div>




		</div>




	</div>
	
	<div class="alert alert-warning alert-dismissible fade show" role="alert" style="display:none">
  <strong>맙소사!</strong> 정보를 받아오는 중에 오류가 발생하였습니다.
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>

</div>


<script type="text/javascript">



	$(document).ready(
			
			function() {

				$("#basic_navbar").removeClass("navbar-transparent").addClass("fixed-top").addClass("bg-danger");
				
				$('#datetimepicker').datetimepicker({
					icons : {
						time : "fa fa-clock-o",
						date : "fa fa-calendar",
						up : "fa fa-chevron-up",
						down : "fa fa-chevron-down",
						previous : 'fa fa-chevron-left',
						next : 'fa fa-chevron-right',
						today : 'fa fa-screenshot',
						clear : 'fa fa-trash',
						close : 'fa fa-remove'
					}
				});
				
			
								
				
				//AJAX --> 지역 selector init
				
				
				$.ajax({
					
					type:"GET",
					data:"",
					url : "/museum/getLocalList",
					dataType:"json",
					success: function(json){
						
					

						var list = json;
						
						for(var i = 0; i<list.length; ++i){
							
							console.log("append : " + i);
							$("#event_local_list").append(new Option(list[i], list[i], true, true));
							
							
							
						}
						$("#event_local_list").selectpicker('val', '지역');
						$("#event_local_list").selectpicker('refresh');
		

						
					},
					error: function(xhr, status, error){
						
						console.log("지역 받아오기 오류");
						
					}
					
				});
	
			});
	
	//AJAX --> 전시관 selector init

	
	function onChangeSelect (){
	var selected = $("#event_local_list option:selected").text();

	
	$.ajax({
		
		type : "GET",
		data : {name:selected},
		url : "/museum/getPlaceList",
		dataType : "json",
		success : function(result){
			
		
			
			var list = result;
			
			var $placeList = $("#event_place_list");
			
		
			$placeList.empty();

			for(var i = 0; i<list.length; ++i){
				
				console.log("append : " + list[i]);
				$placeList.append(new Option(list[i], list[i], true, true));
				
				
			}
			$("#event_local_list").selectpicker('val', '전시관');
			$placeList.selectpicker('refresh');
			
			
			
		},
		error : function(xhr, status, error){
			
			$(".alert").alert();

			
		} 
		

		
	});
	
	};
	

		
		$("#event_search_btn").on('click', function(){
			
		
			var selected_place = $("#event_place_list option:selected").text();
			var selected_type = $("#event_type_list option:selected").val();
			var keyword = $.trim($("#event_keyword_input").val());
			var date = $("#datetimepicker").find("input").val();
			
			if(selected_place === "전시관")
				selected_place = null;
			
		
			if(!date){
				alert("날짜를 선택 해 주세요.")
				return;
			}
			
			
			
			
			var query = {"type":selected_type, "placeName" : selected_place, "keyword" : keyword, "date" : date}
			
			
			$.ajax({
				
				type : 'GET',
				data : query,
				url : "/museum/getMuseumListForQuery",
				dataType : "json",
				success:function(result){
					refreshUI(result);
				},
				error : function(xhr, status, error){
					alert("전송 실패 " + error + xhr + status);				
				}
	
			});

			
		});
		
		function refreshUI(result){
			
			var $temp = $("#event_element").clone();
			var $container = $("#event_container");
			var list = result;
			$container.empty();
			$("#interval_progressBar").attr("style", "display:block");
					

			var imageUrl;
			for(var i = 0; i<list.length; ++i){
				
				var $element = $temp.clone();
				
				
				console.log(list[i]);
				
				if(!list[i].de_image){
					
					imageUrl = "${pageContext.request.contextPath}/resources/assets/img/defaults/noimage1.png";
					
				}else{
					
					imageUrl = list[i].de_image;
					
				}
				
			 	$element.find("#event_image").attr("src", imageUrl);
				$element.find("#event_url").attr("href", list[i].de_url);
				$element.find("#event_title").html(list[i].de_title);
				$element.find("#event_Date").html(list[i].de_startDate+" ~ " +list[i].de_endDate);
				$element.find("#event_placeName").html(list[i].de_refName); 
				$container.append($element);
				
				
				
				
			}
			
			$("#interval_progressBar").attr("style", "display:none");
			
			
			
		}
		
		
		
		
		
	
	
	
	
</script>