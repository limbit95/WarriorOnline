package edu.kh.warrioronline.dungeon.model.controller;

import java.io.IOException;

import edu.kh.warrioronline.Slime.model.dto.Slime;
import edu.kh.warrioronline.Slime.model.service.SlimeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/battle")
public class BattleController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			SlimeService slimeService = new SlimeService();
			
			int slimeNo = Integer.parseInt(req.getParameter("slimeno"));
			
			Slime slime = slimeService.selectOne(slimeNo);
			
			HttpSession session = req.getSession();
			
			session.setAttribute("slime", slime);
			
			session.removeAttribute("damagedslime");
			session.removeAttribute("deadslime");
			
		} catch (Exception e) {
			System.out.println("[전투 시작 중 예외발생]");
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("/WEB-INF/views/dungeon/slime.jsp").forward(req, resp);
		
	}
	
}