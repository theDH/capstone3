package com.techelevator;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.model.Park;
import com.techelevator.model.Survey;
import com.techelevator.model.Weather;
import com.techelevator.npgeek.model.ParkDAO;
import com.techelevator.npgeek.model.SurveyDAO;
import com.techelevator.npgeek.model.WeatherDAO;

@Controller
public class ParksController {

	@Autowired
	private ParkDAO parkDao;
	@Autowired
	private WeatherDAO weatherDao;
	@Autowired
	private SurveyDAO surveyDao;
	


	@RequestMapping(path="/")
	public String displayParkList(ModelMap modelHolder) {
		List<Park> listOfParks = parkDao.getAllParks();
		
		modelHolder.addAttribute("parks", listOfParks);
		
		return "parks";
	}

	@RequestMapping (path="/parkDetails")
	public String displayParkDetails(ModelMap modelHolder, @RequestParam String parkcode)  {
		
		
		Park park = parkDao.getParkDetails(parkcode);
		
		
		List<Weather> fiveDay = weatherDao.getWeather(parkcode);
		
		modelHolder.addAttribute("park", park);
		modelHolder.addAttribute("weather", fiveDay);
		
		return "parkDetails";
	}
	
	@RequestMapping("/survey")
	public String displaySurvey() {
		return "survey";
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.POST)
	public String submitSurvey(Survey survey, RedirectAttributes flashScope) {
		flashScope.addFlashAttribute("Thank you");
		//add method to save survey
		return "redirect:/surveyResults";
	}
	
}
