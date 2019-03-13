package com.techelevator.npgeek.model;

import java.util.List;

import com.techelevator.model.Weather;

public interface WeatherDAO {

	 List<Weather> getWeather(String parkCode);
	
}
