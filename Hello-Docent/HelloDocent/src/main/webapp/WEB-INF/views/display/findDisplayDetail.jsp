<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<body class="product-page sidebar-collapse">
  
  <div class="page-header page-header-xs" style="background-image: url('${pageContext.request.contextPath}/resources/assets/img/museum/museum_back.jpg');">
    <div class="filter"></div>
  </div>
  <div class="main">
    <div class="section">
      <div class="container">
       
        <div class="row">
         
        
        
         
          <div class="col-md-7 col-sm-6" style="display:flex; align-items:center; ">
            <div class="card-body">
            
            <img src="${disInfo.DPL_IMAGEURL}" onError='this.onerror=null;this.src="${pageContext.request.contextPath}/resources/assets/img/defaults/noimage1.png"'
				class="horizontal-image img-rounded img-responsive img-fluid" style="width:100%" />       
            </div>
          </div>
          
          <div class="col-md-5 col-sm-6">
            <h2> ${disInfo.DP_NAME} </h2>
            <h4 class="price"><strong>${disInfo.DPL_ALTERNATIVETITLE}</strong></h4>
            <hr />
           <div>${disInfo.DPL_DESCRIPTION} </div>
            <hr />
            
            <div class="row">
              
              <div class="col-12">
                
              	  ${disInfo.EP_NAME} 
               
              </div>
             
             
              <hr />
             
          
               <div class="col-12 col-md-6"> ${disInfo.DPL_TEMPORAL}</div>
              
               <div class="col-12 col-md-6">${disInfo.DPL_EXTENT}</div>
               
                 <hr />
                
                <div class="col-12 w-100 text">
                
                 <a href='${disInfo.DPL_URL}'><button class="btn btn-danger btn-block btn-round">자세한 설명 보기 &nbsp;<i class="fa fa-chevron-right"></i></button></a>
                
                </div>
                
              </div>
            </div>
            <hr />
  

            </div>
           
            </div>
            
                  
                  
                  
    <div class="section">
          <hr />
        
<div class="section section-gray" id="cards">
    <div class="container tim-container">
      <div class="title">
        <h2>관련 해설 보기</h2>
      </div>
      <h4 class="title">Docent's Commentary</h4>
      <div class="row">
      
      <!-- SECTION 1 -->
      
        <div id="card_section_1" class="col-md-4 col-sm-6"></div>
        
        
        <!-- SECTION 2 -->
        
        <div id="card_section_2" class="col-md-4 col-sm-6"></div>
        
        
        <!-- SECTION 3 -->
        
        <div id="card_section_3"  class="col-md-4 col-sm-6"></div>
      </div>
      
      </div>
  </div>

              </div>
            
            
          </div>
          
             <hr />
        </div>
        
        
        <!-- BEHIND CARD VIEWS -->
        
                  <!-- SIMPLE TWITTER -->
          
          <div id="card_1" class="card" style="display:none">
            <div class="card-body">
            
              <div class="clearfix"></div>
              <div id="description " class="card-description"></div>
              
                   <div id="tagField " class="w-100" style="padding:15px" >
                   
                    <div class="card-footer">
                <div class="author">
                    <img id="writerPhoto" src="" alt="..." class="avatar img-raised">
                    <span id="writerName"></span>
                </div>
              </div>
              </div>              
            </div>
          </div>
        
        
          
          <!-- TWITTER CARD -->
          
          <div id="card_2" class="card" style="display:none">
            <div class="card-body text-center">
              <div class="clearfix"></div>
              <div class="author">
            
                  <img id="writerPhoto" src="" alt="..." class="avatar-big img-raised border-gray" >
             	  <span id="writerName"></span>
            
            
                <h5 id="title" class="card-title"></h5>
            
              </div>
              <p class="card-description" id="description"></p>
              
                   <div id="tagField" class="w-100" style="padding:15px" >
                          
              </div>
              
              
            </div>
          </div>
          
          
                    
                  <!-- POST PAPER CARD -->
        
          <div id="card_3" class="card" data-background="color" data-color="orange" style="display:none">
           
             
           
            <div class="card-body">
              <div class="author">
                
                  <img id="writerPhoto" src="" alt="..." class="avatar img-raised">
                  <span id="writerName"></span>
               
              </div>
              <span class="category-social pull-right">
                <i class="fa fa-quote-right"></i>
              </span>
              <div class="clearfix"></div>
  
  <h5 id="title" class="card-title"></h5>
 
 
              <p id="description" class="card-description"></p>
              
              
                   <div id="tagField" class="w-100" style="padding:15px" ></div>
              
              
            </div>
          </div>
          
          
                   
         
         <!-- BACKGROUND IMAGE CARD -->
         
          <div id="back_img_card" class="card" data-background="image" 
          style="background-image: url('');
          display:none">
            <div class="card-body">
                <h3 id="title" class="card-title"></h3>
              <div id="description" class="card-description">
              </div>
              
              
                 <div id="tagField" class="w-100" style="padding:15px" >
              </div>
                
              
              <div class="card-footer">
             
               <div class="author">
                 
                    <img id="writerPhoto" src="" alt="" class="avatar img-raised">
                    <span id="writerName"></span>
                
                </div>
             
             
              </div>
            </div>
          </div>
          
          
            
        <!-- CARD TYPE SIMPLE BLOG -->
        
		<div class="card" id="img_card" style="display:none">
            <div class="card-image">            
                <img id="image" class="img" src="">              
            </div>
            <div class="card-body">

              <h5 id="title" class="card-title"> </h5>
             
                 <div id="tagField" class="w-100" style="padding:15px" ></div>
                
              
              <hr />
              <div class="card-footer">
                <div class="author">
                    <img id="writerPhoto" src="" alt="..." class="avatar img-raised">
                    <span id="writerName"></span>
                </div>
                
                
              </div>
            </div>
          </div>
          
          
          
	<span id="dummyBadge" class="badge badge-pill" style="display:none"></span>
          
          
          

        
        
<script>

$(document).ready(function(){
	
	$("img").attr("onError", "this.onerror=null;this.src='${pageContext.request.contextPath}/resources/assets/img/defaults/noimage1.png");
	
	getCommentary();
	
	
	
	
});


 var Colors = {
	
	"1" : "badge-primary",
	"2" : "badge-info",
	"3" : "badge-success",
	"4" : "badge-danger",
	"5" : "badge-warning",
	"6" : "badge-default"
}
 


function getCommentary(){
	
	$.ajax({
		
		url : "/commentary/getCommentary",
		type : "GET",
		data : {id : '${dispId}'},
		success : function(response){
			
			console.log(response);
			preHandler(response);
			
		},
		error : function(xhs, status, error){
			
			
		}
		
		
		
	});
	
	
}

/* 해설 정보 섹션 랜더링 전처리 */
function preHandler(array){
	
	if(!array){
		
		return;
		
	}
	
	console.log(array);
	
	
	for(var i=0; i<array.length; ++i){
		
		
		
		console.log("ID,," + array[i].CMT_ID);
		
		var imgUrl = setImgURL(array[i].CMT_ID);
		var $instance = componentFactory(imgUrl);
		var index = (array.length+1) % 3;
		

		var id = "#card_section_" + (i+1);
		
		$instance.find("#title").html(array[i].CMT_TITLE);
		$instance.find("#description").html(array[i].CMT_INTRODUCE);
		
		$(id).append($instance);
		getDocentInfo(array[i].CMT_WRITERUID, $instance);
		
		getTags($instance,array[i].CMT_ID, array[i].CMT_ISFREE);
		setLocationEvent($instance, array[i].CMT_ID);
		
		
		
		
		}
	

	
}


function componentFactory(imgUrl){
	
	var random;
	var $component;
	
	
	//img가 존재할때 이미지 타입의 카드로 초기화
	if(imgUrl){

		random = Math.floor((Math.random() * 2)+1);
		if(random == 1){
			
			
			$component = $("#back_img_card").clone();
			$component.attr("style", "display:block");
			$component.css("background-image", "url('"+ imgUrl +"')");
			$component.css("display", "block");
			
			return $component;
			
		}else if(random == 2 ){
			
			console.log("random 2 in..."+random);
			
			$component = $("#img_card").clone();
			console.log($component.html());
			$component.attr("style", "display:block");
			
			$component.find("#image").attr("src", imgUrl);
			
			
			return  $component;
		}
		
		//img가 존재하지 않을 때 이미지 필드가 없는 카드로 초기화
	}else{
		
		console.log("random 2..."+random);
		
		random = Math.floor((Math.random() * 3)+1);
		var index = "#card_"+random;
		$component = $(index).clone();
		$component.css("display", "block");
		
		return $component;
		
		
	}
	
	
}


function setCostInfo(id){
	
	var result;
	
	$.ajax({
		
		url : "/commentary/getCostInfo",
		type : "GET",
		async : false,
		data : {id : id},
		success : function(response){
			
			result = response;
			
		},
		error : function(xhs, status, error){
			
			console.log("costInfo error");
			
		}
		
		
		
	});
	
	return result;
	
	
	
}





/* 본문 이미지 가져오기 */
function setImgURL(id, $component){
	
	var result;
	
	$.ajax({
		
		url : "/upload/getSingleImage",
		type : "GET",
		data : {id : id},
		async : false,
		success : function(image){
			console.log(image);
			result = image;
			
		},
		
		error : function(request, status, error){
			
			alert("이미지 수신 에러! " + error + request.status);
			
		}
		
		
		
		
	});
	
	return result;
	
	
}

/* 도슨트 정보 가져오기 */
function getDocentInfo(writerUid, $component){
	
	
	
	$.ajax({
		
		url : "/member/getMemberSimpleInfo",
		type : "GET",
		data : {id : writerUid},
		success : function(memberInfo){
			
			console.log("memberInfo : " +memberInfo.USER_NICK + " " + memberInfo.USER_PROFILEPHOTO);
			
			$component.find("#writerPhoto").attr("src", memberInfo.USER_PROFILEPHOTO);
			$component.find("#writerName").html(memberInfo.USER_NICK);
			
			
		},
		error : function(xhs, status, error){
			
			
			console.log("error! " + xhs.status);
			
		}
		
		
		
	});
	
	
	
}


function badgeColorFactory($component){
	
	console.log("color!");
	var random = Math.floor((Math.random()*6)+1);
	$component.addClass(Colors[random]);
	
	
}


function getTags($component, id, isFree){
	
	
	$.ajax({
		
		url : "/commentary/commentaryGetTags",
		data : {id : id},
		type : "GET",
		success : function(tags){
			
			
			
			var $badge = $("#dummyBadge").clone();
			$badge.attr("style", "display:inline");
			
			console.log(tags);
			
			var $isFreeBadge = $badge.clone();
			$isFreeBadge.html(isFree);
			badgeColorFactory($isFreeBadge);
			$component.find("#tagField").append($isFreeBadge);
			
			if(isFree === "cost"){
				var cost = setCostInfo(id) + " credit";
				var $cost = $badge.clone();
				$cost.html(cost);
				badgeColorFactory($cost);
				$component.find("#tagField").append($cost);

				
				}
			
			
			for(var i = 0; i<tags.length; ++i){
			
				
				var $tBadge = $badge.clone();
				
				$tBadge.addClass("badge-warning badge");
				badgeColorFactory($tBadge);
				$tBadge.html(tags[i]);
				
			$component.find("#tagField").append($tBadge);	

			
			}
			
			
		},
		error : function(xhs, status, error){
			
			
		}
		
		
	});
	
	
	
	
}

function setLocationEvent($componenet, id){
	
	
	$componenet.on("click", function(){
		
		console.log("id : " + id);
		
		location.href="/commentary/commentaryView?id="+ id;
		
		
		
		
	});
	
	
}

  
        
        
</script>
     
    
    

      