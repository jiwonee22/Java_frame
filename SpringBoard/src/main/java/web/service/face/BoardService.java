package web.service.face;

import java.util.List;

import javax.servlet.http.HttpSession;

import web.dto.Board;
import web.util.Paging;

public interface BoardService {

	/**
	 * 페이징을 구한다
	 * 
	 * @param req - 요청
	 * @return 페이징 객체
	 */
	public Paging getPaging(Paging paramData);

	/**
	 * 페이징이 적용된 게시글 목록을 불러온다
	 * 
	 * @param paging - 페이징 객체
	 * @return 페이징이 적용된 게시글 목록
	 */
	public List<Board> getList(Paging paging);
	
	/**
	 * 게시글 번호로 게시글 객체를 받아온다
	 * 
	 * @param boardNo - 게시글 번호
	 * @return 게시글 객체
	 */
	public Board getBoardByBoardNo(int boardNo);

	/**
	 * 게시글 작성
	 * 
	 * @param title
	 * @param content
	 * @param id
	 * @param nick
	 */
	public void writeBoard(String title, String content, String id, String nick);
	

	


	
}
