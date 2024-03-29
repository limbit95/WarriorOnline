package edu.kh.warrioronline.dungeon.model.controller;

import java.io.IOException;

import edu.kh.warrioronline.Slime.model.dto.Slime;
import edu.kh.warrioronline.warrior.model.dto.Warrior;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/attack")
public class AttackController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session = req.getSession();
		
		Warrior warrior = (Warrior)session.getAttribute("selectwarrior");
		
		Slime slime = (Slime)session.getAttribute("slime");
		
		if(warrior.getIsAlive().equals("Y")) {
			slime.damaged(warrior);			
		}
		
		if(slime.isAlive()) {
			warrior.damaged(slime);
		}
		
		if(warrior.getIsAlive().equals("N")){
			session.setAttribute("deadwarrior", "사망");
		}
		
		session.setAttribute("damagedslime", slime);
		
		if(!slime.isAlive()) {
			session.setAttribute("deadslime", slime);
			warrior.setExp(warrior.getExp() + slime.getExp());
			warrior.setGold(warrior.getGold() + slime.getGold());
			warrior.statusUp();
		}
		
		session.setAttribute("selectwarrior", warrior);
		
		req.getRequestDispatcher("/WEB-INF/views/dungeon/slime.jsp").forward(req, resp);
		
	}
	
}