package com.techelevator.npgeek.model;

import java.util.LinkedList;
import java.util.List;

import com.techelevator.model.DailySurvey;
import com.techelevator.model.Survey;

public interface SurveyDAO {
	
public void saveSurvey(Survey survey);

LinkedList<DailySurvey> getDailySurveys();

}
