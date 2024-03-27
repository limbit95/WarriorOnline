package edu.kh.warrioronline.member.model.service;

import edu.kh.warrioronline.member.model.dao.MemberDAO;
import edu.kh.warrioronline.member.model.dto.Member;

import static edu.kh.warrioronline.common.JDBCTemplate.*;

import java.sql.Connection;

public class MemberService {
	
	private MemberDAO dao = new MemberDAO();

	/** 로그인 서비스
	 * @param inputId
	 * @param inputPw
	 * @return
	 */
	public Member login(String inputId, String inputPw) throws Exception{
		Connection conn = getConnection();
		
		Member loginMember = dao.login(conn, inputId, inputPw);
		
		close(conn);
		
		return loginMember;
	}

	/** 회원가입 서비스
	 * @param member
	 * @return
	 */
	public int signUp(Member member) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.signUp(conn, member);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	
	
}