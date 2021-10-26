package selectKey.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.MyBatisConnectionFactory;
import selectKey.dao.SelectKeyDao;
import selectKey.dto.TestMember;

@WebServlet("/mybatis/selectKey")
public class SelectKeyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//마이바티스 연결 객체
	private SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	
	//DAO객체
	private SelectKeyDao selectKeyDao;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/mybatis/selectKey [GET]");

		req.getRequestDispatcher("/WEB-INF/views/mybatis/selectKey.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/mybatis/selectKey [POST]");
		
		System.out.println("mybatis/selectKey - id : " + req.getParameter("id"));
		System.out.println("mybatis/selectKey - pw : " + req.getParameter("pw"));
		
		//마이바티스 수행객체
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//DAO객체
		selectKeyDao = sqlSession.getMapper(SelectKeyDao.class);
		
		//데이터 삽입
//		selectKeyDao.insert(req.getParameter("id"), req.getParameter("pw"));
		
		TestMember tm = new TestMember();
		tm.setId(req.getParameter("id"));
		tm.setPw(req.getParameter("pw"));
		
		selectKeyDao.insert(tm);
		
		
		//commit 수행
		sqlSession.commit();
		
	
	}
}
