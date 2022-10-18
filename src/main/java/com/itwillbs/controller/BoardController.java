package com.itwillbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board/*") // /board로 시작하는 모든 주소는 BoardController에서 제어
public class BoardController {

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	
//	// http://localhost:8088/controller/board/test (X) 패스 바꿈!! 
//	// http://localhost:8088/board/test
//	@RequestMapping(name = "/test", method = RequestMethod.GET)
//	public void test() {
//		log.info("test() 호출");
//	}
	
	// 글쓰기 GET 글쓰기 페이지로 이동
	// http://localhost:8088/board/regist
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public void gesisterGET() throws Exception{
		log.info("*****BoardController - gesisterGET() 호출");
		log.info("/board/regist.jsp 호출");
	}
	
	// 글쓰기 POST 작성한 글 DB에 저장
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String gesisterPOST() throws Exception{
		log.info("*****BoardController - gesisterPOST() 호출");
		
		return "/board/list";
	}
}
