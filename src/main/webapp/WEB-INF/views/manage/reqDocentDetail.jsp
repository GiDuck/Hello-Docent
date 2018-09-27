<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

      <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-4 col-md-5">
                        <div class="card card-user">
                            <div class="image">
                                <img src="${pageContext.request.contextPath}/resources/assets-dash/img/background.jpg" onError='this.onerror=null;this.src="${pageContext.request.contextPath}/resources/assets/img/defaults/noimage_people.png"' alt="..."/>
                            </div>
                            <div class="content">
                                <div class="author">
                                <c:choose>
                                <c:when test="${member.user_profilePhoto} == null">
                                  <img class="avatar border-white" src="${pageContext.request.contextPath}/resources/assets/img/defaults/noimage_people.png" alt="..."/>
                                 </c:when>
                                 <c:otherwise>
                                 
                               <img class="avatar border-white" src="${member.user_profilePhoto}" onError='this.onerror=null;this.src="${pageContext.request.contextPath}/resources/assets/img/defaults/noimage_people.png"' alt="..."/>
                                 
                                 </c:otherwise>
                                 </c:choose>
                                  
                                  <h4 class="title">${member.user_nick}<br /></h4>
                                </div>
                                <p class="description text-center">
                                 
                                </p>
                            </div>
                            <hr>
                            <div class="text-center">
                                <div class="row">
                                    <div class="col-md-5 col-md-offset-1">
                                        <h5>12<br /><small>방문수</small></h5>
                                    </div>
                                    <div class="col-md-5">
                                        <h5>2018-05-06<br /><small>가입일</small></h5>
                                    </div>
                                   
                                </div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="header">
                                <h4 class="title">그 외의 다른신청 보기</h4>
                            </div>
                            <div class="content">
                                <ul class="list-unstyled team-members">
                                            <li>
                                                <div class="row">
                                                    <div class="col-xs-3">
                                                        <div class="avatar">
                                                            <img src="${pageContext.request.contextPath}/resources/assets-dash/img/faces/face-0.jpg" alt="Circle Image" class="img-circle img-no-padding img-responsive">
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-6">
                                                        DJ Khaled
                                                        <br />
                                                        <span class="text-muted"><small>Offline</small></span>
                                                    </div>

                                                    <div class="col-xs-3 text-right">
                                                        <btn class="btn btn-sm btn-success btn-icon"><i class="fa fa-envelope"></i></btn>
                                                    </div>
                                                </div>
                                            </li>
                                            
                                        </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-8 col-md-7">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">세부 신청정보</h4>
                            </div>
                            <div class="content">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>닉네임</label>
                                                <input type="text" class="form-control border-input" placeholder="신청자 닉네임.." value="${member.user_nick}"></div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="exampleInputEmail1">이메일 주소</label>
                                                <input type="email" class="form-control border-input" placeholder="신청자 이메일.." value = "${request.req_email}">
                                            </div>
                                        </div> 
                                        
                                    </div>
                                    
                                    <div class="row">
                                    <div class="col-md-12">
                                            <div class="form-group">
                                                <label>직업</label>
                                                <input type="text" class="form-control border-input" placeholder="신청자 직업.." value="${request.req_professional}"></div>
                                        </div>
                                        
                                    </div>
         
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>신청자 이름</label>
                                                <input type="text" class="form-control border-input" placeholder="신청자 이름.." value= "${request.req_name}" >
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>연락처</label>
                                                <input type="text" class="form-control border-input" placeholder="전화번호.." value="${request.req_telnum}">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>신청날짜</label>
                                                <input type="text" class="form-control border-input" placeholder="신청날짜 " value="${request.req_date}">
                                            </div>
                                        </div>
                                        </div>
                                       

                                    <div class="row">
                                        <div class="col-md-12" >
                                            <div class="form-group">
                                                <label>자기소개</label>
                                                <textarea rows="5" class="form-control border-input" placeholder="신청자 소개..." >${request.req_introduce}</textarea>
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div class="row  text-center">
                                    
                                    <div class="col-md-6">
                                        <button id="confirmBtn" type="button" class="btn btn-success btn-fill" style="width:80%">도슨트 활동 승인</button>
                                    </div>
                                    
                                    <div class="col-md-6">
                                        <button id="cancelBtn" type="button" class="btn btn-danger btn-fill" style="width:80%">승인 취소</button>
                                    </div>
                                    
                                    
                                    </div>
                                    
                                    <div class="clearfix"></div>
                            </div>
                        </div>
                    </div>


                </div>
            </div>
        </div>
        
        <script>
        
        
        $(document).ready(function(){
        	

        	attachCancelBtn();
        	attachConfirmBtn();
        	
        });
        
   
        
        
        
        
       function attachConfirmBtn(){
        
	        $("#confirmBtn").on('click', function(){
	        	
	        	
		var test = window.confirm("해당 유저의 신청을 승인합니다. 진행하시겠습니까?");
	        	
	        	if(test){
	        	
	        	$.ajax({
	        		
	        		data : {id : '${member.user_iuid}'},
	        		type : "GET",
	        		url : "/manage/approveDocent",
	        		success : function(response){
		        		
	    	        	alert("도슨트 승인 완료.");
	    	        	location.replace("/manage/reqDocentInfo");
	    	        	},
	    	        	
	    	        	error : function(status){
	    	        	
	    	        	alert("승인이 완료되지 않았습니다. 시스템 관리자에게 문의 하십시오.");
	    	        	console.log("도슨트 승인 에러 발생 " + status);
	    	        	
	    	        }
	    	        
	        	
	        	});
	        	
	        	}
	        	
	        	
	        	});
	        	
	        	
	        	
	        }
	        
        
        
        function attachCancelBtn(){
        
	        $("#cancelBtn").on('click', function(){
	        	
	        	var test = window.confirm("신청 정보가 모두 사라집니다. 사용자가 원한 경우가 아니면 심각한 문제가 발생할 수도 있습니다. 제대로 확인하셨습니까?");
	        	
	        	if(test){
	        		
	        		$.ajax({
	        			
	        			url : "/manage/removeRequestDocent",
	        			type : "GET",
	        			data : {id : '${member.user_iuid}'},
	        			success : function(response){
	        				
	        				alert("취소 성공");
	        				location.replace("/manage/reqDocentInfo");
	        				
	        			},
	        			error : function(status){
	        				
	        				alert("취소되지 않았습니다. 시스템 관리자에게 문의하십시오.");
	        				
	        			}
	        			
	        		});
	        		
	        	
	        	}	
	        	
	        });
	        
       	 
        }
        
        
      
        
        
        
        </script>