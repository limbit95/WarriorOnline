package edu.kh.warrioronline.warrior.model.controller;

import java.io.IOException;

import edu.kh.warrioronline.warrior.model.dto.Warrior;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addstat")
public class AddStatController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String addType = req.getParameter("add");
		
		HttpSession session = req.getSession();
		
		Warrior warrior = (Warrior)session.getAttribute("selectwarrior");
		
		if(addType != null) {
			if(addType.equals("maxhp")) {
				warrior.maxHpUp();
			} else if(addType.equals("attack")) {
				warrior.attackUp();
			}
		}
		
		session.setAttribute("selectwarrior", warrior);
		
		req.getRequestDispatcher("/WEB-INF/views/warrior/addstat.jsp").forward(req, resp);
		
	}
	
}