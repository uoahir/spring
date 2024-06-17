package com.bs.spring.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.bs.spring.board.model.dto.Board;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Override
	public List<Board> selectBoardList(SqlSessionTemplate session, Map<String, Integer> page) {
		int cPage = page.get("cPage");
		int numPerpage = page.get("numPerpage");
		RowBounds rb = new RowBounds((cPage-1)*numPerpage, numPerpage);
		return session.selectList("bo.selectboardlist", null, rb);
	}

	@Override
	public Board selectBoard(SqlSessionTemplate session, int boardNo) {
		
		return session.selectOne("bo.selectboard", boardNo);
	}

	@Override
	public int insertBoard(SqlSessionTemplate session, Board bo) {
		// TODO Auto-generated method stub
		return session.insert("bo.insertboard",bo);
	}

	@Override
	public int boardReadCountUp(SqlSessionTemplate session, int boardNo) {
		// TODO Auto-generated method stub
		return session.update("bo.boardreadcountup", boardNo);
	}

	@Override
	public int selectBoardCount(SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectList("bo.selectboardcount").size();
	}
	
	
	
	
	
	
}
