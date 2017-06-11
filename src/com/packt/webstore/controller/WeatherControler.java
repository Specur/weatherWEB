package com.packt.webstore.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
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
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import static java.nio.charset.StandardCharsets.*;

@Controller
public class WeatherControler {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mappingOnWelcome(Model model) {
		City city = new City();
		model.addAttribute("city", city);
		return "index";
	}

	@RequestMapping("/peaks")
	public String peaks(Model model) {
		model.addAttribute("greeting", "Witaj");
		return "peaks";
	}

	@RequestMapping("/weekendWeather")
	public String weekendWeatherEntry(Model model) {
		model.addAttribute("greeting", "Witaj");
		return "weekendWeather";
	}

	@RequestMapping("/authors")
	public String authors(Model model) {
		model.addAttribute("greeting", "Witaj");
		return "authors";
	}

	@RequestMapping("/smogkrakow")
	public String smogkrakow(Model model) {
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
		return "smogkrakow";
	}

	private void addAttributeToModelWelcome(Model model, Smog smog, City city) {
		model.addAttribute("Sensor1", smog.getAmountUGM3(0));
		model.addAttribute("Sensor2", smog.getAmountUGM3(1));
		model.addAttribute("Sensor3", smog.getAmountUGM3(2));
		model.addAttribute("Sensor4", smog.getAmountUGM3(3));
		model.addAttribute("Sensor5", smog.getAmountUGM3(4));
		model.addAttribute("Sensor6", smog.getAmountUGM3(5));
		model.addAttribute("city", city);

	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String catchMappingOnCity(@ModelAttribute("city") City city) {
		return "redirect:/weather/" + city.getName();
	}

	@RequestMapping(value = "/peak", method = RequestMethod.POST)
	public String greetingSubmit(Model model, @RequestParam("peakName") String peakName) throws IOException {

		byte[] peakNameNew_ = peakName.getBytes(ISO_8859_1);
		String peakNameNew = new String(peakNameNew_, UTF_8);

		// ł Ł ą ę ć ź ż ś Ś Ż Ź Ć

		// do parsowania
		String peakName3 = peakNameNew.replace(" ", "-").replace("%20", "-");
		peakName3 = org.apache.commons.lang3.StringUtils.stripAccents(peakName3);

		// do wyświetlania w widoku
		String peakNameForModel_ = peakNameNew.replace(" ", " ").replace("%20", " ").replace("%C3%B3", "ó")
				.replace("%C4%85", "ą").replace("%C4%87", "ć").replace("%C4%99", "ę").replace("%C5%82", "ł")
				.replace("%C5%84", "ń").replace("%C5%9B", "ś").replace("%C5%BA", "ź").replace("%C5%BC", "ż")
				.replace("%C4%86", "Ć").replace("%C4%84", "Ą").replace("%C4%98", "Ę").replace("%C5%81", "Ł")
				.replace("%C5%83", "Ń").replace("%C3%93", "Ó").replace("%C5%9A", "Ś").replace("%C5%B9", "Ź")
				.replace("%C5%BB", "Ż");
		String peakNameForModel = peakNameForModel_.substring(0, 1).toUpperCase() + peakNameForModel_.substring(1);
		;
		Document getURLForHeight = null;
		String noURL = null;
		try{
		getURLForHeight = Jsoup.connect("https://www.mountain-forecast.com/peaks/" + peakName3).get();
		

		Elements height = getURLForHeight.getElementsByClass("height");
		String heightt = height.get(0).text();

		Document getURLForForecast = Jsoup
				.connect("https://www.mountain-forecast.com/peaks/" + peakName3 + "/forecasts/" + heightt).get();

		Elements tempHigh = getURLForForecast.select("#forecast-cont > table > tbody > tr:nth-child(11) > td > span");
		Elements tempLow = getURLForForecast.select("#forecast-cont > table > tbody > tr:nth-child(12) > td > span");
		Elements rain = getURLForForecast.select("#forecast-cont > table > tbody > tr:nth-child(10) > td > b > span");
		Elements forecast = getURLForForecast.select("#forecast-cont > table > tbody > tr.med.summary-row > td");
		Elements getTimeOfTheDay = getURLForForecast.select("#forecast-cont > table > tbody > tr.lar.hea1 > td > span");
		List<String> weatherCalendar = calculateDay();
		List<String> dayOfWeek = calculateDayOfWeek();
		List<String> summary = new ArrayList<>();
		for (int i = 0; i < forecast.size(); i++) {
			summary.add(forecast.get(i).text());
		}
		List<String> rainList = new ArrayList<>();
		for (int i = 0; i < rain.size(); i++) {
			//rain.get(i).text().replaceAll("-", "0");
			String changed = rain.get(i).text().replace("-", "0");
			rainList.add(changed);
		}
		
		

		model.addAttribute("calendar", weatherCalendar);
		model.addAttribute("timeOfTheDay", getTimeOfTheDay);
		model.addAttribute("temph", tempHigh);
		model.addAttribute("templ", tempLow);
		model.addAttribute("rain", rainList);
		model.addAttribute("szczyt", peakNameForModel);
		model.addAttribute("forecast", summary);
		model.addAttribute("dayOfWeek", dayOfWeek);
		}catch(HttpStatusException e)
		{
			noURL = "błędna nazwa szczytu lub brak w bazie";
			model.addAttribute("noURL",noURL);
		}
		return "/peak";
	}

	@RequestMapping("/weather/{city}")
	public String mappingOnCity(Model model, @PathVariable("city") String city) {

		CollectionWeatherConditions weatherAllWebsite = new CollectionWeatherConditions();
		WeatherParser division = new WeatherParser(weatherAllWebsite);
		Elements description = null;
		URL urlWeatherOnline = null;
		URL urlPogodynka = null;

		byte[] cityNew_ = city.getBytes(ISO_8859_1);
		String cityNew = new String(cityNew_, UTF_8);

		String cityName = cityNew.replace(" ", "-").replace("%20", "-");
		cityName = org.apache.commons.lang3.StringUtils.stripAccents(cityNew);

		// do wyświetlania w widoku
		String peakNameForModel_ = city.replace(" ", " ").replace("%20", " ").replace("%C3%B3", "ó")
				.replace("%C4%85", "ą").replace("%C4%87", "ć").replace("%C4%99", "ę").replace("%C5%82", "ł")
				.replace("%C5%84", "ń").replace("%C5%9B", "ś").replace("%C5%BA", "ź").replace("%C5%BC", "ż")
				.replace("%C4%86", "Ć").replace("%C4%84", "Ą").replace("%C4%98", "Ę").replace("%C5%81", "Ł")
				.replace("%C5%83", "Ń").replace("%C3%93", "Ó").replace("%C5%9A", "Ś").replace("%C5%B9", "Ź")
				.replace("%C5%BB", "Ż");
		String peakNameForModel = peakNameForModel_.substring(0, 1).toUpperCase() + peakNameForModel_.substring(1);
		try {
			Document getURLForForecast = Jsoup.connect("http://www.pogodynka.pl/polska/" + cityName + "_" + cityName)
					.get();

			description = getURLForForecast.select("tr > td.opis > div.obrazek_after");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			urlWeatherOnline = new URL("http://www.weatheronline.pl/Polska/" + cityName);
			urlPogodynka = new URL("http://www.pogodynka.pl/polska/" + cityName + "_" + cityName);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addDescription(model, description);
		division.divisionPogodynka(urlPogodynka);
		division.divisionWeatheronline(urlWeatherOnline);

		addAttributeToModelweather(model, weatherAllWebsite, peakNameForModel);

		return "weather";
	}

	private void addAttributeToModelweather(Model model, CollectionWeatherConditions weatherAllWebsite, String city) {
		List<String> weatherCalendar = calculateDay();
		List<String> dayOfWeek = calculateDayOfWeek();
		// dane w tablach ustawione w nastepujacy sposob
		// teraz 3h 6h 9h 1d 2d 3d 4d 5d 6d 7d 8d 9d 10d 11d 12d 13d 14d 15d 16d
		model.addAttribute("calendar", weatherCalendar);
		model.addAttribute("dayOfWeek", dayOfWeek);
		model.addAttribute("pressure", weatherAllWebsite.getPressure());
		model.addAttribute("temperature", weatherAllWebsite.getTemperature());
		model.addAttribute("wind", weatherAllWebsite.getWind());
		model.addAttribute("city", city);

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

	@RequestMapping(value = "/weekend", method = RequestMethod.POST)
	public String getWeatherForWeekend(Model model, @RequestParam("city") String city) {
		CollectionWeatherConditions weatherAllWebsite = new CollectionWeatherConditions();
		WeatherParser division = new WeatherParser(weatherAllWebsite);
		URL urlPogodynka = null;
		
		byte[] cityNew_ = city.getBytes(ISO_8859_1);
		String cityNew = new String(cityNew_, UTF_8);

		String cityName = cityNew.replace(" ", "-").replace("%20", "-");
		cityName = org.apache.commons.lang3.StringUtils.stripAccents(cityNew);
		
		// do wyświetlania w widoku
		String peakNameForModel_ = cityNew.replace(" ", " ").replace("%20", " ").replace("%C3%B3", "ó")
				.replace("%C4%85", "ą").replace("%C4%87", "ć").replace("%C4%99", "ę").replace("%C5%82", "ł")
				.replace("%C5%84", "ń").replace("%C5%9B", "ś").replace("%C5%BA", "ź").replace("%C5%BC", "ż")
				.replace("%C4%86", "Ć").replace("%C4%84", "Ą").replace("%C4%98", "Ę").replace("%C5%81", "Ł")
				.replace("%C5%83", "Ń").replace("%C3%93", "Ó").replace("%C5%9A", "Ś").replace("%C5%B9", "Ź")
				.replace("%C5%BB", "Ż");
		String peakNameForModel = peakNameForModel_.substring(0, 1).toUpperCase() + peakNameForModel_.substring(1);

		try {
			urlPogodynka = new URL("http://www.pogodynka.pl/polska/" + cityName + "_" + cityName);
		} catch (MalformedURLException var7) {
			var7.printStackTrace();
		}

		division.weatherForWeekend(urlPogodynka);
		this.addAttributeToModelWeekend(model, weatherAllWebsite, peakNameForModel);
		return "weekend";
	}

	private void addAttributeToModelWeekend(Model model, CollectionWeatherConditions weatherAllWebsite, String city) {
		Map<String, LocalDate> weatherCalendar = this.daysOfTheNextWeekend();
		model.addAttribute("calendar", weatherCalendar);
		model.addAttribute("pressure", weatherAllWebsite.getPressure());
		model.addAttribute("temperature", weatherAllWebsite.getTemperature().toString());
		model.addAttribute("wind", weatherAllWebsite.getWind());
		model.addAttribute("city", city);
	}

	private Map<String, LocalDate> daysOfTheNextWeekend() {
		Map<String, LocalDate> nextWeekendDaysDate = new HashMap();
		LocalDate date = LocalDate.now();
		DayOfWeek today = date.getDayOfWeek();
		switch (today) {
		case MONDAY:
			date.plusDays(4);
			nextWeekendDaysDate.put("Piątek", date);
			date.plusDays(1);
			nextWeekendDaysDate.put("Sobota", date);
			date.plusDays(1);
			nextWeekendDaysDate.put("Niedziela", date);
			break;
		case TUESDAY:
			date.plusDays(3);
			nextWeekendDaysDate.put("Piątek", date);
			date.plusDays(1);
			nextWeekendDaysDate.put("Sobota", date);
			date.plusDays(1);
			nextWeekendDaysDate.put("Niedziela", date);
			break;
		case WEDNESDAY:
			date.plusDays(2);
			nextWeekendDaysDate.put("Piątek", date);
			date.plusDays(1);
			nextWeekendDaysDate.put("Sobota", date);
			date.plusDays(1);
			nextWeekendDaysDate.put("Niedziela", date);
			break;
		case THURSDAY:
			date.plusDays(1);
			nextWeekendDaysDate.put("Piątek", date);
			date.plusDays(1);
			nextWeekendDaysDate.put("Sobota", date);
			date.plusDays(1);
			nextWeekendDaysDate.put("Niedziela", date);
			break;
		case FRIDAY:
			nextWeekendDaysDate.put("Piątek", date);
			date.plusDays(1);
			nextWeekendDaysDate.put("Sobota", date);
			date.plusDays(1);
			nextWeekendDaysDate.put("Niedziela", date);
			break;
		case SATURDAY:
			nextWeekendDaysDate.put("Sobota", date);
			date.plusDays(1);
			nextWeekendDaysDate.put("Niedziela", date);
			break;
		case SUNDAY:
			nextWeekendDaysDate.put("Niedziela", date);
		}

		return nextWeekendDaysDate;
	}

	private void addDescription(Model model, Elements description) {

		List<String> desc = new ArrayList<>();
		desc.add(description.get(description.size() - 73).toString());
		desc.add(description.get(description.size() - 74).toString());
		desc.add(description.get(description.size() - 73).toString());
		desc.add(description.get(description.size() - 72).toString());
		desc.add(description.get(description.size() - 67).toString());
		desc.add(description.get(description.size() - 59).toString());
		desc.add(description.get(description.size() - 51).toString());
		desc.add(description.get(description.size() - 43).toString());
		desc.add(description.get(description.size() - 35).toString());
		desc.add(description.get(description.size() - 27).toString());
		desc.add(description.get(description.size() - 19).toString());
		desc.add(description.get(description.size() - 16).toString());
		desc.add(description.get(description.size() - 14).toString());
		desc.add(description.get(description.size() - 12).toString());
		desc.add(description.get(description.size() - 10).toString());
		desc.add(description.get(description.size() - 8).toString());
		desc.add(description.get(description.size() - 6).toString());
		desc.add(description.get(description.size() - 4).toString());
		desc.add(description.get(description.size() - 2).toString());
		desc.add(description.get(description.size() - 1).toString());

		model.addAttribute("description", desc);
	}

	public static boolean oneOnFour(int rok) {
		return ((rok % 4 == 0 && rok % 100 != 0) || rok % 400 == 0);
	}

	public static int dayWeak(int day, int month, int year) {

		int howManyDay[] = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 };
		int myDay;
		int yy, c, g;
		int result;
		month = 6;
		myDay = day + howManyDay[month - 1];
		if ((month > 2) && (oneOnFour(year) == true))
			myDay++;

		yy = (year - 1) % 100;
		c = (year - 1) - yy;
		g = yy + (yy / 4);
		result = (((((c / 100) % 4) * 5) + g) % 7);
		result += myDay - 1;
		result %= 7;

		return result;
	}

	private List<String> calculateDayOfWeek() {
		String[] dayList = new String[] { "poniedziałek", "wtorek", "środa", "czwartek", "piątek", "sobota",
				"niedziela" };
		List<String> weatherCalendar = new ArrayList<String>();
		Calendar calendar = Calendar.getInstance();
		for (int i = 0; i < 20; i++) {
			weatherCalendar.add(dayList[dayWeak(calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH),
					calendar.get(Calendar.YEAR))]);
			calendar.add(Calendar.DAY_OF_MONTH, 1);
		}

		return weatherCalendar;
	}

}
