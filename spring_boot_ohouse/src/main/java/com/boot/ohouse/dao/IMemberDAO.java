package com.boot.ohouse.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.boot.ohouse.model.MemberVO;

public interface IMemberDAO {
	ArrayList<MemberVO> listAllMember();	//회원정보 조회
	void insertMember(MemberVO vo);	// 회원정보 등록
	void updateMember(MemberVO vo);		//회원정보 수정
	void deleteMember(String memId);		//회원정보 삭제
	MemberVO detailViewMember(String memId);		//회원 상세정보
	
	MemberVO loginCheck(HashMap<String, Object>map);	//로그인 체크
	String memIdCheck(String memId);		//아이디 중복확인
	ArrayList<MemberVO> memIdSearch(HashMap<String, Object> map);	//회원정보 검색
}
