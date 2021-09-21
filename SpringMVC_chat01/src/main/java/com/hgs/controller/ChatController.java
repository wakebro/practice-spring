package com.hgs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class ChatController {
	
	@GetMapping("/chat")
	public String chat(Model model) {
		
		model.addAttribute("userid", "test");
		
		return "chat";
	}
}
