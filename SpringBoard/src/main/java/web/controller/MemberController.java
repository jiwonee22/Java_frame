package web.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.dto.Member;
import web.service.face.MemberService;


@Controller
public class MemberController {
	
	//로깅 객체
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	//서비스 객체
	@Autowired MemberService memberService;

	@RequestMapping(value="/member/login", method = RequestMethod.GET)
	public void memberLogin() {
		logger.info("/member/login [GET]");
	}

	@RequestMapping(value="/member/login", method = RequestMethod.POST)
	public String memberLoginProc(Member member, HttpSession session) {
		logger.info("/member/login [GET]");
		logger.info("전달 파라미터 : {}", member);
		
		//아이디, 비밀번호 DB에서 조회하기
		boolean isMember = memberService.login(member);
		logger.info("isMember : {}", isMember);
		
		if(isMember) { //성공
			session.setAttribute("login", isMember);
			session.setAttribute("memberId", member.getId());
		} else {
			session.invalidate();
		}
		
		return "redirect:/member/main";
		
	}
	
	@RequestMapping(value="/member/logout")
	public String memberLogout(HttpSession session) {
		logger.info("/member/logout [GET]");
		
		session.invalidate();
		
		return "redirect:/member/main";
		
	}
	
	@RequestMapping(value="/member/join", method = RequestMethod.GET)
	public void memberJoin() {
		logger.info("/member/join [GET]");
		
	}
	
	@RequestMapping(value="/member/join", method = RequestMethod.POST)
	public String memberJoinProc(Member member) {
		logger.info("/member/join [POST]");
		logger.info("전달 파라미터 : {}", member);
		
		memberService.join(member);
		
		return "redirect:/member/main";
		
	}
	
	@RequestMapping(value="/member/main")
	public void memberMain(HttpSession session) {
		logger.info("/member/main [GET]");
		
		
	}

}
