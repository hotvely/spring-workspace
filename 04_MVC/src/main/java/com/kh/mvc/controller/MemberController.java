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
	public String signIn(Member vo, HttpServletRequest req)
	{
		HttpSession session = req.getSession();
		System.out.println("웹에서 넘어온 .. VO " + vo);
		if (service.login(vo) != null)
		{
			System.out.println("singIn" + service.login(vo));
			session.setAttribute("vo", service.login(vo));
			return "redirect:/";
		}

		return "login";
	}

	// allMember - 비즈니스 로직 포함, 데이터 바인딩 model.
	// --> return "find_ok"
	@RequestMapping("allMember")
	public String allMember(HttpServletRequest req)
	{
		List<Member> list = service.showAllMember();
		req.setAttribute("list", list);

		if (list != null)
			return "find_ok";
		else
			return "find_fial";
	}

	// logout - 로그아웃 기능!
	@RequestMapping("logout")
	public String logout(HttpServletRequest req)
	{
		HttpSession session = req.getSession();
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
	public String update(Member vo, HttpServletRequest req)
	{
		HttpSession session = req.getSession();
	
		
		vo.setId(((Member)session.getAttribute("vo")).getId());
		
		if (service.update(vo) > 0)
		{
		
			//session에 있는 값 변경하쟈~~
			session.setAttribute("vo", vo);
			return "redirect:/";
		}
			

		return "update";

	}
}
