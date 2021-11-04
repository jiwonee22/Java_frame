package web.dao.face;

import java.util.List;

import web.dto.Board;

public interface BoardDao {

    /**
     * 게시글 전체를 선택해서 불러온다
     * 
     * @return 게시글 전체의 목록
     */
    public List<Board> selectBoardAll();

}
