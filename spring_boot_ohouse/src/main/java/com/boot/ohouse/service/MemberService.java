package com.boot.ohouse.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boot.ohouse.dao.IMemberDAO;
import com.boot.ohouse.model.MemberVO;

@Service
public class MemberService implements IMemberService {
@Autowired
@Qualifier("IMemberDAO")
IMemberDAO dao;
	
	@Override
	public ArrayList<MemberVO> listAllMember() {
		// TODO Auto-generated method stub
		return dao.listAllMember();
	}

	@Override
	public void insertMember(MemberVO vo) {
		// TODO Auto-generated method stub
		dao.insertMember(vo);
	}

	@Override
	public void updateMember(MemberVO vo) {
		// TODO Auto-generated method stub
		dao.updateMember(vo);
	}

	@Override
	public void deleteMember(String memId) {
		// TODO Auto-generated method stub
		dao.deleteMember(memId);
	}

	@Override
	public MemberVO detailViewMember(String memId) {
		// TODO Auto-generated method stub
		return dao.detailViewMember(memId);
	}

	@Override
	public MemberVO loginCheck(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.loginCheck(map);
	}

	@Override
	public String memIdCheck(String memId) {
		// TODO Auto-generated method stub
		return dao.memIdCheck(memId);
	}

	@Override
	public ArrayList<MemberVO> memIdSearch(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.memIdSearch(map);
	}

}
