<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

    <style>
    
    .hover{
	background: #FFFF00; /* yellow*/
	
	}
 
    </style>



<div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">도슨트 활동 요청 목록</h4>
                                <p class="category">아직 처리되지 않은 도슨트 회원 전환 요청입니다.</p>
                            </div>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-striped">
                                    <thead>                              
                                        <th>번호</th>
                                    	<th>이름</th>
                                    	<th>전화번호</th>
                                    	<th>이메일</th>
                                    	<th>요청일자</th>
                                    </thead>
                                    <tbody>
                                    <c:set var="index" value="1"/>
                                    <c:forEach var="req" items="${req}">
                                   
                         
                                    
                                        <tr id="${req.req_id}" >
                                        	<td>${index}</td>
                                        	<td>${req.req_name}</td>
                                        	<td>${req.req_telnum}</td>
                                        	<td>${req.req_email}</td>
                                        	<td>${req.req_date}</td>
                                        </tr>
                                        
                                       <c:set var="index" value="${index+1}"/>
                                    
                                   
                                    
                                    </c:forEach>
                                      
                                     
                                    </tbody>
                                    
                                </table>

                            </div>
                        </div>
                    </div>


                  
                            </div>
                        </div>
                    </div>
              
                    
                    
    <script>
    
    $(document).ready(function(){
    	
    	attachMouseOver();
    	attachRowClick();

    	
    });
    
    
    
    function attachMouseOver(){
    	
    	//! 행에 하이라이트 주기
    	$("tr:not(:first-child)").mouseover(function(){
    	    $(this).addClass("hover");
    	}).mouseout(function(){
    	    $(this).removeClass("hover");
    	});
    	
    	
    }
    
    
    function attachRowClick(){

    $("tr").on('click', function(){
    	
    	var id = $(this).attr("id");
    	console.log("id... " + id);
    	var sendUri = "/manage/getReqDocentDetail?id="+encodeURIComponent(id);
    	console.log("parsed Url : " + sendUri);
    	location.href = sendUri;
    	
    });
    }
    
    </script>


        