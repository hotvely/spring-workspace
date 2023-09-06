package com.kh.api.controller;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kh.api.model.Phone;
import com.kh.api.model.Userinfo;
import com.kh.api.service.PhoneServiceImpl;

@RestController
public class PhoneController
{
	@Autowired
	private PhoneServiceImpl service;

	@GetMapping("/phone")
	public ResponseEntity select()
	{
		try
		{
			List<Phone> list = service.select();
			return new ResponseEntity(list, HttpStatus.OK);
		}
		catch (RuntimeException e)
		{
			// TODO: handle exception
			return new ResponseEntity("phone select() error", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/phone/{num}")
	public ResponseEntity select(@PathVariable String num)
	{
		try
		{
			Phone temp = new Phone();
			temp.setNum(num);
			Phone phone = service.select(temp);

			return new ResponseEntity(phone, HttpStatus.OK);

		}
		catch (RuntimeException e)
		{
			// TODO: handle exception
			return new ResponseEntity("phone select(String num) error", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/userinfo/{user}")
	public ResponseEntity select(@PathVariable Userinfo user)
	{
		try
		{
			Userinfo userinfo = service.select(user);
			return new ResponseEntity(userinfo, HttpStatus.OK);
		}
		catch (RuntimeException e)
		{
			// TODO: handle exception
			return new ResponseEntity("phone select(Userinfo user) error", HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/phone")
	public ResponseEntity insert(@RequestBody Phone phone)
	{
		try
		{
			int result = service.insert(phone);

			return new ResponseEntity(result, HttpStatus.OK);
		}
		catch (RuntimeException e)
		{
			// TODO: handle exception
			return new ResponseEntity("phone insert error...", HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/phone")
	public ResponseEntity update(@RequestBody Phone phone)
	{

		try
		{
			System.out.println(phone);
			int result = service.update(phone);
			System.out.println("result :" + result);
			return new ResponseEntity(result, HttpStatus.OK);
		}
		catch (RuntimeException e)
		{
			// TODO: handle exception
			return new ResponseEntity("phone update error...", HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/phone/{num}")
	public ResponseEntity delete(@PathVariable String num)
	{
		try
		{
			service.delete(num);
			return new ResponseEntity(HttpStatus.OK);
		}
		catch (RuntimeException e)
		{
			// TODO: handle exception
			return new ResponseEntity("phone delete error...", HttpStatus.BAD_REQUEST);
		}
	}

//	@DeleteMapping("/phone/{list}")
//	public ResponseEntity delete(@PathVariable List<String> list)
//	{
//		try
//		{
//			int result = service.delete(list);
//			return new ResponseEntity(HttpStatus.OK);
//		}
//		catch (RuntimeException e)
//		{
//			// TODO: handle exception
//			return new ResponseEntity("phone delete error...", HttpStatus.BAD_REQUEST);
//		}
//	}

}
