package com.kh.di;

public class Greet
{
	private String message;

	public Greet()
	{
		System.out.println(getClass().getName() + "..Instance");
	}

	public Greet(String message)
	{
		this.message = message;
	}

	public void printMessage()
	{
		System.out.println(getClass().getName() + "=>" + message);
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	
	
}
