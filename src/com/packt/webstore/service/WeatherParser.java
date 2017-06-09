package com.packt.webstore.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;


import com.packt.webstore.domain.Temperature;
import com.packt.webstore.domain.CollectionWeatherConditions;

//WEATHERONLINE INDEX 0
//POGODYNKA INDEX 1
public class WeatherParser {
	private CollectionWeatherConditions pageResults;

	private List<Temperature> Temperature = new ArrayList<Temperature>();
	private List<String> wind = new ArrayList<String>();
	private List<String> pressure = new ArrayList<String>();
//	private List<String> descriptionWeather = new ArrayList<String>();

	public WeatherParser(CollectionWeatherConditions pageResults) {
		this.pageResults = pageResults;
	}

	private void calculateTemperatureForPogodynka(List<Integer> temperatureAdd) {
		// TODO Auto-generated method stub
		Temperature calculate = new Temperature();
		Temperature.add(calculate.setTemp(temperatureAdd.get(0),1));
		calculate = new Temperature();
		Temperature.add(calculate.setTemp(temperatureAdd.get(1), 1));
		calculate = new Temperature();
		Temperature.add(calculate.setTemp(temperatureAdd.get(2), 1));
		calculate = new Temperature();
		Temperature.add(calculate.setTemp(temperatureAdd.get(3), 1));
		calculate = new Temperature();
		Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size()-74), 1));
		calculate = new Temperature();
		Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size()-66), 1));
		calculate = new Temperature();
		Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size()-58), 1));
		calculate = new Temperature();
		Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size()-50), 1));
		calculate = new Temperature();
		Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size()-43), 1));
		calculate = new Temperature();
		Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size()-34), 1));
		calculate = new Temperature();
		Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size()-26), 1));
		calculate = new Temperature();
		Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size()-19), 1));
		calculate = new Temperature();
		Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size()-16), 1));
		calculate = new Temperature();
		Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size()-14), 1));
		calculate = new Temperature();
		Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size()-12), 1));
		calculate = new Temperature();
		Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size()-10), 1));
		calculate = new Temperature();
		Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size()-8), 1));
		calculate = new Temperature();
		Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size()-6), 1));
		calculate = new Temperature();
		Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size()-4), 1));
		calculate = new Temperature();
		Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size()-2), 1));
	}


	private void addWindForPogodynka(List<String> wind ){

		pageResults.addOneWind(wind.get(wind.size()-73));
		pageResults.addOneWind(wind.get(wind.size()-74));
		pageResults.addOneWind(wind.get(wind.size()-73));
		pageResults.addOneWind(wind.get(wind.size()-72));
		pageResults.addOneWind(wind.get(wind.size()-67));
		pageResults.addOneWind(wind.get(wind.size()-59));
		pageResults.addOneWind(wind.get(wind.size()-51));
		pageResults.addOneWind(wind.get(wind.size()-43));
		pageResults.addOneWind(wind.get(wind.size()-35));
		pageResults.addOneWind(wind.get(wind.size()-27));
		pageResults.addOneWind(wind.get(wind.size()-19));
		pageResults.addOneWind(wind.get(wind.size()-16));
		pageResults.addOneWind(wind.get(wind.size()-14));
		pageResults.addOneWind(wind.get(wind.size()-12));
		pageResults.addOneWind(wind.get(wind.size()-10));
		pageResults.addOneWind(wind.get(wind.size()-8));
		pageResults.addOneWind(wind.get(wind.size()-6));
		pageResults.addOneWind(wind.get(wind.size()-4));
		pageResults.addOneWind(wind.get(wind.size()-2));
		pageResults.addOneWind(wind.get(wind.size()-1));
	}
	private void addTempForPogodynka(List<Temperature> temperature ){
		pageResults.setTemperature(temperature);
	}
	private void addPressureForPogodynka(List<String> pressure ){
		pageResults.addOnePressure(pressure.get(pressure.size()-73));
		pageResults.addOnePressure(pressure.get(pressure.size()-74));
		pageResults.addOnePressure(pressure.get(pressure.size()-73));
		pageResults.addOnePressure(pressure.get(pressure.size()-72));
		pageResults.addOnePressure(pressure.get(pressure.size()-67));
		pageResults.addOnePressure(pressure.get(pressure.size()-59));
		pageResults.addOnePressure(pressure.get(pressure.size()-51));
		pageResults.addOnePressure(pressure.get(pressure.size()-43));
		pageResults.addOnePressure(pressure.get(pressure.size()-35));
		pageResults.addOnePressure(pressure.get(pressure.size()-27));
		pageResults.addOnePressure(pressure.get(pressure.size()-19));
		pageResults.addOnePressure(pressure.get(pressure.size()-16));
		pageResults.addOnePressure(pressure.get(pressure.size()-14));
		pageResults.addOnePressure(pressure.get(pressure.size()-12));
		pageResults.addOnePressure(pressure.get(pressure.size()-10));
		pageResults.addOnePressure(pressure.get(pressure.size()-8));
		pageResults.addOnePressure(pressure.get(pressure.size()-6));
		pageResults.addOnePressure(pressure.get(pressure.size()-4));
		pageResults.addOnePressure(pressure.get(pressure.size()-2));
		pageResults.addOnePressure(pressure.get(pressure.size()-1));
	}
	//	private void addDescriptionForPogodynka(List<String> descriptionWeather ){
//		pageResults.setDescriptionWeather(descriptionWeather);
//	}
	// POGODYNKA INDEX 1
	public void divisionPogodynka(URL url) {

		List<Integer> TemperatureAdd = new ArrayList<Integer>();
		String oneHtmlLine = null;
		String word = null;
		StringTokenizer stringTokenizer = null;
		BufferedReader allHtml = null;
		try {
			allHtml = new BufferedReader(new InputStreamReader(url.openStream()));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			while ((oneHtmlLine = allHtml.readLine()) != null) {
				stringTokenizer = new StringTokenizer(oneHtmlLine, "=;<>\"&,()");
				while (stringTokenizer.hasMoreTokens()) {
					word = stringTokenizer.nextToken();
					System.out.println(word);

					if (word.equals("'temperatura'")) {
						TemperatureAdd.add(Integer.parseInt(stringTokenizer.nextToken()));
					}
					if(word.equals("'wiatr'")){
						wind.add(stringTokenizer.nextToken());
					}
					if(word.equals("'cisnienie'")){
						pressure.add(stringTokenizer.nextToken());
					}

				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		calculateTemperatureForPogodynka(TemperatureAdd);
		addTempForPogodynka(Temperature);
		addWindForPogodynka(wind);
		addPressureForPogodynka(pressure);
		//addDescriptionForPogodynka(descriptionWeather);
	}
	//WEATHERONLINE INDEX 0
	public void divisionWeatheronline(URL url) {
		int i = 0;
		String word = null;
		StringTokenizer stringTokenizer = null;
		String oneHtmlLine = null;
		BufferedReader allHtml = null;

		try {
			allHtml = new BufferedReader(new InputStreamReader(url.openStream()));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			while ((oneHtmlLine = allHtml.readLine()) != null) {

				stringTokenizer = new StringTokenizer(oneHtmlLine, "=;<>\"&,()");

				while (stringTokenizer.hasMoreTokens()) {
					word = stringTokenizer.nextToken();
					if (word.equals("Temp_plus") || word.equals("Temp_minus")) {
						i++;

						if (i == 5)
							Temperature.get(1).setTemp(Integer.parseInt(stringTokenizer.nextToken()), 0 );
						if (i == 6)
							Temperature.get(5).setTemp(Integer.parseInt(stringTokenizer.nextToken()), 0 );
						if (i == 7)
							Temperature.get(6).setTemp(Integer.parseInt(stringTokenizer.nextToken()), 0 );
						if (i == 8)
							Temperature.get(7).setTemp(Integer.parseInt(stringTokenizer.nextToken()), 0 );
					}

				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


	private void addPressureForWeekend(List<String> wind) {
		Map<String, LocalDate> nextWeekendDaysDate = new HashMap();
		LocalDate date = LocalDate.now();
		DayOfWeek today = date.getDayOfWeek();
		switch(today) {
			case MONDAY:
				//Piatek
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 46));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 45));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 44));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 43));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 42));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 41));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 40));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 39));
				//Sobota
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 38));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 37));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 36));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 35));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 34));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 33));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 32));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 31));
				//Niedziela
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 30));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 29));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 28));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 27));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 26));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 25));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 24));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 23));
				break;
			case TUESDAY:
				//Piatek
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 54));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 53));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 52));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 51));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 50));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 49));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 48));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 47));
				//Sobota
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 46));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 45));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 44));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 43));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 42));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 41));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 40));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 39));
				//Niedziela
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 38));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 37));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 36));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 35));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 34));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 33));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 32));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 31));
				break;
			case WEDNESDAY:
				//Piątek
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 62));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 61));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 60));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 59));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 58));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 57));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 56));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 55));
				//Sobota
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 54));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 53));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 52));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 51));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 50));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 49));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 48));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 47));
				//Niedziela
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 46));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 45));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 44));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 43));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 42));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 41));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 40));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 39));
				break;
			case THURSDAY:
				//Piatek
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 70));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 69));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 68));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 67));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 66));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 65));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 64));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 63));
				//Sobota
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 62));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 61));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 60));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 59));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 58));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 57));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 56));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 55));
				//Niedziela
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 54));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 53));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 52));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 51));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 50));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 49));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 48));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 47));
				break;
			case FRIDAY:
				//Piatek
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 74));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 73));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 72));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 71));
				//Sobota
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 70));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 69));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 68));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 67));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 66));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 65));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 64));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 63));
				//Niedziela
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 62));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 61));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 60));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 59));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 58));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 57));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 56));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 55));
				break;
			case SATURDAY:
				//Sobota
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 74));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 73));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 72));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 71));
				//Niedziela
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 70));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 69));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 68));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 67));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 66));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 65));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 64));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 63));
				break;
			case SUNDAY:
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 74));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 73));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 72));
				this.pageResults.addOnePressure((String)this.pressure.get(this.pressure.size() - 71));
				break;
		}

	}

	private void addWindForWeekend(List<String> wind) {
		Map<String, LocalDate> nextWeekendDaysDate = new HashMap();
		LocalDate date = LocalDate.now();
		DayOfWeek today = date.getDayOfWeek();
		switch(today) {
			case MONDAY:
				this.pageResults.addOneWind((String)wind.get(wind.size() - 46));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 45));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 44));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 43));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 42));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 41));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 40));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 39));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 38));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 37));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 36));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 35));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 34));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 33));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 32));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 31));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 30));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 29));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 28));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 27));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 26));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 25));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 24));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 23));
				break;
			case TUESDAY:
				this.pageResults.addOneWind((String)wind.get(wind.size() - 54));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 53));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 52));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 51));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 50));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 49));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 48));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 47));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 46));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 45));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 44));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 43));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 42));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 41));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 40));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 39));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 38));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 37));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 36));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 35));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 34));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 33));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 32));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 31));
				break;
			case WEDNESDAY:
				this.pageResults.addOneWind((String)wind.get(wind.size() - 62));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 61));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 60));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 59));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 58));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 57));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 56));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 55));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 54));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 53));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 52));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 51));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 50));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 49));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 48));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 47));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 46));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 45));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 44));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 43));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 42));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 41));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 40));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 39));
				break;
			case THURSDAY:
				this.pageResults.addOneWind((String)wind.get(wind.size() - 70));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 69));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 68));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 67));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 66));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 65));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 64));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 63));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 62));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 61));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 60));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 59));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 58));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 57));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 56));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 55));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 54));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 53));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 52));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 51));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 50));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 49));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 48));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 47));
				break;
			case FRIDAY:
				this.pageResults.addOneWind((String)wind.get(wind.size() - 74));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 73));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 72));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 71));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 70));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 69));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 68));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 67));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 66));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 65));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 64));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 63));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 62));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 61));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 60));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 59));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 58));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 57));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 56));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 55));
				break;
			case SATURDAY:
				this.pageResults.addOneWind((String)wind.get(wind.size() - 74));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 73));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 72));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 71));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 70));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 69));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 68));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 67));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 66));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 65));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 64));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 63));
				break;
			case SUNDAY:
				this.pageResults.addOneWind((String)wind.get(wind.size() - 74));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 73));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 72));
				this.pageResults.addOneWind((String)wind.get(wind.size() - 71));
		}

	}

	private void extractTemperatureForWeekend(List<Integer> temperatureAdd) {
		Map<String, LocalDate> nextWeekendDaysDate = new HashMap();
		LocalDate date = LocalDate.now();
		DayOfWeek today = date.getDayOfWeek();
		Temperature calculate = new Temperature();
		switch(today) {
			case MONDAY:
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size()-46), 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 45), 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 44) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 43) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 42) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 41) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 40) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 39) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 38) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 37) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 36) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 35) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 34) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 33) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 32) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 31) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 30) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 29) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 28) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 27) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 26) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 25) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 24) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 23) , 1));
				break;
			case TUESDAY:
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 54) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 53) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 52) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 51) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 50) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 49) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 48) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 47) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 46) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 45) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 44) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 43) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 42) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 41) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 40) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 39) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 38) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 37) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 36) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 35) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 34) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 33) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 32) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 31) , 1));
				break;
			case WEDNESDAY:
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 62) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 61) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 60) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 59) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 58) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 57) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 56) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 55) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 54) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 53) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 52) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 51) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 50) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 49) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 48) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 47) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 46) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 45) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 44) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 43) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 42) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 41) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 40) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 39) , 1));
				break;
			case THURSDAY:
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 70) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 69) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 68) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 67) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 66) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 65) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 64) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 63) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 62) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 61) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 60) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 59) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 58) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 57) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 56) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 55) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 54), 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 53) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 52) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 51) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 50) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 49) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 48) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 47) , 1));
				break;
			case FRIDAY:
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 74) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 73) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 72) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 71) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 70) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 69) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 68) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 67) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 66) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 65) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 64) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 63) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 62) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 61) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 60) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 59) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 58) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 57) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 56) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 55) , 1));
				break;
			case SATURDAY:
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 74) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 73) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 72) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 71) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 70) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 69) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 68) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 67) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 66) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 65) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 64) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 63) , 1));
				break;
			case SUNDAY:
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 74) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 73) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 72) , 1));
				calculate = new Temperature();
				this.Temperature.add(calculate.setTemp(temperatureAdd.get(temperatureAdd.size() - 71) , 1));
		}

	}
	public void weatherForWeekend(URL url) {

		List<Integer> TemperatureAdd = new ArrayList<Integer>();
		String oneHtmlLine = null;
		String word = null;
		StringTokenizer stringTokenizer = null;
		BufferedReader allHtml = null;
		try {
			allHtml = new BufferedReader(new InputStreamReader(url.openStream()));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			while ((oneHtmlLine = allHtml.readLine()) != null) {
				stringTokenizer = new StringTokenizer(oneHtmlLine, "=;<>\"&,()");
				while (stringTokenizer.hasMoreTokens()) {
					word = stringTokenizer.nextToken();
					System.out.println(word);

					if (word.equals("'temperatura'")) {
						TemperatureAdd.add(Integer.parseInt(stringTokenizer.nextToken()));
					}
					if(word.equals("'wiatr'")){
						wind.add(stringTokenizer.nextToken());
					}
					if(word.equals("'cisnienie'")){
						pressure.add(stringTokenizer.nextToken());
					}

				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.extractTemperatureForWeekend(TemperatureAdd);
		this.addTempForWeekend(this.Temperature);
		this.addWindForWeekend(this.wind);
		this.addPressureForWeekend(this.pressure);
	}

	private void addTempForWeekend(List<Temperature> temperature) {
		this.pageResults.setTemperature(temperature);
	}

}