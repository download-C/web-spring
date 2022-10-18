package com.itwillbs.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Inject
	SqlSession session;
	
	private static final String NAMESPACE = "com.itwillbs.mapper.BoardMapper";

	private static final Logger log = LoggerFactory.getLogger(BoardDAOImpl.class);

	@Override
	public void boardWrite(BoardVO vo) {
		log.info("DAO insertBoard(vo) 호출");
		session.insert(NAMESPACE+".insertBoard",vo);
	}
	

}
