package interceptor.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import interceptor.controller.InterceptorLoginController;

public class AdminInterceptor implements HandlerInterceptor{
	
	//로그 객체
	private static final Logger logger = LoggerFactory.getLogger(InterceptorLoginController.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.info(" + + + 인터셉터 시작 + + + ");
		
		//세션 객체
		HttpSession session = request.getSession();
		if(session.getAttribute("login") == null) {
			logger.info(" >> 접속 불가 : 비 로그인 상태");
		
			response.sendRedirect("/interceptor/main");
			
//			return true; //컨트롤러 접근 허용
			return false; //컨트롤러 접근 금지시키기
		} else {
			logger.info(" >> 로그인 상태");
		
			if(!"관리자".equals(session.getAttribute("nick"))) {
				logger.info(" >> 접속 불가 : 일반 사용자 로그인");
				
				response.sendRedirect("/interceptor/main");
				return false;
				
			}
		}
		
		logger.info(" >> 정상 접근 : 관리자 로그인");
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		logger.info(" + + + 인터셉터 종료 + + + ");
		
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}


}
