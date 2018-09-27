
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


  <div class="wrapper">
    <div class="page-header page-header-xs settings-background" style="background-image: url('https://cdn.pixabay.com/photo/2015/07/02/10/40/writing-828911_1280.jpg');">
      <div class="filter"></div>
    </div>
    <div class="profile-content section">
      <div class="container">
 
        <div class="row">
          <div class="col-md-6 ml-auto mr-auto">
            <form class="settings-form" action="/docent/updateDocentInfo" method="POST" accept-charset="utf-8" >
             
              
              <div class="form-group">
                <label>Description</label>
                <textarea name="di_introduce" class="form-control textarea-limited" placeholder="사람들에게 보여질 소개를 입력하세요.." rows="3" maxlength="400">${info.di_introduce}</textarea>
                <h5>
                  <small>
                    <span id="textarea-limited-message" class="pull-right">400 characters left</span>
                  </small>
                </h5>
              </div>
              
                <div class="form-group">
                <label>Carrer</label>
                <textarea name="di_carrer" class="form-control textarea-limited" placeholder="사람들에게 보일 경력 혹은 학력을 입력하세요." rows="3" maxlength="150">${info.di_carrer}</textarea>
                <h5>
                  <small>
                    <span id="textarea-limited-message" class="pull-right">300 characters left</span>
                  </small>
                </h5>
              </div>
              
              <input type="hidden" name="di_iuid" value="${info.di_iuid}">
              
              
              
              <label>도슨트 메뉴</label>
              
              <div class="row form-group">
              
              <div name="tempBtn" class="col-md-6"><div class="btn">댓글 관리</div></div>
              <div name="tempBtn" class="col-md-6"><div class="btn">평점 관리</div></div>
              <div name="tempBtn" class="col-md-6"><div class="btn">수익 관리</div></div>
              
              </div>
        
              <div class="row text-center">
                <button type="submit" class="btn btn-wd btn-info btn-round">Save</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>

  
  <script>
  $(".btn").css("margin", "8px");
  $(".btn").addClass("w-100 btn-lg");
  
  
  $("div[name=tempBtn]").on('click', function(){
	 
	  alert("현재 준비중인 기능입니다");
	  
  });
  
  </script>