package com.bs.spring.board.model.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.bs.spring.board.model.dao.BoardDao;
import com.bs.spring.board.model.dto.Board;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	private final SqlSessionTemplate session;
	private final BoardDao dao;
	
	@Override
	public List<Board> selectBoardList(Map<String, Integer> page) {
		
		return dao.selectBoardList(session, page);
	}

	@Override
	public Board selectBoard(int boardNo) {
		// TODO Auto-generated method stub
		return dao.selectBoard(session, boardNo);
	}

	@Override
	public int insertBoard(Board bo) {
		// TODO Auto-generated method stub
		return dao.insertBoard(session, bo);
	}

	@Override
	public int boardReadCountUp(int boardNo) {
		// TODO Auto-generated method stub
		return dao.boardReadCountUp(session, boardNo);
	}

	@Override
	public int selectBoardCount() {
		// TODO Auto-generated method stub
		return dao.selectBoardCount(session);
	}
	
	
	
	
	
	
	
	

}
