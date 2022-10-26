package com.itwillbs.persistence;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.PageVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardDAOTest {

	private static final Logger log = LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Inject
	private BoardDAO dao;
	
//	@Test
	public void 테스트확인() {
		log.info("♡♡♡♡♡♡♡테스트 확인");
	}
	
//	@Test
	public void 페이징처리완료() throws Exception{
		log.info("♡♡♡♡♡♡♡페이징처리() 호출");
		for(BoardVO vo :dao.listPage(0)) {
			log.info(vo.getBno()+": "+vo.getTitle());
		}
	}
	
//	@Test
	public void 페이징처리완료2() throws Exception{
		log.info("♡♡♡♡♡♡♡페이징처리2() 호출");
		for(BoardVO vo :dao.listPage(5,30)) {
			log.info(vo.getBno()+": "+vo.getTitle());
		}
	}
	
//	@Test
	public void 페이징처리3() throws Exception{
		log.info("♡♡♡♡♡♡♡페이징처리3() 호출");
		PageVO vo = new PageVO();

		vo.getPageStart();
		dao.listPage(vo);
		
	}
	
}
