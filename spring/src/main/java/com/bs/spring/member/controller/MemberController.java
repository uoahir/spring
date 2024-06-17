package com.bs.spring.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bs.spring.member.model.dto.Member;
import com.bs.spring.member.model.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
@SessionAttributes("loginMember") // type에만 선언가능 == 클래스 
@Slf4j // log라는 필드가 생김
public class MemberController {
	
	private final MemberService service;
	private final BCryptPasswordEncoder pwencoder;
	
	
	@PostMapping("/login.do")
	public String loginMember(String userId, String pw, Model mo) {
//			HttpSession session, Model mo) {
		
		Member m = service.loginMember(userId, pw);//지연 바보 ㅋㅋ멍청이
		
		log.debug("{}",m);
		
		String page ="";
		
		System.out.println(m);
		if(m!=null) {
//			session.setAttribute("loginMember", m);
			mo.addAttribute("loginMember", m);
			page="redirect:/";
		} else {
			mo.addAttribute("msg", "아이디나 패스워드가 일치하지 않습니다. :(");
			mo.addAttribute("loc", "/");
			page="common/msg";
		}
		
		return page;
	}
	
// session 으로 저장됐을 때 
//	@GetMapping("logout.do")
//	public String logout(HttpSession session) {
//		session.invalidate();
//		return "redirect:/";
//	}
	
	@GetMapping("logout.do")
	public String logout(SessionStatus session) {
		if(!session.isComplete()) session.setComplete();
		// session 이 종료되지 않았으면(!session.isComplete), session 을 종료시킨다(setComplete) !
		return "redirect:/";
	}
	
	@GetMapping("signup.do")
	public String signup(@ModelAttribute("member") Member m) {
		return "member/signUp";
	}
	
	@PostMapping("signupend.do")
	public String signupend(@Validated Member m, 
							BindingResult isResult,
							Model model) {
		if(isResult.hasErrors()) {
			// 설정한 유효성검사를 통과하지 못한 것
			return "member/signUp";
			
		}
		String page = "";
		String encodePw = pwencoder.encode(m.getPassword());
//		System.out.println(encodePw);
		log.debug(encodePw);
		m.setPassword(encodePw);
		int result = service.signupMember(m);
		
		
		if(result>0) {
			
			page = "redirect:/";
			
		} else {
			model.addAttribute("msg", "회원가입 실패");
			model.addAttribute("loc","/member/signup.do");
			page = "common/msg";
		}
		
		return page;
	}
}
