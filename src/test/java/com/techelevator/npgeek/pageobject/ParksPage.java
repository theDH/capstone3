package com.techelevator.npgeek.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ParksPage {
	
	private WebDriver webDriver;
	
	public ParksPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public ParkDetailsPage clickParkDetailLink() {
		WebElement parkDetailLink = webDriver.findElement(By.xpath("/html/body/nav[1]/div[2]/h1/a"));
		parkDetailLink.click();
		return new ParkDetailsPage(webDriver);
	}
	
	public ParksPage enterDegree(String temp) {
		Select termField = new Select(webDriver.findElement(By.name("temp")));
		termField.selectByValue(temp);
		return this;
	}

}
