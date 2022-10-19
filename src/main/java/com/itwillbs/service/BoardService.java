package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardVO;

public interface BoardService {
	
	public void boardWrite(BoardVO vo) throws Exception;

	public List<BoardVO> getListAll() throws Exception;

}
