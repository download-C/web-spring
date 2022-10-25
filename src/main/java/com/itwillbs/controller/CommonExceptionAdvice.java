package com.itwillbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

// 컨트롤러의 역할 보조
@ControllerAdvice
public class CommonExceptionAdvice {
	

	private static final Logger log = LoggerFactory.getLogger(CommonExceptionAdvice.class);
	
	// Exception 발생 시 실행되는 메서드로 설정 
	// -> 예외별로 설정할 수 있음. 
	// @ExceptionHandler() 괄호 안에 구체적인 오류와 관련된 클래스를 넣어주면 됨.
	
//	@ExceptionHandler(NullPointerException.class)
//	public void NullPointException() {
//		log.info("NullPointExcetion 발생");
//	}

//	@ExceptionHandler(Exception.class)
//	public String commons(Exception e, Model model) {  // String 타입일 경우 특정 jsp 파일로 이동시킬 수 있음!
//							// 404에러, 500에러 등이 발생했을 때 관련 jsp 파일을 만들어두는 경우~~
//		log.info("commons()");
//		log.info(e.toString());
//		log.info(e.getMessage());
//		model.addAttribute("e", e.toString());
//		model.addAttribute("ee", e.getMessage());
//		
//		
//		return "commons";
//	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView commons(Exception e) {
		// Model 객체 대신 사용하는 리턴 타입의 객체

		ModelAndView mav = new ModelAndView();
		mav.setViewName("/commons");
		mav.addObject("e", e.getMessage());
		
		log.info("ModelAndView commons()");
		log.info(e.toString());
		log.info(e.getMessage());
				
		return mav;
	}
}
