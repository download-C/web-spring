package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.PageVO;

public interface BoardService {

	public void boardWrite(BoardVO vo) throws Exception;

	public List<BoardVO> getListAll() throws Exception;

	public BoardVO getBoard(Integer bno) throws Exception;

	public void updateReadcount(Integer bno) throws Exception;

	public Integer updateBoard(BoardVO vo) throws Exception;

	public Integer deleteBoard(int bno) throws Exception;

	public List<BoardVO> getlistPage(PageVO vo) throws Exception;

	public int getTotlaCnt() throws Exception; 

}
