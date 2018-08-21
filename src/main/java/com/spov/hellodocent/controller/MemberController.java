package com.spov.hellodocent.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spov.hellodocent.authorization.FacebookLogin;
import com.spov.hellodocent.authorization.GoogleLogin;
import com.spov.hellodocent.authorization.KakaoLogin;
import com.spov.hellodocent.authorization.NaverLogin;
import com.spov.hellodocent.authorization.OAuthLogin;
import com.spov.hellodocent.authorization.OAuthManager;
import com.spov.hellodocent.domain.LoginSessionDTO;
import com.spov.hellodocent.domain.MemberDTO;
import com.spov.hellodocent.domain.RequestDocentDTO;
import com.spov.hellodocent.encrypto.EncryptoMember;
import com.spov.hellodocent.encrypto.EncryptoString;
import com.spov.hellodocent.services.MemberService;
import com.spov.hellodocent.services.MuseumService;

/**
 * OAuthManager가 각 서비스 회사에 맞는 Client ID와 Secret Token을 찾아서 Request URI를 View에 있는
 * Button에 초기화 시켜준다. 그리고 각 서비스 회사로 부터 들어오는 Callback을 컨트롤러의 각 매핑에서 처리한다. 새로운 로그인
 * 서비스를 추가할 시, OAuthLogin Interface를 반드시 구현해야 한다.
 */


@Controller
@RequestMapping("/member")
public class MemberController {

	@Inject
	private HttpSession session;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	private ArrayList<OAuthLogin> loginServices = new ArrayList<OAuthLogin>();
	private OAuthManager loginManager;

	// 구글 oAuth 관련
	@Autowired
	private GoogleConnectionFactory googleConnectionFactory;

	// 페이스북 oAuth 관련
	@Autowired
	private FacebookConnectionFactory facebookConnectionFactory;

	// oAuth2 인증 절차에 필요한 파라미터값들을 전달
	@Autowired
	@Qualifier("facebookOAuth2Parameters")
	private OAuth2Parameters facebookOAuth2Parameters;

	@Autowired
	@Qualifier("googleOAuth2Parameters")
	private OAuth2Parameters googleOAuth2Parameters;

	@Autowired
	private KakaoLogin kakaoLogin;

	@Autowired
	private NaverLogin naverLogin;

	@Inject
	private MuseumService museumService;

	@Inject
	private MemberService memberService;

	@Resource(name = "sessionContextFactory")
	ObjectFactory sessionContextFactory;

	// 회원 가입 페이지
	@RequestMapping(value = "/join", method = { RequestMethod.GET, RequestMethod.POST })
	public String join(HttpServletResponse response, Model model) {

		OAuthLogin googleLogin = new GoogleLogin(googleConnectionFactory, googleOAuth2Parameters);
		OAuthLogin facebookLogin = new FacebookLogin(facebookConnectionFactory, facebookOAuth2Parameters);

		if (loginServices.size() != 0) {
			loginServices.clear();
		}

		loginServices.add(googleLogin);
		loginServices.add(facebookLogin);
		loginServices.add(kakaoLogin);
		loginServices.add(naverLogin);

		loginManager = new OAuthManager(loginServices);

		model = loginManager.setLoginURLs(model);

		// 만약 레이아웃 적용 안하고 보내려면"empty/member/join";

		return "member/nf/join";
	}

	// ------------------------------------ 구글 콜백

	@RequestMapping(value = "/googleSignInCallback", method = { RequestMethod.GET, RequestMethod.POST })
	public String googleSignInCallback(HttpServletRequest request, Model model) throws Exception {

		String code = request.getParameter("code");

		MemberDTO member = loginManager.getUserData(code, GoogleLogin.class.getName());
		System.out.println(member);
		checkMember(member);
		

		return "redirect:/";

	}

	// ------------------------------------- 페이스북 콜백

	@RequestMapping(value = "/facebookSignInCallback", method = { RequestMethod.GET, RequestMethod.POST })
	public String facebookSignInCallback(HttpServletRequest request) throws Exception {

		String code = request.getParameter("code");
		MemberDTO member = loginManager.getUserData(code, FacebookLogin.class.getName());
		System.out.println(member);
		checkMember(member);
		return "redirect:/";

	}

	// ------------------------------------- 카카오 콜백

	@RequestMapping(value = "/kakaoSignInCallback", method = { RequestMethod.GET, RequestMethod.POST })
	public String kakaoSignInCallback(HttpServletRequest request) throws Exception {
		System.out.println("Hello Kakao Callback");
		String code = request.getParameter("code");
		MemberDTO member = loginManager.getUserData(code, KakaoLogin.class.getName());
		System.out.println(member);
		checkMember(member);
		return "redirect:/";
	}

	// 네이버 로그인 API 사용 시 요청 후 받는 CallBack
	@RequestMapping(value = "/naverSignInCallback", method = { RequestMethod.GET, RequestMethod.POST })
	public String naverSignInCallback(HttpServletRequest request, Model model) {

		String code = request.getParameter("code");
		MemberDTO member = loginManager.getUserData(code, NaverLogin.class.getName());
		System.out.println(member);
		checkMember(member);

		return "redirect:/";

	}

	public void checkMember(MemberDTO member) {
		
	EncryptoString encryStr = new EncryptoString();

		MemberDTO getMember = memberService.findUser(member.getUser_uid());
		String deKey = null;
		
		try {
		String rawData = getMember.getUser_isDocent();
		deKey = (String)encryStr.Decrypto((String)rawData);
		System.out.println("De Key : " + deKey);
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(deKey != null) {

		session.setAttribute("userVO", new LoginSessionDTO(getMember.getUser_iuid(),
				deKey, getMember.getUser_profilePhoto(), getMember.getUser_nick()));
		
		}else {
			
			memberService.insertMember(member);
			session.setAttribute("userVO",  new LoginSessionDTO(member.getUser_iuid(),
					deKey, member.getUser_profilePhoto(), member.getUser_nick()));
		}
		
		
		
		
		
	}
	
	
	@RequestMapping(value="/removeSession", method=RequestMethod.GET)
	public String removeSession(HttpSession session) {
	
		
		session.removeAttribute("userVO");
		
		
		return "redirect:/";
		
		
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="/getMemberSimpleInfo", method=RequestMethod.GET)
	public Map<String, String> getMemberSimpleInfo (@RequestParam("id") String id){
		
		EncryptoString encrypto = new EncryptoString();
		
		Map<String, String> temp = memberService.getMemberSimpleInfo(id);
		Map<String ,String> responseParam = new HashMap<>();
		
		responseParam.put("USER_NICK", (String)encrypto.Decrypto(temp.get("USER_NICK")));
		responseParam.put("USER_PROFILEPHOTO", (String)encrypto.Decrypto(temp.get("USER_PROFILEPHOTO")));

		
			
		return responseParam;
	}
	
	
	@RequestMapping(value="/getMemberModify", method=RequestMethod.GET)
	public String getMemberModify(HttpSession session, Model model) {

	 LoginSessionDTO dto = (LoginSessionDTO)session.getAttribute("userVO");
		MemberDTO member = memberService.getMemberInfo(dto.getUser_iuid());
		member = (MemberDTO)new EncryptoMember().Decrypto(member);
		
		model.addAttribute("member", member);
		
		return "member/memberModify";
	}
	
	@RequestMapping(value="/getRequestDocent", method=RequestMethod.GET)
	public String getRequestDocent(HttpSession session, Model model) {

		return "member/requestDocent";
	}
	
	
	
	@RequestMapping(value="/deleteMember", method=RequestMethod.GET)
	public String deleteMember(@RequestParam("id") String uid, HttpSession session, Model model) {

		memberService.deleteMember(uid);
		session.removeAttribute("userVO");
		
		
		return "member/memberModify";
	}
	
	
	@RequestMapping(value="/requestDocent", method=RequestMethod.POST)
	public String requestDocent(@ModelAttribute RequestDocentDTO dto, BindingResult errors) {
		
		if (errors.hasErrors()){
			 
			System.out.println(errors.getAllErrors());
			 
			}
		
		logger.debug("Request Docent..." + dto.toString());
		memberService.insertRequestDocent(dto);
		
		return "redirect:/";
	}
	
	
	
	@RequestMapping(value="/updateMember", method=RequestMethod.POST)
	@ResponseBody
	public String updateMember(@RequestBody Map<String, String> param) {
		
		System.out.println(param);
		
		memberService.updateMemberInfo(param);
		
		
		return "success";
		
	}

}
