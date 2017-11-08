package com.techelevator.selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SurveyResults {

private WebDriver webDriver;
	
	public SurveyResults(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	public HomePage clickOnHome() {
		WebElement clickOnTheHomePage = webDriver.findElement(By.linkText("Home"));
		clickOnTheHomePage.click();
		return new HomePage(webDriver);
	}
	public SurveyPage clickOnSurveyLink() {
		WebElement surveyLink = webDriver.findElement(By.linkText("Survey"));
		surveyLink.click();
		return new SurveyPage(webDriver);
	}
	
}
