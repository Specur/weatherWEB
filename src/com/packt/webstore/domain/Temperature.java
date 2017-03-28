package com.packt.webstore.domain;

//obiekt przedstawiajacy temperature
public class Temperature {
	private int[] temperature = new int[5];
	private int[] websidePutData = new int[5];
	
	public Temperature(){
		for(int i = 0 ; i < 5 ; i ++){
			temperature[i] = 0;
			websidePutData[i] = 0;
		}
	}
	
	public void setTemp(int temp , int indexWebside){
		temperature[indexWebside] = temp;
		websidePutData[indexWebside] = 1;
	}
	
	//liczy srednia ze wszystkich stron
	public int getAverage(){
		int average = 0;
		int count = 0;
		for(int i = 0 ; i < 5 ; i++){
			if(websidePutData[i] == 1){
				count++;
				average+= temperature[i];
			}
		}
		if(average != 0)
		return (int)average/count;
		
		
		
		return 0;
		
		
	}

}
