package web.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.face.BoardDao;
import web.dto.Board;
import web.service.face.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

	//로깅 객체
	private static final Logger logger = LoggerFactory.getLogger(BoardService.class);

	//DAO 객체
	@Autowired BoardDao boardDao;

	@Override
	public List<Board> getList() {
		logger.info("getList()");
		
		List<Board> boardList = boardDao.selectBoardAll();
				
		return boardList;

	}
	
	
}
