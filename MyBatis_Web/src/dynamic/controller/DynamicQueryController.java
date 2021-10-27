package dynamic.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Emp;
import dynamic.dao.DynamicQueryDao;
import mybatis.MyBatisConnectionFactory;

@WebServlet("/dynamic/query")
public class DynamicQueryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//마이바티스 연결 객체
	private SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
	
	//마이바티스 수행 객체
	private SqlSession sqlSession;
	
	//DAO객체
	private DynamicQueryDao dynamicQueryDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/dynamic/query [GET]");
		//-------------------------------------------------------------------------
		
		//마이바티스 관련 객체
		sqlSession = factory.openSession();
		dynamicQueryDao = sqlSession.getMapper(DynamicQueryDao.class);
		//-------------------------------------------------------------------------
		
		//데이터베이스 조회
		List<HashMap<String, Object>> list1 = dynamicQueryDao.select1();
		
		//조회결과 테스트
		for(Map m : list1) {
			System.out.println(m.get("ENAME"));
		}
	
		List<HashMap<String, Object>> list2 = dynamicQueryDao.select2("KING");
		List<HashMap<String, Object>> list3 = dynamicQueryDao.select2("");
		List<HashMap<String, Object>> list4 = dynamicQueryDao.select2(null);
		
//		System.out.println("--- \"KING\" ---");
//		for(Map m : list2) System.out.println(m);
//	
//		System.out.println("--- \"\" ---");
//		for(Map m : list3) System.out.println(m);
//
//		System.out.println("--- null ---");
//		for(Map m : list4) System.out.println(m);
		
		//-------------------------------------------------------------------------
		
		//DTO를 이용한 파라미터 전달
		Emp emp = new Emp();
		emp.setEmpno(7782); //7782 CLARK
		emp.setEname("KING");
		
		List<HashMap<String, Object>> list5 = dynamicQueryDao.select3(emp);
		
		for(Map m : list5) {
			System.out.println(m);
		}
		
		//-------------------------------------------------------------------------
		
		//HashMap을 이용한 파라미터 전달
		HashMap<String, Object> param = new HashMap<>();
		
		//사원 이름 검색
		param.put("category", "ename");
		param.put("keyword", "FORD");
		
		//직무 검색
		param.put("category", "job");
		param.put("keyword", "MANAGER");
		
		List<HashMap<String, Object>> list6 = dynamicQueryDao.select4(param);
		
		
		
		
	}
	
	
}
