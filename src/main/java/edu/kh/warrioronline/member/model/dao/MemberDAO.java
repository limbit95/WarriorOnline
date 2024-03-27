package edu.kh.warrioronline.member.model.dao;

import java.beans.Statement;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import static edu.kh.warrioronline.common.JDBCTemplate.*;
import edu.kh.warrioronline.member.model.dto.Member;

public class MemberDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public MemberDAO(){
		try {
			prop = new Properties();
			String filePath = MemberDAO.class.getResource("/edu/kh/warrioronline/sql/member-sql.xml").getPath();
			prop.loadFromXML( new FileInputStream(filePath));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/** 로그인 SQL 수행 DAO
	 * @param conn
	 * @param inputId
	 * @param inputPw
	 * @return
	 * @throws Exception
	 */
	public Member login(Connection conn, String inputId, String inputPw) throws Exception{
		Member loginMember = null;
		
		try {
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, inputId);
			pstmt.setString(2, inputPw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				loginMember = new Member();
				
				loginMember.setMemberNo(rs.getInt(1));
				loginMember.setMemberId(rs.getString(2));
				loginMember.setMemberNickname(rs.getString(3));
				loginMember.setEnrollDate(rs.getString(4));
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return loginMember;
	}

	/** 회원가입 SQL 수행 DAO
	 * @param conn
	 * @param member
	 * @return
	 */
	public int signUp(Connection conn, Member member) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("signUp");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberNickname());
			
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	
}