package com.kh.di;

import java.io.InputStream;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;

public class HelloTestApp3UsingSpring
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// 1. BeanFactory 생성.. 주문서는 공장에서 미리 받아서 읽기 !
		// Bean Configuration File : 빈(Bean) 설정문서;
		System.out.println("1. BeanFactory 생성...");
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/main/resources/config/hello.xml"));

		// 2. getBean() 으로 bean 받아서 printMessage() 호출할거
		System.out.println("2. getBean() 클라이언트 호출..");
		Hello hello = (Hello) factory.getBean("hello");
		hello.printMessage();
	}

}
