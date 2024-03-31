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
public class Potion {

	private int potionNo;
	private String potionName;
	private int heal;
	private int quantity;
	private int price;
	
}