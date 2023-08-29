package com.kh.character;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Character
{
	private String name;
	private int level;
	private Weapon weapon;
	
	public String quest(String questName) throws Exception{
		System.out.println(questName + " 퀘스트 진행중..");
		return questName + " 퀘스트 진행중";
	}
	
}
