package com.packt.webstore.controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.packt.webstore.domain.City;
import com.packt.webstore.domain.Peak;
import com.packt.webstore.domain.Smog;
import com.packt.webstore.domain.CollectionWeatherConditions;
import com.packt.webstore.service.SmogParser;
import com.packt.webstore.service.WeatherParser;
@Controller
public class WeatherControler {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mappingOnWelcome(Model model) {
		Smog smog = new Smog();
		SmogParser parsingSmog = new SmogParser(smog);
		URL urlSmog = null;
		City city = new City();
		try {
			urlSmog = new URL("http://powietrzewkrakowie.pl");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		parsingSmog.fetchDataFromPowietrzewkrakowie(urlSmog);
		addAttributeToModelWelcome(model, smog, city);
		return "addProduct";
	}

	private void addAttributeToModelWelcome(Model model, Smog smog, City city) {
		model.addAttribute("Sensor1" , smog.getAmountUGM3(0));
		model.addAttribute("Sensor2" , smog.getAmountUGM3(1));
		model.addAttribute("Sensor3" , smog.getAmountUGM3(2));
		model.addAttribute("Sensor4" , smog.getAmountUGM3(3));
		model.addAttribute("Sensor5" , smog.getAmountUGM3(4));
		model.addAttribute("Sensor6" , smog.getAmountUGM3(5));
		model.addAttribute("city", city);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String catchMappingOnCity(@ModelAttribute("city") City city) {
		return "redirect:/weather/" + city.getName();
	}
	

    @RequestMapping(value = "/peak" ,method = RequestMethod.POST)
    public String greetingSubmit(Model model ,@RequestParam("peakName") String peakName) {
    	
    	model.addAttribute("abc", "abc");
    	model.addAttribute("szczyt", peakName);
        return "/peak";
    }
    
	
	@RequestMapping("/weather/{city}")
	public String mappingOnCity(Model model, @PathVariable("city") String city) {

		CollectionWeatherConditions weatherAllWebsite = new CollectionWeatherConditions();
		WeatherParser division = new WeatherParser(weatherAllWebsite);
		

		URL urlWeatherOnline = null;
		URL urlPogodynka = null;
		
		try {
			urlWeatherOnline = new URL("http://www.weatheronline.pl/Polska/" + city);
			urlPogodynka = new URL("http://www.pogodynka.pl/polska/" + city + "_" + city);

			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		division.divisionPogodynka(urlPogodynka);
		division.divisionWeatheronline(urlWeatherOnline);

		addAttributeToModelweather(model, weatherAllWebsite);

		return "weather";
	}

	private void addAttributeToModelweather(Model model, CollectionWeatherConditions weatherAllWebsite) {
		List<String> weatherCalendar = calculateDay();
	//dane w tablach  ustawione w nastepujacy sposob
	//teraz 3h 6h 9h 1d 2d 3d 4d 5d 6d 7d 8d 9d 10d 11d 12d 13d 14d 15d 16d
        model.addAttribute("calendar" ,weatherCalendar);
	//	model.addAttribute("description", weatherAllWebsite.getDescriptionWeather());
		model.addAttribute("pressure", weatherAllWebsite.getPressure());
		model.addAttribute("temperature", weatherAllWebsite.getTemperature().toString());
		model.addAttribute("wind", weatherAllWebsite.getWind());
		
	}

	private List<String> calculateDay() {
		List<String> weatherCalendar = new ArrayList<String>();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Calendar calendar = Calendar.getInstance();
		dateFormat.format(calendar.getTime());
		weatherCalendar.add(dateFormat.format(calendar.getTime()));
		
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		weatherCalendar.add(dateFormat.format(calendar.getTime()));
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		weatherCalendar.add(dateFormat.format(calendar.getTime()));
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		weatherCalendar.add(dateFormat.format(calendar.getTime()));
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		weatherCalendar.add(dateFormat.format(calendar.getTime()));
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		weatherCalendar.add(dateFormat.format(calendar.getTime()));
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		weatherCalendar.add(dateFormat.format(calendar.getTime()));
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		weatherCalendar.add(dateFormat.format(calendar.getTime()));
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		weatherCalendar.add(dateFormat.format(calendar.getTime()));
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		weatherCalendar.add(dateFormat.format(calendar.getTime()));
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		weatherCalendar.add(dateFormat.format(calendar.getTime()));
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		weatherCalendar.add(dateFormat.format(calendar.getTime()));
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		weatherCalendar.add(dateFormat.format(calendar.getTime()));
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		weatherCalendar.add(dateFormat.format(calendar.getTime()));
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		weatherCalendar.add(dateFormat.format(calendar.getTime()));
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		weatherCalendar.add(dateFormat.format(calendar.getTime()));
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		weatherCalendar.add(dateFormat.format(calendar.getTime()));
		return weatherCalendar;
	}

}
