package service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dao.face.EmpDao;
import dto.Emp;
import mybatis.MyBatisConnectionFactory;
import service.face.EmpService;

public class EmpServiceImpl implements EmpService {
	
	//마이바티스 연결 객체
	private SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
	
	//DAO객체
	private EmpDao empDao = null;
		
	@Override
	public List<Emp> getList() {

		//마이바티스 수행 객체
		SqlSession sqlSession = factory.openSession();
	
		//매퍼를 이용한 DAO객체 연결
		empDao = sqlSession.getMapper(EmpDao.class);
		
		//전체 리스트 조회
		List<Emp> empList = empDao.selectAll();
		
		//자원 해제
		sqlSession.close();
		
		//조회된 결과 반환
		return empList;
	}
	
	@Override
	public int getEmpNo(HttpServletRequest req) {
		
		//마이바티스 수행 객체
		SqlSession sqlSession = factory.openSession();
			
		//매퍼를 이용한 DAO객체 연결
		empDao = sqlSession.getMapper(EmpDao.class);
		
		//요청객체로부터 파라미터 받아서 사원 번호 반환
		String param = req.getParameter("empno");
		
		int empno = 0;
		
		if(param != null && !"".equals(param)) 
			
			empno = Integer.parseInt(param);
		
		//자원 해제
		sqlSession.close();
			
		return empno;
	}
	
	
	@Override
	public Emp getDetail(int empno) {
		

		//마이바티스 수행 객체
		SqlSession sqlSession = factory.openSession();
			
		//매퍼를 이용한 DAO객체 연결
		empDao = sqlSession.getMapper(EmpDao.class);
		
		Emp empDetail = empDao.selectByEmpno(empno);
		
		//자원 해제
		sqlSession.close();
			
		return empDetail;
		
		
		
	}

}
