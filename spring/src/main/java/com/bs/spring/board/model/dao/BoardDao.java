package com.bs.spring.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import com.bs.spring.board.model.dto.Board;

public interface BoardDao {
	List<Board> selectBoardList(SqlSessionTemplate session ,Map<String,Integer> page);
	Board selectBoard(SqlSessionTemplate session, int boardNo);
	int insertBoard(SqlSessionTemplate session, Board bo);
	int boardReadCountUp(SqlSessionTemplate session, int boardNo);
	int selectBoardCount(SqlSession session);
}
