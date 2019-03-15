package com.techelevator.npgeek.model.Jdbc;

import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.DailySurvey;
import com.techelevator.model.Survey;
import com.techelevator.npgeek.model.SurveyDAO;

@Component 
public class JdbcSurveyDao implements SurveyDAO{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcSurveyDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
		
	@Override
	public void saveSurvey(Survey newSurvey) {
		String sql = "INSERT INTO survey_result (parkcode, emailaddress, state, activitylevel)" +
				" VALUES (?, ?, ?, ?)";
		
		jdbcTemplate.update(sql, newSurvey.getPark(), newSurvey.getEmailAddress(), newSurvey.getState(), newSurvey.getActivityLevel());
	}

	@Override
	public LinkedList<DailySurvey> getDailySurveys(){
		LinkedList<DailySurvey> allSurveys = new LinkedList<DailySurvey>();
		
		String sql = "SELECT parkname, COUNT (survey_result.parkcode)  FROM survey_result JOIN park ON park.parkcode = survey_result.parkcode GROUP BY parkname ORDER BY COUNT DESC";
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
		
		return theSurvey;
	}
		
	
}
