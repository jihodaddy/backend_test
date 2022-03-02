package com.boot.ohouse.controller;



import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.ohouse.model.DrugShapeVO;
import com.boot.ohouse.paging.Criteria;
import com.boot.ohouse.paging.PageMakerDTO;
import com.boot.ohouse.service.DrugShapeService;

@Controller
@RequestMapping("/drugShape/*")
public class DrugShapeController {
	
	  private static final Logger log = LoggerFactory.getLogger(DrugShapeController.class);
	 

	
@Autowired
DrugShapeService service;
	
/*
 * @RequestMapping(value ="/shapeListView", method = RequestMethod.GET) public
 * String shapeListView(Criteria cri, Model model) throws Exception{
 * List<DrugShapeVO> shapeList = service.drugShapeListView(cri);
 * model.addAttribute("shapeList", shapeList); return
 * "drugShape/drugShapeListView"; }
 */
	
	@RequestMapping("/shapeListView")
	public String shapeListView(Model model){
		ArrayList<DrugShapeVO> shapeList = service.drugShapeListView();
		model.addAttribute("shapeList", shapeList);
		return "drugShape/drugShapeListView";
	}
	

	/* 게시판 목록 페이지 접속(페이징 적용) */
	@GetMapping("/list")
	public void boardListGET(Model model, Criteria cri) throws Exception {
		
		log.info("boardListGET");
		
		log.info("cri : " + cri);
		
		model.addAttribute("shapeList", service.getListPaging(cri));
		
		int total = service.getTotal(cri);
		
		PageMakerDTO pageMake = new PageMakerDTO(cri, total);
		
		model.addAttribute("pageMaker", pageMake);
		
	}	
}
