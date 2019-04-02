package com.techelevator.npgeek.model;

import java.util.LinkedList;

import com.techelevator.model.DailySurvey;

public interface DailySurveyDAO {

	LinkedList<DailySurvey> getDailySurveys();
	
}
