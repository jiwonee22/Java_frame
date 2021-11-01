package web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReturnController {
	
	//로깅 객체
	private static final Logger logger = LoggerFactory.getLogger(ReturnController.class);
	
	@RequestMapping(value="/return/test")
	public void returnTest1(Model model) {
		
		//viewName: return/test
		//view: 	/WEB-INF/views/return/test.jsp
		
		//jsp 포워딩
		model.addAttribute("title", "void반환타입");
		model.addAttribute("data", "MODEL DATA 1");
		
	}
	
	@RequestMapping(value="/return/test2")
	public String returnTest2(Model model) {
		
		model.addAttribute("title", "String반환타입");
		model.addAttribute("data", "MODEL DATA 2");
		
		
//		return null; //null리턴일 경우, void리턴과 같은 동작
		
		return "return/test"; //test2.jsp 파일을 만들지 않아도 됨
		
	}
	
	@RequestMapping(value="/return/test3")
	public ModelAndView returnTest3() {
		
		ModelAndView mav = new ModelAndView();
		
		//모델값 지정하기
		mav.addObject("title", "ModelAndView 반환");
		mav.addObject("data", "Model DATA 3");
		
		//뷰네임 지정하기
//		mav.setViewName(null); //void리턴타입과 같은 동작
		mav.setViewName("return/test"); //문자열로 원하는 viewName을 지정할 수 있음
		
		return mav;
	}

//	@RequestMapping(value="/return/test3")
//	public ModelAndView returnTest3(ModelAndView mav) {
//		
//		ModelAndView mav = new ModelAndView();
//		
//		//모델값 지정하기
//		mav.addObject("title", "ModelAndView 반환");
//		mav.addObject("data", "Model DATA 3");
//		
//		//뷰네임 지정하기
////		mav.setViewName(null); //void리턴타입과 같은 동작
//		mav.setViewName("return/test"); //문자열로 원하는 viewName을 지정할 수 있음
//		
//		return mav;
//	}
}
