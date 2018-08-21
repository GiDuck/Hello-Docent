<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


  <div class="wrapper">
    <div class="main">
      <div class="section section-white">
        <div class="container">
         
          <div class="row">

            <div class="col-md-6 ml-auto mr-auto text-center title">
              <h2>Docent's Posting</h2>
              <h3 class="title-uppercase">
                <small>All story for culture by professional docents</small>
              </h3>
            </div>
          </div>
          
      
      
          <div class="row text-center">
          
          <div class="col-sm-10 " style="padding:5px"><input id="findBlogInput" class="form-control form-control-lg" placeholder="검색어를 입력하세요.."></div>
          <div class="col-sm-2 text-center" style="padding:5px"><div id="findBlogBtn" class="btn btn-lg w-100" style="display:flex" >검색</div></div>
          
          
          </div>
      	
        
        <div class="container">
        
        <div class="row w-100" style="margin:0 auto">
       <br/>
       <br/>
        
        <script>
 		 var items = new Array();
  		</script>
        
        <c:forEach items="${blogs}" var="blog" >
        
        <script> items.push("${blog.COL_ID}"); </script>
        
        <div class="row">
          <div id="blogBody" class="article col-12 w-100 text-center" style="margin:0 auto;">
            <div class="row">
              <div class="col-12">
                <div class="card card-blog card-plain text-center w-100">
                  <div id="blogImage" class="card-image">
                      <img class="img img-raised" name="${blog.COL_ID}" src=""></div>
                  <div class="card-body">
                    <div class="card-category" id="tagging_field">
                      <span class="badge badge-primary main-tag"></span>
                    </div>                  
                      <h3 class="card-title" id="blogTitle">${blog.COL_TITLE}</h3>
                   
                    <div class="card-description"><p id="blog_introduce">${blog.COL_INTRODUCE}</p></div>
                  </div>
                  <button name="readMoreBtn" class="btn btn-danger btn-round btn-sm" value="${blog.COL_ID}">Read more</button>
                <br/>
         		<br/>
         		<br/>
                
                </div>
              </div>
            </div>
          </div>
          <br/>
          <br/>
          <hr/>
          </div>
          
          </c:forEach>
         
         </div>
         </div>
         
 
          
        </div>
      </div>
    </div>
    <div class="container">
    <div class="row text-center">
  <nav aria-label="..." style="margin:0 auto">
  <ul id="pagination" class="pagination">

  </ul>
</nav>
</div>
</div>
    
    
  </div>
  

  
  <script>
  
  $(document).ready(function(){
	  
		//navbar 색상 조절
		$("#basic_navbar").removeClass("navbar-transparent").addClass("fixed-top").addClass("bg-danger");
		//img 태그 요소에 반응형 처리
		$("img").addClass("img-fluid");
		attachMoveEvent();
		onClickFind();
		setOnImage();
		
		
		getBlogSize();
		
  });
  
  
  function attachMoveEvent(){
	  
	  
	  $("button[name=readMoreBtn]").on('click', function(){
		 
		  var id = $(this).attr("value");
		  
		  
		  location.href="/blog/blogView?id="+id;
		  
	  });
	  
	  
  }
  
  function onClickFind(){
	  
	$("#findBlogBtn").on('click', function(){
		
		var keyword = $("#findBlogInput").val();
		if(keyword.trim().length<3){
			
			alert("검색어는 두 자리 이상이어야 합니다.");
			return;
		}
		
		
		location.href="/blog/blogMain?pageNum=1&keyword="+keyword;
		
	});
	
	  
  }
  
  function setOnImage(){
	  
	  
	  
	  for(var i=0; i<items.length; ++i){
		  
	  var key = "img[name="+ items[i] +"]";
	  
	  var $component = $(key);
	  getImage($component, items[i]);
	  
	  }
	  
	  
	  
  }
  
  function getImage($component, id){
	  
	  $.ajax({
		  
		  url : "/blog/getSingleBlogImage",
		  data : {id : id},
		  type : "GET",
		  success : function(imgUrl){
			  
			  console.log("received url : " +imgUrl);
			  if(!imgUrl || imgUrl.trim()==="")
				  $component.remove();
			  
			  $component.attr("src", imgUrl);
			  
		  },
		  error : function(xhs, status, error){
			  
			console.log("error : "+ status);  
			  
		  }
		  
	  });
	  
	  
  }

  
  function getBlogSize(){
	  
	  
	  $.ajax({
		  
		 url : "/blog/getBlogSize",
		 type : "GET",
		 data : {keyword : '${keyword}'},
		 success : function(size){
			 
			 console.log("get blog size... " + size);
			 setPagination(size);
			 
		 },
		 error : function(xhs, status, error){
			 
			 console.log("size get error... " + status);
			 
			 
		 }
		  
	  });
	  
	  
  }
  
  
  











  
  function setPagination(size){
	
	var pageNum = '${pageNum}';
	var isEndPage = false;
	
	
	/* 10개 단위로 앞, 뒤로 넘어가기 */
	var prev = (pageNum-1) * 10;
	var next = (pageNum+1) * 10;
	
	var min = 1;
	var max = size;
	
	
	
	/* 시작, 끝 (10개 단위) */
	var start = parseInt(((pageNum-1)/10)*10 + 1);
	var end = parseInt((((pageNum-1)/10)+1)*10);
	
	var sizeDiv = parseInt(size/10);
	
	console.log("sizeDiv " + sizeDiv);
	
	if ((pageNum-1) == sizeDiv){
	
		
		isEndPage = true;
		end = sizeDiv + 1;
		
	}
	
	console.log("start : " + start);
	console.log("end : " + end);
	
	
	var $root = $("#pagination");
	var $prv_disable = $('<li id="previous-disable" class="page-item"><span class="page-link">Previous</span></li>');
	var $prv = $('<li id="previous" class="page-item"><a class="page-link" href="#">Previous</a></li>');
	var $next_disable = $('<li id="next-disable" class="page-item"><span class="page-link">Next</span></li>');
	var $next = $('<li id="next" class="page-item"><a class="page-link" href="#">Next</a></li>');
	var $pageNum = $('<li id="pageNum" class="page-item"><a class="page-link" href="#">1</a></li>');
	var $pageNum_selected = $('<li class="page-item active" id="pageNum-selected"><span class="page-link">2'+
			    '<span class="sr-only">(current)</span></span></li>');
	console.log ("size : " + size);

	
	console.log("isEndPage : " + isEndPage);
	
	if (isEndPage){		
		$root.append($prv_disable);
	}else{
		$prv.attr("href", "/blog/blogMain?pageNum="+((pageNum-1)*10)+"&keyword="+'${keyword}');
		$root.append($prv);
		
	}
	
	for(var i = start; i< end+1; ++i){
		
		console.log ("now : " + i);
		var $node;
		if(pageNum == i){
			
		$node = $pageNum_selected.clone();
		$node.find(".page-link").html(i);
		$node.find(".page-link").attr("href", "/blog/blogMain?pageNum="+(i)+"&keyword="+'${keyword}');
		$root.append($node);
			
		}else{
			
		$node = $pageNum.clone();
		$node.find(".page-link").html(i);
		$node.find(".page-link").attr("href", "/blog/blogMain?pageNum="+(i)+"&keyword="+'${keyword}');
		$root.append($node);
		}
		
	}
	
	if (isEndPage){
		$root.append($next_disable);
	}else{
		
		$prv.attr("href", "/blog/blogMain?pageNum="+((pageNum+1)*10)+"&keyword="+'${keyword}');
		$root.append($next);
	}
	
	


	
	
	  
	  
	  
	  
  }
  
  
  </script>