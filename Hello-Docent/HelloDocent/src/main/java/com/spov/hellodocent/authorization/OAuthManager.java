package com.spov.hellodocent.authorization;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.spov.hellodocent.domain.MemberDTO;

public class OAuthManager {

	private ArrayList<OAuthLogin> loginList = new ArrayList<OAuthLogin>();

	public OAuthManager(ArrayList<OAuthLogin> loginList) {
		super();
		this.loginList = loginList;
	}

	public Model setLoginURLs(Model model) {

		for (OAuthLogin login : loginList) {

			model.addAttribute(login.getClass().getSimpleName() + "_url", login.URLBuildUp());
			System.out.println("completed URL : " + login.getClass().getSimpleName() + "_url");

		}

		return model;
	}

	public MemberDTO getUserData(String code, String className) {

		MemberDTO member = null;

		
		for (OAuthLogin login : loginList) {
			System.out.println("로그인 클래스 이름 :" + login.getClass().getName());
			
			if (login.getClass().getName().equals(className)) {
			
			System.out.println("selected class is... " + login.getClass().getSimpleName());
			login.GetAccessToken(code);
			member = login.GetUserInfo();
			
			return member;
			}
			

		}

		return member;

	}

}
