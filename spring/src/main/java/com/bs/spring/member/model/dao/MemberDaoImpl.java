package com.bs.spring.member.model.dao;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.bs.spring.member.model.dto.Member;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Override
	public Member loginMember(SqlSessionTemplate session, String id) {
		
		return session.selectOne("mem.loginMember", id);
	}

	@Override
	public int signupMember(SqlSessionTemplate session, Member m) {
		// TODO Auto-generated method stub
		return session.insert("mem.signupMember",m);
	}

}
