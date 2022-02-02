package com.db.elements;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LandingPageElements {
	WebDriver driver;

	public LandingPageElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@autocomplete='username']")
	public WebElement txtbx_userName;

	@FindBy(how = How.XPATH, using = "//span[text()='Next']")
	public WebElement txtbx_nextButton;

	@FindBy(how = How.XPATH, using = "//input[@autocomplete='current-password']")
	public WebElement txtbx_password;

	@FindBy(how = How.XPATH, using = "//span[text()='Log in']")
	public WebElement btn_login;
}
