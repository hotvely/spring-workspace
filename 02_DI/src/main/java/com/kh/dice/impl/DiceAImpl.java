package com.kh.dice.impl;

import java.util.Random;

import com.kh.dice.Dice;

public class DiceAImpl implements Dice
{
	private int value;
	
	public DiceAImpl()
	{
		// TODO Auto-generated constructor stub
		System.out.println(getClass().getName() + "생성자...");
	}

	@Override
	public void selectedNumber()
	{
		// TODO Auto-generated method stub
		value = new Random().nextInt(6) + 1;
	}

	@Override
	public int getValue()
	{
		// TODO Auto-generated method stub
		return value;
	}

}
