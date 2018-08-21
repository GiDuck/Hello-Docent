<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="contact-page sidebar-collapse">
  <div class="main">
    <div class="section section-gray">
      <div class="container">
        <div class="row">
          <div class="col-md-8 ml-auto mr-auto text-center">
            <h2 class="title">저희와 함께해 주세요!</h2>
            <p>Hello Docent는 여러분의 참여로 인해 더 많은 사람들에게 넓고 깊은 지식을 제공할 수 있습니다.<br/>여러분들의 우수한 콘텐츠를 만들고 공유해보세요!</p>
          </div>
        </div>
        <div class="row">
          <div class="col-md-6 ml-auto mr-auto text-center">
            <h3 class="title">
              <small>Find us on social networks</small>
            </h3>
            <button class="btn btn-just-icon btn-twitter">
              <i class="fa fa-twitter"></i>
            </button>
            <button class="btn btn-just-icon btn-facebook">
              <i class="fa fa-facebook"></i>
            </button>
            <button class="btn btn-just-icon btn-google">
              <i class="fa fa-google"></i>
            </button>
            <button class="btn btn-just-icon btn-dribbble">
              <i class="fa fa-dribbble"></i>
            </button>
            <button class="btn btn-just-icon btn-instagram">
              <i class="fa fa-instagram"></i>
            </button>
            <button class="btn btn-just-icon btn-youtube">
              <i class="fa fa-youtube"></i>
            </button>
          </div>
        </div>
        <div class="row">
          <div class="col-md-6 ml-auto mr-auto text-center">
            <h3 class="title">
              <small>Or drop us a note</small>
            </h3>
            <form class="contact" action="/member/requestDocent" method="POST">
            <input type="hidden" name="req_date" type="date" value="">
            <input type="hidden" name="req_id" value="${sessionScope.userVO.user_iuid}">
              <div class="row">
                <div class="col-md-6">
                  <input type="text" class="form-control" placeholder="Name" name="req_name">
                </div>
                <div class="col-md-6">
                  <input type="text" class="form-control" placeholder="Telephone Number" type="tel" name="req_telnum">
                </div>
              </div>
              <div class="row">
                <div class="col-md-6">
                  <input type="text" class="form-control" placeholder="Email" type="email" name="req_email">
                </div>
                <div class="col-md-6">
                  <input type="text" class="form-control" placeholder="Professional" name="req_professional">
                </div>
              </div>
              <textarea class="form-control" placeholder="간단한 자기소개를 적어주세요." rows="7" name="req_introduce"></textarea>
              <div class="row">
                <div class="col-md-6 ml-auto mr-auto">
                  <button id="submitBtn" type="submit" class="btn btn-primary btn-block btn-round">Send </button>
                </div>
              </div>
            </form>
            <h3 class="visit">
              <small>Or come and visit</small>
            </h3>
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
		submit();
	
		
  });
  
  
  function submit(){
	  
	  
	/*   $("#submitBtn").on('submit', function(){
		 
		  alert("도슨트 신청이 완료되었습니다.");
		  
		  
	  });
	   */
	  
  }
  
  </script>