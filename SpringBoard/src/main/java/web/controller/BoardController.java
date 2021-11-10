package web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import web.dto.Board;
import web.dto.Boardfile;
import web.service.face.BoardService;
import web.util.Paging;

@Controller
@RequestMapping(value="/board")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired private BoardService boardService;

	@RequestMapping(value="/list")
	public void list(Paging paramData, Model model) {
		logger.info("/board/list");

		//페이징 계산
		Paging paging = boardService.getPaging( paramData );
		logger.info("{}", paging);

		//게시글 목록 조회
		List<Board> list = boardService.list(paging);
		for(Board b : list) {
			logger.info("{}", b);
		}

		model.addAttribute("paging", paging);
		model.addAttribute("list", list);
	}

	@RequestMapping(value="/view")
	public String view(Board viewBoard, Model model) {
		logger.info("/board/view 파라미터 {}", viewBoard);

		if( viewBoard.getBoardNo() < 1 ) {
			return "redirect:/board/list";
		}

		viewBoard = boardService.view(viewBoard);
		logger.info("/board/view 상세보기 {}", viewBoard);


		//첨부파일 정보 전달
		Boardfile boardfile = boardService.getAttachFile(viewBoard);
		model.addAttribute("boardfile", boardfile);


		//모델값 전달
		model.addAttribute("viewBoard", viewBoard);

		return "board/view";
	}

	@RequestMapping(value="/write", method=RequestMethod.GET)
	public void write() {

	}

	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String writeProc(Board board, MultipartFile file, HttpSession session) {
		logger.info("{}", board);
		logger.info("{}", file);

		board.setWriterId((String) session.getAttribute("id"));
		board.setWriterNick((String) session.getAttribute("nick"));
		logger.info("{}", board);

		boardService.write(board, file);

		return "redirect:/board/list";
	}

	@RequestMapping(value="/download")
	public String download(int fileNo, Model model) {

		Boardfile file = boardService.getFile(fileNo);

		model.addAttribute("downFile", file);

		return "down";
	}

	@RequestMapping(value="/error")
	public void error() {

	}

	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(Board board, Model model) {

		// 게시글 번호가 1보다 작으면 목록으로 보내기
		if(board.getBoardNo() < 1) {
			return "redirect:/board/list";
		}

		// 게시글 상세 정보 전달
		board = boardService.view(board);
		logger.info("상세보기 : {}", board.toString());
		model.addAttribute("view", board);

		//게시글 첨부파일 전달
		Boardfile boardfile = boardService.getAttachFile(board);
		model.addAttribute("boardfile", boardfile);

		return "board/update";

	}


	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateProc(Board board, MultipartFile file, HttpSession session) {

		//작성자 ID, NICK 추가 - 세션
		board.setWriterId((String) session.getAttribute("id"));
		board.setWriterNick((String) session.getAttribute("nick"));

		logger.info("글수정 : {}", board);

		boardService.update(board, file);

		return "redirect:/board/view?boardNo="+board.getBoardNo();

	}
	

	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteProcess(Board board) {
		boardService.delete(board);
		
		return "redirect:/board/list";
	}




}























