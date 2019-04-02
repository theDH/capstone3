package com.techelevator.npgeek.model.Jdbc;

import java.util.LinkedList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.DailySurvey;
import com.techelevator.npgeek.model.DailySurveyDAO;

@Component
public class JdbcDailySurveyDao implements DailySurveyDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcDailySurveyDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public LinkedList<DailySurvey> getDailySurveys(){
		LinkedList<DailySurvey> allSurveys = new LinkedList<DailySurvey>();
		
		String sql = "SELECT parkname, survey_result.parkcode, COUNT(*) FROM survey_result JOIN park ON park.parkcode = survey_result.parkcode GROUP BY parkname, survey_result.parkcode ORDER BY COUNT DESC";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		
		while(results.next()) {
			DailySurvey theSurvey = mapRowToPark(results);
			allSurveys.add(theSurvey);
		}
		
		return allSurveys;
	
	
	}

	private DailySurvey mapRowToPark(SqlRowSet results) {
		DailySurvey theSurvey =new DailySurvey();
		
		theSurvey.setParkname(results.getString("parkname"));
		theSurvey.setCount(results.getLong("count"));
		theSurvey.setParkcode(results.getString("parkcode").toLowerCase());
		return theSurvey;
	}

}
