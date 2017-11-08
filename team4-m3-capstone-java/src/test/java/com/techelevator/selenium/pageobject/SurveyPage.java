package com.techelevator.selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SurveyPage {

	private WebDriver webDriver;
	
	public SurveyPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public HomePage clickOnHome() {
		WebElement clickOnTheHomePage = webDriver.findElement(By.linkText("Home"));
		clickOnTheHomePage.click();
		return new HomePage(webDriver);
	}

	public SurveyPage enterEmail(String email) {
		WebElement emailInput = webDriver.findElement(By.name("email"));
		emailInput.sendKeys(email);
		return this;
	}
	public SurveyPage enterState(String state) {
		WebElement stateInput = webDriver.findElement(By.name("state"));
		stateInput.sendKeys(state);
		return this;
	}
	public SurveyResults selectSubmit() {
		WebElement activityLevel = webDriver.findElement(By.id("submit"));
		activityLevel.click();
		return new SurveyResults (webDriver);
		
	}
}