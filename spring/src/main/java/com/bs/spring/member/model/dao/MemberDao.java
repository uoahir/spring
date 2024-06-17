package com.bs.spring.member.model.dao;


import org.mybatis.spring.SqlSessionTemplate;

import com.bs.spring.member.model.dto.Member;

public interface MemberDao {
	Member loginMember(SqlSessionTemplate session, String id);
	int signupMember(SqlSessionTemplate session, Member m);
}
