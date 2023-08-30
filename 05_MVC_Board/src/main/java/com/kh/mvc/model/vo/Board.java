package com.kh.mvc.model.vo;

import java.sql.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board
{
	private int no;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
}
