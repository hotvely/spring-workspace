package com.kh.mvc;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.mvc.model.vo.Board;
import com.kh.mvc.model.vo.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MyBatisUnitTest
{
	public SqlSession getSession()
	{
		Reader r;
		try
		{
			r = Resources.getResourceAsReader("mybatis-config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);

			return factory.openSession();

		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

//	@Test
//	public void insertTest()
//	{
//		SqlSession session = getSession();
//
//		Board board = new Board();
//		board.setTitle("테스트 001");
//		board.setContent("테스트 게시물 01");
//		board.setWriter("사용자01");
//		System.out.println("db before :: " + board.getNo());
//
//		int result = session.insert("board.insert", board);
//		if (result > 0)
//		{
//			System.out.println(result + "개의 게시글을 추가완료 !");
//			session.commit();
//		}
//
//		System.out.println("db after :: " + board.getNo());
//		System.out.println("------------------------------------------------------------------");
//	}
//
//	@Test
//	public void selectAllTest()
//	{
//		SqlSession session = getSession();
//		Criteria cri = new Criteria();
//		List<Board> list = session.selectList("board.selectAll", cri);
//
//		System.out.println(list);
//		System.out.println(list.size());
//		System.out.println("-------selectAllTest-----------------------------------------------------------");
//
//	}

//	@Test
//	public void selectTest()
//	{
//		SqlSession session = getSession();
//		Board board = session.selectOne("board.select", 451);
//		System.out.println(board);
//		System.out.println("-------selectTest-----------------------------------------------------------");
//	}

	@Test
	public void updateTest()
	{
		SqlSession session = getSession();
		Board board = new Board();
		board.setNo(2);
		board.setTitle("테스트 수정!");
		board.setContent("테스트에서 수정테스트중!!");
		int result = session.update("board.update", board);
		if (result > 0)
		{
			System.out.println(result + "개 수정함 ㅎㅎ");
		}
		System.out.println("----------updateTest--------------------------------------------------------");
	}

//	@Test
//	public void deleteTest()
//	{
//		SqlSession session = getSession();
//		int result = session.delete("board.delete", 25);
//		if (result > 0)
//		{
//			System.out.println(result + "개 삭제완료 ~");
//		}
//		System.out.println("----------deleteTest--------------------------------------------------------");
//	}

}
