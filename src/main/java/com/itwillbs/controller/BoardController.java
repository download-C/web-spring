package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String gesisterPOST(BoardVO vo, RedirectAttributes rttr /*Model model*/) throws Exception{
		log.info("*****BoardController - gesisterPOST() 호출");
		
		// 뷰에서 입력한 정보 받아오기 -> bno는 AutoIncreasemnet가 걸려있어서 따로 처리할 필요 X
		log.info("작성된 글: "+vo);
		
		service.boardWrite(vo);
//		model.addAttribute("msg", "OK");
		rttr.addFlashAttribute("msg", "OK"); // 한 번만 써지고 사라짐.
		log.info("글쓰기 완료!");
		
		return "redirect:/board/listAll";
	}
	
	// DB에서 글 정보 가져와서 view에 출력
	// http://localhost:8088/board/listAll
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public String listAllGET(@ModelAttribute("msg") String msg, 
			Model model, HttpSession session) throws Exception{
		log.info("*****BoardController - listAllGET() 호출");
		log.info("msg: "+msg);
		
		// 글 전체 목록 가져오기
		List<BoardVO> boardList = service.getListAll();
		log.info(boardList+"");
		model.addAttribute("boardList", boardList);
		session.setAttribute("isUpdate", false);
		
		// 세션 객체에 isUpdate 정보 전달해서 한 번 읽은 글은 조회수 업데이트 X
		
		
		return "/board/listAll";
	}
	
	// http://localhost:8088/board/content?bno=3
	@RequestMapping(value = "/content", method = RequestMethod.GET)
	public void contentGET(@RequestParam("bno") int bno, 
			Model model, HttpSession session) throws Exception {
		log.info("controller - readGET() 호출");
		log.info("bno : "+bno);
		
		BoardVO vo = service.getBoard(bno);
		model.addAttribute("vo", vo);
		
		// isUpdate 변수에 따라 컨텐츠 페이지에서 새로고침 시 조회수 업데이트 제어하기
		boolean isUpdate = (boolean)session.getAttribute("isUpdate");
//		log.info("isUpdate: "+isUpdate);	
		if(!isUpdate) {

			service.updateReadcount(bno);
			// 조회수 1 올린 뒤 true로 바꾸고 세션값으로 저장해서 앞으로 조회수 X 
			session.setAttribute("isUpdate", true);
			log.info("isUpdate: "+isUpdate);
		} else {
			log.info("isUpdate가 true이므로 이미 읽은 글입니다. 조회수가 올라가지 않습니다.");
		}
		log.info("/board/content -> content.jsp");
	}
	
	@RequestMapping(value="/modify", method = RequestMethod.GET)
	public void modifyGET(/* @RequestParam("bno") */int bno, Model model) throws Exception{
		log.info("modifyGET() 실행");
	
		// bno로 해당 게시글 정보 가져오기
		BoardVO vo = service.getBoard(bno);
		log.info(bno+"번 글 정보 :"+vo);
		// 가져온 정보 view로 보내기
		model.addAttribute("vo", vo);
		
		log.info("/modify -> board/modify.jsp로 이동");
	}
	
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public String modifyPOST(int bno, HttpServletRequest request) throws Exception{
		log.info("modifyPOST(bno) 호출");
		
		// 해당 글의 기존 정보 가져온 뒤 수정할 수 있는 제목과 내용만 받아서 덮어쓰기
		BoardVO vo = service.getBoard(bno);
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		vo.setTitle(title);
		vo.setContent(content);
		
		// 수정된 정보 업데이트
		int result = service.updateBoard(vo);
		// 수정 성공 시 목록으로 이동
		if(result == 1) return "redirect:/board/listAll";
		// 수정 실패 시 해당 게시글 수정 페이지로 이동
		else {
//			new NullPointerException();
			return "/board/modify?bno="+bno;
		}
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public void deleteGET(int bno) throws Exception {
		log.info("deleteGET(bno) 호출");
		
		service.deleteBoard(bno);
		
	}
}
