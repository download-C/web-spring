package com.itwillbs.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BoardVO {
	private Integer bno;
	private String title;
	private String context;
	private String writer;
	private Integer readcount;
	private Timestamp regdate;
	
}
