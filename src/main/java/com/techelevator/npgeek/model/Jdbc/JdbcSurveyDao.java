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


		
	
}
