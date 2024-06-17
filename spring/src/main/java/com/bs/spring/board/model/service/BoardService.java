package com.bs.spring.board.model.service;

import java.util.List;
import java.util.Map;

import com.bs.spring.board.model.dto.Board;

public interface BoardService {
	List<Board> selectBoardList(Map<String,Integer> page);
	Board selectBoard(int boardNo);
	int insertBoard(Board bo);
	int boardReadCountUp(int boardNo);
	int selectBoardCount();
}
