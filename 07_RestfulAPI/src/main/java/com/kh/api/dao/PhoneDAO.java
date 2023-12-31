package com.kh.api.dao;

import java.util.List;

import com.kh.api.model.Phone;
import com.kh.api.model.Userinfo;

public interface PhoneDAO
{ // impl -> PhoneDAOImpl
	int insert(Phone phone);

	int delete(List<String> list);

	int delete(String num);

	int update(Phone phone);

	Phone select(Phone phone);

	List<Phone> select();

	Userinfo select(Userinfo user);
}
