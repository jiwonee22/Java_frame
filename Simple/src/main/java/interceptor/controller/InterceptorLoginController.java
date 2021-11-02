package interceptor.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import interceptor.dto.User;

@Controller
public class InterceptorLoginController {
	
	//로그 객체
	private static final Logger logger = LoggerFactory.getLogger(InterceptorLoginController.class);

	@RequestMapping(value="/interceptor/login", method=RequestMethod.GET)
	public void loginForm() {
		logger.info("/interceptor/login [GET]");
	}
	
	@RequestMapping(value="/interceptor/login", method=RequestMethod.POST)
	public String loginProc(User user, HttpSession session) {
		logger.info("/interceptor/login [POST]");
		logger.info("{}", user);
		
		//간단한 로그인 인증 - DB없이 문자열 비교
		if("abc".contentEquals(user.getId()) && "123".equals(user.getPw())) {
			logger.info("일반사용자 로그인 성공");
			
			session.setAttribute("login", true); //로그인 상태
			session.setAttribute("loginid", user.getId()); //로그인 아이디
			session.setAttribute("nick", "지원"); //로그인 닉네임

		} else if("admin".equals(user.getId())) {
			logger.info("관리자 로그인 성공");
			
			session.setAttribute("login", true); //로그인 상태
			session.setAttribute("loginid", user.getId()); //로그인 아이디
			session.setAttribute("nick", "관리자"); //로그인 닉네임
			
		} else {
			logger.info("로그인 실패");
			
			session.invalidate(); //세션 정보 지우기(강제 로그아웃)
			
			return "redirect:/interceptor/login";
		}
		
		return "redirect:/interceptor/main";
		
	}
	
	@RequestMapping(value="/interceptor/main")
	public void main() {
		logger.info("/interceptor/main");

	}

	@RequestMapping(value="/interceptor/logout")
	public String logout(HttpSession session) {
		logger.info("/interceptor/logout");

		session.invalidate();
		
		return "redirect:/interceptor/main";

	}
	
	@RequestMapping(value="/interceptor/admin/main")
	public void adminMain() {
		logger.info("/interceptor/admin/main");

	}
}
