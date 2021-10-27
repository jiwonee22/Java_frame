package dynamic.controller;

import java.io.IOException;
import java.util.Arrays;
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

@WebServlet("/dynamic/query2")
public class DynamicQueryController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//마이바티스 연결 객체
	private SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
	
	//마이바티스 수행 객체
	private SqlSession sqlSession;
	
	//DAO객체
	private DynamicQueryDao dynamicQueryDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/dynamic/query2 [GET]");
		//-------------------------------------------------------------------------

		req.getRequestDispatcher("/WEB-INF/views/dynamic/queryCheckbox.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/dynamic/query2 [POST]");
		//--------------------------------------------------------------------------
		
		//getParameter()메소드는 전달파라미터를 1개만 추출한다
		String data = req.getParameter("deptno");
		System.out.println(data);
		//--------------------------------------------------------------------------
		//getParameterValues()메소드는 전달파라미터 중 해당 name으로 전달된 모든 값을 배열로 추출한다
		String[] values = req.getParameterValues("deptno");
		System.out.println(Arrays.toString(values));
		//--------------------------------------------------------------------------
		
		sqlSession = factory.openSession();
		dynamicQueryDao = sqlSession.getMapper(DynamicQueryDao.class);
		
		//deptno로 전달된 여러개의 전달 데이터를 String[]로 파싱
		String[] deptnos = req.getParameterValues("deptno");
		
		//String[] 데이터를 HashMap에 담아서 매퍼에 전달한다 -> list자체는 매퍼에서 사용이 어려움
		HashMap<String, Object> map = new HashMap<>();
		map.put("deptnoArr", deptnos);
		
		List<HashMap<String, Object>> list = dynamicQueryDao.selectCheckbox(map);
		for(Map m : list) System.out.println(m);
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/views/dynamic/query.jsp").forward(req, resp);
		
		
		
		
		
		
		
	
	}
	
}
