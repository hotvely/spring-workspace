package com.kh.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kh.api.model.Greeting;

@RestController
public class GreetingController
{
	//http://loaclhost:8080/api/greet	--> selectList (데이터를 가져와서 던지는 경우.. 딱 떨이질떄..?)
	@GetMapping("/greet")
	public Greeting sayGreeting()
	{
		return new Greeting(3214L, "Restful API");
	}

	
	// http://localhost:8080/board/view?no=23 (X 이제 일케 안씀!)
	// http://localhost:8080/board/23 --> selectOne
	@GetMapping("/greet/{id}")
	public String showSample(@PathVariable int id)
	{
		//PathVariable -> URL 경로의 일부를 파라미터로 사용할 때, 
		return "Hello Rest API case number..;" + id;
	}
		
	
	
	
	// http://localhost:8080/search?keyword=....
	@GetMapping("/greet2")
	public Greeting sayGreet2(String content)
	{
		return new Greeting(500L, content);
	}
	
	
}
