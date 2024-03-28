package edu.kh.warrioronline.warrior.model.service;

import java.sql.Connection;
import java.util.List;

import static edu.kh.warrioronline.common.JDBCTemplate.*;

import edu.kh.warrioronline.warrior.model.dao.WarriorDAO;
import edu.kh.warrioronline.warrior.model.dto.Warrior;

public class WarriorService {

	private WarriorDAO dao = new WarriorDAO();
	
	/** 로그인한 회원의 캐릭터 전부 조회 서비스
	 * @param memberNo 
	 * @return
	 */
	public List<Warrior> selectAll(int memberNo) throws Exception{
		Connection conn = getConnection();
		
		List<Warrior> warriorList = dao.selectAll(conn, memberNo);
		
		close(conn);
		
		return warriorList;
	}

	/** 캐릭터 생성 서비스
	 * @param warriorName
	 * @param memberNo 
	 * @return
	 */
	public int create(String warriorName, int memberNo) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.create(conn, warriorName, memberNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	/** 캐릭터 삭제 서비스
	 * @param warriorNo
	 * @return
	 */
	public int delete(String warriorNo) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.delete(conn, warriorNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	/** 선택한 캐릭터 조회 서비스
	 * @param warriorNo
	 * @param memberNo 
	 * @return
	 */
	public Warrior selectOne(String warriorNo, int memberNo) throws Exception{
		Connection conn = getConnection();
		
		Warrior warrior = dao.selectOne(conn, warriorNo, memberNo);
		
		close(conn);
		
		return warrior;
	}

}
