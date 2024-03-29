package edu.kh.warrioronline.warrior.model.dto;

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
public class Weapon {

	private int weaponNo;
	private String weaponName;
	private int weaponAttack;
	private int avalLevel;
	private int price;
	
}