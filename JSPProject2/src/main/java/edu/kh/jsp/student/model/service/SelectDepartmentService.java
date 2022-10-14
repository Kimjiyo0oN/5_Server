package edu.kh.jsp.student.model.service;

import java.sql.Connection;
import java.util.List;

import static edu.kh.jsp.common.JDBCTemplate.*;

import edu.kh.jsp.student.model.dao.SelectDepartmentDAO;
import edu.kh.jsp.student.model.vo.Student;

public class SelectDepartmentService {
	SelectDepartmentDAO dao = new SelectDepartmentDAO();

	/** 학과별 학생 정보 조회
	 * @param department 
	 * @return
	 * @throws Exception
	 */
	public List<Student> selectDepartment(String department) throws Exception{
		Connection conn = getConnection();
		
		List<Student> sList = dao.selectDepartment(conn, department);
		
		close(conn);
		
		return sList;
	}

}
