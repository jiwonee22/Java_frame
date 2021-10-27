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

@WebServlet("/dynamic/query3")
public class DynamicQueryController3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//마이바티스 연결 객체
	private SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
	
	//마이바티스 수행 객체
	private SqlSession sqlSession;
	
	//DAO객체
	private DynamicQueryDao dynamicQueryDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/dynamic/query3 [GET]");
		//-------------------------------------------------------------------------
		
		sqlSession = factory.openSession();
		dynamicQueryDao = sqlSession.getMapper(DynamicQueryDao.class);
		
		//7369 SMITH
		HashMap<String, Object> map = dynamicQueryDao.selectByEmpno(7369);
		System.out.println("DynamicQueryController - " + map);
		
		req.setAttribute("map", map);
		req.getRequestDispatcher("/WEB-INF/views/dynamic/update.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/dynamic/query3 [POST]");
		//--------------------------------------------------------------------------
		
		sqlSession = factory.openSession();
		dynamicQueryDao = sqlSession.getMapper(DynamicQueryDao.class);
		//---------------------------------------------------------------
		
		HashMap<String, Object> param = new HashMap<>();
		param.put("empno", req.getParameter("empno"));
		param.put("job", req.getParameter("job"));
		param.put("sal", req.getParameter("sal"));
		param.put("comm", req.getParameter("comm"));
		
		System.out.println("/dynamic/query3 [POST] - " + param);
		
		dynamicQueryDao.update(param);
		sqlSession.commit();
		
	
	}
	
}
