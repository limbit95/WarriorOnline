package edu.kh.warrioronline.Slime.model.dto;

import edu.kh.warrioronline.warrior.model.dto.Warrior;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Slime {

	private int slimeNo;
	private String slimeName;
	private int Level;
	private int exp; // 죽었을 때 제공 경험치
	private int hp;
	private int maxHp;
	private int attack;
	private int gold; // 죽었을 때 드랍 골드
	private boolean isAlive; // 사망여부
	
	public void damaged(Warrior warrior) {
		if(hp <= (warrior.getAttack() + warrior.getWeaponDamage())) {
			hp = 0;
			isAlive = false;
			return;
		}
		
		hp -= (warrior.getAttack() + warrior.getWeaponDamage());
		return;
	}
	
}