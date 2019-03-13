package com.techelevator.npgeek.model.Jdbc;

import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Weather;
import com.techelevator.npgeek.model.ParkDAO;
import com.techelevator.npgeek.model.WeatherDAO;

@Component
public class JdbcWeatherDao implements WeatherDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcWeatherDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Weather> getWeather(String parkCode){
		
		
		parkCode = parkCode.toUpperCase();
		
		LinkedList<Weather> weatherForecast = new LinkedList<Weather>();
		
		String sql = "Select * FROM weather WHERE parkcode = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkCode);
		
		while(results.next()) {
			Weather theWeather = mapRowToPark(results);
			weatherForecast.add(theWeather);
		}
		System.out.println(weatherForecast.isEmpty());
		return weatherForecast;
	}

	private Weather mapRowToPark(SqlRowSet results) {
		Weather theWeather = new Weather();
		
		theWeather.setFiveDayForecastValue(results.getLong("fivedayforecastvalue"));
		theWeather.setHigh(results.getLong("high"));
		theWeather.setLow(results.getLong("low"));
		theWeather.setParkCode(results.getString("parkcode"));
		theWeather.setForecast(results.getString("forecast"));
		
		
		
		return theWeather;
	}

}
