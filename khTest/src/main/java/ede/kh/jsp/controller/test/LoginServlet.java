package ede.kh.jsp.controller.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("inputId");
		
		String pw = req.getParameter("inputPW");
		
		String agree = "N";
		
		if(id.equals("user01")&&pw.equals("pass01!")) {
			agree ="Y";
		}else {
			agree ="N";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/loginResult.jsp");
		
		req.setAttribute("agree", agree);
		
		dispatcher.forward(req, resp);
	}
}
