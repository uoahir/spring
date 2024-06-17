package com.bs.spring.memo.model.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.bs.spring.memo.model.dao.MemoDao;
import com.bs.spring.memo.model.dto.Memo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemoServiceImpl implements MemoService {
	
	private final SqlSessionTemplate session;
	private final MemoDao dao;
	
	@Override
	public List<Memo> memoList(Map<String,Object> page) {
		
		return dao.memoList(session, page);
	}

//	@Override
//	public int InsertMemo(String memo, String password) {
//		
//		return dao.insertMemo(memo, password, session);
//	}
	

	@Override
	public int selectMemoCount() {
		// TODO Auto-generated method stub
		return dao.selectMemoCount(session);
	}

	@Override
	public int InsertMemo(Memo m) {
		// TODO Auto-generated method stub
		return dao.insertMemo(m, session);
	}

}
