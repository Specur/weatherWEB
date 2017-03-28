package com.packt.webstore.controller;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.packt.webstore.domain.City;
import com.packt.webstore.domain. PageResults;
import com.packt.webstore.domain.Temperature;
import com.packt.webstore.service.*;

@Controller
public class ProductControler {
	
	//mapowanie na stone startowa
	@RequestMapping(value = "/", method = RequestMethod.GET)
		public String getAddNewProductForm(Model model) { 
			 City city = new City();
			 model.addAttribute("city",city);
			 return "addProduct"; 
		}
		@RequestMapping(value = "/", method = RequestMethod.POST)
		public String processAddNewProductForm(@ModelAttribute("city") City city)
		{  
		
		return "redirect:/products/"+city.getName(); 
		}
		
	
	//mapowanie na strony z miastami
	 @RequestMapping("/products/{city}")
	 public String list(Model model , @PathVariable("city") String city) {
		 
		 //deklaracja obiektu PageResults do ktorego bedziemy zapisywac pogode ze wszystkich stron
		 PageResults weatherAllWebside = new  PageResults(); 
		 //Przypisujemy PageResults do naszego obiektu parsujacego storny
		 Division division = new Division(weatherAllWebside);
		 
		 URL urlWeatherOnline = null;
		 URL urlPogodynka = null;
		try {
			//Odpowiednie linki dla poszczegolnych stron
			urlWeatherOnline = new URL("http://www.weatheronline.pl/Polska/"+city);
			urlPogodynka = new URL("http://www.pogodynka.pl/polska/"+city+"_"+city);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//wysylamy linki do parsera ktory wydobywa dane i od razu zapisuje je do naszego
		//obiektu przechowujacego dane
		 division.divisionWeatheronline(urlWeatherOnline);
		 division.divisionPogodynka(urlPogodynka);
		 
		 
		 
		 
		 

		 
		 //przeslanie dni tygodnia do HTML
		 // ten fragment trzeba poprawic
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
		 calendar.add(Calendar.DAY_OF_MONTH, 1);
		 String dateString4 = dateFormat.format(calendar.getTime());
		 calendar.add(Calendar.DAY_OF_MONTH, 1);
		 String dateString5 = dateFormat.format(calendar.getTime());
		 calendar.add(Calendar.DAY_OF_MONTH, 1);
		 String dateString6 = dateFormat.format(calendar.getTime());
		 calendar.add(Calendar.DAY_OF_MONTH, 1);
		 String dateString7 = dateFormat.format(calendar.getTime());
		 calendar.add(Calendar.DAY_OF_MONTH, 1);
		 String dateString8 = dateFormat.format(calendar.getTime());
		 calendar.add(Calendar.DAY_OF_MONTH, 1);
		 String dateString9 = dateFormat.format(calendar.getTime());
		 calendar.add(Calendar.DAY_OF_MONTH, 1);
		 String dateString10 = dateFormat.format(calendar.getTime());
		 calendar.add(Calendar.DAY_OF_MONTH, 1);
		 String dateString11 = dateFormat.format(calendar.getTime());
		 calendar.add(Calendar.DAY_OF_MONTH, 1);
		 String dateString12 = dateFormat.format(calendar.getTime());
		 calendar.add(Calendar.DAY_OF_MONTH, 1);
		 String dateString13 = dateFormat.format(calendar.getTime());
		 calendar.add(Calendar.DAY_OF_MONTH, 1);
		 String dateString14 = dateFormat.format(calendar.getTime());
		 calendar.add(Calendar.DAY_OF_MONTH, 1);
		 String dateString15 = dateFormat.format(calendar.getTime());
		 calendar.add(Calendar.DAY_OF_MONTH, 1);
		 String dateString16 = dateFormat.format(calendar.getTime());
		 
		 //wyslanie obiektow do modelu
		 //ten fragment trzeba poprawwic
		 model.addAttribute("dataDzis" , dateString);
		 model.addAttribute("dataDzis1" , dateString1);
		 model.addAttribute("dataDzis2" , dateString2);
		 model.addAttribute("dataDzis3" , dateString3);
		 model.addAttribute("dataDzis4" , dateString4);
		 model.addAttribute("dataDzis5" , dateString5);
		 model.addAttribute("dataDzis6" , dateString6);
		 model.addAttribute("dataDzis7" , dateString7);
		 model.addAttribute("dataDzis8" , dateString8);
		 model.addAttribute("dataDzis9" , dateString9);
		 model.addAttribute("dataDzis10" , dateString10);
		 model.addAttribute("dataDzis11" , dateString11);
		 model.addAttribute("dataDzis12" , dateString12);
		 model.addAttribute("dataDzis13" , dateString13);
		 model.addAttribute("dataDzis14" , dateString14);
		 model.addAttribute("dataDzis15" , dateString15);
		 model.addAttribute("dataDzis16" , dateString16);
		 
		 model.addAttribute("tempNow", weatherAllWebside.getTempNow());
		 model.addAttribute("tempToday", weatherAllWebside.getTempToday());
		 model.addAttribute("temp3h", weatherAllWebside.getTemp3h());
		 model.addAttribute("temp6h", weatherAllWebside.getTemp6h());
		 model.addAttribute("temp9h", weatherAllWebside.getTemp9h());
		 model.addAttribute("temp12h", weatherAllWebside.getTemp12h());
		 model.addAttribute("temp1d", weatherAllWebside.getTemp1d());
		 model.addAttribute("temp2d", weatherAllWebside.getTemp2d());
		 model.addAttribute("temp3d", weatherAllWebside.getTemp3d());
		 model.addAttribute("temp4d", weatherAllWebside.getTemp4d());
		 model.addAttribute("temp5d", weatherAllWebside.getTemp5d());
		 model.addAttribute("temp6d", weatherAllWebside.getTemp6d());
		 model.addAttribute("temp7d", weatherAllWebside.getTemp7d());
		 model.addAttribute("temp8d", weatherAllWebside.getTemp8d());
		 model.addAttribute("temp9d", weatherAllWebside.getTemp9d());
		 model.addAttribute("temp10d", weatherAllWebside.getTemp10d());
		 model.addAttribute("temp11d", weatherAllWebside.getTemp11d());
		 model.addAttribute("temp12d", weatherAllWebside.getTemp12d());
		 model.addAttribute("temp13d", weatherAllWebside.getTemp13d());
		 model.addAttribute("temp14d", weatherAllWebside.getTemp14d());
		 model.addAttribute("temp15d", weatherAllWebside.getTemp15d());
		 model.addAttribute("temp16d", weatherAllWebside.getTemp16d());
		
		 return "products";   
	 }
	 
	 
	 

}
