package com.techelevator.npgeek.cukes;

import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techelevator.selenium.pageobject.HomePage;
import com.techelevator.selenium.pageobject.ParkDetails;
import com.techelevator.selenium.pageobject.SurveyPage;
import com.techelevator.selenium.pageobject.SurveyResults;

@Component
public class NPGeekSteps {

	private WebDriver webDriver;
	private HomePage homePage;
	private ParkDetails parkDetails;
	private SurveyPage surveyLink;
	private SurveyResults surveyResults;
	
	@Autowired 
	public NPGeekSteps(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.homePage = new HomePage(webDriver);
		this.parkDetails = new ParkDetails(webDriver);
		this.surveyLink = new SurveyPage(webDriver);
		this.surveyResults = new SurveyResults(webDriver);
	}
	
	@Given("^I am on the home page$")
	public void i_am_on_the_home_page() throws Throwable {
		webDriver.get("http://localhost:8080/m3-capstone-java/");
	}
	
	
	@When("^I click on the survey link$")
	public void i_am_clicking_on_the_survey_link() throws Throwable {
		homePage.clickOnSurveyLink();
	}
	
	@When("^I click on a park image$")
	public void i_click_on_a_park_image() throws Throwable {
		homePage.clickOnImage();
	}
	
	@Then("^I enter my email address (.*)$")
	public void enter_email_address_on_survey(String email) throws Throwable {
		surveyLink.enterEmail(email);
	}
	
	@When("^I enter my state (.*)$")
	public void enter_state_on_survey(String state) throws Throwable {
		surveyLink.enterState(state);
	}
	
	@Then("^I click on the home page link$")
	public void go_back_to_home_page() throws Throwable {
		parkDetails.clickOnHome();
	}
	
	@When("^I click submit$")
	public void submit_survey_form() throws Throwable {
		surveyLink.selectSubmit();
	}
	
	@Then("^I am taken to a survey results page")
	public void taken_to_survey_results_page() throws Throwable {
		WebElement survey = webDriver.findElement(By.id("survey-form"));
		Assert.assertNotNull("There should be a survey results page", survey);
	}
	
	@Then("^I am taken to the park details page$")
	public void taken_to_park_details_page() throws Throwable {
		WebElement forecast = webDriver.findElement(By.className("forecast"));
		Assert.assertNotNull("Should be taken to a park details page", forecast);
	}
	
	@Then("^I return to the home page$")
	public void taken_back_to_home_page() throws Throwable {
		WebElement parkImage = webDriver.findElement(By.className("park-image"));
		Assert.assertNotNull("Should return to home page", parkImage);
	}
	
	
}
