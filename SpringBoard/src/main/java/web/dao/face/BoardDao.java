package web.dao.face;

import java.util.List;

import web.dto.Board;
import web.dto.Boardfile;
import web.util.Paging;

public interface BoardDao {

	/**
	 * 페이징을 적용하여 게시글 목록 조회
	 * 
	 * 	paging.startNo, paging.endNo를 이용하여 rownum을 조회한다
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return 페이징이 적용된 게시글 목록
	 */
	public List<Board> selectList(Paging paging);

	/**
	 * 전체 게시글 수를 조회한다
	 * 
	 * @return 총 게시글 수
	 */
	public int selectCntAll();

	/**
	 * 조회하려는 게시글의 조회수를 1 증가시킨다
	 * 
	 * @param viewBoard - 게시글 번호 객체
	 */
	public void hit(Board viewBoard);

	/**
	 * 게시글 번호를 이용하여 게시글을 조회한다
	 * 
	 * @param viewBoard - 조회하려는 게시글의 글 번호 객체
	 * @return 조회된 게시글 정보
	 */
	public Board selectBoardByBoardno(Board viewBoard);

	/**
	 * 게시글 정보를 삽입한다
	 * 
	 * @param board - 삽입할 게시글 정보
	 */
	public void insertBoard(Board board);

	/**
	 * 첨부파일 정보를 삽입한다
	 * 
	 * @param boardfile - 삽입할 첨부파일 정보
	 */
	public void insertFile(Boardfile boardfile);

	/**
	 * 게시글 번호를 이용하여 첨부파일 정보를 조회한다
	 * 
	 * @param viewBoard - 조회할 게시글 번호
	 * @return 조회된 첨부파일 정보
	 */
	public Boardfile selectBoardfileByBoardno(Board viewBoard);

	/**
	 * 파일 번호를 이용하여 첨부파일 정보를 조회한다
	 * 
	 * @param fileNo - 조회할 파일 번호
	 * @return 조회된 첨부파일 정보
	 */
	public Boardfile selectBoardfileByFileno(int fileNo);
	
	/**
	 * 게시글정보를 수정
	 * 
	 * @param board - 수정할 내용을 가진 게시글 객체
	 */
	public void update(Board board);

	/**
	 * 게시글의 첨부파일을 삭제한다
	 * 
	 * @param board - 첨부파일을 삭제할 게시글 객체
	 */
	public void deleteFile(Board board);

	/**
	 * 게시글정보를 삭제
	 * 
	 * @param board - 삭제할 게시글의 글번호 객체
	 */
	public void delete(Board board);
	
	
	
}


















