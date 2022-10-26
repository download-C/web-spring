package com.itwillbs.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.PageVO;



@Repository
public class BoardDAOImpl implements BoardDAO{

	@Inject
	SqlSession session;
	
	private static final String NAMESPACE = "com.itwillbs.mapper.BoardMapper";

	private static final Logger log = LoggerFactory.getLogger(BoardDAOImpl.class);

	@Override
	public void boardWrite(BoardVO vo) throws Exception{
		log.info("DAO insertBoard(vo) 호출");
		session.insert(NAMESPACE+".insertBoard",vo);
	}

	@Override
	public List<BoardVO> getListAll() throws Exception{
		log.info("DAO - getListAll() 호출");
		
		List<BoardVO> boardList = session.selectList(NAMESPACE+".getListAll");
//		log.info(boardList+"");
		log.info("목록 글 개수 :"+boardList.size());
		return session.selectList(NAMESPACE+".getListAll");
	}

	@Override
	public BoardVO getBoard(Integer bno) throws Exception {
		log.info("getBoard("+bno+") 호출");
		BoardVO vo = session.selectOne(NAMESPACE+".getBoard", bno);
//		log.info(vo+"");
		
		return session.selectOne(NAMESPACE+".getBoard", bno);
	}

	@Override
	public void updateReadcount(Integer bno) throws Exception {
		log.info("updateReadcount(bno) 호출");
		
		log.info("bno: "+bno);
		
		session.update(NAMESPACE+".updateReadcount", bno);	
		log.info(bno+"번 글 조회수 1 증가");
		
	}

	@Override
	public Integer updateBoard(BoardVO vo) throws Exception {
		log.info("updateBoard(vo) 호출");
		int result = session.update(NAMESPACE+".updateBoard", vo);
		return result;
	}

	@Override
	public Integer deleteBoard(int bno) throws Exception {
		log.info("deleteBoard(bno) 호출");
		return session.delete(NAMESPACE+".deleteBoard", bno);
	}

	@Override
	public List<BoardVO> listPage(Integer page) throws Exception {
		log.info("listPage(page) 호출");
		if(page <= 0) {
			page = (page-1)*10;
		}
		return session.selectList(NAMESPACE+".listPage", page);
	}
	
	@Override
	public List<BoardVO> listPage(Integer page, Integer pageSize) throws Exception {
		log.info("listPage(page) 호출");
		if(page <= 0) page = (page-1)*30;
		
		Map<String, Object> pageObj = new HashMap<String, Object>();
		pageObj.put("page", page);
		pageObj.put("pageSize", pageSize);
		
		return session.selectList(NAMESPACE+".listPage2", pageObj);
	}

	@Override
	public List<BoardVO> listPage(PageVO vo) throws Exception {
		
		log.info("listPage(vo) 호출");
		
		return session.selectList(NAMESPACE+".listPage3", vo);
	}

	@Override
	public int getTotalCnt() throws Exception {
		return session.selectOne(NAMESPACE+".getTotalCnt");
	}

}
