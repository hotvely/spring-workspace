package com.kh.character;

public class Sword extends Weapon
{

	public Sword()
	{
		// TODO Auto-generated constructor stub
	}

	public Sword(String name)
	{
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String attack() throws Exception
	{
		// TODO Auto-generated method stub
		return "검을 휘두름~!!";
	}

}
