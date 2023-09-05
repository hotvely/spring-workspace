package com.kh.api.service;

import java.util.List;

import com.kh.api.model.Phone;
import com.kh.api.model.Userinfo;

public interface PhoneService
{ // impl -> PhoneServiceImpl

	int insert(Phone phone);

	int delete(List<String> list);

	int update(Phone phone);

	Phone select(Phone phone);

	List<Phone> select();

	Userinfo select(Userinfo user);
}
