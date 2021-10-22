package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Emp;
import service.face.EmpService;
import service.impl.EmpServiceImpl;

@WebServlet("/emp/list")
public class EmpListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmpService empService = new EmpServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/emp/list [GET]");
		
		//사원 전체 정보 목록 조회 - empService 이용
		List<Emp> empList = empService.getList();
		
		//테스트 출력
		for(Emp e : empList) {
			System.out.println(e);
		}
		
		//조회된 결과를 모델값으로 전달
		req.setAttribute("empList", empList);
		
		//View지정 및 forward
		req.getRequestDispatcher("/WEB-INF/views/emp/list.jsp").forward(req, resp);
		
	
	}

}
