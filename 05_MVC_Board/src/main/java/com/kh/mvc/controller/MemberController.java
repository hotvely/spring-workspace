package com.kh.mvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.mvc.model.service.MemberService;
import com.kh.mvc.model.vo.Member;

@Controller
@RequestMapping("/user/*")
public class MemberController
{

	@Autowired
	private MemberService service;

	@Autowired
	private BCryptPasswordEncoder bcpe;

	@GetMapping("/all")
	public void all()
	{

	}

	@GetMapping("/member")
	public void member()
	{

	}

	@GetMapping("/admin")
	public void admin()
	{

	}

	@GetMapping("/login")
	public void login()
	{

	}

	@GetMapping("/logout")
	public void logout(HttpServletResponse response) throws IOException
	{
		response.sendRedirect("/user/login");
	}

	@PostMapping("/logout")
	public void logout()
	{
		System.out.println("post방식 함수 들어옴..");

	}

	@GetMapping("/error")
	public void error()
	{
	}

	@GetMapping("/register")
	public void register()
	{

	}

	@PostMapping("/register")
	public String register(Member vo)
	{
		System.out.println("before password : " + vo.getPassword());

		// BCryptPasswordEncoder를 이용해서 암호화 처리 !
		String encodePassword = bcpe.encode(vo.getPassword());
		System.out.println("after password : " + encodePassword);

		if (service.registerMember(vo) > 0)
			return "redirect:/user/login";

		return "redirect:/user/register";
	}
}
