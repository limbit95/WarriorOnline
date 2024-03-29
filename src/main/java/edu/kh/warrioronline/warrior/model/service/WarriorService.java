package edu.kh.warrioronline.warrior.model.service;

import java.sql.Connection;
import java.util.List;

import static edu.kh.warrioronline.common.JDBCTemplate.*;

import edu.kh.warrioronline.warrior.model.dao.WarriorDAO;
import edu.kh.warrioronline.warrior.model.dto.Warrior;
import edu.kh.warrioronline.warrior.model.dto.Weapon;

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
	 * @param warriorNo String 
	 * @param memberNo 
	 * @return
	 */
	public Warrior selectOne(String warriorNo, int memberNo) throws Exception{
		Connection conn = getConnection();
		
		Warrior warrior = dao.selectOne(conn, warriorNo, memberNo);
		
		close(conn);
		
		return warrior;
	}
	
	/** 선택한 캐릭터 조회 서비스
	 * @param warriorNo Int
	 * @param memberNo 
	 * @return
	 */
	public Warrior selectOne(int warriorNo, int memberNo) throws Exception{
		Connection conn = getConnection();
		
		Warrior warrior = dao.selectOne(conn, warriorNo, memberNo);
		
		close(conn);
		
		return warrior;
	}

	/** 캐릭터 이름 중복 검사 서비스 
	 * @param warriorName
	 * @return
	 */
	public int nameCheck(String warriorName) throws Exception{
		Connection conn = getConnection();
		
		int checkResult = dao.nameCheck(conn, warriorName);
		
		close(conn);
		
		return checkResult;
	}

	/** 생성한 캐릭터의 무기 인벤토리 생성 서비스 
	 * @param warriorName
	 * @param memberNo
	 * @return
	 */
	public int weaponCreate(String warriorName, int memberNo) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.weaponCreate(conn, warriorName, memberNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	/** 생성한 캐릭터의 물약 인벤토리 생성 서비스 
	 * @param warriorName
	 * @param memberNo
	 * @return
	 */
	public int potionCreate(String warriorName, int memberNo) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.potionCreate(conn, warriorName, memberNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
 
	/** 선택한 캐릭터의 무기 인벤토리 전체 조회 서비스
	 * @param warriorNo 
	 * @return
	 */
	public List<Weapon> selectAllByWeapon(int warriorNo) throws Exception{
		Connection conn = getConnection();
		
		List<Weapon> weaponList = dao.selectAllByWeapon(conn, warriorNo);
		
		close(conn);
		
		return weaponList;
	}

	/** 선택한 캐릭터의 현재 무기 장착 해제 서비스 
	 * @param warriorNo
	 * @return
	 */
	public int offWeapon(int warriorNo) throws Exception{
		Connection conn = getConnection();
		
		int off = dao.offWeapon(conn, warriorNo);
		
		if(off > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return off;
	}

	/** 선택한 캐릭터에게 선택한 무기 장착 서비스
	 * @param warriorNo
	 * @param weaponNo
	 * @return
	 */
	public int onWeapon(int warriorNo, String weaponNo) throws Exception{
		Connection conn = getConnection();
		
		int on = dao.onWeapon(conn, warriorNo, weaponNo);
		
		if(on > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return on;
	}

	/** 캐릭터 저장 서비스
	 * @param warrior
	 * @param memberNo 
	 * @return
	 */
	public int save(Warrior warrior, int memberNo) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.save(conn, warrior, memberNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

}