package edu.kh.warrioronline.dungeon.model.controller;

import java.io.IOException;
import java.util.Random;

import edu.kh.warrioronline.Slime.model.dto.Slime;
import edu.kh.warrioronline.Slime.model.service.SlimeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/slime")
public class SlimeDungeonController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			SlimeService slimeService = new SlimeService();
			
			int length = slimeService.selectAll();
			
			Random random = new Random();
			int slimeNo = random.nextInt(length) + 1;
			
			Slime slime = slimeService.selectOne(slimeNo);
			
			req.setAttribute("randomslime", slime);
			
		} catch (Exception e) {
			System.out.println("[슬라임 랜덤 생성 중 예외발생]");
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("/WEB-INF/views/dungeon/slime.jsp").forward(req, resp);
		
	}
	
}