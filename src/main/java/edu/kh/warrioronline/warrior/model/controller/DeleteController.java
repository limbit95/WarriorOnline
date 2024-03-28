package edu.kh.warrioronline.warrior.model.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.warrioronline.member.model.dto.Member;
import edu.kh.warrioronline.warrior.model.dto.Warrior;
import edu.kh.warrioronline.warrior.model.service.WarriorService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/delete")
public class DeleteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String warriorNo = req.getParameter("warriorNo");
			
			WarriorService service = new WarriorService();
			
			int result = service.delete(warriorNo);
			
			HttpSession session = req.getSession();
			
			Member member = (Member)session.getAttribute("loginMember");
			
			if(result > 0) {
				List<Warrior> warriorList = service.selectAll(member.getMemberNo());
				session.setAttribute("warriorList", warriorList);
			} else {
				session.setAttribute("message2", "캐릭터 삭제 실패!");
			}
			
			resp.sendRedirect("/selectpage");
		} catch (Exception e) {
			System.out.println("[삭제 중 예외발생]");
			e.printStackTrace();
		}
		
	}
	
}