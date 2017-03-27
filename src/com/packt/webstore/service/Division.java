package com.packt.webstore.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;


import com.packt.webstore.domain. PageResults;
//WEATHERONLINE INDEX 0
//POGODYNKA INDEX 1
public class Division {
	private PageResults pageResults;
	
	public Division( PageResults pageResults){
		this.pageResults = pageResults;
	}
	
	//algorytm pomoniczy do Pogodynka
	//wyciaganie danych z tabeli
	private void CalculateTemp(int [] tabTemp , int liczba){
		
			pageResults.setTemp16d(tabTemp[liczba-1], 1);
			pageResults.setTemp15d(tabTemp[liczba-2], 1);
			pageResults.setTemp14d(tabTemp[liczba-4], 1);
			pageResults.setTemp13d(tabTemp[liczba-6], 1);
			pageResults.setTemp12d(tabTemp[liczba-8], 1);
			pageResults.setTemp11d(tabTemp[liczba-10], 1);
			pageResults.setTemp10d(tabTemp[liczba-12], 1);
			pageResults.setTemp9d(tabTemp[liczba-14], 1);
			pageResults.setTemp8d(tabTemp[liczba-16], 1);
			pageResults.setTemp7d((int)(tabTemp[liczba-18]+tabTemp[liczba-19]+tabTemp[liczba-20])/3, 1);
			
			pageResults.setTemp6d((int)(tabTemp[liczba-24]+tabTemp[liczba-25]+tabTemp[liczba-26]+tabTemp[liczba-27]+tabTemp[liczba-28])/5, 1);
			
			pageResults.setTemp5d((int)(tabTemp[liczba-32]+tabTemp[liczba-33]+tabTemp[liczba-34]+tabTemp[liczba-35]+tabTemp[liczba-36])/5, 1);
			pageResults.setTemp4d((int)(tabTemp[liczba-40]+tabTemp[liczba-41]+tabTemp[liczba-42]+tabTemp[liczba-43]+tabTemp[liczba-44])/5, 1);
			pageResults.setTemp3d((int)(tabTemp[liczba-48]+tabTemp[liczba-49]+tabTemp[liczba-50]+tabTemp[liczba-51]+tabTemp[liczba-52])/5, 1);
			pageResults.setTemp2d((int)(tabTemp[liczba-56]+tabTemp[liczba-57]+tabTemp[liczba-58]+tabTemp[liczba-59]+tabTemp[liczba-60])/5, 1);
			pageResults.setTemp1d((int)(tabTemp[liczba-64]+tabTemp[liczba-65]+tabTemp[liczba-66]+tabTemp[liczba-67]+tabTemp[liczba-68])/5, 1);
			
			pageResults.setTemp12h(tabTemp[liczba-71], 1);
			pageResults.setTemp9h(tabTemp[liczba-72], 1);
			pageResults.setTemp6h(tabTemp[liczba-73], 1);
			pageResults.setTemp3h(tabTemp[liczba-74], 1);
			
		
			
		
		
	}
	
	
	
	
	
	
	
	
	
	
	//POGODYNKA INDEX 1
	//dzielenie html z pogodynki
	public void divisionPogodynka(){
		int tabTemp[] = new int[100];
		int flaga = 0 ;
		File file = new File("pogodynka.txt");
	    Scanner in = null;
	    String wyr;
		try
			{
				in = new Scanner(file);
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
	 
	      String zdanie = in.nextLine();
	     
				StringTokenizer stringTokenizer ;
					while (in.hasNextLine()) {
						stringTokenizer = new StringTokenizer(zdanie, "=;<>\"&,()");
					zdanie = in.nextLine();
					while(stringTokenizer.hasMoreTokens()){
						wyr = stringTokenizer.nextToken();
						if(wyr.equals("'temperatura'")){
							tabTemp[flaga]= Integer.parseInt(stringTokenizer.nextToken());
							flaga++;
						}
					
						
					}
	
					}
					CalculateTemp(tabTemp,flaga);
	}

	
	
	
	
	//WEATHERONLINE INDEX 0
	//dzielenie html z weatheronline
	//weatheronline wydobywa tylko pogode na nastepne 4 dni
	public void divisionWeatheronline(){
		File file = new File("weatheronline.txt");
	    Scanner in = null;
	    String wyr;
		try
			{
				in = new Scanner(file);
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
	 
	      String zdanie = in.nextLine();
	      int i = 0 ;
				StringTokenizer stringTokenizer ;
					while (in.hasNextLine()) {
						stringTokenizer = new StringTokenizer(zdanie, "=;<>\"&");
					zdanie = in.nextLine();
					while(stringTokenizer.hasMoreTokens()){
						wyr = stringTokenizer.nextToken();
						
						if(wyr.equals("Temp_plus") || wyr.equals("Temp_minus")){
							i++;
							
							if(i == 5)
							pageResults.setTempToday(Integer.parseInt(stringTokenizer.nextToken()),0);
							if(i == 6)
								pageResults.setTemp1d(Integer.parseInt(stringTokenizer.nextToken()),0);
							if(i == 7)
								pageResults.setTemp2d(Integer.parseInt(stringTokenizer.nextToken()),0);
							if(i == 8)
								pageResults.setTemp3d(Integer.parseInt(stringTokenizer.nextToken()),0);
						}
					}
				    
				}
	}

}
