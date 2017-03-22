package com.packt.webstore.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;


import com.packt.webstore.domain. PageResults;


public class Division {
	private  static  PageResults pageResults;
	
	public Division( PageResults pageResults){
		this.pageResults = pageResults;
	}
	
	
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
								if(i == 1)
								pageResults.setTempMinNextDay(Integer.parseInt(stringTokenizer.nextToken()));
								if(i == 2)
									pageResults.setTempMinSecondDay(Integer.parseInt(stringTokenizer.nextToken()));
								if(i == 3)
									pageResults.setTempMinThirdDay(Integer.parseInt(stringTokenizer.nextToken()));
								if(i == 4)
									pageResults.setTempMinFourthDay(Integer.parseInt(stringTokenizer.nextToken()));
							if(i == 5)
							pageResults.setTempMaxNextDay(Integer.parseInt(stringTokenizer.nextToken()));
							if(i == 6)
								pageResults.setTempMaxSecondDay(Integer.parseInt(stringTokenizer.nextToken()));
							if(i == 7)
								pageResults.setTempMaxThirdDay(Integer.parseInt(stringTokenizer.nextToken()));
							if(i == 8)
								pageResults.setTempMaxFourthDay(Integer.parseInt(stringTokenizer.nextToken()));
						}
					}
				    
				}
	}

}
