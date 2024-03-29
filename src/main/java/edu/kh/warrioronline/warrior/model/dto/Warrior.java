package edu.kh.warrioronline.warrior.model.dto;

import edu.kh.warrioronline.Slime.model.dto.Slime;
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
public class Warrior {

	private int warriorNo; // 번호
	private String warriorName; // 이름
	private int level; // 레벨
	private int exp; // 경험치
	private int maxHp; // 최대 체력
	private int hp; // 체력
	private int attack; // 공격력
	private int statPoint; // 스탯포인트
	private int gold; // 돈
	private String isAlive; // 생존여부
	private String createDate; // 캐릭터 생성 일자
	
	private String weaponName; // 무기 이름
	private int weaponDamage; // 무기 공격력
	
	public void damaged(Slime slime) {
		if(hp <= slime.getAttack()) {
			hp = 0;
			exp -= 5;
			if(exp < 0) {
				exp = 0;
			}
			isAlive = "N";
			return;
		}
		
		hp -= slime.getAttack();
		return;
	}
	
	public void statusUp() {
		if(exp >= 100) {
			exp -= 100;
			level += 1;
			statPoint += 1;
		} 
	}
	
	// 영구 체력 증가 
		public void maxHpUp() {
			if(statPoint > 0) {
				maxHp += 10;
				statPoint--;
			} 
		}
		
	// 영구 공격력 증가
	public void attackUp() {
		if(statPoint > 0) {
			attack += 3;
			statPoint--;
		} 
	}
	
}