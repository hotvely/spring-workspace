package com.kh.mvc.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor		//기본생성자 추가
@AllArgsConstructor		//데이터 넣은 생성자 추가
public class Member
{
	private String id;
	private String pwd;
	private String name;
	private String addr;
	
	
	
	
}
