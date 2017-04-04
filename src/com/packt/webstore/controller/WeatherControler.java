package com.packt.webstore.controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.packt.webstore.domain.City;
import com.packt.webstore.domain.Smog;
import com.packt.webstore.domain.TemperatureFromAllWebsite;
import com.packt.webstore.service.ParsingSmog;
import com.packt.webstore.service.ParsingWeather;

@Controller
public class WeatherControler {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mappingOnWelcome(Model model) {
		Smog smog = new Smog();
		ParsingSmog parsingSmog = new ParsingSmog(smog);
		URL urlSmog = null;
		
		try {
			urlSmog = new URL("http://powietrzewkrakowie.pl");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		parsingSmog.getSmog(urlSmog);
		
		City city = new City();
		model.addAttribute("Sensor1" , smog.getAmountUGM3(0));
		model.addAttribute("Sensor2" , smog.getAmountUGM3(1));
		model.addAttribute("Sensor3" , smog.getAmountUGM3(2));
		model.addAttribute("Sensor4" , smog.getAmountUGM3(3));
		model.addAttribute("Sensor5" , smog.getAmountUGM3(4));
		model.addAttribute("Sensor6" , smog.getAmountUGM3(5));
		model.addAttribute("city", city);
		return "addProduct";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String catchMappingOnCity(@ModelAttribute("city") City city) {
		return "redirect:/weather/" + city.getName();
	}

	@RequestMapping("/weather/{city}")
	public String mappingWebsiteWithCity(Model model, @PathVariable("city") String city) {

		TemperatureFromAllWebsite weatherAllWebsite = new TemperatureFromAllWebsite();
		ParsingWeather division = new ParsingWeather(weatherAllWebsite);
		

		URL urlWeatherOnline = null;
		URL urlPogodynka = null;
		try {
			urlWeatherOnline = new URL("http://www.weatheronline.pl/Polska/" + city);
			urlPogodynka = new URL("http://www.pogodynka.pl/polska/" + city + "_" + city);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		division.divisionWeatheronline(urlWeatherOnline);
		division.divisionPogodynka(urlPogodynka);

		addAttributeToModel(model, weatherAllWebsite);

		return "weather";
	}

	private void addAttributeToModel(Model model, TemperatureFromAllWebsite weatherAllWebsite) {
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

		model.addAttribute("dataDzis", dateString);
		model.addAttribute("dataDzis1", dateString1);
		model.addAttribute("dataDzis2", dateString2);
		model.addAttribute("dataDzis3", dateString3);
		model.addAttribute("dataDzis4", dateString4);
		model.addAttribute("dataDzis5", dateString5);
		model.addAttribute("dataDzis6", dateString6);
		model.addAttribute("dataDzis7", dateString7);
		model.addAttribute("dataDzis8", dateString8);
		model.addAttribute("dataDzis9", dateString9);
		model.addAttribute("dataDzis10", dateString10);
		model.addAttribute("dataDzis11", dateString11);
		model.addAttribute("dataDzis12", dateString12);
		model.addAttribute("dataDzis13", dateString13);
		model.addAttribute("dataDzis14", dateString14);
		model.addAttribute("dataDzis15", dateString15);
		model.addAttribute("dataDzis16", dateString16);

		model.addAttribute("tempNow", weatherAllWebsite.getTempNow());
		model.addAttribute("tempToday", weatherAllWebsite.getTempToday());
		model.addAttribute("temp3h", weatherAllWebsite.getTemp3h());
		model.addAttribute("temp6h", weatherAllWebsite.getTemp6h());
		model.addAttribute("temp9h", weatherAllWebsite.getTemp9h());
		model.addAttribute("temp12h", weatherAllWebsite.getTemp12h());
		model.addAttribute("temp1d", weatherAllWebsite.getTemp1d());
		model.addAttribute("temp2d", weatherAllWebsite.getTemp2d());
		model.addAttribute("temp3d", weatherAllWebsite.getTemp3d());
		model.addAttribute("temp4d", weatherAllWebsite.getTemp4d());
		model.addAttribute("temp5d", weatherAllWebsite.getTemp5d());
		model.addAttribute("temp6d", weatherAllWebsite.getTemp6d());
		model.addAttribute("temp7d", weatherAllWebsite.getTemp7d());
		model.addAttribute("temp8d", weatherAllWebsite.getTemp8d());
		model.addAttribute("temp9d", weatherAllWebsite.getTemp9d());
		model.addAttribute("temp10d", weatherAllWebsite.getTemp10d());
		model.addAttribute("temp11d", weatherAllWebsite.getTemp11d());
		model.addAttribute("temp12d", weatherAllWebsite.getTemp12d());
		model.addAttribute("temp13d", weatherAllWebsite.getTemp13d());
		model.addAttribute("temp14d", weatherAllWebsite.getTemp14d());
		model.addAttribute("temp15d", weatherAllWebsite.getTemp15d());
		model.addAttribute("temp16d", weatherAllWebsite.getTemp16d());
	}

}
