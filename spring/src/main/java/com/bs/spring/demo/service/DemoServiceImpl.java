package com.bs.spring.demo.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bs.spring.demo.dao.DemoDao;
import com.bs.spring.demo.model.dto.Demo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DemoServiceImpl implements DemoService {
	
	
	private final SqlSessionTemplate session;
	
	private final DemoDao dao;
	
	@Override
	public List<Demo> selectDemoList(Map<String, Integer> page) {
		List<Demo> result = dao.SelectDemo(session, page);
		return result;
	}

	@Override
	public Demo selectDemoByNo(int no) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Autowired
//	public DemoServiceImpl(@Qualifier("sqlSessionTemplate") SqlSessionTemplate session, DemoDao dao) {
//		super();
//		this.session = session;
//		this.dao=dao;
//	}
	
	@Override
	public int insertDemo(Demo d) {
		return dao.insertDemo(d, session);
	}

}
