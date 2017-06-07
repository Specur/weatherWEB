package com.packt.webstore.domain;

import java.util.ArrayList;

public class Smog {
	private String placeSensorInKrakow;
	private ArrayList<Integer> amountUGM3 = new ArrayList<Integer>();
	public int getAmountUGM3(int value) {
		return amountUGM3.get(value);
	}
	public void setAmountUGM3(int value) {
		amountUGM3.add(value);
	}
	private String descriptionAirState;
	public String getPlaceSensorInKrakow() {
		return placeSensorInKrakow;
	}
	public void setPlaceSensorInKrakow(String placeSensorInKrakow) {
		this.placeSensorInKrakow = placeSensorInKrakow;
	}
	public String getDescriptionAirState() {
		return descriptionAirState;
	}
	public void setDescriptionAirState(String descriptionAirState) {
		this.descriptionAirState = descriptionAirState;
	}
	
}
