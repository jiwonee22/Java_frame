package web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	//로깅 객체
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@RequestMapping(value="/page/redirect")
	public String redirectPage() {
		
		logger.info("/page/redirect 요청");
		
		//리다이렉트(slash까지 적어야함)
		return "redirect:/param/requestParam";
	}
	
	@RequestMapping(value="/page/redirect2")
	public ModelAndView redirectPageMav(ModelAndView mav) {
		
		logger.info("/page/redirect2 요청");
		
		mav.setViewName("redirect:/param/dto");
		
		return mav;
	}
	
	@RequestMapping(value="/page/forward")
	public String forwardPage() {
		
		logger.info("포워드 테스트");
		
		return "forward";
	}

}
