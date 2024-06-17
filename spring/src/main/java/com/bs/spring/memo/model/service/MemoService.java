package com.bs.spring.memo.model.service;

import java.util.List;
import java.util.Map;

import com.bs.spring.memo.model.dto.Memo;

public interface MemoService {
	List<Memo> memoList(Map<String,Object> page);
//	int InsertMemo(String memo, String password);
	int InsertMemo(Memo m);
	int selectMemoCount();
}
