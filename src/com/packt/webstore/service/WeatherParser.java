package com.packt.webstore.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


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


}