<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@page import="com.spov.hellodocent.domain.LoginSessionDTO"%>
<%@page import="com.spov.hellodocent.tools.UidMaker"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
 
<%

  
String commentaryUid = UUID.randomUUID().toString();


%>

<%-- <c:set var="user_uid" value="${sessionScope.userVO.user_iuid}"/> --%>
  




  <div class="main add-product">
    <div class="section">
      <div class="container">
      <div class="row" style="margin:20px">
        <h3><b>해설 등록하기</b></h3>
      
        
        </div>
     
        
        <div class="row" style="margin:20px" >
        
        <div class="col-3" style="display:flex; align-items:center;">
		 <c:set var="scheme" value="http://"/>
        
        <img src="${scheme}${params.DPL_IMAGEURL}" 
        class="img-responsive rounded" alt="display" style="width:100%; height:auto; margin: 0 auto">
        
        
        </div>
        
        
        <div class="col-9" >
        
        <div class="row" style="display:flex; align-items:center;">
        <div class="col-12"><h6>${params.DP_NAME}</h6></div>
        <div class="col-12"><h6>${params.DPL_ALTERNATIVETITLE}</h6></div>
        <div class="col-12"><h6>${params.DPL_TEMPORAL}</h6></div>
        <div class="col-12"><h6>${params.EP_NAME}</h6></div>
		</div>
		
        
        </div>
   
        </div>
        

        
          <div class="row">
           
            <div class="col-md-12 col-sm-12">
              <div class="form-group">
                <h6>TITLE
                  <span class="icon-danger">*</span>
                </h6>
                <input id="co_title" type="text" class="form-control border-input" placeholder=" 제목을 입력하세요...">
              </div>
              <div class="form-group">
                <h6>INTRODUCE</h6>
                <textarea class="form-control" id="co_introduce" rows="3" placeholder="소개를 입력하세요..."></textarea>
              </div>
              <div class="row price-row">
                <div class="col-md-6">
                  <h6>DATE
                    <span class="icon-danger">*</span>
                  </h6>
                  <div class="input-group border-input">
                    <input id="co_date" type="text" value=<fmt:formatDate value="<%=new Date() %>" pattern="yyyy-MM-dd"/> class="form-control border-input" readonly="readonly">
                    <div class="input-group-append">
                      <span class="input-group-text"><i class="nc-icon nc-calendar-60"></i></span>
                    </div>
                  </div>
                </div>
                <div class="col-md-6">
                 
                 <h6>Content Type<span class="icon-danger"> *</span></h6>
                 
			     <select id="content_type" class="form-control border-input">
			     <option value="text" selected>TEXT</option>
			     <option value="video">VIDEO</option>
			     <option value="voice">VOICE</option>
			     </select>              
                </div>
              </div>
              <div class="container">
     
              <div class="form-group">
                <h6>Description</h6>
              <textarea id="editor"></textarea>
            <script type="text/javascript">
          var froala =  $('#editor').froalaEditor({
            	
            	height : 500,
            	
            	disableRightClick : true,
            	
            	placeholderText : '내용을 작성해 주세요.',
        
		        // Set the image upload parameter.
		        imageUploadParam: 'image',
		 
		        // Set the image upload URL.
		        imageUploadURL: '/upload/imageUpload',
		 
		        // Additional upload params.
		        imageUploadParams: {boardUid: '${display_uid}', id : '<%=commentaryUid%>'},
		 
		        imageUploadRemoteUrls: true,
		   
		        
		        // Set request type.
		        imageUploadMethod: 'POST',
		 
		        // Set max image size to 5MB.
		        imageMaxSize: 5 * 1024 * 1024,
		 
		        // Allow to upload PNG and JPG.
		        imageAllowedTypes: ['jpeg', 'jpg', 'png']
		      })
		      .on('froalaEditor.image.beforeUpload', function (e, editor, images) {

		    	 	console.log("file content : " +  images[0].name);
		    	 	console.log("file size : " +  images[0].size/1024 + "kb");

		    	  
		    	  // Return false if you want to stop the image upload.
		      })
		      .on('froalaEditor.image.uploaded', function (e, editor, response) {
		    	    
		        // Image was uploaded to the server.
		      })		      
		      
		      .on('froalaEditor.image.beforeRemove', function (e, editor, $img) {
		        // Image was before removed in the editor.
		    	  

		      })
		      .on('froalaEditor.imageManager.beforeDeleteImage', function (e, editor, $img) {
		        // Image was inserted in the editor.
		    	
		      })
		      .on('froalaEditor.image.inserted', function (e, editor, $img, response) {
		        // Image was inserted in the editor.

		      })
		      .on('froalaEditor.image.replaced', function (e, editor, $img, response) {
		        // Image was replaced in the editor.
		    	  alert("replaced! --> " + response);

		      })
		      .on('froalaEditor.image.error', function (e, editor, error, response) {
		        // Bad link.
		        if (error.code == 1) {  }
		 
		        // No link in upload response.
		        else if (error.code == 2) { }
		 
		        // Error during image upload.
		        else if (error.code == 3) { }
		 
		        // Parsing response failed.
		        else if (error.code == 4) {  }
		 
		        // Image too text-large.
		        else if (error.code == 5) { }
		 
		        // Invalid image type.
		        else if (error.code == 6) {}
		 
		        // Image can be uploaded only to same domain in IE 8 and IE 9.
		        else if (error.code == 7) { }
		 
		        // Response contains the original server response to the request if available.
		      });
            
            
            
/*             .on('froalaEditor.image.removed', function (e, editor, $img) {
		        // Image was removed in the editor.
		    	
		        alert("removed! --> " + $img.attr("src"));

		      }) */
		      
		      
		      
		      
		      
		      

            </script>

              </div>
              </div>
             
            </div>
            
            
           	<div class="sector">
             <div class="col-md-12 col-sm-12">
             
              <h6>Tags</h6>
              <div class="row">
             
              <div class="col-6">
              <input class="border-input form-control" id="input_tags" placeholder="태그 입력..">
              </div>
             
              <div class="col-4">
              <div class="btn" id="btn_tagging">tagging</div>
              </div>
              
                <div class="col-2"></div>
              
              
              </div>
              <div id="tags">
                <input id="tagging_field" class="tagsinput" data-color="success" type="text" value="" data-role="tagsinput" />
                <!-- <div class="tagsinput-add"></div> -->
                <!-- You can change "tag-primary" with with "tag-info", "tag-success", "tag-warning","tag-danger" -->
              </div>
             
              <h6>COST
                <span class="icon-danger">*</span>
              </h6>
              <div class="form-check-radio">
                <label class="form-check-label">
                  <input class="form-check-input" type="radio" name="free_or_cost" value="free" checked> 무료(Free)
                  <span class="form-check-sign"></span>
                </label>
              </div>
             
              <div class="form-check-radio">
                <label class="form-check-label">
                  <input class="form-check-input" type="radio" name="free_or_cost" value="cost" > 유료(Cost)
                  <span class="form-check-sign"></span>
                </label>
              </div>
              
              <div class="form-group" id="cost_info" style="display:none">
              
              <h6>가격 책정</h6>
              
                <label class="form-check-label">
                 <select class="form-control border-input" id="credit_select">
                 <option value="0">credit</option>
                 <option value="10">10 credit</option>
                 <option value="25">25 credit</option>
                 <option value="50">50 credit</option>
                 <option value="100">100 credit</option>
                 </select>
           
                </label>
              
              <label class="border-input">
              
              <input type="text" class="form-control border-input" id="input_credit" placeholder="직접 책정하기..">
              
              
              </label>
              
              
              </div>
              
            </div>
            
            </div>
            
            
          </div>
          <div class="row buttons-row">
            <div class="col-md-4 col-sm-4">
              <button class="btn btn-outline-danger btn-block btn-round">취소</button>
            </div>
            <div class="col-md-4 col-sm-4">
              <button class="btn btn-outline-primary btn-block btn-round">임시저장</button>
            </div>
            <div class="col-md-4 col-sm-4">
              <button class="btn btn-primary btn-block btn-round" id="btn_submit">저장 및 발행</button>
            </div>
          </div>

      </div>
    </div>
  </div>

  <script>

  
  $(document).ready(function(){
	  
		//navbar 색상 조절
	  
		$("#basic_navbar").removeClass("navbar-transparent").addClass("fixed-top").addClass("bg-danger");
		

		
		
	  
  });
  
  

	//태깅 버튼 클릭 시 
	$("#btn_tagging").on('click', function(){
		
		
		var tag = $("#input_tags").val().trim();
		
		if(!tag){
			
			alert("1글자 이상 써주세요.");
			return;
		}
		

		
		$("#tagging_field").tagsinput('add', tag);
		

			
			
		});
			
	
	
	
	// 유료 무료 radio 버튼 선택 action
	
	
	$("input[name=free_or_cost]").change(function(){
	
		$selector = $(this);
		
		
	if($selector.attr("value")==="free"){
				
		$("#cost_info").attr("style", "display:none");
		
	}else if($selector.attr("value")==="cost"){
	
		$("#cost_info").attr("style", "display:block");
	}

	});
	
	
	$("#credit_select").change(function(){
		
		
		$("#input_credit").attr("value", $("#credit_select option:selected").val());
		
		
		
		
	});
	
	
	$("#btn_submit").on('click', function(){
		
		
		var ref = '${display_uid}';
		var title = $("#co_title").val();
		var introduce = $("#co_introduce").val();
		var date = new Date().getTime();
		var type=$("#content_type option:selected").val();
		var tags = $("#tagging_field").val().split(",");
		var costType = $(":input[name=free_or_cost]:checked").val();
		var howMuch = $("#input_credit").val();
		var sethtml = froala.froalaEditor('html.get');
		
		

		
		
		var imagesURL = new Array();
		
		var doc = new DOMParser().parseFromString(sethtml, 'text/html');
		var first = doc.firstChild;
		var childNodes = doc.querySelectorAll("img");
		
		
		console.log(ref + " / " +title + " / " +introduce+ " / " +date+ " / " +type+ " / " +costType+ " / " +tags+ " / " +howMuch);
		console.log("html... : " + doc);
		console.log("nodes... " + childNodes);
		
		
		for(let item of childNodes){
			
			imagesURL.push(item.getAttribute('src'));
			console.log("꺼낸 src : " + item.getAttribute('src'));
			
		}
		
		
		var param = {
				
				CMT_ID : '<%=commentaryUid%>',
				CMT_REF : ref,
				CMT_WRITERUID : '${sessionScope.userVO.user_iuid}',
				CMT_TITLE : title,
				CMT_INTRODUCE : introduce,
				CMT_ISFREE : costType,
				CMT_CONTENTTYPE : type,
				CMT_DATE : date,
				CMT_CONTENT : sethtml,
				CMT_IMAGE_ARRAY : imagesURL,
				CMT_TAGS : tags,
				CMT_PRICE : howMuch
	
				
		};
		
		
		
		console.log("JSON : " + JSON.stringify(param));
		
		
		$.ajax({
			type : "POST",
			url : "/commentary/insertCommentary",
			data : JSON.stringify(param),
			contentType : "application/json; charset=utf-8",
			success : function(res){
				
				if(res==="success"){
					
					alert("전송 성공");
					location.replace("/");
					
				}else if(res=="fail"){
						
						alert("오류가 발생하였습니다.");
						
					}
				
			},
			error : function(xhr, status, error){
				
				
				alert(status + " " + error);
			}
			
		});
		
		
		
		
	});
	

  
	 
  </script>
  

  