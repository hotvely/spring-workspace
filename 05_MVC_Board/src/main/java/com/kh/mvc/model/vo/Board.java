package com.kh.mvc.model.vo;

import java.sql.*;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board
{
	private int num;
	private int no;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	
	// 파일 업로드에 해당하는 데이터 타입.
	private MultipartFile uploadFile;
	private String url;
}
