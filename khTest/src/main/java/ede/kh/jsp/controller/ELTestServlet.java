package ede.kh.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/elTest")
public class ELTestServlet extends HttpServlet{
	
	// ** 데이터 전달 방식에 따라서
	// 하나의 요청 주소로 여러가지 처리가 가능하다! **
	// GET - select
	// POST - insert
	// PUT - update
	// DELETE - delete
	
//	a태그로 요청(GET)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher 
			= req.getRequestDispatcher("/WEB-INF/views/el/elTest.jsp");
		
		// WEB-INF 폴더는
		// 외부 접근 방법을 통해서 접근 불가
		// 단, 내부 접근(Servlet, JSP에서의 직접 접근)은 가능
		
		dispatcher.forward(req, resp);
	}
	
	// form 태그 요청(POST) --문자 인코딩 차이가 있어서 문자가 깨짐(POST)
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// 요청 데이터 문자 인코딩 지정 
			req.setCharacterEncoding("UTF-8");
			
			System.out.println(req.getParameter("inputName"));
			System.out.println(req.getParameter("inputAge"));
			System.out.println(req.getParameter("inputAddress"));
			
		}
	
}
