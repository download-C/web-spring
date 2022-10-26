package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.PageVO;
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

	@Override
	public BoardVO getBoard(Integer bno) throws Exception {
		log.info("service - getBoard() 호출");
		
		return dao.getBoard(bno);
	}

	@Override
	public void updateReadcount(Integer bno) throws Exception {
		log.info("service - updateReadcount(bno) 호출");
		
		dao.updateReadcount(bno);
	}

	@Override
	public Integer updateBoard(BoardVO vo) throws Exception {
		log.info("updateBoard(vo) 호출");
		int result = dao.updateBoard(vo);
		return result;
	}

	@Override
	public Integer deleteBoard(int bno) throws Exception {
		log.info("deleteBoard(bno) 호출");
		return dao.deleteBoard(bno);
	}

	@Override
	public List<BoardVO> getlistPage(PageVO vo) throws Exception{
		return dao.listPage(vo);
	}

	@Override
	public int getTotlaCnt() throws Exception {
		return dao.getTotalCnt();
	}
}
