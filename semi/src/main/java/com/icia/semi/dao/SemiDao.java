package com.icia.semi.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.icia.semi.dto.SemiDto;
import com.icia.semi.dto.memberDto;

public interface SemiDao {
	// 게시글 목록 가져오기
	List<SemiDto> getContentList(Map<String, Integer> pMap);

	// 전체 게시글 개수 구하기
	@Select("SELECT count(*) FROM content_tbl")
	int cntContent();

	// 게시글 정보 입력
	void insertContent(SemiDto content);

	// 게시글 정보 상세 보기
	SemiDto selectContent(Integer c_id);

	// 게시글 정보 수정
	void updateContent(SemiDto content);

	// 게시글 정보 삭제
	void deleteContent(Integer c_id);

	// 로그인 화면 구성
	static Map<String, String> users = new HashMap<>();

	memberDto login(memberDto member); 
	// 회원가입
	int checkDuplicateId(String m_id);
	
	void insertMember(memberDto member);

	
}

