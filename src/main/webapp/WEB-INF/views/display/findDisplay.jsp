<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    

    
    <div class="page-header" style="background-image: url('${pageContext.request.contextPath}/resources/assets/img/museum/museum_docent.jpg');">
    <div class="filter"></div>
    <div class="content-center">
      <div class="container text-center">
        <h1>새로운 시각으로 문화를 즐겨보세요</h1>
        <h3>수많은 전문가들의 색다른 해설이 당신을 기다리고 있습니다!</h3>
      </div>
    </div>
  </div> 
  
  
  <div class="wrapper">

    <!-- section -->
    <div class="section section-gray">
      <div class="container">
        <h3 class="section-title">전시품 검색</h3>
        
        <div class="row" style="margin:20px">
        
        <div class="col-9">      
        <input id="searchInput" class="form-control form-control-lg w-100" placeHolder ="검색어를 입력하세요..." style="margin:0 auto"/>
        </div>
        
        <div class="col-3">
        
        <button id="searchBtn" class="btn btn-lg w-100" style="margin:0 auto">검색하기</button>
        
        </div>
        </div>
        
        
        
        <div class="row">
          <div class="col-md-3">
            <div class="card card-refine">
              <div class="panel-group" id="accordion" aria-multiselectable="true" aria-expanded="true">
             
                <div class="card-header card-collapse" role="tab" id="clothingGear">
                  <h5 class="mb-0 panel-title">
                    <a class="" data-toggle="collapse" data-parent="#accordion" href="#clothing" aria-expanded="true" aria-controls="collapseSecond">
                     	 전시관별 보기
                      <i class="nc-icon nc-minimal-down"></i>
                    </a>
                  </h5>
                </div>
    
    
                <div id="clothing" class="collapse" role="tabpanel" aria-labelledby="headingOne">
                  
                  <div class="card-body">
                  
                   <c:forEach var="temp" items="${museumInfo}">            
                    <div class="form-check">
                      <label class="form-check-label">
                        <input class="form-check-input" type="checkbox" value="${temp.ID}"> ${temp.NAME}  (${temp.COUNTSUM})
                        <span class="form-check-sign"></span>
                      </label>
                    </div>
                    </c:forEach>
              
                  </div>
                </div>
               
                
                
                <div class="card-header card-collapse" role="tab" id="designer">
                  <h5 class="mb-0 panel-title">
                    <a class="" data-toggle="collapse" data-parent="#accordion" href="#refineDesigner" aria-expanded="true" aria-controls="collapseThree">
                      	시대별 보기
                      <i class="nc-icon nc-minimal-down"></i>
                    </a>
                  </h5>
                </div>
                
                
                <div id="refineDesigner" class="collapse" role="tabpanel" aria-labelledby="headingOne">
                  <div class="card-body">
                    <div class="form-check">
                      <label class="form-check-label">
                        <input class="form-check-input" type="checkbox" value="" checked> All
                        <span class="form-check-sign"></span>
                      </label>
                    </div>
                   
                  </div>
                </div>
                
                
                
                <div class="card-header card-collapse" role="tab" id="color">
                  <h5 class="mb-0 panel-title">
                    <a class="" data-toggle="collapse" data-parent="#accordion" href="#colorMaker" aria-expanded="true" aria-controls="collapseTree">
                      	국외 유물 보기
                      <i class="nc-icon nc-minimal-down"></i>
                    </a>
                  </h5>
                </div>
                
                
                
                <div id="colorMaker" class="collapse" role="tabpanel" aria-labelledby="headingOne">
                  <div class="card-body">
                    <div class="form-check">
                      <label class="form-check-label">
                        <input class="form-check-input" type="checkbox" value="" checked> All
                        <span class="form-check-sign"></span>
                      </label>
                    </div>
                  
                  </div>
                </div>
                
                
                  <div class="card-header card-collapse" role="tab" id="color">
                  <h5 class="mb-0 panel-title">
                    <a class="" data-toggle="collapse" data-parent="#accordion" href="#seeMore" aria-expanded="true" aria-controls="collapseTree">
                      	보기 개수
                      <i class="nc-icon nc-minimal-down"></i>
                    </a>
                  </h5>
                </div>
                
                <div id="seeMore" class="collapse" role="tabpanel" aria-labelledby="headingOne">
                  <div class="card-body">

                    <div class="form-check-radio">
                      <label class="form-check-label">
                        <input class="form-check-input" type="radio" name = "search_range" value="20" checked> 20
                        <span class="form-check-sign"></span>
                      </label>
                    </div>
                    
                    <div class="form-check-radio">
                      <label class="form-check-label">
                        <input class="form-check-input" type="radio" name = "search_range" value="50"> 50
                        <span class="form-check-sign"></span>
                      </label>
                    </div>
                    
                    <div class="form-check-radio">
                      <label class="form-check-label">
                        <input class="form-check-input" type="radio" name = "search_range" value="100">  100
                        <span class="form-check-sign"></span>
                      </label>
                    </div>
                  
                  </div>
                </div>
                
                
              </div>
            </div>
            <!-- end card -->
          </div>
          <div class="col-md-9">
            <div class="products">
              <div class="row">
               <c:forEach var="displays" items="${displayInfo}">
               <c:set var="url" value="${displays.DPL_IMAGEURL}"/>
                <div class="col-md-4 col-sm-4">
                  <div class="card card-product card-plain">
                    <div class="card-image text-center">
                      <a href="/display/findDisplayDetail?id=${displays.DP_ID}">
                        <img src="${url}" alt="Rounded Image" class="img-rounded img-responsive" onError='this.onerror=null;this.src="${pageContext.request.contextPath}/resources/assets/img/defaults/noimage1.png"'>
                      </a>
                      <div class="card-body">
                        <div class="card-description">
                          <h5 class="card-title">${displays.DP_NAME}</h5>
                          <p class="card-description">${displays.DPL_ALTERNATIVETITLE}</p>
                        </div>
                        <div class="price">
                          <h5>${displays.EP_NAME}</h5>
                        </div>
                        
                       
                      </div>
                    </div>
                  </div>
                </div>
                </c:forEach>
                
                
               
              </div>
            </div>
            
             <div class="col-md-3 offset-md-4">
                  <button rel="tooltip" title="This is a morphing button" class="btn btn-round btn-outline-default" id="successBtn" data-toggle="morphing" data-rotation-color="gray">Load more...</button>
                </div>
            
          </div>
        </div>
      </div>
    </div>
    </div>
    <!-- section -->
    
    <!-- section -->
    <div class="subscribe-line subscribe-line-black">
      <div class="container">
        <div class="row">
          <div class="col-md-9 col-sm-8">
            <form class="">
              <div class="form-group">
                <input type="text" value="" class="form-control" placeholder="Enter your email...">
              </div>
            </form>
          </div>
          <div class="col-md-3 col-sm-4">
            <button type="button" class="btn btn-neutral btn-block btn-lg">Join Newsletter</button>
          </div>
        </div>
      </div>
    </div>
    
    
    <script>
    

    
	$(document).ready(function(){
	
	
		$("#searchInput").on('keydown', (e)=>{
			
			console.log('hello');
			if(e.keyCode == '13'){
				clickSearch();
				e.preventDefault();

				
			}

		});
		
		
		
		$("#searchBtn").on('click',()=>{
		
			
			clickSearch();
			
		});
		
		

	});

    function clickSearch(){
    	
    	
    	var reg = /^[ㄱ-ㅎ가-힣a-zA-Z\s]+$/;
    		
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
    	
    	
    	
    
    	
    	
    }
    
    
   
    
    </script>