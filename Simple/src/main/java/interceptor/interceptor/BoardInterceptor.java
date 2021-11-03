package interceptor.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class BoardInterceptor implements HandlerInterceptor {
	
	//로그 객체
	private static final Logger logger = LoggerFactory.getLogger(BoardInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.info(" + + + 인터셉터 시작 + + + ");
		
		//세션 객체
		HttpSession session = request.getSession();
		if(session.getAttribute("login") == null) {
			logger.info(" >> 접속 불가 : 비 로그인 상태");

			response.sendRedirect("/board/noLogin");
			
			return false;
		
		} else {
			logger.info(" >> 로그인 상태");

			return HandlerInterceptor.super.preHandle(request, response, handler);
			
		}
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		logger.info(" + + + 인터셉터 종료 + + + ");

		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
}
