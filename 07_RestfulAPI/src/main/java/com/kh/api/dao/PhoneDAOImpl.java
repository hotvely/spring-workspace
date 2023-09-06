package com.kh.api.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.api.model.Phone;
import com.kh.api.model.Userinfo;

@Repository
public class PhoneDAOImpl implements PhoneDAO
{
	@Autowired
	SqlSessionTemplate session;

	@Override
	public int insert(Phone phone)
	{
		// TODO Auto-generated method stub
		return session.insert("phone.insert", phone);
	}

	@Override
	public int delete(List<String> list)
	{
		// TODO Auto-generated method stub
		return session.delete("phone.delete", list);
	}

	@Override
	public int delete(String num)
	{
		// TODO Auto-generated method stub
		return session.delete("phone.delete", num);
	}

	@Override
	public Phone select(Phone phone)
	{
		// TODO Auto-generated method stub
		return session.selectOne("phone.select", phone);
	}

	@Override
	public List<Phone> select()
	{
		// TODO Auto-generated method stub
		return session.selectList("phone.select");
	}

	@Override
	public Userinfo select(Userinfo user)
	{
		// TODO Auto-generated method stub
		return session.selectOne("phone.selectUser", user);
	}

	@Override
	public int update(Phone phone)
	{
		// TODO Auto-generated method stub
		return session.update("phone.update", phone);
	}

}
