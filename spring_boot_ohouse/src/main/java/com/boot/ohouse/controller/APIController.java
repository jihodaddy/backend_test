package com.boot.ohouse.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boot.ohouse.service.APIService;
import com.boot.ohouse.service.DrugInfoService;
import com.boot.ohouse.service.DrugSaveService;

@Controller
public class APIController {
	@Autowired
	DrugInfoService drugService;
	@Autowired
	DrugSaveService dsaveService;
	
	
	@RequestMapping("/pubApi")
	public String publicApi() {
		System.out.println("controller in");
		try {
			APIService.main();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("controller out");
		return "publicApi";
	}

	/*
	 * @RequestMapping("/drugInfo") public String drugInfo() {
	 * System.out.println("controller in"); try { drugService.drugSearch(); } catch
	 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * System.out.println("controller out"); return "publicApi"; }
	 */
	
	/*
	 * @RequestMapping("/drugForm") public String drugForm() { return "drugView"; }
	 * 
	 * @RequestMapping("/drugSearch") public String
	 * drugSearch(@RequestParam("drugName") String drugName, Model model) { try {
	 * DrugInfoVO drugVO = drugService.drugSearch(drugName);
	 * model.addAttribute("drugVO" , drugVO); } catch (IOException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * return "drugResult"; }
	 */

	 @RequestMapping("/drugForm")
	 public String drugForm() {
		 return "drugView"; 
		 }
	
		@RequestMapping("/naver")
		public String naver() {
		return "naverApiView";
		}
	 
	 
	
	@RequestMapping("/clovaOCRForm")
	public String clovaOCRForm() {
		return "ocrView";
	}
	
	
	@RequestMapping("/drugSave")
	public void drugSave() throws IOException {
		dsaveService.drugSave();
		
	}
	
}
