package com.kh.dice;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DiceTestApp2
{
	public static void main(String[] args)
	{
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/main/resources/config/dice.xml"));
		ApplicationContext factory = new ClassPathXmlApplicationContext("/config/dice.xml");
		
		Player playerA = (Player) factory.getBean("playerA");
		playerA.playDice(3);
		System.out.println("====================");
		System.out.println("선택된 주사위 수의 통합은 : " + playerA.getTotalValue());
		System.out.println("====================");

		Player playerB = (Player) factory.getBean("playerB");
		playerB.playDice(3);
		System.out.println("====================");
		System.out.println("선택된 주사위 수의 통합은 : " + playerB.getTotalValue());
		System.out.println("====================");

		Player playerC = (Player) factory.getBean("playerC");
		playerC.playDice(3);
		System.out.println("====================");
		System.out.println("선택된 주사위 수의 통합은 : " + playerC.getTotalValue());
		System.out.println("====================");

	}
}
