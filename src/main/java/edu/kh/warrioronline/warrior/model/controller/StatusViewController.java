package edu.kh.warrioronline.warrior.model.controller;

import java.io.IOException;

import edu.kh.warrioronline.warrior.model.dto.Warrior;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/statusview")
public class StatusViewController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/warrior/statusview.jsp").forward(req, resp);
		
	}
	
}