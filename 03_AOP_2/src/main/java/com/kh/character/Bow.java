package com.kh.character;

public class Bow extends Weapon
{
	public Bow()
	{
	}

	public Bow(String name)
	{
		super(name);
	}

	@Override
	public String attack() throws Exception
	{
		// TODO Auto-generated method stub
		return "활을 쏨";
	}

}
