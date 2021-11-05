package web.dao.face;

import java.util.List;

import web.dto.Board;
import web.util.Paging;

public interface BoardDao {

    /**
     * 게시글 전체를 페이징 적용해서 불러온다
     * 
     * @param paging - 페이징 개개체
     * @return 페이징이 적용된 게시글 전체 목록
     */
	public List<Board> selectBoardList(Paging paging);
	
	/**
	 * 전체 게시글의 수를 조회한다
	 * 
	 * @return - 총 게시글 개수
	 */
	public int selectCntAll();

}
