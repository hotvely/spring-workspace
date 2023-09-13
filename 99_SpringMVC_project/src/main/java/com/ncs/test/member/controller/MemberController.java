package com.ncs.test.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ncs.test.member.model.service.MemberService;
import com.ncs.test.member.model.vo.Member;

@Controller
public class MemberController
{
	@Autowired
	private MemberService service;
	
	@RequestMapping("/login")
	public String memberLogin(String memberId, String memberPwd, Model model)
	{
		System.out.println(memberId);
		System.out.println(memberPwd);
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPwd(memberPwd);
		Member target = service.select(member);
		
		System.out.println(target);
		if(target != null)
		{
			model.addAttribute("loginMember", target);
			return "index";
		}
		
		model.addAttribute("msg" , "로그인 실패 !!!");
		return "errorPage";
	}
}
