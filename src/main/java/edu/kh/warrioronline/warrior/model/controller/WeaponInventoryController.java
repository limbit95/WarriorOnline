package edu.kh.warrioronline.warrior.model.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.warrioronline.member.model.dto.Member;
import edu.kh.warrioronline.warrior.model.dto.Warrior;
import edu.kh.warrioronline.warrior.model.dto.Weapon;
import edu.kh.warrioronline.warrior.model.service.WarriorService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/weaponinventory")
public class WeaponInventoryController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			HttpSession session = req.getSession(); 
			
			WarriorService warriorService = new WarriorService();
			
			Warrior warrior = (Warrior)session.getAttribute("selectwarrior");
			
			List<Weapon> weaponList = warriorService.selectAllByWeapon(warrior.getWarriorNo());
			
			if(!weaponList.isEmpty()) {
				session.setAttribute("weaponList", weaponList);
			}
			
			String weaponNo = req.getParameter("weaponNo");
			
			if(weaponNo != null) {
				int off = warriorService.offWeapon(warrior.getWarriorNo());
				int on = warriorService.onWeapon(warrior.getWarriorNo(), weaponNo);
			}
			
			Member member = (Member)session.getAttribute("loginMember");
			Warrior warrior2 = warriorService.selectOne(warrior.getWarriorNo(), member.getMemberNo());
			
			session.setAttribute("selectwarrior", warrior2);
			
		} catch (Exception e) {
			System.out.println("[무기 인벤토리 조회중 예외발생]");
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("/WEB-INF/views/warrior/weaponinventory.jsp").forward(req, resp);
		
	}
	
}