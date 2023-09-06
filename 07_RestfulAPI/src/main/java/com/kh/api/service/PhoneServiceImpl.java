package com.kh.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.api.dao.PhoneDAOImpl;
import com.kh.api.model.Phone;
import com.kh.api.model.Userinfo;

@Service
public class PhoneServiceImpl implements PhoneService
{
	@Autowired
	private PhoneDAOImpl dao;
	  
	@Override
	public int insert(Phone phone)
	{
		// TODO Auto-generated method stub
		return dao.insert(phone);
	}

	@Override
	public int delete(List<String> list)
	{
		// TODO Auto-generated method stub
		
		return dao.delete(list);
	}
	
	@Override
	public int delete(String num)
	{
		// TODO Auto-generated method stub
		
		return dao.delete(num);
	}

	@Override
	public Phone select(Phone phone)
	{
		// TODO Auto-generated method stub
		return dao.select(phone);
	}

	@Override
	public List<Phone> select()
	{
		// TODO Auto-generated method stub
		return dao.select();
	}

	@Override
	public Userinfo select(Userinfo user)
	{
		// TODO Auto-generated method stub
		return dao.select(user);
	}

	@Override
	public int update(Phone phone)
	{
		// TODO Auto-generated method stub
		return dao.update(phone);
	}

}
