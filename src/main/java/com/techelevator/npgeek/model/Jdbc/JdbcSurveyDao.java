package com.techelevator.npgeek.model.Jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.SurveyDAO;

@Component 
public class JdbcSurveyDao implements SurveyDAO{

	private JdbcTemplate jdbcTemplate;
		
		
	
}
