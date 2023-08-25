package com.kh.di;

public class HelloTestApp2
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		// 1. 사용할 컴포넌트(Bean) 정보를 갖는 hello.properties를 parsing,
		// Bean객체를 생성할 HelloFactory객체 생성
		HelloFactory helloFactory = HelloFactory.getInstance();

		// 2. HelloFactory 객체로 parsing할 resource전달해줌
		helloFactory.setConfigResource("./src/main/resources/config/hello.properties");

		// 3. Bean객체 생성
		Hello hello = helloFactory.getBean("instance.one");

		// 4. printMessage() 호출
		hello.printMessage();

	}

}
