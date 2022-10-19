package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{
	
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Inject
	private BoardDAO dao;
	
	@Override
	public void boardWrite(BoardVO vo) throws Exception{
		dao.boardWrite(vo);
	}

	@Override
	public List<BoardVO> getListAll() throws Exception{
		log.info("service - getListAll() 호출");
		return dao.getListAll();
	}



}
