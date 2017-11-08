package com.techelevator.selenium;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import com.techelevator.selenium.pageobject.HomePage;
import com.techelevator.selenium.pageobject.SurveyPage;
import com.techelevator.selenium.pageobject.SurveyResults;
import com.techelevator.selenium.pageobject.ParkDetails;

public class WebPageTest {
	
	private static WebDriver webDriver;
	private HomePage homePage;
	private SurveyPage surveyLink;
	private SurveyResults surveyResults;
	private ParkDetails parkDetails;


	@BeforeClass
	public static void openBrowswer() {
		String homeDir = System.getProperty("user.home");
		System.setProperty("webdriver.chrome.driver", homeDir+"/dev-tools/chromedriver/chromedriver");
		webDriver = new ChromeDriver();
	}
	
	@AfterClass
	public static void closeBrowser() {
		webDriver.close();
	}
	
	@Before
	public void goToTheHomepage () {
		webDriver.get("http://localhost:8080/m3-capstone-java/");
		homePage = new HomePage(webDriver);	
	}
	
	@Test
	public void goToTheSurvey () {
		homePage.clickOnSurveyLink();
		WebElement survey = null;
		try {
			survey = webDriver.findElement(By.id("survey-form"));
		} catch (NoSuchElementException e) {
			Assert.assertFalse(true);
		}
		Assert.assertNotNull("table doesn't exist", survey);
	}
	
	@Test
	public void enterInfoInSurvey() {
		SurveyPage surveyLink = homePage.clickOnSurveyLink();
		surveyLink.enterEmail("jello@jello.com").enterState("PA").selectSubmit();
		WebElement surveyResults = webDriver.findElement(By.cssSelector(".survey-result"));
		Assert.assertNotNull(surveyResults);
	}
	
	@Test
	public void clickDetailPageAndGoBackToHome() {
		SurveyPage surveyLink = homePage.clickOnSurveyLink();
		HomePage homePage = surveyLink.clickOnHome();
		WebElement homeElements = webDriver.findElement(By.className("park-image"));
		Assert.assertNotNull("Should have a park-image", homeElements);
	}
	
	@Test
	public void clickOnParkLinkAndGoToDetailsPage() {
		ParkDetails parkDetails = homePage.clickOnImage();
		WebElement forecastElement = webDriver.findElement(By.className("forecast"));
		Assert.assertNotNull("Should have a forecast element", forecastElement);
	}
	
	@Test
	public void clickOnParkDetailsAndTemperatureIsInFahrenheit() {
		ParkDetails parkDetails = homePage.clickOnImage();
		WebElement tempButton = webDriver.findElement(By.cssSelector("input[type='submit']"));
		Assert.assertEquals("Should read 'Convert To Celsius'", "Convert To Celsius", tempButton.getAttribute("value"));
	}
	
	@Test
	public void clickOnCelsiusAndTemperatureChangesToCelsius() {
		ParkDetails parkDetails = homePage.clickOnImage();
		WebElement tempButton = webDriver.findElement(By.cssSelector("input[type='submit']"));
		tempButton.click();
		WebElement newTempButton = webDriver.findElement(By.cssSelector("input[type='submit']"));
		Assert.assertEquals("Value of button should read Convert To Fahrenheit", "Convert To Fahrenheit", newTempButton.getAttribute("value"));
		newTempButton.click();
	}
	
	@Test
	public void checkThatTempIsWithFDegrees() {
		ParkDetails parkDetails = homePage.clickOnImage();
		WebElement tempDegrees = webDriver.findElement(By.className("hi-temp"));
		Assert.assertTrue("Should end in F", tempDegrees.getText().endsWith("F"));
	}
	
	@Test
	public void clickOnTempButtonTwiceAndButtonReadsFahrenheit() {
		ParkDetails parkDetails = homePage.clickOnImage();
		WebElement tempButton = webDriver.findElement(By.cssSelector("input[type='submit']"));
		tempButton.click();
		WebElement newTempButton = webDriver.findElement(By.cssSelector("input[type='submit']"));
		newTempButton.click();
		WebElement originalButton = webDriver.findElement(By.cssSelector("input[type='submit']"));
		Assert.assertEquals("Value of button should read Convert To Celsius'", "Convert To Celsius", originalButton.getAttribute("value"));
	}
	
}

