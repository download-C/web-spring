package com.itwillbs.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.service.BoardService;


@Controller
@RequestMapping("/board/*") // /board로 시작하는 모든 주소는 BoardController에서 제어
public class BoardController {

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;

	
	// http://localhost:8088/controller/board/test (X) 패스 바꿈!! 
	// http://localhost:8088/board/test
	@RequestMapping(name = "/test", method = RequestMethod.GET)
	public void test() {
		log.info("test() 호출");
	}
	
	// 글쓰기 GET 글쓰기 페이지로 이동
	// http://localhost:8088/board/regist
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public void gesisterGET() throws Exception{
		log.info("*****BoardController - gesisterGET() 호출");
		log.info("/board/regist.jsp 호출");
	}
	
	// 글쓰기 POST 작성한 글 DB에 저장
	// http://localhost:8088/board/regist
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String gesisterPOST(BoardVO vo) throws Exception{
		log.info("*****BoardController - gesisterPOST() 호출");
		
		// 뷰에서 입력한 정보 받아오기 -> bno는 AutoIncreasemnet가 걸려있어서 따로 처리할 필요 X
		log.info("작성된 글: "+vo);
		
		service.boardWrite(vo);
		log.info("글쓰기 완료!");


		
//		service.
		return "/board/list";
	}
	
	// DB에서 글 정보 가져와서 view에 출력
	// http://localhost:8088/board/list
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listGET() throws Exception{
		log.info("*****BoardController - listGET() 호출");
//		service.
		return "/board/list";
	}
}
