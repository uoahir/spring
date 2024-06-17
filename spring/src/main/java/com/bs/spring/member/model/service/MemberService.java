package com.bs.spring.member.model.service;

import com.bs.spring.member.model.dto.Member;

public interface MemberService {
	Member loginMember(String id, String pw); 
	Member searchMemberById(String id);
	int signupMember(Member m);
}
