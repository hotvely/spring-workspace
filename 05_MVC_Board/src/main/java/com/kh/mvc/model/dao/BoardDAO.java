package com.kh.mvc.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.mvc.model.vo.Board;

@Repository
public class BoardDAO
{
	@Autowired
	private SqlSessionTemplate sqlSession;

	public int insert(Board board)
	{
		return sqlSession.insert("board.insert");
	}

	public List<Board> selectAll()
	{
		return sqlSession.selectList("board.selectAll");
	}

	public List<Board> select(String keyword)
	{
		return sqlSession.selectList("board.select", keyword);
	}

	public int update(Board board)
	{
		return sqlSession.update("board.update",board);
	}
	
	public int delete(Board board)
	{
		return sqlSession.delete("board.delete");
	}

}
