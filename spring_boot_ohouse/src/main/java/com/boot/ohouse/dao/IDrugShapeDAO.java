package com.boot.ohouse.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.boot.ohouse.model.DrugShapeVO;
import com.boot.ohouse.paging.Criteria;

public interface IDrugShapeDAO {
	public ArrayList<DrugShapeVO> drugShapeSearch(HashMap<String, Object> map);
	public ArrayList<DrugShapeVO> drugShapeListView();
	
	/* 페이징처리 */
	// 게시물 총 갯수
	public int getTotal(Criteria cri);

	// 페이징 처리 게시글 조회
	public List<DrugShapeVO> getListPaging(Criteria cri) throws Exception;
	
}
