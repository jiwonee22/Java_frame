package web.controller;

import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import web.dto.User;

@Controller
public class ParamController {
	
	//로깅객체
	private static final Logger logger = LoggerFactory.getLogger(ParamController.class);
	
	@RequestMapping(value="/param/requestParam", method=RequestMethod.GET)
	public String paramForm() {
		
		logger.info("TEST - /param/requestParam [GET]");
		
		//VIEW지정
		return "param/paramForm";
	}
	
	@RequestMapping(value="/param/requestParam", method=RequestMethod.POST)
	public String paramResult(String username, String userage) {
	
		logger.info("/param/requestParam [POST]");
		
		logger.debug("username : {}" , username);
		logger.debug("userage : {}" , userage);
		
		logger.debug("username : {} , userage : {}", username, userage);
		
		return "param/paramResult";
	}
	
	@RequestMapping(value="/param/required")
	public void requiredTest(@RequestParam(required=true) String test) {
		logger.info("/param/required");
		
		logger.info("/param/required test : {}", test);
		
	}
	
	@RequestMapping(value="/param/test")
	public void paramTest(
			HttpSession session

			, HttpServletRequest req
			, HttpServletResponse resp
			
			, Writer out
			, Reader in
			
			, Locale locale
			
			, Model model
			, ModelAndView mav
			, ModelMap modelMap
				
			
			) {
		
		String userid = (String) session.getAttribute("userid");
		
	}
	
	@RequestMapping(value="/param/dto", method = RequestMethod.GET)
	public void paramDtoForm() {
		logger.info("/param/dto [GET]");
		
	}

	
	@RequestMapping(value="/param/dto", method = RequestMethod.POST)
	public String paramDto(
			
			User user //커맨드 객체
			
			, @ModelAttribute("u2") User user2 //커맨드 객체
			
			, Model model //모델값 처리 객체
			
			) {
		logger.info("/param/dto [POST]");
		logger.info("user : {}", user);
		logger.info("user : {}", user2);
		
		model.addAttribute("userData", user);
		
		return "param/dtoResult";
		
	}
	
	@RequestMapping(value="/param/map", method = RequestMethod.GET)
	public void paramMapForm() {
		logger.info("/param/map [GET]");
		
	}
	
	@RequestMapping(value="/param/map", method = RequestMethod.POST)
	public String paramMapResult(@RequestParam HashMap<String, String> map, Model model) {
		logger.info("/param/mapForm [POST]");
		logger.info("{}", map);
		
		//맵객체 자체를 모델값으로 전달한다
		model.addAttribute("m", map);
		
		//맵객체 내부의 키=값 쌍을 각각의 모델값으로 분리해서 전달한다
		model.addAllAttributes(map);
		
		return "param/mapResult";
		
	}
	
	
	
	
	
	
	
	
	
}
