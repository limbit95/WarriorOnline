package edu.kh.warrioronline.warrior.model.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.warrioronline.warrior.model.dto.Potion;
import edu.kh.warrioronline.warrior.model.dto.Warrior;
import edu.kh.warrioronline.warrior.model.service.WarriorService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/potioninventory")
public class PotionInventoryController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			HttpSession session = req.getSession();
			WarriorService warriorService = new WarriorService();
			Warrior warrior = (Warrior)session.getAttribute("selectwarrior");
			
			List<Potion> potionList = (List<Potion>)session.getAttribute("potionList");
			
			if(potionList == null) {
				potionList = warriorService.selectAllByPotion(warrior.getWarriorNo());
			}
			
			if(!potionList.isEmpty())		{
				session.setAttribute("potionList", potionList);
			}
			
			String potionNo = req.getParameter("potionNo");
			
			if(potionNo != null) {
				for(Potion p : potionList) {
					if(p.getPotionNo() == Integer.parseInt(potionNo)) {
						if(p.getQuantity() > 0) {
							if(warrior.getHp() == warrior.getMaxHp()) {
								session.setAttribute("potionmessage", "[체력이 최대치입니다]");
							} else if((warrior.getHp() + p.getHeal()) >= warrior.getMaxHp()) {
								warrior.healHp(p.getHeal());
								p.setQuantity(p.getQuantity() - 1);
								session.setAttribute("potionmessage", "[체력이 최대치까지 회복되었습니다]");
							} else {
								warrior.healHp(p.getHeal());
								p.setQuantity(p.getQuantity() - 1);
								session.setAttribute("potionmessage", "[체력이 [" + p.getHeal() + "]만큼 회복되었습니다.]");
							}
						} else {
							session.setAttribute("potionmessage", "[해당 물약이 부족합니다]");
						}
					}
				}
			}
			
		} catch (Exception e) {
			System.out.println("[물약 인벤토리 조회 중 예외발생]");
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("/WEB-INF/views/warrior/potioninventory.jsp").forward(req, resp);
		
	}
}