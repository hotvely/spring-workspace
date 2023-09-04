package com.kh.security.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kh.security.model.dao.MemberDAO;
import com.kh.security.model.vo.Member;

@Service
public class MemberService implements UserDetailsService
{
	@Autowired
	private MemberDAO dao;

	public int registerMember(Member vo)
	{
		return dao.resigsterMember(vo);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		// TODO Auto-generated method stub
		Member member = dao.getMemberById(username);
		System.out.println(member);
		if (member == null)
		{
			throw new UsernameNotFoundException(username + " not founded;");
		}
		return member;
	}

}
