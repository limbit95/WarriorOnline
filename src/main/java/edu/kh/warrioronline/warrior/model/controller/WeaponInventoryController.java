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
			// 접속한 캐릭터의 무기 인벤토리 전체 조회			
			HttpSession session = req.getSession(); 
			
			WarriorService warriorService = new WarriorService();
			
			Warrior warrior = (Warrior)session.getAttribute("selectwarrior");
			
			List<Weapon> weaponList = (List<Weapon>)session.getAttribute("weaponList");
			
			if(weaponList == null) {
				weaponList = warriorService.selectAllByWeapon(warrior.getWarriorNo());
			}
			
			if(!weaponList.isEmpty()) {
				session.setAttribute("weaponList", weaponList);
			}
			
			// 무기 인벤토리에서 선택한 무기로 장착
			String equipWeaponNo = req.getParameter("equip");
			
			if(!weaponList.isEmpty() && equipWeaponNo != null) {
				for(Weapon w : weaponList) {
					if(w.getWeaponNo() == Integer.parseInt(equipWeaponNo)) {
						if(warrior.getLevel() >= w.getAvalLevel()) {
							warrior.setWeaponNo(w.getWeaponNo());
							warrior.setWeaponName(w.getWeaponName());
							warrior.setWeaponDamage(w.getWeaponAttack());
							session.setAttribute("weaponchangemessage", "[무기 교체 완료]");
							break;
						} else {
							session.setAttribute("weaponchangemessage", "[사용 가능한 레벨이 아닙니다]");
							break;
						}
					}
				}
			}
			// 무기 인벤토리에서 선택한 무기 판매
			String sellWeaponNo = req.getParameter("sell");
			
			if(!weaponList.isEmpty() && sellWeaponNo != null) {
				for(Weapon w : weaponList) {
					if(w.getWeaponNo() == Integer.parseInt(sellWeaponNo)) {
						if(warrior.getWeaponNo() == Integer.parseInt(sellWeaponNo)) {
							session.setAttribute("weaponchangemessage", "[판매 불가 : 해당 무기 현재 장착 중]");
							break;
						}
						warrior.setGold(warrior.getGold() + w.getPrice());
						weaponList.remove(w);
						session.setAttribute("weaponList", weaponList);
						int result = warriorService.sellFl(w.getWeaponNo(), warrior.getWarriorNo());
						session.setAttribute("weaponchangemessage", "[무기 판매 완료]");
						break;
					}
				}
			}
			
			// --------------------------------------------------------------------------
			// 무기 장착 변경 코드 (DB에 바로 저장하는 코드여서 위의 코드로 변경함			
//			if(weaponNo != null) {
//				int off = warriorService.offWeapon(warrior.getWarriorNo());
//				int on = warriorService.onWeapon(warrior.getWarriorNo(), weaponNo);
//			}
//			
//			Member member = (Member)session.getAttribute("loginMember");
//			Warrior warrior2 = warriorService.selectOne(warrior.getWarriorNo(), member.getMemberNo());
//			
//			warrior.setWeaponName(warrior2.getWeaponName());
//			warrior.setWeaponDamage(warrior2.getWeaponDamage());
			// --------------------------------------------------------------------------
			
			
			session.setAttribute("selectwarrior", warrior);
			
		} catch (Exception e) {
			System.out.println("[무기 인벤토리 조회중 예외발생]");
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("/WEB-INF/views/warrior/weaponinventory.jsp").forward(req, resp);
		
	}
	
}