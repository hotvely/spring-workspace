package com.kh.mvc.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.mvc.model.vo.Member;

@Repository
public class MemberDAO
{
	@Autowired
	private SqlSessionTemplate session;

	public int resigsterMember(Member vo)
	{
		return session.insert("memberMapper.registerMember", vo);
	}

	public Member getMemberById(String id)
	{
		// TODO Auto-generated method stub
		return session.selectOne("memberMapper.getMemberById", id);
	}

}
