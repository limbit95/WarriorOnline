package edu.kh.warrioronline.warrior.model.dao;

import java.beans.Statement;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.warrioronline.warrior.model.dto.Warrior;
import static edu.kh.warrioronline.common.JDBCTemplate.*;

public class WarriorDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;

	public WarriorDAO(){
		try {
			prop = new Properties();
			String filePath = WarriorDAO.class.getResource("/edu/kh/warrioronline/sql/warrior-sql.xml").getPath();
			prop.loadFromXML( new FileInputStream(filePath));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 로그인한 회원의 캐릭터 전부 조회 SQL 수행 DAO
	 * @param conn
	 * @param memberNo
	 * @return
	 */
	public List<Warrior> selectAll(Connection conn, int memberNo) throws Exception{
		List<Warrior> warriorList = new ArrayList<Warrior>();
		
		try {
			String sql = prop.getProperty("selectAll");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Warrior warrior = new Warrior();
				
				warrior.setWarriorNo(rs.getInt("WARRIOR_NO"));
				warrior.setWarriorName(rs.getString("WARRIOR_NAME"));
				warrior.setLevel(rs.getInt("WARRIOR_LEVEL"));
				warrior.setExp(rs.getInt("WARRIOR_EXP"));
				warrior.setMaxHp(rs.getInt("MAX_HP"));
				warrior.setHp(rs.getInt("HP"));
				warrior.setAttack(rs.getInt("ATTACK"));
				warrior.setStatPoint(rs.getInt("STAT_POINT"));
				warrior.setGold(rs.getInt("GOLD"));
				warrior.setIsAlive(rs.getString("ISALIVE"));
				warrior.setCreateDate(rs.getString("CREATE_DATE"));
				
				warriorList.add(warrior);
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return warriorList;
	}

	/** 캐릭터 생성 SQL 수행 DAO
	 * @param conn
	 * @param warriorName
	 * @param memberNo 
	 * @return
	 */
	public int create(Connection conn, String warriorName, int memberNo) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("create");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, warriorName);
			pstmt.setInt(2, memberNo);
			
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}

	/** 캐릭터 삭제 SQL 수행 DAO
	 * @param conn
	 * @param warriorNo
	 * @return
	 */
	public int delete(Connection conn, String warriorNo) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("delete");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, warriorNo);
			
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 선택한 캐릭터 조회 SQL 수행 DAO
	 * @param conn
	 * @param warriorNo
	 * @param memberNo 
	 * @return
	 */
	public Warrior selectOne(Connection conn, String warriorNo, int memberNo) throws Exception{
		Warrior warrior = null;
		
		try {
			String sql = prop.getProperty("selectOne");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, warriorNo);
			pstmt.setInt(2, memberNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				warrior = new Warrior();
				
				warrior.setWarriorNo(rs.getInt("WARRIOR_NO"));
				warrior.setWarriorName(rs.getString("WARRIOR_NAME"));
				warrior.setLevel(rs.getInt("WARRIOR_LEVEL"));
				warrior.setExp(rs.getInt("WARRIOR_EXP"));
				warrior.setMaxHp(rs.getInt("MAX_HP"));
				warrior.setHp(rs.getInt("HP"));
				warrior.setAttack(rs.getInt("ATTACK"));
				warrior.setStatPoint(rs.getInt("STAT_POINT"));
				warrior.setGold(rs.getInt("GOLD"));
				warrior.setIsAlive(rs.getString("ISALIVE"));
				warrior.setCreateDate(rs.getString("CREATE_DATE"));
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return warrior;
	}

}