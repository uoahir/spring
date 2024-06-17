package com.bs.spring.memo.model.dto;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Memo {
	private String memoNo;
	@NotEmpty(message="내용반드시입력하세요")
	private String memo;
	@NotEmpty(message="비밀번호를 반드시 입력하세요")
	@Pattern(regexp="(?=.*[a-zA-Z])(?=.*[0-9]).{4}", message="비밀번호는 4글자로 영문자, 숫자가 반드시 포함되어야함니다.")
	private String password;
	private Date memoDate;
}
