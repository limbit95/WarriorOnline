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
import edu.kh.warrioronline.warrior.model.dto.Weapon;

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
	 * @param warriorNo String
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
				warrior.setWeaponName(rs.getString("WEAPON_NAME"));
				warrior.setWeaponDamage(rs.getInt("WEAPON_ATTACK"));
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return warrior;
	}
	
	/** 선택한 캐릭터 조회 SQL 수행 DAO 
	 * @param conn
	 * @param warriorNo INT
	 * @param memberNo 
	 * @return
	 */
	public Warrior selectOne(Connection conn, int warriorNo, int memberNo) throws Exception{
		Warrior warrior = null;
		
		try {
			String sql = prop.getProperty("selectOne");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, warriorNo);
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
				warrior.setWeaponName(rs.getString("WEAPON_NAME"));
				warrior.setWeaponDamage(rs.getInt("WEAPON_ATTACK"));
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return warrior;
	}

	/** 캐릭터 이름 중복 검사
	 * @param conn
	 * @param warriorName 
	 * @return
	 */
	public int nameCheck(Connection conn, String warriorName) throws Exception{
		int checkResult = 0;
		
		try {
			String sql = prop.getProperty("nameCheck");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, warriorName);
			
			checkResult = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		
		return checkResult;
	}

	/** 생성한 캐릭터의 무기 인벤토리 생성 서비스 
	 * @param conn
	 * @param warriorName
	 * @param memberNo
	 * @return
	 */
	public int weaponCreate(Connection conn, String warriorName, int memberNo) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("createWeapon");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, warriorName);
			pstmt.setInt(2, memberNo);
			
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		
		return result;
	}



	/** 생성한 캐릭터의 물약 인벤토리 생성 서비스 
	 * @param conn
	 * @param warriorName
	 * @param memberNo
	 * @return
	 */
	public int potionCreate(Connection conn, String warriorName, int memberNo) throws Exception{
int result = 0;
		
		try {
			String sql = prop.getProperty("createPotion");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, warriorName);
			pstmt.setInt(2, memberNo);
			
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 선택한 캐릭터의 무기 인벤토리 조회 SQL 수행 DAO
	 * @param conn
	 * @param warriorNo
	 * @return
	 */
	public List<Weapon> selectAllByWeapon(Connection conn, int warriorNo) throws Exception{
		List<Weapon> weaponList = new ArrayList<Weapon>(); 
		
		try {
			String sql = prop.getProperty("selectAllByWeapon");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, warriorNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Weapon weapon = new Weapon();
				
				weapon.setWeaponNo(rs.getInt("WEAPON_NO"));
				weapon.setWeaponName(rs.getString("WEAPON_NAME"));
				weapon.setWeaponAttack(rs.getInt("WEAPON_ATTACK"));
				weapon.setAvalLevel(rs.getInt("AVALIABLE_LEVEL"));
				weapon.setPrice(rs.getInt("PRICE"));
				
				weaponList.add(weapon);
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return weaponList;
	}

	/** 선택한 캐릭터의 현재 무기 장착 해제 SQL 수행 DAO
	 * @param conn
	 * @param warriorNo
	 * @return
	 */
	public int offWeapon(Connection conn, int warriorNo) throws Exception{
		int off = 0;
		
		try {
			String sql = prop.getProperty("offWeapon");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, warriorNo);
			
			off = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		
		return off;
	}

	/** 선택한 캐릭터에게 선택한 무기 장착 SQL 수행 DAO
	 * @param conn
	 * @param warriorNo
	 * @param weaponNo
	 * @return
	 */
	public int onWeapon(Connection conn, int warriorNo, String weaponNo) throws Exception{
		int on = 0;
		
		try {
			String sql = prop.getProperty("onWeapon");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, warriorNo);
			pstmt.setString(2, weaponNo);
			
			on = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		
		return on;
	}

	/** 캐릭터 저장 SQL 수행 DAO
	 * @param conn
	 * @param warrior
	 * @param memberNo 
	 * @return
	 */
	public int save(Connection conn, Warrior warrior, int memberNo) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("save");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, warrior.getLevel());
			pstmt.setInt(2, warrior.getExp());
			pstmt.setInt(3, warrior.getMaxHp());
			pstmt.setInt(4, warrior.getHp());
			pstmt.setInt(5, warrior.getAttack());
			pstmt.setInt(6, warrior.getStatPoint());
			pstmt.setInt(7, warrior.getGold());
			pstmt.setString(8, warrior.getIsAlive());
			pstmt.setInt(9, warrior.getWarriorNo());
			pstmt.setInt(10, memberNo);
			
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
}