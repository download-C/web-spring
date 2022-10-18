package com.itwillbs.controller;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"} 
	)
public class DataSourceBeanTest {
	
	// 1. DB 연결 정보 객체 주입
	@Autowired
	private DataSource ds;
	@Autowired
	private SqlSessionTemplate sqlTemplate;

	private static final Logger log = LoggerFactory.getLogger(DataSourceBeanTest.class);
	
	public void sqlSessionTemplate객체확인() {
		log.info("sqlTemplate"+sqlTemplate);
	}
	
	@Test
	public void DS주입확인() {
		log.info("DB연결 : "+ds);
	}
	

}
