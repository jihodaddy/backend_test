package com.boot.ohouse.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boot.ohouse.dao.IDrugShapeDAO;
import com.boot.ohouse.model.DrugShapeVO;
import com.boot.ohouse.paging.Criteria;

@Service
public class DrugShapeService implements IDrugShapeService {
@Autowired
@Qualifier("IDrugShapeDAO")
IDrugShapeDAO dao;
	
	@Override
	public ArrayList<DrugShapeVO> drugShapeSearch(HashMap<String, Object> map) {
		return dao.drugShapeSearch(map);
	}
	/*
	 * @Override public List<DrugShapeVO> drugShapeListView(Criteria cri) throws
	 * Exception{ return dao.drugShapeListView(cri); }
	 */

	@Override
	public ArrayList<DrugShapeVO> drugShapeListView(){
		return dao.drugShapeListView();
	}
	/* 페이징 */
	@Override
	public int getTotal(Criteria cri) {
		// TODO Auto-generated method stub
		return dao.getTotal(cri);
	}
	@Override
	public List<DrugShapeVO> getListPaging(Criteria cri) throws Exception {
		return dao.getListPaging(cri);
	}

}
