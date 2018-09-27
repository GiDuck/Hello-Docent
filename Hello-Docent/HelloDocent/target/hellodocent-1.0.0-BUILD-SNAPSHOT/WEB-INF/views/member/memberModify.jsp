<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<div class="settings-page sidebar-collapse">

  <div class="wrapper">
    <div class="page-header page-header-xs settings-background" style="background-image: url('${pageContext.request.contextPath}/resources/assets/img/sections/joshua-earles.jpg');">
      <div class="filter"></div>
    </div>
    <div class="profile-content section">
      <div class="container">
        <div class="row">
          <div class="profile-picture">
            <div class="fileinput fileinput-new" data-provides="fileinput">
              <div class="fileinput-new img-no-padding">
                <img name="profile" src="${pageContext.request.contextPath}/resources/assets/img/defaults/noimage_people.png" alt="...">
              </div>
              <div class="fileinput-preview fileinput-exists img-no-padding"></div>
              <div>
                <span class="btn btn-outline-default btn-file btn-round">
                  <span class="fileinput-new">Change Photo</span>
                  <span class="fileinput-exists">Change</span>
                  <input type="file" name="...">
                </span>
                <br />
                <a href="#paper-kit" class="btn btn-link btn-danger fileinput-exists" data-dismiss="fileinput"><i class="fa fa-times"></i> Remove</a>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-6 ml-auto mr-auto">
            <form class="settings-form">
              <div class="row">
                <div class="col-md-6 col-sm-6">
                  <div class="form-group">
                    <label>Nick Name</label>
                    <input name="nickName" type="text" class="form-control border-input" placeholder="Nick Name"></div>
                </div>
                <div class="col-md-6 col-sm-6">
                  <div class="form-group">
                    <label>Email</label>
                    <input name="email" type="text" class="form-control border-input" placeholder="Email">
                  </div>
                </div>
              </div>
              <div class="form-group">
                <label>Type</label>
                <input name="type" type="text" class="form-control border-input" placeholder="Type" readonly="readonly">
              </div>
             
              <label>Notifications</label>
              <ul class="notifications">
                <li class="notification-item">
                  	실시간 PUSH 알람 받기
                  <input type="checkbox" data-toggle="switch" checked="" data-on-color="info" data-off-color="info">
                  <span class="toggle"></span>
                </li>
                <li class="notification-item">
                   	이메일 알람 받기
                  <input type="checkbox" data-toggle="switch" checked="" data-on-color="info" data-off-color="info">
                  <span class="toggle"></span>
                </li>
                <li class="notification-item">
                    Follower가 새로운 게시글 등록시 알림 받기
                  <input type="checkbox" data-toggle="switch" checked="" data-on-color="info" data-off-color="info">
                  <span class="toggle"></span>
                </li>
              </ul>
              
           
              <div class="text-center w-100">
                <button type="submit" class="btn btn-wd btn-info btn-round">Save</button>
                <div id="deleteMember" class="btn btn-wd btn-danger btn-round">회원 탈퇴</div>
                
              </div>
            </form>       
          </div>
          </div>
        </div>
      </div>
    </div>
  </div>



<script>

$(document).ready(function(){
	setDelBtn();
	initField();
	
});

function setDelBtn(){

$("#deleteMember").on('click', function(){

	var conf = confirm("정말 삭제하시겠습니까? 게시글과 댓글을 비롯한 모든 회원 정보가 삭제되며, 돌이킬 수 없습니다.");
	if(conf){
		
		alert("탈퇴가 정상적으로 처리되었습니다. 감사합니다.");
		
	}else{
		
		return;
		
	}
	
});


}

function initField(){
	
	
	$("input[name=nickName]").val('${member.user_nick}');
	$("input[name=email]").val('${member.user_email}');
	$("input[name=type]").val('${member.user_isDocent}');
	$("img[name=profile]").attr("src", '${member.user_profilePhoto}');
	

	
}







</script>