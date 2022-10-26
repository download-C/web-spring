package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.PageVO;

public interface BoardDAO {
	
	public void boardWrite(BoardVO vo) throws Exception;

	public List<BoardVO> getListAll() throws Exception;

	public BoardVO getBoard(Integer bno) throws Exception;

	public void updateReadcount(Integer bno) throws Exception;

	public Integer updateBoard(BoardVO vo)throws Exception;

	public Integer deleteBoard(int bno) throws Exception;
	
	public List<BoardVO> listPage(Integer page) throws Exception;
	
	public List<BoardVO> listPage(Integer page, Integer pageSize) throws Exception;
	
	public List<BoardVO> listPage(PageVO vo) throws Exception;

	public int getTotalCnt() throws Exception;

}
