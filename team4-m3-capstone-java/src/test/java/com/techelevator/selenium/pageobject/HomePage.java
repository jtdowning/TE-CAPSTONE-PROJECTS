package com.techelevator.selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

	public class HomePage {

		private WebDriver webDriver;
	
		public HomePage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

		public ParkDetails clickOnImage() {
			WebElement clickOnTheImage = webDriver.findElement(By.className("park-image"));
			clickOnTheImage.click();
			return new ParkDetails(webDriver);
	}
		public SurveyPage clickOnSurveyLink() {
			WebElement surveyLink = webDriver.findElement(By.linkText("Survey"));
			surveyLink.click();
			return new SurveyPage(webDriver);
		}
		public ParkDetails parkName() {
			WebElement clickOnParkName = webDriver.findElement(By.linkText("Cuyahoga Valley National Park"));
			clickOnParkName.click();
			return new ParkDetails(webDriver);
		}
		
		public HomePage clickOnHome() {
			WebElement clickOnTheHomePage = webDriver.findElement(By.linkText("Home"));
			clickOnTheHomePage.click();
			return new HomePage(webDriver);
		}
		
}	
