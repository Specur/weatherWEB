package com.packt.webstore.domain;

import java.util.ArrayList;
import java.util.List;

public class CollectionWeatherConditions {
		List<String> wind = new ArrayList<String>();
		List<String> pressure = new ArrayList<String>();
		List<Temperature> temperature = new ArrayList<Temperature>();
		
		public void addOneWind(String wind){
			this.wind.add(wind);
		}
		public void addOnePressure(String pressure){
			this.pressure.add(pressure);
		}
		public List<String> getWind() {
			return wind;
		}
		public void setWind(List<String> wind) {
			this.wind = wind;
		}
		public List<String> getPressure() {
			return pressure;
		}
		public void setPressure(List<String> pressure) {
			this.pressure = pressure;
		}
		public List<String> getTemperature() {
			List<String> temp = new ArrayList<String>();
			for(Temperature string : temperature){
				temp.add(string.toString());
			}
			return temp;
		}
		public void setTemperature(List<Temperature> temperature) {
			this.temperature = temperature;
		}
}
