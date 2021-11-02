package login.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import login.dto.Login;
import login.service.face.LoginService;

@Controller
public class LoginController {
	
	//로깅 객체
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	//서비스 객체
	@Autowired private LoginService loginService;
	
	//메인화면
	@RequestMapping(value="/login/main")
	public void main() {
		
		logger.info("/login/main [GET]");
		
	}
	
	//회원가입
	@RequestMapping(value="/login/join", method=RequestMethod.GET)
	public void join() {
		logger.info("/login/join [GET]");
	}
	
	//회원가입처리
	@RequestMapping(value="/login/join", method=RequestMethod.POST)
	public String joinProc(Login login) {
		logger.info("/login/join [POST]");
		logger.info("전달 파라미터 {}", login);
		
		//회원가입 처리 - LoginService이용
		loginService.join(login); 
		
		//메인페이지로 리다이렉트
		return "redirect:/login/main";
	}
	
	//로그인
	@RequestMapping(value="/login/login", method=RequestMethod.GET)
	public void login() {
		logger.info("/login/login [GET]");
	}
	
	//로그인처리
	@RequestMapping(value="/login/login", method=RequestMethod.POST)
	public String loginProc(Login login, HttpSession session) {
		logger.info("/login/login [POST]");
		logger.info("전달파라미터 {}", login);
		
		//아이디, 패스워드 DB 조회 - 인증
		boolean isLogin = loginService.login(login);
		
		logger.info("isLogin : {}", isLogin);
		
		//인증 결과에 따른 세션 처리
		if(isLogin) { //성공
			session.setAttribute("login", isLogin);
			session.setAttribute("loginid", login.getId());
		} else { //실패
			session.invalidate();
		}
		
		//메인페이지 리다이렉트
		return "redirect:/login/main";
	}
	
	//마이페이지
	@RequestMapping(value="/login/mypage", method=RequestMethod.GET)
	public void mypage(HttpSession session, Model model) {
		
		String loginid  = (String) session.getAttribute("loginid");
		logger.info("/login/mypage id : {}", loginid);
		
		//로그인된 사용자의 정보 조회
		Login info = loginService.info(loginid);
		logger.info("조회결과 info {}", info);
		
		//사용자의 정보, 모델값 전달
		model.addAttribute("info", info);
		
		
	}
	
	//로그아웃
	@RequestMapping(value="/login/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.info("/login/logout");
		
		session.invalidate();
		
		return "redirect:/login/main";
		
	}

}
