package com.techelevator.npgeek.model;

import java.util.LinkedList;
import java.util.List;

import com.techelevator.model.Weather;

public interface WeatherDAO {

	 LinkedList<Weather> getWeather(String parkCode);
	
}
