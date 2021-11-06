package web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.dto.Board;
import web.service.face.BoardService;
import web.util.Paging;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	//로깅 객체
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	//서비스 객체
	@Autowired BoardService boardService;
	
	@RequestMapping(value="/list")
	public void list(Model model, Paging paramData) {
		logger.info("/board/list [GET]");
		
		Paging paging = boardService.getPaging(paramData);
		logger.info("{}", paging);
		
		List<Board> boardList = boardService.getList(paging);
		for(Board b : boardList) {
			logger.info("{}", b);
		}
		
		model.addAttribute("paging", paging);
		model.addAttribute("boardList", boardList);
		
	}
	
	@RequestMapping(value="/view")
	public void view(@RequestParam("boardno") int boardNo, Model model) {
		logger.info("/board/view [GET]");
		
		Board boardView = boardService.getBoardByBoardNo(boardNo);
		
		model.addAttribute("board", boardView);
		
		
	}
}
