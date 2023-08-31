package com.kh.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kh.mvc.model.service.BoardService;
import com.kh.mvc.model.vo.Board;
import com.kh.mvc.model.vo.Criteria;
import com.kh.mvc.model.vo.Paging;

@Controller
@RequestMapping("/board/*")
public class BoardController
{
	@Autowired
	private BoardService service;

//	@GetMapping("/list")
//	@PostMapping("/list")
//	@PutMapping
//	@DeleteMapping

//	@RequestMapping(value="/list", method=RequestMethod.GET) //<- get
	@GetMapping("/list")
	public void list(Criteria cri, Model model)
	{
		List<Board> list = service.selectAll(cri);
		int total = service.getTotal();
		System.out.println(total);
		model.addAttribute("paging", new Paging(cri, total));

		model.addAttribute("list", list);
	}

	@GetMapping("/insert")
	public void insert()
	{

	}

	@PostMapping("/insert")
	public String insert(Board board)
	{
		System.out.println(board);
		service.insert(board);
		return "redirect:/board/list";
	}

	@GetMapping("/view")
	public void view(int no, Model model)
	{
		Board board = service.select(no);
		model.addAttribute("board", board);

	}

	@PostMapping("/update")
	public String update(Board board)
	{	
		System.out.println(board);
		
		if(board.getTitle().isEmpty())
		{
			board.setTitle(service.select(board.getNo()).getTitle());
		}
		if(board.getContent().isEmpty())
		{
			board.setContent(service.select(board.getNo()).getContent());
		}
		
		if(service.update(board) > 0)
		{
			return "redirect:/board/list";
		}
		
		return null;
	}

	@GetMapping("/delete")
	public String delete(int no)
	{
		if(service.delete(no) > 0)
		{
			return "redirect:/board/list";
		}
		
		return null;
	}

//	
//	@PutMapping
//	@DeleteMapping

}
