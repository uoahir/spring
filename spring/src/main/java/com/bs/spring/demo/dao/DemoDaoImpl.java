package com.bs.spring.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.bs.spring.demo.model.dto.Demo;

@Repository
public class DemoDaoImpl implements DemoDao {

	@Override
	public int insertDemo(Demo d, SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return session.insert("demo.insertDemo", d);
	}

	@Override
	public int updateDemp(SqlSession session, Demo d) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Demo> SelectDemo(SqlSession session, Map<String, Integer> param) {
		int cPage = param.get("cPage");
		int numPerpage = param.get("numPerpage");
		RowBounds rb = new RowBounds((cPage-1)*numPerpage, numPerpage);
		return session.selectList("demo.selectlist",null,rb);
	}

	@Override
	public Demo selectDemoByNo(SqlSession session, int no) {
		// TODO Auto-generated method stub
		return null;
	}

}
