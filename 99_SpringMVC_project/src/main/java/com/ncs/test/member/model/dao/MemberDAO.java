package com.ncs.test.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncs.test.member.model.vo.Member;

@Repository
public class MemberDAO
{
	@Autowired
	private SqlSessionTemplate sql;
	
	public Member select(Member vo)
	{
		return sql.selectOne("memberMapper.select", vo);
	}
	
	
	
}
