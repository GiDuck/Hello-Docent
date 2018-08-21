<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script src=" https://code.jquery.com/jquery-3.3.1.min.js"></script>



	<div class="wrapper full-screen">
		<div class="page-header"
			style="background-image: url('http://cc0photo.com/wp-content/uploads/edd/2015/05/CC0-photo-1874-1560x1040.jpg');
			display:flex; align-items:center;">
			<div class="filter"></div>
			<div class="container h-100 d-inline-block">
				<div class="row ">
					<div class="col-lg-6 col-md-6 col-sm-7 col-12 ml-auto">
						
						
						<!-- 1차 section -->
						<div class="info info-horizontal">
							<div class="icon">
								<i class="fa fa-umbrella"></i>
							</div>
							<div class="description">
								<h3>문화를 즐기는 새로운 방법</h3>
								<p>더 넓은 지식, 색다른 시각, 정확한 정보를 즐기십시오.</p>
							</div>
						</div>
						
						<!-- 2차 section -->
						<div class="info info-horizontal">
							<div class="icon">
								<i class="fa fa-map-signs"></i>
							</div>
							<div class="description">
								<h3>내 맘대로 골라 듣는 해설</h3>
								<p>수 많은 전문가들이 올려 놓은 콘텐츠를 골라보세요.</p>
							</div>
						</div>
						
						<!-- 3차 section -->
						<div class="info info-horizontal">
							<div class="icon">
								<i class="fa fa-user-secret"></i>
							</div>
							<div class="description">
								<h3>즐겨 보십시오. 단 한 번의 가입으로</h3>
								<p>간편한 가입으로 이 모든 서비스를 즐기실 수 있습니다!</p>
							</div>
						</div>
					</div>
					
					
					<!-- Login Section -->
					
					<div class="col-lg-6 col-md-6 col-sm-5 col-12 mr-auto">
						<div class="card card-register">
							<h2 class="card-title text-center">
								<b>Login</b>
							</h2>

						
							<a href="${GoogleLogin_url}">
							<button id="btnJoinGoogle"
									class="btn btn-primary btn-round" style="width: 100%">
									<i class="fa fa-google" aria-hidden="true"></i>Google Login
								</button></a> 
								<a href="${FacebookLogin_url}"><button
									class="btn btn-primary btn-round" style="width: 100%">
									<i class="fa fa-facebook" aria-hidden="true"></i>Facebook Login
								</button></a> <a href="${KakaoLogin_url}"><button
									class="btn btn-primary btn-round" style="width: 100%">KaKao
									Login</button></a> <a href="${NaverLogin_url}"><button
									class="btn btn-primary btn-round" style="width: 100%">Naver
									Login</button></a>


						</div>
					</div>
				
				</div>
		
				
		<div class="text-center">
			<h6>&copy;<script>
					document.write(new Date().getFullYear())
				</script>, made with <i class="fa fa-heart heart"></i> Hello! Docent!</h6></div>	
				
		
			</div>
		
			
		</div>


		
	</div>



<script type="text/javascript">

$(document).ready(function(){

	$("#basic_navbar").removeClass("nav-down").removeClass("navbar-absolute").addClass("fixed-top");
	
	
});



</script>
	
		

