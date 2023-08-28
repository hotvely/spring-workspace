package com.kh.di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class GreeTestApp3UsingSpring
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/main/resources/config/greet.xml"));

//		Greet g1 = (Greet)factory.getBean("greet1");
//		g1.printMessage();
//		
//		Greet g2 = (Greet)factory.getBean("greet2");
//		g2.printMessage();

		// 기본 생성자 한번 거쳤다가, 변수에 값을 할당해 주고(greet.xml에서) 호출하는 방식
		Greet g3 = (Greet) factory.getBean("greet3");
		g3.printMessage();
		
		Greet g4 = (Greet) factory.getBean("greet4");
		g4.printMessage();
	}

}
