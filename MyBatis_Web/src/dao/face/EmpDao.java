package dao.face;

import java.util.List;

import dto.Emp;

public interface EmpDao {

	/**
	 * 전체 조회하기
	 * 
	 * @return 조회된 전체 결과 리스트
	 */
	public List<Emp> selectAll();

	/**
	 * 사원 번호로 사원 객체 조회
	 * 
	 * @param empNo
	 * @return 사원 객체
	 */
	public Emp selectByEmpno(int empno);

	
}
