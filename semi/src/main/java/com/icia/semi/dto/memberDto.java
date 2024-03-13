package com.icia.semi.dto;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Alias("member")
public class memberDto {
	private int id;
	private String m_id; // 아이디
	private String m_pass; // 비밀번호
	private String m_name; // 이름
	private String m_birth; // 생년월일
	
}
