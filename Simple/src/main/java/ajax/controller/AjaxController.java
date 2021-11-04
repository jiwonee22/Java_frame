package ajax.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ajax.dto.ResultData;


@Controller
public class AjaxController {

	//로그 객체
	private static final Logger logger = LoggerFactory.getLogger(AjaxController.class);
	
	//------------------------------------------------------------------------------------
	//1. 응답 출력 스트림을 이용하여 JSON Text를 직접 출력(응답)하기
	
	@RequestMapping(value="/ajax/test01")
	public void ajaxTest01() {
		logger.info("AJAX TEST 01");
	}
	
	@RequestMapping(value="/ajax/test01_ok")
	public void ajaxTest01_ok(Writer out) {
		logger.info("AJAX TEST 01 OK");
		
		try {
			out.write("{\"result\": true}");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//------------------------------------------------------------------------------------
	//2. @ResponseBody를 이용해서 응답메시지 Body를 직접 작성, 객체를 JSON Text로 응답하기
	//	jackson-databind 라이브러리 필요
	
	//	** jackson 라이브러리
	//		Java객체 <-> JSON 변환을 도와주는 자바 라이브러리
	
	@RequestMapping(value="/ajax/test02")
	public void ajaxTest02() {
		logger.info("AJAX TEST 02");
	}

//	@RequestMapping(value="/ajax/test02_ok")
//	public @ResponseBody HashMap<String, Object> ajaxTest02_ok(@RequestParam HashMap<String, Object> params) {
//		logger.info("AJAX TEST 02 OK");
//		
//		HashMap<String, Object> map = new HashMap<>();
//		
//		map.put("A", "Apple");
//		map.put("B", "123");
//		map.put("C", false);
//		
//		return map;
//	}
	
//	@RequestMapping(value="/ajax/test02_ok")
//	public @ResponseBody ResultData ajaxTest02_ok() {
//		logger.info("AJAX TEST 02 OK");
//		
//		ResultData rd = new ResultData("Alice", 22222, true);
//
//		return rd;
//	}
	
	@RequestMapping(value="/ajax/test02_ok")
	public @ResponseBody List<ResultData> ajaxTest02_ok() {
		logger.info("AJAX TEST 02 OK");
		
		List<ResultData> list = new ArrayList<>();
		
		list.add(new ResultData("Apple", 11111, true));
		list.add(new ResultData("Banana", 22222, false));
		list.add(new ResultData("Cherry", 33333, true));
		
		return list;
	}
	
	//------------------------------------------------------------------------------------
	//3. AJAX 응답으로 JSP응답을 활용하기
	//	전달해야하는 데이터(모델값)을 JSP에 전달하고 JSP로 포워딩한다
	//	-> 완성된 HTML코드로 응답 데이터를 전송할 수 있다
	
	@RequestMapping(value="/ajax/test03")
	public void ajaxTest03() {
		logger.info("AJAX TEST 03");
	}
	
	@RequestMapping(value="/ajax/test03_ok")
	public String ajaxTest03_ok(Model model) {
		logger.info("AJAX TEST 03 OK");
		
		model.addAttribute("data1", new ResultData("A", 123, true));
		model.addAttribute("data2", new ResultData("B", 456, true));

		return "ajax/test03_ok_response";
	}

	//------------------------------------------------------------------------------------
	//4. JSON을 생성하는 전용 view 사용 - jsonView
	//	jsonView를 Spring Bean으로 등록한다
	//	BeanNameViewResolver를 이용하여 jsonView로 응답한다
	
	@RequestMapping(value="/ajax/test04")
	public void ajaxTest04() {
		logger.info("AJAX TEST 04");
	}

	@RequestMapping(value="/ajax/test04_ok")
	public ModelAndView ajaxTest04_ok(ModelAndView mav) {
		logger.info("AJAX TEST 04 OK");
		
		mav.addObject("rd", new ResultData("Alice", 99999, true));
		mav.setViewName("jsonView");
		
		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}