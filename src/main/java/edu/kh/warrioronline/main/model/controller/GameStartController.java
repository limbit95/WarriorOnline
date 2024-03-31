package edu.kh.warrioronline.main.model.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.warrioronline.member.model.dto.Member;
import edu.kh.warrioronline.warrior.model.dto.Warrior;
import edu.kh.warrioronline.warrior.model.dto.Weapon;
import edu.kh.warrioronline.warrior.model.service.WarriorService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/gamestart")
public class GameStartController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			HttpSession session = req.getSession();
			WarriorService warriorService = new WarriorService();
			
			Member member = (Member)session.getAttribute("loginMember");
			
			Warrior warrior = (Warrior)session.getAttribute("selectwarrior");
			
			String warriorNo = req.getParameter("warriorNo");
			
			if(warrior == null) { // 선택한 캐릭터로 처음 접속할 때 
				Warrior loadwarrior = warriorService.selectOne(warriorNo, member.getMemberNo());
				session.setAttribute("selectwarrior", loadwarrior);
				
				int sellFlReset = warriorService.sellFlReset(loadwarrior.getWarriorNo());
				
				if(loadwarrior.getIsAlive().equals("N")){
					session.setAttribute("deadwarrior", "사망");
				}
			} else { // 접속한 상태서 다른 페이지로 이동했다 gamestart 페이지로 넘어올 때
				session.setAttribute("selectwarrior", warrior);
			}
			
			String save = req.getParameter("save");
			
			if(save != null) {
				int result = warriorService.save(warrior, member.getMemberNo());
				int off = warriorService.offWeapon(warrior.getWarriorNo());
				int on = warriorService.onWeapon(warrior.getWarriorNo(), String.valueOf(warrior.getWeaponNo()));
				
				// 판매한 정보 커밋 코드
				int result2 = warriorService.sellWeapon(warrior.getWarriorNo());
			}
			
		} catch (Exception e) {
			System.out.println("[캐릭터 접속 중 예외발생]");
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("/WEB-INF/views/main/gamestart.jsp").forward(req, resp);
		
	}
	
	
	
}