package com.bs.spring.memo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bs.spring.common.PageFactory;
import com.bs.spring.memo.model.dto.Memo;
import com.bs.spring.memo.model.service.MemoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/memo")
@RequiredArgsConstructor
public class MemoController {
	
	private final MemoService service;
	private final PageFactory page;
	
	@GetMapping("/memolist.do")
	public void memoList(Model m,@RequestParam(defaultValue="1") int cPage,@RequestParam(defaultValue="5") int numPerpage, @ModelAttribute("memo") Memo mem) {
		
		List<Memo> memos = service.memoList(Map.of("cPage",cPage,"numPerpage",numPerpage));
		
		int totalData = service.selectMemoCount();
		
		m.addAttribute("pageBar",page.getPage(cPage, numPerpage, totalData, "memolist.do"));
		
		m.addAttribute("memos", memos);
	} 
	
	@GetMapping("/writememo.do")
	public void writeMemo(@ModelAttribute("memo") Memo memo,@RequestParam(defaultValue="1") int cPage,@RequestParam(defaultValue="5") int numPerpage) {}
	
//	@PostMapping("/wirtememoend.do")
//	public String writeMemoEnd(String memo, String password, Model m) {
//		int result = service.InsertMemo(memo, password);
//		if(result>0) {
//			return "redirect:/memo/memolist.do";
//		} else {
//			m.addAttribute("msg", "메모작성실패");
//			m.addAttribute("loc","/memo/writememo.do");
//			return "common/msg";
//		}	
//	}
	
	@PostMapping("/insertmemo.do")
	public String insertMemo(@ModelAttribute("memo") @Validated Memo memo, BindingResult isResult, Model m) {
		if(isResult.hasErrors()) {
			m.addAttribute("memos", service.memoList(Map.of("cPage",1,"numPerpage",5)));
			m.addAttribute("pageBar", page.getPage(1, 5, service.selectMemoCount(), "insertmemo.do"));
			return "memo/writememo";
		}
		int result = service.InsertMemo(memo);
		
		if(result>0) {
			return "redirect:/memo/memolist.do";
		} else {
			m.addAttribute("msg", "메모작성실패 :( ");
			m.addAttribute("loc","/memo/writememo.do");
			return "common/msg";
		}
		
	}
}
