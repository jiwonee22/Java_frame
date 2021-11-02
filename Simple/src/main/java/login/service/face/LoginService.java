package login.service.face;

import javax.servlet.http.HttpServletRequest;

import login.dto.Login;

public interface LoginService {
	
	/**
	 * 회원가입
	 * 
	 * @param login
	 */
	public void join(Login login);

	/**
	 * 로그인 인증 처리
	 * ID&PW를 조회하여 행 COUNT를 확인한다
	 * 
	 * 인증 성공 - true반환
	 * 인증 실패 - false반환
	 * 
	 * @param login - 로그인에 사용할 ID&PW 정보 DTO객체
	 * @return
	 * 		true -  로그인 인증 성공
	 * 		false - 로그인 인증 실패
	 */
	public boolean login(Login login);
	
	/**
	 * 전달된 id를 이용하여 사용자 정보 조회하기
	 * 
	 * @param loginid - 조회할 사용자의 id
	 * @return 조회된 사용자의 정보
	 */
	public Login info(String loginid);
	

	


}
