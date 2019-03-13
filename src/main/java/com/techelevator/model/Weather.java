package com.techelevator.model;

public class Weather {

	private String parkCode;
	private Long fiveDayForecastValue;
	private Long low;
	private Long high;
	private String forecast;
	
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public Long getFiveDayForecastValue() {
		return fiveDayForecastValue;
	}
	public void setFiveDayForecastValue(Long fiveDayForecastValue) {
		this.fiveDayForecastValue = fiveDayForecastValue;
	}
	public Long getLow() {
		return low;
	}
	public void setLow(Long low) {
		this.low = low;
	}
	public Long getHigh() {
		return high;
	}
	public void setHigh(Long high) {
		this.high = high;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	
	
	
}
