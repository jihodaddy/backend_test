package com.boot.ohouse.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.boot.ohouse.model.DrugShapeVO;
import com.boot.ohouse.paging.Criteria;

public interface IDrugShapeService {
	//	낱알 옵션별 검색
	ArrayList<DrugShapeVO> drugShapeSearch(HashMap<String, Object> map);
	
	//public List<DrugShapeVO> drugShapeListView(Criteria cri) throws Exception;
	ArrayList<DrugShapeVO> drugShapeListView();
	
	// 게시물 총 갯수
	int getTotal(Criteria cri);
	//페이징
	List<DrugShapeVO> getListPaging(Criteria cri) throws Exception;
	
}
