package com.boot.ohouse.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.boot.ohouse.service.DrugInfoService;
import com.boot.ohouse.service.OCRService;
import com.boot.ohouse.service.naverSearchService;

@RestController
public class APIRestController {
	@Autowired
	OCRService ocrService;
	@Autowired
	DrugInfoService drugService;
	@Autowired
	naverSearchService naverService;
	
	// OCR 요청 받아서 서비스 호출하고 결과 받아서 반환
			@RequestMapping("/clovaOCR")
			public String  faceRecogCel(@RequestParam("uploadFile") MultipartFile file) {		
				String result = "";
				
				try {
					// 1. 파일 저장 경로 설정 : 실제 서비스되는 위치 (프로젝트 외부에 저장)
					String uploadPath = "C:/upload/";
					
					// 2. 원본 파일 이름 알아오기
					String originalFileName = file.getOriginalFilename();
					String filePathName = uploadPath + originalFileName;
					
					// 3. 파일 생성
					File file1 = new File(filePathName);
					
					// 4. 서버로 전송
					file.transferTo(file1);				
					
					// 서비스에 파일 path와 파일명 전달  -> 서비스 메소드에서 변경
					// 서비스에서 반환된 텍스트를 result에 저장
					result = ocrService.clovaOCRService(filePathName);
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return result;
			}
		
			@RequestMapping("/drugInfo")
			public String drugInfo(@RequestParam("drugName") String drugName) throws IOException {
				String result="";
				
				result = drugService.drugSearch(drugName);
				
				return result; 
				}
			
			@RequestMapping("/naverSearch")
			public String naverSearch(@RequestParam("drugName") String drugName) throws IOException {
				String result="";
				
				result = naverService.naverSearch(drugName);
				
				return result; 
			}
		
}
