package com.techelevator.npgeek.model.Jdbc;

import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Park;
import com.techelevator.npgeek.model.ParkDAO;

public class JdbcParkDao  implements ParkDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcParkDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Park> getAllParks(){
		LinkedList<Park> listOfParks = new LinkedList<Park>();
		String sql = "Select * FROM park ORDER BY parkname;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		
		while(results.next()) {
			Park thePark = mapRowToPark(results);
			listOfParks.add(thePark);
 		}
		return listOfParks;
	}


	private Park mapRowToPark(SqlRowSet results) {
	
		Park thePark = new Park();
	
	thePark.setParkname(results.getString("parkname"));
	thePark.setState(results.getString("state"));
	thePark.setAcreage(results.getLong("acreage"));
	thePark.setElevationinfeet(results.getLong("elevationinfeet"));
	thePark.setMilesoftrail(results.getLong("milesoftrail"));
	thePark.setNumberofcampsites(results.getLong("numberofcampsites"));
	thePark.setClimate(results.getString("climate"));
	thePark.setYearfounded(results.getLong("yearfounded"));
	thePark.setAnnualvisitorcount(results.getLong("annualvisitorcount"));
	thePark.setInspirationalquote(results.getString("inspirationalquote"));
	thePark.setEntryfee(results.getLong("entryfee"));
	thePark.setNumberofanimalspecies(results.getLong("numberofanimalspecies"));
	thePark.setInspirationalquotesource(results.getString("inspirationalquotesource"));
	
	
		return thePark;
	
	
	}	
	
}
