<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%!SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");%>


<script src=" https://code.jquery.com/jquery-3.3.1.min.js"></script>




<div class="page-header" data-parallax="true"
	style="background-image: url('https://upload.wikimedia.org/wikipedia/commons/thumb/5/5d/%EA%B2%BD%EC%A3%BC%EC%B2%A8%EC%84%B1%EB%8C%80_%EA%B5%AD%EB%B3%B4%EC%A0%9C31%ED%98%B8.jpg/1200px-%EA%B2%BD%EC%A3%BC%EC%B2%A8%EC%84%B1%EB%8C%80_%EA%B5%AD%EB%B3%B4%EC%A0%9C31%ED%98%B8.jpg')">
	<div class="filter"></div>
	<div class="content-center">
		<div class="container">
			<div class="motto">
				<h1 class="title">Hello Docent!</h1>
				<h3 class="description">알고 싶은 전시품을 검색 해 보세요.</h3>
				<br /> <br /> <br />
				<div class="center-block">
					<div class="row">
						<div class="col-sm-9" style="padding: 8px">
							<input id="searchInput" class="form-control form-control-lg center-block "
								type="text" placeholder="키워드를 입력하세요..	" />
						</div>
						<div class="col-sm-3" style="padding: 8px">
							<button id="searchBtn" class="btn btn-primary btn-lg btn-block">
								<i class="nc-icon nc-zoom-split"></i>검색
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<c:set var="events" value="${events}" />

<div class="wrapper">
	<div class="section text-center landing-section">
		<div class="container">
			<div class="col-md-12 ml-auto mr-auto">
				
				<div class="row text-center" style="width:100%; padding : 70px">
				<h2 class="title" style="float:none; margin:0 auto">전시 일정</h2>
				</div>

				<div class="row">


					<c:forEach var="temp" items="${events}" begin="1" end="12">

						<c:set var="image_container" value="null" />

						<c:choose>
							<c:when test="${empty temp.de_image}">
								<c:set var="image_container"
									value="${pageContext.request.contextPath}/resources/assets/img/defaults/noimage1.png" />
							</c:when>
							<c:otherwise>
								<c:set var="image_container" value="${temp.de_image}" />
							</c:otherwise>
						</c:choose>

						<div class="col-md-3">
							<div class="card" style="width: 100%;" id="${temp.de_url}">
								<img class="card-img-top" src="${image_container}" style="width:100%; max-height:400px; margin:0"
								onError="this.onerror=null;this.src='${pageContext.request.contextPath}/resources/assets/img/defaults/noimage1.png';">
								<div class="card-body">
									<h5 class="card-text" style="font-weight: bold">"${temp.de_title}"</h5>
									<p class="card-text">
										<fmt:formatDate value="${temp.de_startDate}"
											pattern="yyyy-MM-dd" />
										~
										<fmt:formatDate value="${temp.de_endDate}"
											pattern="yyyy-MM-dd" />
									</p>
								</div>
							</div>
						</div>


					</c:forEach>




					<div class="row text-center" style="width: 100%;margin-top:50px">


						<div style="width: 30%;float:none; margin:0 auto" >
							
							<a href="/museum/findEvent"><button class="btn btn btn-danger btn-round" style="width: 100%">더보기</button></a>

							<div>
							</div>


						</div>


					</div>


				</div>


			</div>


			<br /> <br />
			<div class="row"></div>
		</div>
	</div>
	<div class="section section-dark text-center landing-section">
		<div class="container">
			<h2 class="title">Hot Posting</h2>
			<div class="row">
				<div class="col-md-4">
				
				</div>
			
		
			</div>
		</div>
	</div>

</div>

<script>


$(document).ready(function(){
	
	clickSearch();


		$(".card").on("click", function() {

			var url = $(this).attr('id');
			window.open(url);
			//$(location).attr('href', url).attr('target','_blank');

		});

	});
	
	


function clickSearch(){
	
	
	var reg = /^[가-힣a-zA-Z\s]+$/;
		
	
	
	$("#searchBtn").on('click', function(){

	var inputVal = $("#searchInput").val();
	
	
		
	/* 유효성 검사 */
	if(!inputVal || inputVal.trim().length < 2){
		
		alert("2글자 이상 입력 해 주세요.");
		return;
		
	}
	
	/* 유효성 검사 */
	if(inputVal.trim().length > 12){
		
		alert("검색어가 너무 깁니다");
		return;
		
	}
	
	if(!reg.test(inputVal)){
		
		
		alert("검색어는 문자, 숫자만 입력이 가능합니다.");
		return;
		
		
	}
	
	
	location.href="/display/findDisplay?prefix=0&suffix=20&keyword="+inputVal;
	
	
	
	
	});
	
	
}


</script>
