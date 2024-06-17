package com.bs.spring.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import com.bs.spring.demo.model.dto.Demo;

public interface DemoDao {
	int insertDemo(Demo d, SqlSessionTemplate session);
	int updateDemp(SqlSession session, Demo d);
	
	List<Demo> SelectDemo(SqlSession session,Map<String,Integer> param);
	Demo selectDemoByNo(SqlSession session, int no);
	
}
