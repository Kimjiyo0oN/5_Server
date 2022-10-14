package edu.kh.jsp.student.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jsp.student.model.vo.Student;

import static edu.kh.jsp.common.JDBCTemplate.*;

public class SelectDepartmentDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public SelectDepartmentDAO() {
		try {
			String filePath
			= StudentDAO.class.getResource("/edu/kh/jsp/sql/student-sql.xml").getPath();
			
			prop = new Properties();
			
			prop.loadFromXML(new FileInputStream(filePath));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/** 학과별 학생 정보 DAO
	 * @param conn
	 * @param department 
	 * @return
	 * @throws Exception
	 */
	public List<Student> selectDepartment(Connection conn, String department) throws Exception{
		
		List<Student> sList = new ArrayList<>();
		
		try {
			
			String sql = prop.getProperty("selectDepartment");
			pstmt = conn.prepareStatement(sql);
			 
			pstmt.setString(1, department);
			//SQL 수행 수 결과(ResultSet) 반환 받기
			rs = pstmt.executeQuery();
			 
			 while(rs.next()) {
				 String studentNo = rs.getString("STUDENT_NO");
				 String studentName = rs.getString("STUDENT_NAME");
				 String studentAddress = rs.getString("STUDENT_ADDRESS");
				 String departmentName = rs.getString("DEPARTMENT_NAME");
				 //STUDENT_NO,STUDENT_NAME,STUDENT_ADDRESS,DEPARTMENT_NAME
				 
				 sList.add(new Student(studentNo, studentName, studentAddress, departmentName));
			 }
			
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return sList;
	}

}
