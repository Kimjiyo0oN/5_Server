package edu.kh.project.member.model.dao;

import static edu.kh.project.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.project.member.model.vo.Member;


/**
 * @author user1
 *
 */
public class MemberDAO {
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public MemberDAO(){
		try {
			prop = new Properties();
			String filePath = MemberDAO.class.getResource("/edu/kh/project/sql/member-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath) );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Member login(Connection conn, Member member) throws Exception{
		Member loginmember = null;
		try {
			
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getMemberEmail());
			pstmt.setString(2, member.getMemberPw());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs != null) {
					loginmember = new Member();
					loginmember.setMemberNo(rs.getInt("MEMBER_NO"));
					loginmember.setMemberEmail(rs.getString("MEMBER_EMAIL"));
					loginmember.setMemberNickname(rs.getString("MEMBER_NICKNAME"));
					loginmember.setMemberTel(rs.getString("MEMBER_TEL"));
					loginmember.setMemberAddress(rs.getString("MEMBER_ADDRESS"));
					loginmember.setProfileImage(rs.getString("PROFILE_IMG"));
					loginmember.setAuthority(rs.getInt("AUTHORITY"));
				}	
			}
			
			
		} finally {
			close(rs);
			close(pstmt);
		}
		return loginmember;
	}

	public int signUp(Connection conn, Member member) throws Exception{
		int result =0;
		try {
			String sql = prop.getProperty("signUp");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getMemberEmail());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberNickname());
			pstmt.setString(4, member.getMemberTel());
			pstmt.setString(5, member.getMemberAddress());
			
			result = pstmt.executeUpdate();
			
			
		} finally {
			close(pstmt);
		}
		return result;
	}

	/**
	 * @param conn
	 * @param member
	 * @return
	 * @throws Exception
	 */
	public int updateMember(Connection conn, Member member) throws Exception{
		int result = 0;
		try {
			String sql = prop.getProperty("updateMember");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getMemberNickname());
			pstmt.setString(2, member.getMemberTel());
			pstmt.setString(3, member.getMemberAddress());
			
			pstmt.setInt(4, member.getMemberNo());
			
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}

}
