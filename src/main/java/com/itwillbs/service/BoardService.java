package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardVO;

public interface BoardService {

	public void boardWrite(BoardVO vo) throws Exception;

	public List<BoardVO> getListAll() throws Exception;

	public BoardVO getBoard(Integer bno) throws Exception;

	public void updateReadcount(Integer bno) throws Exception;

	public Integer updateBoard(BoardVO vo) throws Exception;

	public void deleteBoard(int bno) throws Exception; 

}
