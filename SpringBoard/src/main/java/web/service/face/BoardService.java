package web.service.face;

import java.util.List;

import web.dto.Board;

public interface BoardService {

	/**
	 * 게시글 목록을 불러온다
	 * 
	 * @return 게시글 목록
	 */
	public List<Board> getList();

	


	
}
