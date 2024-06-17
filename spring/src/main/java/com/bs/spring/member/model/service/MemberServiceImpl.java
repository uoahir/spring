package com.bs.spring.member.model.service;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bs.spring.member.model.dao.MemberDao;
import com.bs.spring.member.model.dto.Member;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

	private final SqlSessionTemplate session;
	private final MemberDao dao;
	private final BCryptPasswordEncoder pwencoder;
		
	@Override
	public Member loginMember(String id, String pw) {
		Member m = dao.loginMember(session, id);
		if(m == null || !pwencoder.matches(pw, m.getPassword())) {
			m=null;
		}
		
		return m;
	}

	
	
	@Override
	public int signupMember(Member m) {
		// DML -> 트랜젝션처리 autocommit 해줌 ~ 
		return dao.signupMember(session, m);
	}



	@Override
	public Member searchMemberById(String id) {
		Member m = dao.loginMember(session, id);
		return m;
	}
	
	
	
}
