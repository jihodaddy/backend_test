package com.boot.ohouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "member/loginForm";
	}
	@RequestMapping("/joinForm")
	public String joinForm() {
		return "member/joinForm";
	}
}
