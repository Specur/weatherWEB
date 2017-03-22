package com.packt.webstore.controller;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.RequestMapping;
import com.packt.webstore.domain. PageResults;
import com.packt.webstore.service.*;

@Controller
public class ProductControler {
	
	 @RequestMapping("/products")
	 public String list(Model model) {
		 PageResults iphone = new  PageResults(); 
		 URL url = null;
		try {
			url = new URL("http://www.weatheronline.pl/Polska/krakow");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 Download download = new Download(url,"weatheronline.txt");
		 try {
			download.readAndSave();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Division division = new Division(iphone);
		 division.divisionWeatheronline();
		 
		 Date currentDate = new Date();
		 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		 
		 
		 Calendar calendar = Calendar.getInstance();
		 dateFormat.format(calendar.getTime());
		 
		 
		 
		 String dateString = dateFormat.format(calendar.getTime());
		 calendar.add(Calendar.DAY_OF_MONTH, 1);
		 String dateString1 = dateFormat.format(calendar.getTime());
		 calendar.add(Calendar.DAY_OF_MONTH, 1);
		 String dateString2 = dateFormat.format(calendar.getTime());
		 calendar.add(Calendar.DAY_OF_MONTH, 1);
		 String dateString3 = dateFormat.format(calendar.getTime());
		 
		 model.addAttribute("dataDzis" , dateString);
		 model.addAttribute("dataDzis1" , dateString1);
		 model.addAttribute("dataDzis2" , dateString2);
		 model.addAttribute("dataDzis3" , dateString3);
		 
		 model.addAttribute("product", iphone);
		 return "products";   
	 }

}
