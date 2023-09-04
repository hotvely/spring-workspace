package com.kh.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.mvc.model.service.BoardService;
import com.kh.mvc.model.vo.Board;
import com.kh.mvc.model.vo.Criteria;
import com.kh.mvc.model.vo.Paging;

@RequestMapping("/board/*")
@Controller
public class BoardController
{

	String path = "D:\\GitHub\\spring-workspace\\05_MVC_Board\\src\\main\\webapp\\upload\\";

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
		service.insert(board);
		return "redirect:/board/list";
	}

	@GetMapping("/view")
	public void view(int no, Model model)
	{
		Board board = service.select(no);
		model.addAttribute("board", board);

	}

	@GetMapping("/update")
	public void update(int no, Model model)
	{
		model.addAttribute("board", service.select(no));
	}

	@PostMapping("/update")
	public String update(Board board) throws IllegalStateException, IOException
	{
		MultipartFile file = board.getUploadFile();

		ChangeImg(board, file);

		if (board.getTitle().isEmpty())
		{
			board.setTitle(service.select(board.getNo()).getTitle());
		}
		if (board.getContent().isEmpty())
		{
			board.setContent(service.select(board.getNo()).getContent());
		}

		service.update(board);
		return "redirect:/board/list";

	}

	@RequestMapping("/download")
	public ModelAndView downloadFile(String filename)
	{
		HashMap map = new HashMap();
		map.put("path", path);
		
		return new ModelAndView("downloadView", map);
	}

	@GetMapping("/delete")
	public String delete(int no)
	{
		if (service.delete(no) > 0)
		{
			return "redirect:/board/list";
		}

		return null;
	}

//	
//	@PutMapping
//	@DeleteMapping

	public void ChangeImg(Board board, MultipartFile file) throws IllegalStateException, IOException
	{
		// DB에 저장되어 있는 URL이 남아 있을때... 우선 적으로 변경하려고 하는 file유무에 상관없이 삭제한후
		// board에 uploadFile을 바까준다(있으면 value넣고 파일 없으면 null값으로..)
		if (board.getUrl() != null)
		{
			File remove_file = new File(path + board.getUrl().replace("/upload/", ""));
			if (remove_file.delete())
			{
				board.setUploadFile(file);
			}
		}

		if (!file.isEmpty()) // 업로드할 파일이 존재하면... url항상 바꿔주면 됨, 같은 파일이든 다른 파일이든.
		{
			// 중복 방지를 위한 UUID적용...
			UUID uuid = UUID.randomUUID();
			String filename = uuid.toString() + "_" + file.getOriginalFilename();
			System.out.println(filename);
			File copyFile = new File(path + filename);

			file.transferTo(copyFile); // 업로드한 파일이 저장한 path 위치로 저장

			// DB에 path경로 저장 해야함;
			board.setUrl("/upload/" + filename);
		}
		else // 업로드할 파일이 존재하지 않으면 그냥 db url도 null로 밀어버리자.
		{
			board.setUrl(null);
		}
	}

}
