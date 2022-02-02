package com.db.step_def;

import java.util.List;
import java.util.Map;

import com.db.pages.LandingPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class TodoSteps {

	LandingPage dpLandingPage;

	public TodoSteps(LandingPage dpLandingPage) {
		this.dpLandingPage = dpLandingPage;
	}

	@Given("user is on twitter login page")
	public void redirect_ToLandingPage() {
		dpLandingPage.redirectToLandingPage();
	}

	@When("user logs in with following credentials")
	public void login(DataTable dt) throws InterruptedException {
		List<List<String>> dataLs = dt.asLists(String.class);

		String username = dataLs.get(1).get(0);
		String password = dataLs.get(1).get(1);
		dpLandingPage.login(username, password);
	}

	@Then("user expect to be navigated to home page")
	public void verifyLogin() {
		dpLandingPage.verifyLogin();
	}

	@When("^user update following details in profile section$")
	public void updateProfileSection(DataTable dt) throws InterruptedException {
		Map<String, String> details = dt.asMap(String.class, String.class);
		String bio = details.get("bio");
		String location = details.get("location");
		String website = details.get("website");
		dpLandingPage.updateProfileSection(bio, location, website);
	}

	@When("^user expect following details updated in profile section$")
	public void verifyProfileSection(DataTable dt) throws InterruptedException {
		Map<String, String> details = dt.asMap(String.class, String.class);
		String bio = details.get("bio");
		String location = details.get("location");
		String website = details.get("website");
		dpLandingPage.fetchAndVerifyUserDetails(bio, location, website);
	}

	@When("^user navigates to profile page to upload a profile picture$")
	public void userUploadProfilePicture() throws Throwable {
		dpLandingPage.userUploadProfilePicture();
	}

	@When("user Fetch BIO {string} and location {string} and website {string} and check if the submit values got updated")
	public void fetchAndVerifyUserDetails(String bio, String location, String password) throws Throwable {
		dpLandingPage.fetchAndVerifyUserDetails(bio, location, password);
	}

	@When("user retrieves the tweets for the twitter page of {string}")
	public void retrieveTheTweets(String search) throws InterruptedException {
		dpLandingPage.retrieveTheTweets(search);
	}

}
