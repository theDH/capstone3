package com.techelevator.npgeek.model;

import java.util.List;

import com.techelevator.model.Park;

public interface ParkDAO {

List<Park> getAllParks();
public Park getParkDetails(String parkcode);
	
}
