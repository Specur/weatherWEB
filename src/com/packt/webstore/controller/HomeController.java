package com.packt.webstore.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//mapowanie na add 
//ten fragment jest do testow
@Controller
public class HomeController {
	   @RequestMapping("/add")   
	   public String welcome(Model model) {
		   model.addAttribute("greeting", "Witaj");
	      return "welcome";  
	      }
	   

}
