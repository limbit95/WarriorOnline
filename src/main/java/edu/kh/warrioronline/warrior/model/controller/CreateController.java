package edu.kh.warrioronline.warrior.model.controller;

import java.io.IOException;

import edu.kh.warrioronline.member.model.dto.Member;
import edu.kh.warrioronline.warrior.model.service.WarriorService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/create")
public class CreateController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/warrior/create.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			HttpSession session = req.getSession();
			
			Member member = (Member)session.getAttribute("loginMember");
			String warriorName = req.getParameter("warriorName");
			
			WarriorService warriorService = new WarriorService();
			
			int result = warriorService.create(warriorName, member.getMemberNo());
			
			
			if(result > 0) {
				session.setAttribute("message2", "새로운 캐릭터를 생성하였습니다.");
				resp.sendRedirect("/selectpage");
			} else{
				session.setAttribute("message2", "캐릭터 생성 실패!");
				resp.sendRedirect( req.getHeader("referer") );
			}
		} catch (Exception e) {
			System.out.println("[캐릭터 생성 중 예외발생]");
			e.printStackTrace();
		}
		
	}
	
}