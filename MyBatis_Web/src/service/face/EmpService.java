package service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.Emp;

public interface EmpService {

	/**
	 * 전체 정보 조회하기
	 * 
	 * @return 조회된 전체 사원들 정보 목록
	 */
	public List<Emp> getList();
	
	/**
	 * 전달파라미터로 부터 사원번호를 알아내기
	 * 
	 * @param req - 요청 객체
	 * @return - 사원 번호
	 */
	public int getEmpNo(HttpServletRequest req);

	/**
	 * 사원 번호로, 사원 객체 조회
	 * 
	 * @param empNo - 사원 번호
	 * @return - 사원 객체
	 */
	public Emp getDetail(int empNo);

}
