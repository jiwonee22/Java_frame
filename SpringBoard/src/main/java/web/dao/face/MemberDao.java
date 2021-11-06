package web.dao.face;

import web.dto.Member;

public interface MemberDao {
	
	/**
	 * DB에서 일치하는 정보 있는지 검색
	 * 
	 * @param member
	 * @return
	 */
	public int selectCnt(Member member);

	/**
	 * DB에 입력받은 ID와 같은 값이 있는지 조회하기 
	 * 
	 * @param member
	 * @return
	 */
	public int selectCntById(Member member);

	/**
	 * DB에 신규유저 정보를 삽입한다
	 * 
	 * @param member
	 */
	public void insertMember(Member member);

}
