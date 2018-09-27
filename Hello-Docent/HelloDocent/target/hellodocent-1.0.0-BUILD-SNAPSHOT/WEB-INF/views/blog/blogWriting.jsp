<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@page import="com.spov.hellodocent.domain.LoginSessionDTO"%>
<%@page import="com.spov.hellodocent.tools.UidMaker"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
 
<%

  
String commentaryUid = UUID.randomUUID().toString();


%>


  <div class="main add-product">
    <div class="section">
      <div class="container">
      <div class="row" style="margin:20px">
        <h3><b>DOCENT BLOG POSTING</b></h3>
      
        
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
			
	
	$("#btn_submit").on('click', function(){
		
		
		var ref = '${display_uid}';
		var title = $("#co_title").val();
		var introduce = $("#co_introduce").val();
		var date = new Date().getTime();
		var type=$("#content_type option:selected").val();
		var tags = $("#tagging_field").val().split(",");
		var sethtml = froala.froalaEditor('html.get');
		
		

		
		
		var imagesURL = new Array();
		
		var doc = new DOMParser().parseFromString(sethtml, 'text/html');
		var first = doc.firstChild;
		var childNodes = doc.querySelectorAll("img");
		
		
		console.log(ref + " / " +title + " / " +introduce+ " / " +date+ " / " +type+ " / " + " / " +tags+ " / " );
		console.log("html... : " + doc);
		console.log("nodes... " + childNodes);
		
		
		for(let item of childNodes){
			
			imagesURL.push(item.getAttribute('src'));
			console.log("꺼낸 src : " + item.getAttribute('src'));
			
		}
		
		
		var param = {
				
				col_id : '<%=commentaryUid%>',
				col_writeruid : '${sessionScope.userVO.user_iuid}',
				col_title : title,
				col_introduce : introduce,
				col_type : type,
				col_date : date,
				col_content : sethtml,
				images : imagesURL,
				tags : tags
	
				
		};
		
		
		
		$.ajax({
			type : "POST",
			url : "/blog/blogInsert",
			data : JSON.stringify(param),
			contentType : "application/json; charset=utf-8",
			success : function(res){
				
				location.herf = res +"?id=" + param.col_id;
				
			},
			error : function(xhr, status, error){
				
				
				alert(status + " " + error);
			}
			
		});
		
		
		
		
	});
	

  
	 
  </script>
  

  