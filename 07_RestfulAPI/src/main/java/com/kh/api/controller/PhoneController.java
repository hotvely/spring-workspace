package com.kh.api.controller;

import java.util.List;

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
import com.kh.api.service.PhoneServiceImpl;

@RestController
public class PhoneController
{
	@Autowired
	private PhoneServiceImpl service;

	@GetMapping("/phone")
	public ResponseEntity select()
	{
		List<Phone> list = service.select();
		System.out.println(list);
		// phone all list sending sample..
		if (list.isEmpty())
			return new ResponseEntity("error not found", HttpStatus.NOT_FOUND);

		return new ResponseEntity(list, HttpStatus.OK);
	}

	@GetMapping("/phone/{num}")
	public ResponseEntity select(@PathVariable String num)
	{
		System.out.println("파라미터 있는 .... 함수 진입!");
		Phone temp = new Phone();
		temp.setNum(num);
		System.out.println(temp);
		Phone phone = service.select(temp);

		if (phone != null)
			return new ResponseEntity(phone, HttpStatus.OK);

		return new ResponseEntity("error", HttpStatus.NO_CONTENT);
	}

	@PostMapping("/phone")
	public ResponseEntity insert(@RequestBody Phone phone)
	{
		
		System.out.println(phone);
		if (service.insert(phone) > 0)
			return new ResponseEntity(HttpStatus.OK);

		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/phone")
	public ResponseEntity update(@RequestBody Phone phone)
	{
		if (service.update(phone) > 0)
			return new ResponseEntity(HttpStatus.OK);

		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/phone/{num}")
	public ResponseEntity delete(@PathVariable String num)
	{
		List<String> list = null;
		list.add(num);

		if (service.delete(list) > 0)
			return new ResponseEntity(HttpStatus.OK);

		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

}
