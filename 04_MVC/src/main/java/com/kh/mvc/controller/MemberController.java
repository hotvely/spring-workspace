package com.kh.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.mvc.model.service.MemberService;
import com.kh.mvc.model.vo.Member;

@Controller
public class MemberController
{
	@Autowired
	private MemberService service;

	@RequestMapping("search")
	public String search()
	{
		return "search";
	}

	@RequestMapping("find")
	public String find(String keyword, Model model)
	{
		System.out.println(keyword);
		// 서비스로 비즈니스 로직 처리 ~ 하자
		List<Member> list = service.findMember(keyword);
		model.addAttribute("list", list);
		// -- > list 값 데이터바인딩 -> model
//		model.addAttribute("list", list);
		if (list != null)
			return "find_ok";// 성공시
		// 실패시 find_fail
		else
			return "find_fail";
	}

	@RequestMapping("register")
	public String register()
	{
		return "register";
	}

	@RequestMapping("signUp")
	public String signUp(Member member)
	{

		// 비즈니스 로직
		service.registerMember(member);
		return "redirect:/";
	}

	// login
	// signIn - 비즈니스 로직 포함.. -> 파라미터 값 = HttpServletRequest request
	@RequestMapping("login")
	public String login()
	{
		return "login";
	}

	@RequestMapping("signIn")
	public String signIn(Member vo, HttpSession session)
	{
		if (service.login(vo) != null)
		{

			session.setAttribute("vo", service.login(vo));

			return "redirect:/";
		}

		return "login";
	}

	// allMember - 비즈니스 로직 포함, 데이터 바인딩 model.
	// --> return "find_ok"
	@RequestMapping("allMember")
	public String allMember(Model model)
	{
		List<Member> list = service.showAllMember();
		model.addAttribute("list", list);

		if (list != null)
			return "find_ok";
		else
			return "find_fial";
	}

	// logout - 로그아웃 기능!
	@RequestMapping("logout")
	public String logout(HttpSession session)
	{

		session.setAttribute("vo", null);

		return "redirect:/";

	}

	// update - 페이지 이동
	// updateMember - 비즈니스 로직 포함 -> 파라미터 request 필요함
	@RequestMapping("update")
	public String update()
	{
		return "update";
	}

	@RequestMapping("updateMember")
	public String update(Member vo, HttpSession session)
	{
		
		Member prevMem = (Member)session.getAttribute("vo");
		
		vo.setId(prevMem.getId());
		System.out.println(vo);
		if (service.update(vo) > 0)
		{
			System.out.println("값 변경 완료");
			
			System.out.println("변경하기 전 member : " + prevMem);
			
			
			session.setAttribute("vo", vo);
			System.out.println("변경 후 member : " + session.getAttribute("vo"));
			
			return "redirect:/";
		}
			

		return "update";

	}
}
