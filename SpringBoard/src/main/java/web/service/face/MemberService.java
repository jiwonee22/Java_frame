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
	public void join(Member member);

}
