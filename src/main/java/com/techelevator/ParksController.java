package com.techelevator;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.model.DailySurvey;
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
	public String displayParkDetails(ModelMap modelHolder, @RequestParam String parkcode, HttpSession session)  {
		if (session.getAttribute("temp") == null){
			session.setAttribute("temp", "Fahrenheit");
		}
		
		Park park = parkDao.getParkDetails(parkcode);
		
		modelHolder.addAttribute("park", park);
		
		LinkedList<Weather> fiveDay = weatherDao.getWeather(parkcode);
		
		modelHolder.addAttribute("park", park);
		modelHolder.addAttribute("weather", fiveDay);
		
		return "parkDetails";
	}
	
	@RequestMapping("/survey")
	public String displaySurvey() {
		return "survey";
	}
	
	@RequestMapping(path="/submitSurvey", method=RequestMethod.POST)
	public String submitSurvey(Survey survey, RedirectAttributes flashScope) {
		
		surveyDao.saveSurvey(survey);
		
		flashScope.addFlashAttribute("Thank you", true);
		
		return "redirect:/surveyResults";
	}
	
	@RequestMapping("/surveyResults") 
	public String displaySurveyResults(ModelMap modelHolder) {	
		
		
		LinkedList<DailySurvey> theSurvey = surveyDao.getDailySurveys();
		
		
		modelHolder.addAttribute("dailySurvey", theSurvey);
		
		return "surveyResults";
	}
	
	@RequestMapping(path="/tempConversion", method=RequestMethod.POST)
	public String convertTemp(HttpServletRequest request, HttpSession session, @RequestParam String parkcode) {
		System.out.println(session.getAttribute("temp"));
		
		if (session.getAttribute("temp").equals("Fahrenheit")) {
			session.setAttribute("temp", "Celsius");
			return "redirect:/parkDetails?parkcode="+parkcode;
		}else {
			session.setAttribute("temp", "Fahrenheit");
			return "redirect:/parkDetails?parkcode="+parkcode;
			
		}
		
		
	}
	
}
