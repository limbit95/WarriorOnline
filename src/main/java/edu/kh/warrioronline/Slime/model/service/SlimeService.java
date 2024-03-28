package edu.kh.warrioronline.Slime.model.service;

import java.sql.Connection;

import edu.kh.warrioronline.Slime.model.dao.SlimeDAO;
import edu.kh.warrioronline.Slime.model.dto.Slime;

import static edu.kh.warrioronline.common.JDBCTemplate.*;

public class SlimeService {
	
	private SlimeDAO dao = new SlimeDAO();

	/** 슬라임 전체 조회 서비스
	 * @return
	 */
	public int selectAll() throws Exception{
		Connection conn = getConnection();
		
		int length = dao.selectAll(conn);
		
		close(conn);
		
		return length;
	}

	/** 슬라임 랜덤으로 한마리만 조회 서비스
	 * @param slimeNo
	 * @return
	 */
	public Slime selectOne(int slimeNo) throws Exception{
		Connection conn = getConnection();
		
		Slime slime = dao.selectOne(conn, slimeNo);
		
		close(conn);
		
		return slime;
	}

}
