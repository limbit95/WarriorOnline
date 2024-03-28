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

@WebServlet("/giveup")
public class GiveupController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		Warrior warrior = (Warrior)session.getAttribute("selectwarrior");
		
		Slime slime = (Slime)session.getAttribute("slime");
		
		if(slime.isAlive()) {
			warrior.damaged(slime);
		}
		
		session.setAttribute("selectwarrior", warrior);
		
		session.removeAttribute("slime");
		session.removeAttribute("danagedslime");
		
		resp.sendRedirect("/dungeon");
		
	}
	
}