package edu.kh.warrioronline.Slime.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.warrioronline.Slime.model.dto.Slime;

import static edu.kh.warrioronline.common.JDBCTemplate.*;

public class SlimeDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public SlimeDAO(){
		try {
			prop = new Properties();
			String filePath = SlimeDAO.class.getResource("/edu/kh/warrioronline/sql/slime-sql.xml").getPath();
			prop.loadFromXML( new FileInputStream(filePath));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 슬라임 전체 조회 SQL 수행 DAO
	 * @param conn
	 * @return
	 */
	public int selectAll(Connection conn) throws Exception{
		int length = 0;
		
		try {
			String sql = prop.getProperty("selectAll");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				length = rs.getInt("COUNT");
			}
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		return length;
	}

	/** 슬라임 랜덤으로 한마리만 조회 SQL 수행 DAO
	 * @param conn
	 * @param slimeNo
	 * @return
	 */
	public Slime selectOne(Connection conn, int slimeNo) throws Exception{
		Slime slime = null;
		
		try {
			String sql = prop.getProperty("selectOne");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, slimeNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				slime = new Slime();
				
				slime.setSlimeNo(rs.getInt("SLIME_NO"));
				slime.setSlimeName(rs.getString("SLIME_NAME"));
				slime.setLevel(rs.getInt("SLIME_LEVEL"));
				slime.setExp(rs.getInt("SLIME_EXP"));
				slime.setHp(rs.getInt("HP"));
				slime.setMaxHp(rs.getInt("HP"));
				slime.setAttack(rs.getInt("ATTACK"));
				slime.setGold(rs.getInt("GOLD"));
				slime.setAlive(true);
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return slime;
	}

	
	
}