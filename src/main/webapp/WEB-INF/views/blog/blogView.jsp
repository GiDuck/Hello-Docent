<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src=" https://code.jquery.com/jquery-3.3.1.min.js"></script>    

  <div class="wrapper">
    <div class="main">
      <div class="section section-white">
        <div class="container">
          <div class="row">
            <div class="col-md-6 ml-auto mr-auto text-center title">
              <h2>${blog.col_title}</h2> 
            </div>
          </div>
          
          <div class="row">
            <div class="col-md-10 ml-auto mr-auto">
              <div class="text-center">
              
              <div class="col-md-6">
              <c:forEach var="item" items='${tags}'>
                <span class="badge badge-warning main-tag" style="margin-bottom:20px">${item}</span>
               </c:forEach>
               </div>       
                      
                      <h6 class="title-uppercase"><fmt:formatDate value="${blog.col_date}" pattern="yyyy년 MM월 dd일"/></h6>
      
      
      
              </div>
            </div>
            
            
            
            <div class="col-md-8 ml-auto mr-auto">
             
              <div class="article-content" style="margin:30px">
               
               ${blog.col_content}
               
              </div>
              <br/>
              <div class="article-footer">
                <div class="container">
                  <div class="row">
                    <div class="col-md-6">
                      <h5>Tags:</h5>
                    
                      <c:forEach var="item" items='${tags}'>
                      <span class="badge badge-warning">${item}</span>
                      </c:forEach>
                      
                    </div>
                    
                    <div class="col-md-6">
                    
                    <div class="row w-100" id="control-panel" style="display:none">
                    
                    <div class="col-6"><div id="comModifyBtn" class="btn w-100">수정하기</div></div>
                    <div class="col-6"><div id="comRemoveBtn" class="btn btn-danger w-100">삭제하기</div></div>
                    
                    </div>
                    
                    </div>
                  
                  </div>
                </div>
              </div>
              <hr>
              
              
              
              <div class="container">
                <div class="row">
                  <div class="media">
                    <a class="pull-left" href="#paper-kit">
                      <div class="avatar big-avatar">
                        <img class="media-object" alt="64x64" src="${pageContext.request.contextPath}/resources/assets/img/faces/kaci-baum-2.jpg">
                      </div>
                    </a>
                    
                    
                    <div class="media-body">
                      <h4 class="media-heading">Sophie Banks</h4>
                      <div class="pull-right">
                      </div>
                      <p>Hello guys, nice to have you on the platform! There will be a lot of great stuff coming soon. We will keep you posted for the latest news.</p>
                      <p> Don't forget, You're Awesome!</p>
                     <a href="#paper-kit" class="btn btn-danger btn-round pull-right "> <i class="fa fa-reply"></i> Follow</a>
                      
                    </div>
                    
                    
                  
                    
                    
                  </div>
                </div>
                
                
                <div class="container-fluid">
               
                <div class="row w-100">
   
                  <h3 class="text-center">Comments</h3>         
                  <div id="replyContainer" class="comments media-area w-100"></div>

                  </div>
                  </div>
                  
                  
                  
           <!-------------------- 일반 댓글 Dummy ------------------->
                
                
                
                       <div id="dummyReplyView" class="media media w-100" style="display:none;">

                      <a class="pull-left">
                        <div class="avatar">
                          <img id="reply_writer_photo" id="reply_writer_photo" class="media-object" alt="64x64" src="${pageContext.request.contextPath}/resources/assets/img/defaults/noimage_people.png">
                        </div>
                      </a>
                      
                   
                      <div class="media-body">
                      <div class="row">
                     <div class="col-12 col-md-5">
                        <h5 class="media-heading" id="reply_writer"></h5>
                     </div>
                     <div class="col-12 col-md-7">
                        <div class="pull-right">
                          <small class="text-muted" id="reply_date"></small>
                        </div>
                        </div>
                       <div class="col-12" style="margin:5px">
                       <div id="reply_content"></div>
                      </div>
                      </div>
                      </div>
                      
                      <div id="myComponent" style="display:none; width:100%;">
                      <div class="row">
                     <div id="reply_modifyBtn" class="btn btn-info btn-link pull-right col-12 col-sm-4"> <small><i class="fa fa-pencil"></i> Modify</small></div>
                     <div id="reply_removeBtn" class="btn btn-info btn-link pull-right col-12 col-sm-4"> <small><i class="fa fa-eraser"></i> Remove</small></div>
                     <div id="reply_mini_Btn" class="btn btn-info btn-link pull-right col-12 col-sm-4"> <small><i class="fa fa-reply"></i> Reply</small></div>
                      </div>
                      </div>
                   <div id="reply_replyBtn" class="btn btn-info btn-link pull-right "> <i class="fa fa-reply"></i> Reply</div>
                   <div id="replyPostArea"></div>  
                      
                    </div>
                    <!-- end media -->
                
                  
                  
              
              
              
         <!-------------------- 대댓글이 달리는 원 댓글 Dummy ------------------->
              
            <div class="media w-100" id="refReplyOriginDummy" style="display:none;">
                    
  
                    <div class="media-body">              
	               
	                 <a class="pull-left">
                        <div class="avatar">
                          <img id="reply_writer_photo" class="media-object" alt="profile" src="${pageContext.request.contextPath}/resources/assets/img/defaults/noimage_people.png">
                        </div>
                      </a>
	               
	               <div class="row">
	               <div class="col-12 col-md-4">
                     <h5 id="reply_writer" class="media-heading"></h5></div>
                     
                     <div class="col-12 col-md-8">
           			 <div class="pull-right">
                   <small id="refReplyOriginDate" class="text-muted"></small>
                 	</div>
                 	</div>
                 
 
 					<div class="col-12">
                      <div id="refReplyOriginContent" ></div></div>  
                     
                     <div class="col-12">
                     <div class="align-right w-100 row">
				     <div id="reply_replyBtn" class="btn btn-info btn-link"> <i class="fa fa-reply"></i> Replys</div>
                     </div></div>
                     
                       
                   <div id="myComponent" style="display:none; width:100%;">
                     <div class="row">
                     <div id="reply_modifyBtn" class="btn btn-info btn-link pull-right col-12 col-sm-4"> <small><i class="fa fa-pencil"></i> Modify</small></div>
                     <div id="reply_removeBtn" class="btn btn-info btn-link pull-right col-12 col-sm-4"> <small><i class="fa fa-eraser"></i> Remove</small></div>
                     <div id="reply_mini_Btn" class="btn btn-info btn-link pull-right col-12 col-sm-4"> <small><i class="fa fa-reply"></i> Reply</small></div>
                   </div>
                   </div>
                   
                     <div class="row w-100">
                     <div id="refReplyOriginDummyBody" class="col-12 w-100"></div>
                     </div>

                     </div>
                     </div>
             </div>
               
                
  
  
      <!-------------------- 대댓글 Dummy ------------------->
                   
               
                <div class="media" id="refReplyDummy" style="display:none;" >
                
                 
                
                         <a class="pull-left">
                           <div class="avatar">
                              <img id="reply_writer_photo" class="media-object" alt="64x64" src="${pageContext.request.contextPath}/resources/assets/img/defaults/noimage_people.png">
                            </div>
                          </a>
                 
               		 <div class="media-body">
   
  				 <div class="row">
 						 <div class="col-12 col-md-5">   
 						 <h5 id="reply_writer" class="media-heading"></h5>
 						 </div>
 						 
 						 <div class="col-12 col-md-7">
                            <div class="pull-right">
                             <small id="refReplyDate" class="text-muted"></small>
                            </div>
                          </div>
                            
                         
                        <div class="col-12" style="margin:5px">
                        <div id="refReplyContent"></div></div>
                        
                     
                        
                      </div>  
                      
                      
                     <div id="myComponent" class="row" style="display:none; width:100%;">
                     <div class="col-sm-4"></div>
                     <div id="reply_modifyBtn" class="btn btn-info btn-link pull-right col-12 col-sm-4"> <small><i class="fa fa-pencil"></i> Modify</small></div>
                     <div id="reply_removeBtn" class="btn btn-info btn-link pull-right col-12 col-sm-4"> <small><i class="fa fa-eraser"></i> Remove</small></div>

                   </div>
                        
                      
                      </div>                  
                          
 			 </div>      
              
                
  
                
    
                  
                
              
              
 <!-- Reply Post -->
    <div id = "replyPost" class="container">
     
        <h3 class="text-center">Post your comment</h3>
            <div class="media media-post">   
                <div class="media-body">

                  <textarea id="postReplyContent" class="form-control" placeholder="댓글을 입력해 주세요..." rows="6"></textarea>
                  <div class="media-footer" style="margin:3px;">
                 
                    <a id="postReplyBtn" class="btn btn-primary btn-round" style="position : right">Post Comment</a>
                  </div>
                </div>
                <!-- end media-body -->
            </div>
	  </div>
              
              
              
          <div class="row">
            <div class="related-articles">
              <h3 class="title">Related articles</h3>
              <legend></legend>
              <div class="container" >
                <div class="row" id="relatedContainer">
                  <div id="relatedBody" class="col-md-4" style="display:none">
                 
                      <img id="relatedImg" src="" alt="..." class="img-rounded img-responsive">
                   
                    <h6 id="relatedTitle" class="blog-title text-center" style="padding:10px"></h6>
                  </div>
             
                </div>
              </div>
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

 
  
  
  $(document).ready(function(){
	  
		//navbar 색상 조절
		$("#basic_navbar").removeClass("navbar-transparent").addClass("fixed-top").addClass("bg-danger");
		//img 태그 요소에 반응형 처리
		$("img").addClass("img-fluid");

		
		$("#postReplyBtn").on('click', function(){
			
			postReply("");
			
		
		
		}); 
		
		initControlPanel();
		getReplys();
		setRelatedPostingArea();
		
	  
});
  
	function initControlPanel(){

		if('${sessionScope.userVO.user_iuid}' === '${blog.col_writeruid}'){
		
		$("#control-panel").attr("style","inline");
		}
		
		$("#control-panel").find("#comModifyBtn").on('click', function(){
		
			location.replace("/blog/blogModifyView?id="+'${blog.col_id}');
			
		});
		
		
		$("#control-panel").find("#comRemoveBtn").on('click', function(){
		
			
			var confirm = window.confirm("정말 삭제하시겠습니까? 관련된 모든 정보가 사라집니다.");
			if(confirm){
			location.replace("/blog/blogDelete?id="+'${blog.col_id}')}
			else{
				
				return;
			}

			
		});

	}

  
  function postReply(repRef){
	  var content = $("#postReplyContent").val();
	  var writerUid = '${sessionScope.userVO.user_iuid}';
	  
	  if(!content.trim()){
		  alert("댓글은 한 글자이상 입력 해야 합니다.");
		  return;
		  
	  }else if(!writerUid){
		  alert("로그인 정보가 없습니다. 먼저 로그인 해 주세요.");
		  return;
		  
	  }
	  
	  
	  var reply = {
				
				colr_id : "",
				colr_ref : '${blog.col_id}',
				colr_repref : repRef,
				colr_writeruid : '${sessionScope.userVO.user_iuid}',
				colr_content : $("#postReplyContent").val(),
				colr_date : new Date()
	
				
		};

			$.ajax({
				
				type:"POST",
				url : "/reply/insertBlogReply",
				data : JSON.stringify(reply),
				contentType:"application/json",
				success : function(response){
					
					alert("댓글이 성공적으로 작성되었습니다.");
					$("#postReplyContent").val("");
					getReplys();
				},
				error : function(xhs, status,error){
					
					alert("댓글 작성이 실패하였습니다.");
					
				}
				
			
			}); 
		 
	  
  }
  
  
  
  
  
  function postReplyUpdate(reply, $instance){
	  
	  var content = $instance.find("#postReplyContent").val();
	  reply.colr_content = content;
	  
	  if(!content.trim()){
		  alert("댓글은 한 글자이상 입력 해야 합니다.");
		  return;
		  
	  }
	  

			$.ajax({
				
				type:"POST",
				url : "/reply/updateBlogReply",
				data : JSON.stringify(reply),
				contentType:"application/json",
				success : function(response){
					
					alert("댓글이 성공적으로 수정되었습니다.");
					$instance.remove();
					getReplys();
				},
				error : function(xhs, status,error){
					
					console.log(status + "error!");
					
				}
				
			
			}); 
		 
	  
  }
  
  
  function getReplys(){
	  
	  
	  $.ajax({
		 
		  url : "/reply/selectBlogReply",
		  type : "GET",
		  data : {id : '${blog.col_id}'},
		  success : function(response){
			  
			 console.log("받아온 reply... " + JSON.stringify(response, null, "\t"));
			 renderingHandler(response);
			  
			  
		  },
		  error : function(xhs, status, error){
			  
			  console.log(error + " " + status);
			  
		  }
		  
		  
	  });
	  
	  
	  
  }
  
  
  
  
  
  function renderingHandler(container){
	  
	  var writerPhoto;
	  
	  var replyList = container.hasNotAnyRef;
	  var keySet = new Array();
	  keySet = Object.keys(container);
	  
	  var $dummyReply = $("#dummyReplyView").clone();
	  var $refReplyDummy = $("#refReplyDummy").clone(); 
	  var $refReplyOriginDummy = $("#refReplyOriginDummy").clone(); 
	  var $replyArea = $("#replyPost").clone();
 
	  var $field = $("#replyContainer").empty();
		//대댓글이 아닌 일반 댓글 rendering
		
		
		
		
	  for(var i=0; i<replyList.length; ++i){
		  	
		  
		  
		  //대댓글이 참조하는 원 댓글 rendering
		  if(keySet.includes(replyList[i].colr_id)){
			  
			  console.log("keySet에 들어있습니다.. ");
			  
			  renderingRefOriginReplys($refReplyOriginDummy, $field, $replyArea, replyList[i], calMyDoc(replyList[i].col_writeruid));
			  
		  
		  }else{
			  
			  
			  renderingReplys($dummyReply, $field, $replyArea ,replyList[i], calMyDoc(replyList[i].col_writeruid));
			  
			  
			  
		  }

		  
	  }
		
		
		//대댓글 rendering
		
		for(var i=0; i<keySet.length; ++i){
			
			//일반 댓글이면 통과
			if(keySet[i] === "hasNotAnyRef"){
				continue;
				}
			
			
			//각 key별 댓글 리스트를 rendering
			var refReps = container[keySet[i]];
			
			console.log("keySet is.. " + keySet[i] + " "+ JSON.stringify(refReps, null, "\t"));
			console.log("keySet size... " + refReps.length);
			
			for(var j=0; j<refReps.length; ++j){
				
				var id = "#"+keySet[i];
				var $ref = $(id);
				console.log("WARNING : " + refReps[j]);
				renderingRefReplys($refReplyDummy, $ref, $replyArea ,refReps[j], calMyDoc(refReps[j].colr_writeruid));
		
				
			}	
		}  
  }
  
  
  function calMyDoc(compareUid){
	  
	 	  
	  return compareUid ==='${sessionScope.userVO.user_iuid}'? true : false;
	  
	  
	  
  }
  
  
	//대댓글이 아닌 일반 댓글 rendering 하는 함수
  function renderingReplys($component, $field, $postArea, reply, isMyDoc){
	  
		
	  var $instance = $component.clone(); 
	  var $replyArea = $postArea.clone();

	
	  $instance.attr("id", reply.colr_id);
	  $instance.attr("style", "display:block");
	  $instance.find("#reply_date").html(getFormatDate(new Date(reply.colr_date)));
	  $instance.find("#reply_content").html(reply.colr_content);
	  getMemberPhoto($instance, reply.colr_writeruid);
	  
	  if(isMyDoc){
		 
		  attachEventMyComponent ($instance, $replyArea, reply); 
		  
	  }else{
		  
	  attachEvent($instance, $replyArea, reply);
	  
	  }
	  
	  
	  
	  
	  $field.append($instance);
	  
	  
  }
  
  
	//대댓글이 참조하는 댓글을 rendering 하는 함수
  function renderingRefOriginReplys($component, $field, $postArea, reply, isMyDoc){
	  

	  var $instance = $component.clone();
	  var $replyArea = $postArea.clone();

	
	  $instance.attr("id", reply.colr_id);
	  $instance.attr("style", "display:block");
	  $instance.find("#refReplyOriginDate").html(getFormatDate(new Date(reply.colr_date)));
	  $instance.find("#refReplyOriginContent").html(reply.colr_content);
	  getMemberPhoto($instance, reply.colr_writeruid);
	  
	  if(isMyDoc){
		  attachEventMyComponent ($instance, $replyArea, reply); 
		  
	  }else{
		  
	  attachEvent($instance, $replyArea, reply);
	  
	  }
	  
  
	  $field.append($instance);  
	  
  }
  
	//대댓글을 rendering 하는 함수
  function renderingRefReplys($component, $ref, $postArea, reply, isMyDoc){
	
		var $instance = $component.clone();	
		var $replyArea;
		if($postArea){
		$replyArea = $postArea.clone();
		}

	  $instance.attr("id", reply.colr_id);
	  $instance.attr("style", "display:block");
	  $instance.find("#refReplyDate").html(getFormatDate(new Date(reply.colr_date)));
	  $instance.find("#refReplyContent").html(reply.colr_content);
	  getMemberPhoto($instance, reply.colr_writeruid);
	  
	  if(isMyDoc){
		  
		  attachEventMyComponent ($instance, $replyArea, reply); 
		  
	  }
	  
	  
	  	  
	  $ref.find("#refReplyOriginDummyBody").append($instance);
 
  }
  
  
  
  
  
  //Reply 버튼에 이벤트를 부착하는 함수 (toggle 기능)
  function attachEvent($instance, $replyArea, replyInfo){
	  
	  $instance.find("#reply_replyBtn").on('click', function(){
			
		 var $replyPostArea = $replyArea.clone();

		 console.log("find length : " + $instance.find("#replyPost").length);	
		
		 if($instance.find("#replyPost").length > 0){
		
			 $instance.find("#replyPost").remove();
			
		 }else{
		 
			
			$instance.append($replyPostArea);
			attachPostReply($instance, $replyPostArea, replyInfo, 'insert');
		 
		 };
		 
	  });
	  
  }
  
  
  
  
  function attachEventMyComponent($instance, $replyArea, replyInfo){
	  
	  var $myComponent = $instance.find("#myComponent");
	  setMyComponent($instance);
	  
	  if($replyArea){
	  var $replyPostArea = $replyArea.clone();
	  }
	  
	  if($instance.find("#reply_replyBtn").length > 0){
		  
		  $instance.find("#reply_replyBtn").remove();
		  
	  }
	  
	  
	  
	  $myComponent.find("#reply_modifyBtn").on('click', function(){
		  
		  
		  var $replyPostArea = $replyArea.clone();

			
			 if($instance.find("#replyPost").length > 0){
			
				 var confirm = window.confirm("작성했던 내용이 모두 삭제됩니다. 진행 하시겠습니까?");
				 if(confirm){
				 
					 $instance.find("#replyPost").remove();
				 
				 }else{
					 
					 return;
					 
				 }
				 
				 
			 }else{
				 
							
				 $replyPostArea.find("#postReplyContent").html(replyInfo.colr_content);
				 $instance.append($replyPostArea);
				 attachPostReply($instance, $replyPostArea, replyInfo, 'update');
			 
			 };
		  
		  
		  
	  });
	  
	  
	  
	  
 	  $myComponent.find("#reply_removeBtn").on('click', function(){
		  
 		  var confirm = window.confirm("정말 삭제하시겠습니까?");
 		  if(confirm){
 		 requestRemove(replyInfo.colr_id);
 		  }else{
 			  return;
 		  }
	  });
 	  
 	  if($myComponent.find("#reply_mini_Btn").length>0){
 	  
  	  $myComponent.find("#reply_mini_Btn").on('click', function(){
		  
 
  		  
  		 var $replyPostArea = $replyArea.clone();

		
		 if($instance.find("#replyPost").length > 0){
		
			 $instance.find("#replyPost").remove();
			
		 }else{
		 
			
			$instance.append($replyPostArea);
			attachPostReply($instance, $replyPostArea, replyInfo, 'insert');
		 
		 };
		 
  		
	  });
  	  
 	  }
	  
	  
  }
  
  // 삭제 ajax 요청 함수
  
  function requestRemove(id){
	  
	  console.log("requestRemove! " + id);
	  
	  
	  $.ajax({
		 
		  url : "/reply/removeBlogReply",
		  type : "GET",
		  data : {id : id},
		  success : function(response){
			  
			  alert("삭제 성공");
			  getReplys();
			  
			  
		  },
		  error : function(xhr, status, error){
			  
			  
			  
			  alert("댓글을 삭제하던 도중에 에러가 발생 하였습니다. " + status);
		  }
		  
		  
	  });
  }
  
  //수정 ajax 요창 함수
  
  function requestModify(reply){
	  
	  $.ajax({
			 
		  url : "/reply/updateBlogReply",
		  type : "POST",
		  data : {param : reply},
		  success : function(response){
			  
			  alert("수정 성공");
			  getReplys();

			  
			  
		  },
		  error : function(xhr, status, error){
			  
			  
			  alert("댓글을 수정하던 도중에 에러가 발생 하였습니다. " + status);
		  }
		  
		  
	  });
	  
	  
  }
  
  
  //modify, remove 기능 등을 사용할 수 있는 myComponent 기능을 visible, non visible 하는 기능
  function setMyComponent($instance){
	  
	  
	  var $myComponent = $instance.find("#myComponent");
	  
	  if($myComponent.css("display") ==='none'){
		  
		  
		  $myComponent.attr("style", "display:inline");
		  
		  $myComponent.find("#reply_replyBtn").attr("style", "display:none");
		  
		  
	  }else{
		  
		  
		  $myComponent.attr("style", "display:none");
	  }
		  
		  
		  
	  }
	  
	 
  
  
  
  //Reply를 작성한 댓글을 Post 하는 버튼(Reply Area 내부에 있는 버튼)에 이벤트를 부착하는 버튼
  function attachPostReply($instance, $replyPostArea, replyInfo, token){
	  

	  $replyPostArea.find("#postReplyBtn").on('click', function(){
		  if(token ==='insert'){
		  postReply(replyInfo.colr_id);
		  }
		  else if(token ==='update'){
			  
		  postReplyUpdate(replyInfo, $instance);
		  };
		  
		  $instance.find("#replyPost").remove();
		  
		  
		  
	  });
	  
	  
  }
  
  
  function getFormatDate(date){

		var year = date.getFullYear();  
		var month = (1 + date.getMonth());                    
		month = month >= 10 ? month : '0' + month;
		var day = date.getDate();                                       
		day = day >= 10 ? day : '0' + day;             
		var hour = date.getHours();
		hout = hour<10? hour="0"+hour : hour;
		var min = date.getMinutes();
		min = min<10? min="0"+min : min;
		return  year + '년 ' + month + '월 ' + day + '일 ' + hour+':'+ min;

	}

 

	  
	  
	  function getMemberPhoto(element, iuid){
		  
		  
		  $.ajax({
			  
			  url : "/member/getMemberSimpleInfo",
			  type : "GET",
			  data : {id : iuid},
			  success : function(response){
				 
				  
				  element.find("#reply_writer_photo").attr("src", response.USER_PROFILEPHOTO);
				  element.find("#reply_writer").html(response.USER_NICK);
	  
				  
			  },
			  error : function(xhs, status, error){
				  
				  console.log("error! --> " + status);
				  
			  }
			  
		  });
		  
		  
	  }
	  
	 
	  
	  
	  function setRelatedPostingArea(){
		  
		  
		  $.ajax({
			 
			  url : "/commentary/getCommentary",
			  type : "GET",
			  data : {id : '${blog.col_writeruid}'},
			  success : function(posting){
				  
				  
				  console.log("posting");
				 console.log(posting);
				  
				  for(var i = 0 ; i < posting.length; ++i){
				 
				  var postObj = posting[i];
				 
				  

					   if(posting.col_id === '${blog.col_id}')
						  continue;
					   
				  
				  var $postNode = $("#relatedBody").clone();
				  $postNode.attr("style","display:block");
				 
				  var action = function($component, url){
					  
					$component.find("#relatedImg").attr("src", url);
	  
					  
					  
				  };
				  			
				  
				  setImage($postNode, action, postObj.cmt_ID); 
				  $postNode.find("#relatedTitle").html(postObj.col_title);
				
				$postNode.on('click', function(){
					console.log("url id : " + postObj.col_id);
						var url = "/blog/blogView?id=" + postObj.col_id;
						console.log("url " + url);
						location.href=url;
						
						
					});
				  
				 
				  $("#relatedContainer").append($postNode);
				 
				  
			  } 
				  },
			  error : function(xhs, status, error){
				  
				  
				  
			  }
			  
			  
		  });
		  
	  }
	  
	  
	  function setImage($component, action , id){
		  
		  $.ajax({
			  
			  url : "/blog/getSingleBlogImage",
			  type : "GET",
			  data : {id : id},
			  success : function(url){
				  
				  action($component, url);
				  
				  
				  
			  },
			  error : function(xhs, status, error){
				  
				  
				  
			  }
			  
		  });
		  
	  }
	  
	  
  
  </script>