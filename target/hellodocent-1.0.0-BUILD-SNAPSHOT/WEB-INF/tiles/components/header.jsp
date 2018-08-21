<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

  <nav class="navbar navbar-expand-lg nav-down navbar-absolute navbar-transparent" id="basic_navbar">
    <div class="container">
      <div class="navbar-translate">
        <a class="navbar-brand" href="/" rel="tooltip" title="hello-docent-home" data-placement="bottom" target="_blank">
        Hello Docent!
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-bar bar1"></span>
          <span class="navbar-toggler-bar bar2"></span>
          <span class="navbar-toggler-bar bar3"></span>
        </button>
      </div>
      <div class="collapse navbar-collapse" data-nav-image="" data-color="orange">
        <ul class="navbar-nav ml-auto">
         
          <li class="dropdown nav-item">
            <a class="dropdown-toggle nav-link" id="navbarDropdownMenuLink2" data-toggle="dropdown" aria-expanded="false" style="">
        	전시정보
            </a>
            <div class="dropdown-menu dropdown-menu-right dropdown-danger" aria-labelledby="navbarDropdownMenuLink">
              <a class="dropdown-item" href="/display/findDisplay?prefix=0&suffix=50&token=">
                <i class="nc-icon nc-zoom-split"></i> 전시품 찾기
              </a>
              
                <a class="dropdown-item" href="/museum/findPlace">
                <i class="nc-icon nc-bank"></i> 전시관 찾기
              </a>
              
                <a class="dropdown-item" href="/museum/findEvent">
                <i class="nc-icon nc-calendar-60"></i> 전시정보/행사 보기
              </a>
              
      <%--         <a class="dropdown-item" href="${pageContext.request.contextPath}/resources/sections.html#headers">
                <i class="nc-icon nc-shop"></i> Shop
              </a> --%>

            </div>
          </li>

	 <li class="dropdown nav-item">
            <a class="dropdown-toggle nav-link" id="navbarDropdownMenuLink2" data-toggle="dropdown">
             BLOG
            </a>
            <div class="dropdown-menu dropdown-menu-right dropdown-danger" aria-labelledby="navbarDropdownMenuLink">
              <a class="dropdown-item" href="/blog/blogMain?pageNum=1&keyword=">
                <i class="nc-icon nc-paper"></i> 도슨트 컬럼
              </a>


            </div>
          </li>

          
          <li class="dropdown nav-item">
            <a class="dropdown-toggle nav-link" id="navbarDropdownMenuLink2" data-toggle="dropdown">
              MyInfo
            </a>
            <div class="dropdown-menu dropdown-menu-right dropdown-danger" aria-labelledby="navbarDropdownMenuLink">
              <a class="dropdown-item" href="/member/getMemberModify">
                <i class="nc-icon nc-single-02"></i> 내 정보 보기
              </a>
              <a class="dropdown-item" href="/member/getRequestDocent">
                <i class="nc-icon nc-chat-33"></i> 도슨트 활동 신청
              </a>
           <%--    <a class="dropdown-item" href="${pageContext.request.contextPath}/resources/sections.html#blogs">
                <i class="nc-icon nc-world-2"></i> Following
              </a> --%>
            

            </div>
          </li>
          
          
          <li class="dropdown nav-item">
            <a class="dropdown-toggle nav-link" id="navbarDropdownMenuLink2" data-toggle="dropdown">
              	도슨트 메뉴
            </a>
            <div class="dropdown-menu dropdown-menu-right dropdown-danger" aria-labelledby="navbarDropdownMenuLink">
              <a class="dropdown-item" href="/display/findDisplayForDocent?prefix=0&suffix=50&token=">
                <i class="nc-icon nc-single-02"></i> 해설 만들기
              </a>
              <a class="dropdown-item" href="/blog/blogWriting">
                <i class="nc-icon nc-chat-33"></i> 블로그 작성하기
              </a>
              <a class="dropdown-item" href="${pageContext.request.contextPath}/resources/sections.html#blogs">
                <i class="nc-icon nc-world-2"></i> 내 컨텐츠 보기
              </a>
                  
              
              

            </div>
          </li>
          
          
          
          <c:choose>
          
         <c:when test="${empty sessionScope.userVO ? false : true}">
         
       
         	<div class="nav-item" id="state_logOut">
			<a href="/member/removeSession" class="nav-link">Logout</a>
			</div>   
          
          </c:when>
         
         <c:when test="${empty sessionScope.userVO ? true : false}">
          
          <div class="nav-item" id="state_login">
			<a href="/member/join" class="nav-link">Login</a>
			</div>   
          
          </c:when>
						    
          </c:choose>
          
    
          <!-- <li class="nav-item">
					<a class="nav-link" rel="tooltip" title="Follow us on Twitter" data-placement="bottom" href="https://twitter.com/CreativeTim" target="_blank">
						<i class="fab fa-twitter"></i>
						<p class="hidden-lg-up">Twitter</p>
					</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" rel="tooltip" title="Like us on Facebook" data-placement="bottom" href="https://www.facebook.com/CreativeTim" target="_blank">
						<i class="fab fa-facebook-square"></i>
						<p class="hidden-lg-up">Facebook</p>
					</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" rel="tooltip" title="Follow us on Instagram" data-placement="bottom" href="https://www.instagram.com/CreativeTimOfficial" target="_blank">
						<i class="fab fa-instagram"></i>
						<p class="hidden-lg-up">Instagram</p>
					</a>
				</li> -->
        </ul>
      </div>
    </div>
  </nav>
