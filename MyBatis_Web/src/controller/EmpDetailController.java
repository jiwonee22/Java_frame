package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Emp;
import service.face.EmpService;
import service.impl.EmpServiceImpl;

@WebServlet("/emp/detail")
public class EmpDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmpService empService = new EmpServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/emp/detail [GET]");
		
		int empno = empService.getEmpNo(req);
		System.out.println(empno);
		
		Emp empDetail = empService.getDetail(empno);
		System.out.println(empDetail);
		
		req.setAttribute("empDetail", empDetail);
		
		req.getRequestDispatcher("/WEB-INF/views/emp/detail.jsp").forward(req, resp);
		
		
		
	}

}
