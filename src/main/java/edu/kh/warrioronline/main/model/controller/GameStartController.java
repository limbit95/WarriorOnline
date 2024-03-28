package edu.kh.warrioronline.main.model.controller;

import java.io.IOException;

import edu.kh.warrioronline.member.model.dto.Member;
import edu.kh.warrioronline.warrior.model.dto.Warrior;
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
			
			Member member = (Member)session.getAttribute("loginMember");
			String warriorNo = req.getParameter("warriorNo");
			
			WarriorService warriorService = new WarriorService();
			
			Warrior warrior = warriorService.selectOne(warriorNo, member.getMemberNo());
			
			session.setAttribute("selectwarrior", warrior);
		} catch (Exception e) {
			System.out.println("[캐릭터 접속 중 예외발생]");
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("/WEB-INF/views/main/gamestart.jsp").forward(req, resp);
		
	}
	
	
	
}