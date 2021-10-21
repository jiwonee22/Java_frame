package dao;

import java.util.List;

import dto.Emp;

public interface EmpDao {

	/**
	 * emp 테이블 전체 조회
	 * 
	 * @return List형식으로 조회
	 */
	public List<Emp> selectAll();

	/**
	 * empno로 Emp 객체 조회하기
	 * 
	 * @param empno
	 * @return Emp 객체
	 */
	public Emp selectByEmpno(int empno);
	
	/**
	 * 새로운 직원 정보 삽입
	 * 
	 * @param newEmp -  삽입할 Emp 객체
	 * @return 영향받은 행 수
	 */
	public int insertEmp(Emp newEmp);

	/**
	 * 입력받은 직원 번호로 직원 정보 삭제
	 * 
	 * @param deleteEmpno - 직원 번호
	 * @return 영향받은 행 수
	 */
	public int deleteByEmpno(int deleteEmpno);

}
