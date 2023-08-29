package com.kh.mvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mvc.model.dao.MemberDAO;
import com.kh.mvc.model.vo.Member;

@Service
public class MemberService
{
	@Autowired
	private MemberDAO dao;

	public int registerMember(Member vo)
	{
		return dao.registerMember(vo);
//		return dao.registerMember(vo);
	}
	
	public List<Member> findMember(String keyword)
	{
		List<Member> temp = null;
		temp =  dao.findMember(keyword);
		return temp;
	}
	
	public List<Member> showAllMember()
	{
		return dao.showAllMember();
	}
	
	public Member login(Member vo)
	{
		return dao.login(vo);
	}
	
	public int update(Member vo)
	{
		
		return  dao.updateMember(vo);
	}
	

}
