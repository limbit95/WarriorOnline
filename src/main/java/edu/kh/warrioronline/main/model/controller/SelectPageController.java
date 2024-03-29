package edu.kh.warrioronline.main.model.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.warrioronline.member.model.dto.Member;
import edu.kh.warrioronline.member.model.service.MemberService;
import edu.kh.warrioronline.warrior.model.dto.Warrior;
import edu.kh.warrioronline.warrior.model.service.WarriorService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/selectpage")
public class SelectPageController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			HttpSession session = req.getSession();
			
			Member member = (Member)session.getAttribute("loginMember");
			
			WarriorService warriorService = new WarriorService();
			
			List<Warrior> warriorList = warriorService.selectAll(member.getMemberNo());
			
			session.setAttribute("warriorList", warriorList);
			
			session.removeAttribute("deadwarrior");
			session.removeAttribute("selectwarrior");
		} catch (Exception e) {
			System.out.println("[회원 번호 조회 중 예외발생");
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("/WEB-INF/views/main/selectpage.jsp").forward(req, resp);
	}

	
	
}