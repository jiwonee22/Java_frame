package interceptor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardInterceptorController {

	//로그 객체
	private static final Logger logger = LoggerFactory.getLogger(BoardInterceptorController.class);

	@RequestMapping(value="/board/list")
	public void boardList() {
		logger.info("/board/list");
		
	}

	@RequestMapping(value="/board/write")
	public void boardWrite() {
		logger.info("/board/write");
		
	}
	
	@RequestMapping(value="/board/noLogin")
	public void boardNoLogin() {
		logger.info("/board/noLogin");
		
	}


}
