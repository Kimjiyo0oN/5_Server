package edu.kh.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
//		String id = req.getParameter("memberId");
//		String[] pw = req.getParameterValues("memberPw");
//		
//		String name = req.getParameter("memberName");
//		String email = req.getParameter("memberEmail");
//		
//		String[] hobby = req.getParameterValues("hobby");
//		
//		String succ = null;
//		if(pw != null) {
//			
//			if(pw[0].equals(pw[1])) succ="일치";
//			else succ="비밀번호가 일치하지 않습니다.";
//			
//		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/signUpResult.jsp");
		
		dispatcher.forward(req, resp);
	}
}
