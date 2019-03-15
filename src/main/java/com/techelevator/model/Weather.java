package com.techelevator.model;

public class Weather {

	private String parkCode;
	private Long fiveDayForecastValue;
	private Long low;
	private Long high;
	private String forecast;
	private String forecastImage;
	private String parkAdvice;
	private String parkTempAdvice;
	private Long lowInC;
	private Long highInC;
	
	
	
	
	public String getParkTempAdvice() {
			if(high>=75) {
		parkTempAdvice = "Bring an extra gallon of water";
		}else if((high - low) > 20 ) {
			parkTempAdvice = "Wear breathable layers";
		}else if(low < 20) {
			parkTempAdvice = "Be prepared for extreme cold";
		}else {
			parkTempAdvice = null;
		}
		return parkTempAdvice;
	}
	public void setParkTempAdvice(String parkTempAdvice) {
		this.parkTempAdvice = parkTempAdvice;
	}
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
	public String getForecastImage() {

		switch(forecast) {
		case "partly cloudy":
		forecastImage = "partlyCloudy";
		break;
		default:
		forecastImage = forecast;
		}
		return forecastImage;
	}
	public void setForecastImage(String forecastImage) {
		this.forecastImage = forecastImage;
	}
	public String getParkAdvice() {
		
		switch(forecast) {
		case "snow":
		parkAdvice = "Pack snowshoes";
		break;
		case "rain":
		parkAdvice = "Pack rain gear and wear waterproof shoes";
		break;
		case "sunny":
		parkAdvice = "Pack sunblock";
		break;
		case "thunderstorms":
		parkAdvice = "Seek shelter and avoid hiking on exposed ridges";
		break;
		default:
		parkAdvice = null;
		}
		return parkAdvice;
	}
	
	
	public void setParkAdvice(String parkAdvice) {
		this.parkAdvice = parkAdvice;
	}
	
	public Long getLowInC() {
		return lowInC;
	}
	public void setLowInC(Long lowInC) {
		
		this.lowInC = ((low-32) * 5)/9;
		
	}
	public Long getHighInC() {
		return highInC;
	}
	public void setHighInC(Long highInC) {
		
		this.highInC = ((high-32) * 5)/9;
		
	}
	
	
	
	
}
