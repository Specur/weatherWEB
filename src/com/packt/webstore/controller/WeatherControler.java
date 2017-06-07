package com.packt.webstore.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.Normalizer;
import java.text.Normalizer.Form;
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

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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
		model.addAttribute("Sensor1" ,0);
		model.addAttribute("Sensor2" ,0);
		model.addAttribute("Sensor3" ,0);
		model.addAttribute("Sensor4" ,0);
		model.addAttribute("Sensor5" ,0);
		model.addAttribute("Sensor6" ,0);
		model.addAttribute("city", city);
		
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String catchMappingOnCity(@ModelAttribute("city") City city) {
		return "redirect:/weather/" + city.getName();
	}
	

    @RequestMapping(value = "/peak" ,method = RequestMethod.POST)
    public String greetingSubmit(Model model ,@RequestParam("peakName") String peakName) throws IOException {
    	
    	//bez polskich znaków
    	//String peakName2  = peakName;
    	//peakName2 = peakName2.replaceAll(" ","-");
    	//peakName2 = peakName2.replace("ł", "l");
    	String peakName2 = peakName.replace("&#322;","l").replace("&#261;", "a").replace("&#281;", "e").replace("&#324;", "n").replace("&#263;", "c").replace("&#378;", "z").replace("&#380;", "z").replace("&#347;", "s").replace(" ","-");
    	peakName2 = org.apache.commons.lang3.StringUtils.stripAccents(peakName2);

    	//peakName2 = StringUtils.stripAccents(peakName2);
   
    	Document getURLForHeight = Jsoup.connect("https://www.mountain-forecast.com/peaks/"+peakName2).get();
    	//Elements newsHeadlines = doc.select("//*[@id='tabs']/tbody/tr/td[2]/ul/li/a/span[1]");
    	
    	Elements height = getURLForHeight.getElementsByClass("height");
    	String heightt = height.get(0).text();
    	
    	Document getURLForForecast = Jsoup.connect("https://www.mountain-forecast.com/peaks/"+peakName2+"/forecasts/"+heightt).get();
    	
    	Elements tempHigh = getURLForForecast.select("#forecast-cont > table > tbody > tr:nth-child(11) > td > span");
    	Elements tempLow = getURLForForecast.select("#forecast-cont > table > tbody > tr:nth-child(12) > td > span");
    	Elements rain = getURLForForecast.select("#forecast-cont > table > tbody > tr:nth-child(10) > td > b > span");

//    	temp
    	Elements getTimeOfTheDay = getURLForForecast.select("#forecast-cont > table > tbody > tr.lar.hea1 > td > span");
    	
    	
    	List<String> weatherCalendar = calculateDay();
    	
    	
    	
    	model.addAttribute("calendar" ,weatherCalendar);
    	model.addAttribute("timeOfTheDay", getTimeOfTheDay);
    	model.addAttribute("temph", tempHigh);
    	model.addAttribute("templ", tempLow);
    	model.addAttribute("rain", rain);
    	model.addAttribute("szczyt", peakName);
        return "/peak";
    }
    
//    public static String stripAccents(String s) 
//    {
    	
//    	org.apache.commons.lang3.StringEscapeUtils.escapeJava(s);
//        s = Normalizer.normalize(s, Normalizer.Form.NFD);
//        //s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
//        s = s.replaceAll("[^\\p{ASCII}]", "");
    	//return Normalizer.normalize(s,Form.NFKD).replaceAll("‌​\\p{M}", "").replaceAll(" ", "_").replaceAll("ł", "l");
        //return s;
//    }
    
	
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
