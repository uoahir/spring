package com.bs.spring.memo.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.bs.spring.memo.model.dto.Memo;

public interface MemoDao {
	List<Memo> memoList(SqlSessionTemplate session,Map<String,Object> page);
	int insertMemo(Memo m, SqlSessionTemplate session);
	int selectMemoCount(SqlSessionTemplate session);
}
