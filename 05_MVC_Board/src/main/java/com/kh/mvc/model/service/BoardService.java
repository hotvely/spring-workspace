package com.kh.mvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mvc.model.dao.BoardDAO;
import com.kh.mvc.model.vo.Board;
import com.kh.mvc.model.vo.Criteria;

@Service
public class BoardService
{
	@Autowired
	private BoardDAO dao;

	public int insert(Board board)
	{
		return dao.insert(board);
	}

	public List<Board> selectAll(Criteria cri)
	{
		return dao.selectAll(cri);
	}

	public Board select(int no)
	{
		return dao.select(no);
	}

	public int getTotal()
	{
		return dao.getTotal();
	}

	public int update(Board board)
	{
		return dao.update(board);
	}

	public int delete(int no)
	{
		return dao.delete(no);
	}

}
