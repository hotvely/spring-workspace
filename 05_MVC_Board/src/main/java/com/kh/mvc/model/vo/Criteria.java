package com.kh.mvc.model.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Criteria
{
	private int page; // 페이지 번호
	private int amount; // 한 페이지 당 몇개의 데이터 보여줄 지.

	public Criteria()
	{
		this(1,20);
	}
	
	public Criteria(int page, int amount)
	{
		this.page = page;
		this.amount = amount;
	}

}
