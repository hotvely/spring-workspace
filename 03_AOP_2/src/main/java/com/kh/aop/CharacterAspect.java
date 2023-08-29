package com.kh.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

// 일반 적인 자바 클래스가 아닌, Aspect임을 나타냄
@Aspect
public class CharacterAspect
{

	/*
	 * 포인트컷 표현식 execution([수식어] 리턴타입 [클래스이름].이름(파라미터)) - 수식어 : public, private, 등의
	 * 수식어를 명시(생략가눙) - 리턴타입 : 리턴 타입을 명시 - 클래스 이름 및 이름 : 클래스,메서드 이름을 명시(클래스 이름은
	 * 풀패키지명으로 명시, 생략가능!) - 파라미터 : 메서드의 파라미터를 명시 - * : 모든 값을 표현 - .. : 0개 이상을 의미(모든
	 * 매개변수 가져와! 라는 의미임)
	 */
	@Pointcut("execution(* com.kh.character.Character.quest(..))")
	public void questPointcut()
	{
		
	}

//	@Before("execution(* com.kh.character.Character.quest(..))")
	@Before(value = "questPointcut()")
	public void beforeQuest(JoinPoint jp)
	{
		// 퀘스트를 수행하기 전에 필요한 부가 작업들 수행.
		String questName = (String) jp.getArgs()[0];
		System.out.println(questName + " 퀘스트 준비중 ...");
	}

//	@After("execution(* com.kh.character.Character.quest(..))")
	@After(value = "questPointcut()")
	public void afterQuest()
	{
		System.out.println("퀘스트 끗!");
	}

	@Around("execution(* com.kh.character.Character.quest(..))")
	public String aroundQuest(ProceedingJoinPoint jp)
	{
		String result = null;
		System.out.println("공격 준비!!");
		try
		{
			result = (String) jp.proceed();
			System.out.println("result");
			System.out.println("공격 성공@@@@ 대박스~");
		}
		catch (Throwable e)
		{
			// TODO Auto-generated catch block
			System.out.println("에러 에러 에러 ~");
			e.printStackTrace();
		}

		return result;
	}

}
