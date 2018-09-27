<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
    <style>
    
    .td-num{ width : 10%; }
    
    .td-title{ width : 20%; }
    
    .td-intro{ width : 30%; }
    
    .td-contentType{ width : 10%;}
    
    .td-date{ width : 10%; }
    
    .td-cost{ width : 10% }
    
    
    
    
    </style>
    

  <!-- End Navbar -->
  <div class="wrapper">
    <div class="main">
      <div class="section section-white section-search">
        <div class="container">
        
        
          <div class="row">
            <div class="col-md-10 col-12 ml-auto mr-auto text-center">

<div class="col-12 w-100"><h4>My Commentary</h4></div>

<br/>
<br/>

<table class="table w-100">

<thead class="thead">

<tr>

<td class="td-num">Num</td>
<td class="td-title">제목</td>
<td class="td-intro">소개</td>
<td class="td-contentType">Type</td>
<td class="td-cost">Cost</td>
<td class="td-date">DATE</td>
</tr>
</thead>

<tbody>
<c:set var="index" value="1"/>
<c:forEach var="com" items="${coms}">

<tr onclick="javascript:moveToCom('${com.CMT_ID}')">

<td class="td-num">${index}</td>
<td class="td-title">${com.CMT_TITLE}</td>
<td class="td-intro">${com.CMT_INTRODUCE}</td>
<td class="td-contentType">${com.CMT_CONTENTTYPE}</td>
<td class="td-type">${com.CMT_ISFREE}</td>
<td class="td-type">${com.CMT_DATE}</td>

</tr>


<c:set var="index" value="${index+1}"/>

</c:forEach>


</tbody>
</table>
        
 </div>
   </div>
   
   
   <div class="row">
   
   <br/><br/><br/>
   
   
   </div>


   
   <!-- BLOG 출력 -->
   
   
   <div class="row">
<div class="col-md-10 col-12 ml-auto mr-auto text-center">

<div class="col-12 w-100"><h4>My BLOG POSTING</h4></div>

<br/>
<br/>

<table class="table w-100">

<thead class="thead">

<tr>

<td class="td-num">Num</td>
<td class="td-title">제목</td>
<td class="td-intro">소개</td>
<td class="td-contentType">Type</td>
<td class="td-contentType">DATE</td>
</tr>
</thead>

<tbody>
<c:set var="index" value="1"/>
<c:forEach var="blog" items="${blogs}">

<tr onclick="javascript:moveToBlog('${blog.COL_ID}')">

<td class="td-num">${index}</td>
<td class="td-title">${blog.COL_TITLE}</td>
<td class="td-intro">${blog.COL_INTRODUCE}</td>
<td class="td-contentType">${blog.COL_CONTENTTYPE}</td>
<td class="td-type">${blog.COL_DATE}</td>

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
	  
	//navbar 색상 조절
	$("#basic_navbar").removeClass("navbar-transparent").addClass("fixed-top").addClass("bg-danger");
	//img 태그 요소에 반응형 처리
	$("img").addClass("img-fluid");
	
});



function moveToBlog(blogID){
	
	
	location.href = "/blog/blogView?id=" + blogID;
	
	
}

function moveToCom(comID){
	
	
	location.href = "/commentary/commentaryView?id=" + comID;
	
	
}

</script>