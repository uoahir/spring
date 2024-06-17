package com.bs.spring.board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bs.spring.board.model.dto.Board;
import com.bs.spring.board.model.service.BoardService;
import com.bs.spring.common.PageFactory;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService service;
	private final PageFactory page;
	
	@GetMapping("/boardlist.do")
	public void boardList(@RequestParam(defaultValue="1") int cPage, @RequestParam(defaultValue = "10") int numPerpage, Model m){
		List<Board> boards = service.selectBoardList(Map.of("cPage", cPage, "numPerpage", numPerpage));
	
		
		int totalData = service.selectBoardCount();
		
		m.addAttribute("pageBar",page.getPage(cPage, numPerpage, totalData, "boardlist.do"));
		
		m.addAttribute("boards", boards);
	}
	
	@GetMapping("/boarddetail.do")
	public void boardDetail(int boardNo, Model m) {
		int result = service.boardReadCountUp(boardNo); // update
		Board board = service.selectBoard(boardNo); // select one -> detail 화면에 들어가기
		m.addAttribute("board", board);
		if(result>0) {
		
		}
	}
	
//	@GetMapping("/boardwrite.do")
//	public void boardWrite() {}
	
	@PostMapping("/insertboard.do")
	public String insertBoard(Board bo,Model m) {
		int result = service.insertBoard(bo);
		if(result>0) {
			return "redirect:/board/boardlist.do";
		} else {
			m.addAttribute("msg", "입력실패");
			m.addAttribute("loc","/board/boardwrite.do");
			return "common/msg";
		}
	}
	
	
	
	
	
}
