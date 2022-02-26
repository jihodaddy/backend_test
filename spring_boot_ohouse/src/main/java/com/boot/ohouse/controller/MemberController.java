package com.boot.ohouse.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boot.ohouse.model.MemberVO;
import com.boot.ohouse.service.MemberService;

@Controller
public class MemberController {
@Autowired
MemberService service;
	
	//회원가입
	@RequestMapping("/insertMember")
	public String joinMember(MemberVO vo) {
		service.insertMember(vo);
		return "index";
	}
	// 멤버조회
	@RequestMapping("/listAllMember")
	public String listAllMember(Model model) {
		ArrayList<MemberVO> memList = service.listAllMember();
		model.addAttribute("memList" , memList);
		return "member/memberListView";
	}
	// 로그인 처리
	@RequestMapping("/login") //ajax
	public String loginCheck(@RequestParam HashMap<String, Object>map,
											HttpSession session) {
		System.out.println("controller");
		MemberVO vo = service.loginCheck(map);
		String result="fail";
				System.out.println(vo.getMemId());
		if(vo != null) {
			session.setAttribute("sid" , vo.getMemId());
			result = "success";
		}
		System.out.println(result);
		return result;
		
	}
	
	//로그아웃
		@RequestMapping("/logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "redirect:/";
		}
		
		
}
