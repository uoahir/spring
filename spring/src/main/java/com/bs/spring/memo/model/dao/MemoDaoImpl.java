package com.bs.spring.memo.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.bs.spring.memo.model.dto.Memo;

@Repository
public class MemoDaoImpl implements MemoDao {

	
	@Override
	public List<Memo> memoList(SqlSessionTemplate session,Map<String,Object> page) {
		// TODO Auto-generated method stub
		int cPage= (Integer)page.get("cPage");
		int numPerpage= (Integer)page.get("numPerpage");
		RowBounds rb = new RowBounds((cPage-1)*numPerpage,numPerpage);
		return session.selectList("memo.memolist",null,rb);
	}

	@Override
	public int selectMemoCount(SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return session.selectOne("memo.selectMemoCount");
	}

	@Override
	public int insertMemo(Memo m, SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return session.insert("memo.insertmemo",m);
	}

//	@Override
//	public int insertMemo(String memo, String password, SqlSessionTemplate session) {
//		Map<String,Object> param = new HashMap<>();
//		param.put("memo", memo);
//		param.put("password", password);
//		return session.insert("memo.insertmemo",param);
//	}

}
