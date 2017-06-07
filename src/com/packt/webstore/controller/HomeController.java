package com.packt.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/peaks")
	public String peaks(Model model) {
		model.addAttribute("greeting", "Witaj");
		return "peaks";
	}
	
	@RequestMapping("/smogkrakow")
	public String smogkrakow(Model model) {
		model.addAttribute("greeting", "Witaj");
		return "smogkrakow";
	}

}
