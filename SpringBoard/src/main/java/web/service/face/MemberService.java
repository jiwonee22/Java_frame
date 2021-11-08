package web.service.face;

import web.dto.Member;

public interface MemberService {

	/**
	 * 로그인
	 * 
	 * @param member
	 * @return 
	 */
	public boolean login(Member member);

	/**
	 * 회원가입
	 * 
	 * @param member
	 */
	public boolean join(Member member);

	/**
	 * 회원의 닉네임 조회
	 * 
	 * @param member - 닉네임을 조회하려는 사용자 정보
	 * @return 사용자의 닉네임
	 */
	public String getNick(Member member);

}
