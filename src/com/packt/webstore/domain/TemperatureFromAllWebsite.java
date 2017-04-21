package com.packt.webstore.domain;

//klasa przechowujaca wszystkie temperatury dla poszczegolnego miasta
public class TemperatureFromAllWebsite {

	private Temperature tempNow;
	private Temperature tempToday;
	private Temperature temp3h;
	private Temperature temp6h;
	private Temperature temp9h;
	private Temperature temp12h;
	private Temperature temp1d;
	private Temperature temp2d;
	private Temperature temp3d;
	private Temperature temp4d;
	private Temperature temp5d;
	private Temperature temp6d;
	private Temperature temp7d;
	private Temperature temp8d;
	private Temperature temp9d;
	private Temperature temp10d;
	private Temperature temp11d;
	private Temperature temp12d;
	private Temperature temp13d;
	private Temperature temp14d;
	private Temperature temp15d;
	private Temperature temp16d;

	public TemperatureFromAllWebsite() {
		tempNow = new Temperature();
		temp16d = new Temperature();
		temp15d = new Temperature();
		temp14d = new Temperature();
		temp13d = new Temperature();
		temp12d = new Temperature();
		temp11d = new Temperature();
		temp10d = new Temperature();
		temp9d = new Temperature();
		temp8d = new Temperature();
		temp7d = new Temperature();
		temp6d = new Temperature();
		temp5d = new Temperature();
		temp4d = new Temperature();
		temp3d = new Temperature();
		temp2d = new Temperature();
		temp1d = new Temperature();
		temp12h = new Temperature();
		temp9h = new Temperature();
		temp6h = new Temperature();
		temp3h = new Temperature();
		tempToday = new Temperature();

	}

	public int getTempNow() {
		return tempNow.getAverage();
	}

	public void setTempNow(int tempNoww, int index) {
		tempNow.setTemp(tempNoww, index);
	}

	public int getTemp3h() {
		return temp3h.getAverage();
	}

	public void setTemp3h(int temp3hh, int index) {
		temp3h.setTemp(temp3hh, index);
	}

	public int getTemp6h() {
		return temp6h.getAverage();
	}

	public void setTemp6h(int temp6hh, int index) {
		temp6h.setTemp(temp6hh, index);
	}

	public int getTemp9h() {
		return temp9h.getAverage();
	}

	public void setTemp9h(int temp9hh, int index) {
		temp9h.setTemp(temp9hh, index);
	}

	public int getTemp12h() {
		return temp12h.getAverage();
	}

	public void setTemp12h(int temp12hh, int index) {
		temp12h.setTemp(temp12hh, index);
	}

	public int getTemp1d() {
		return temp1d.getAverage();
	}

	public void setTemp1d(int temp1dd, int index) {
		temp1d.setTemp(temp1dd, index);
	}

	public int getTemp2d() {
		return temp2d.getAverage();
	}

	public void setTemp2d(int temp2dd, int index) {
		temp2d.setTemp(temp2dd, index);
	}

	public int getTemp3d() {
		return temp3d.getAverage();
	}

	public void setTemp3d(int temp3dd, int index) {
		temp3d.setTemp(temp3dd, index);
	}

	public int getTemp4d() {
		return temp4d.getAverage();
	}

	public void setTemp4d(int temp4dd, int index) {
		temp4d.setTemp(temp4dd, index);
	}

	public int getTemp5d() {
		return temp5d.getAverage();
	}

	public void setTemp5d(int temp5dd, int index) {
		temp5d.setTemp(temp5dd, index);
	}

	public int getTemp6d() {
		return temp6d.getAverage();
	}

	public void setTemp6d(int temp6dd, int index) {
		temp6d.setTemp(temp6dd, index);
	}

	public int getTemp7d() {
		return temp7d.getAverage();
	}

	public void setTemp7d(int temp7dd, int index) {
		temp7d.setTemp(temp7dd, index);
	}

	public int getTemp8d() {
		return temp8d.getAverage();
	}

	public void setTemp8d(int temp8dd, int index) {
		temp8d.setTemp(temp8dd, index);
	}

	public int getTemp9d() {
		return temp9d.getAverage();
	}

	public void setTemp9d(int temp9dd, int index) {
		temp9d.setTemp(temp9dd, index);
	}

	public int getTemp10d() {
		return temp10d.getAverage();
	}

	public void setTemp10d(int temp10dd, int index) {
		temp10d.setTemp(temp10dd, index);
	}

	public int getTemp11d() {
		return temp11d.getAverage();
	}

	public void setTemp11d(int temp11dd, int index) {
		temp11d.setTemp(temp11dd, index);
	}

	public int getTemp12d() {
		return temp12d.getAverage();
	}

	public void setTemp12d(int temp12dd, int index) {
		temp12d.setTemp(temp12dd, index);
	}

	public int getTemp13d() {
		return temp13d.getAverage();
	}

	public void setTemp13d(int temp13dd, int index) {
		temp13d.setTemp(temp13dd, index);
	}

	public int getTemp14d() {
		return temp14d.getAverage();
	}

	public void setTemp14d(int temp14dd, int index) {
		temp14d.setTemp(temp14dd, index);
	}

	public int getTemp15d() {
		return temp15d.getAverage();
	}

	public void setTemp15d(int temp15dd, int index) {
		temp15d.setTemp(temp15dd, index);
	}

	public int getTemp16d() {
		return temp16d.getAverage();
	}

	public void setTemp16d(int temp16dd, int index) {
		temp16d.setTemp(temp16dd, index);
	}

	public int getTempToday() {
		return tempToday.getAverage();
	}

	public void setTempToday(int tempTodayy, int index) {
		tempToday.setTemp(tempTodayy, index);
	}

}
