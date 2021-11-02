package login.dao.face;

import login.dto.Login;

public interface LoginDao {
	
	/**
	 * 신규 회원 정보를 DB에 삽입한다
	 * 
	 * @param login
	 */
	public void insert(Login login);

	/**
	 * 로그인 ID&PW가 일치하는 행(사용자)의 수 구하기
	 * -> 인증에 활용
	 * 
	 * @param login - 로그인 정보
	 * @return - 일치하는 행(사용자) 수
	 */
	public int selectCnt(Login login);
	
	/**
	 * 전달된 id를 이용하여 사용자 정보를 조회한다
	 * 
	 * @param loginid - 조회하려는 대상의 id
	 * @return 조회된 회원의 정보 DTO객체
	 * 
	 */
	public Login selectLoginById(String loginid);


}
