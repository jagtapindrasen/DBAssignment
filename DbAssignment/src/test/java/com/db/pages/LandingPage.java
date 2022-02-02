package com.db.pages;

import java.awt.Robot;

import java.awt.Toolkit;

import java.awt.datatransfer.StringSelection;

import java.awt.event.KeyEvent;

import org.junit.Assert;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.db.elements.LandingPageElements;
import com.db.step_def.AbstractBase;

public class LandingPage {

	WebDriver driver;
	AbstractBase base;
	LandingPageElements homeElements;
	private WebDriver webdriver;
	String tweetArray[];

	public LandingPage(AbstractBase base) {

		this.base = base;
		this.driver = base.getDriver();
		homeElements = new LandingPageElements(this.driver);

	}

	public void redirectToLandingPage() {

		String landingPageUrl = base.getLandingPageURL();
		driver.get(landingPageUrl);

	}

	public void login(String username, String password) {

		homeElements.txtbx_userName.sendKeys(username);
		homeElements.txtbx_nextButton.click();
		homeElements.txtbx_password.sendKeys(password);
		homeElements.btn_login.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void verifyLogin() {

		String actualUrl = driver.getCurrentUrl();
		boolean actualValue = actualUrl.contains("home");
		System.out.println("URL verification " + actualUrl);
		Assert.assertEquals(true, actualValue);

	}

	public void userUploadProfilePicture() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement Profile;
		Profile = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[contains(normalize-space(),'Profile')]")));
		Profile.click();
		WebElement EditProfile;
		EditProfile = wait.until(

				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Edit profile')]")));
		EditProfile.click();

		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//div[@aria-label='Add avatar photo']"));
		element.click();
		Thread.sleep(2000);

		uploadFile(System.getProperty("user.dir") + "\\src\\test\\java\\com\\db\\config\\india.JPG");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Apply')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("displayName")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
		Thread.sleep(5000);

	}

	public static void setClipboardData(String string) {

		// StringSelection is a class that can be used for copy and paste operations.
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

	}

	public static void uploadFile(String fileLocation) {

		try {

			// Setting clipboard with file location
			setClipboardData(fileLocation);
			// native key strokes for CTRL, V and ENTER keys
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (Exception exp) {
			exp.printStackTrace();

		}

	}

	public void updateProfileSection(String bio, String location, String website) throws InterruptedException {

		WebElement Profile, EditProfile, TextBio, Location, Website;

		// Click Profile
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Profile = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[contains(normalize-space(),'Profile')]")));
		Profile.click();
		// Click Edit Profile
		EditProfile = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Edit profile')]")));
		EditProfile.click();
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, 30);

		// Set BIO
		TextBio = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("description")));
		TextBio.click();
		TextBio.clear();
		TextBio.sendKeys(bio);

		// Set Location
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("location")));
		Location = driver.findElement(By.name("location"));
		Location.click();
		Location.clear();
		Location.sendKeys(location);

		// Set website
		Website = driver.findElement(By.name("url"));
		Website.click();
		Website.clear();
		Website.sendKeys(website);
		driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();

	}

	public void fetchAndVerifyUserDetails(String bio, String location, String website) throws InterruptedException {

		// Click Profile

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement Profile;
		Profile = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[contains(normalize-space(),'Profile')]")));
		Profile.click();

		// Click Edit profile
		WebElement EditProfile;
		EditProfile = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Edit profile')]")));
		EditProfile.click();
		Thread.sleep(2000);

		// Fetch profile details
		String actualBio = driver.findElement(By.name("description")).getText();
		String actualLocation = driver.findElement(By.name("location")).getAttribute("value");
		String actualUrl = driver.findElement(By.name("url")).getAttribute("value");
		driver.findElement(By.xpath("//div[@data-testid=\"app-bar-close\"]"));

		// Verify profile details
		Assert.assertEquals(bio, actualBio);
		Assert.assertEquals(location, actualLocation);
		Assert.assertEquals(website, actualUrl);

	}

	public void retrieveTheTweets(String search) throws InterruptedException {

		try {

			WebDriverWait wait = new WebDriverWait(driver, 30);
			WebElement Website;
			Website = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Search query']")));
			Website.click();
			Thread.sleep(2000);
			Website.clear();
			Website.sendKeys(search);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@data-testid='TypeaheadUser']//span[text()='" + search + "']")).click();
			int i = 1;
			while (true) {
				// System.out.println("Value of i === " + i);
				String timeXpth = "//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div/section/div/div/div["
						+ i + "]/div/div/article/div/div/div/div[2]/div[2]/div[1]/div/div/div[1]/a/time";

				Thread.sleep(3000);
				JavascriptExecutor je = (JavascriptExecutor) driver;
				je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(timeXpth)));
				Thread.sleep(3000);
				String timeXpath = driver.findElement(By.xpath(timeXpth)).getText();
				// System.out.println("tweet time :"+timeXpath);
				if (timeXpath.contains("s") || timeXpath.contains("m") || timeXpath.equals("1h")) {
					String contentXpath = "//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div/section/div/div/div["
							+ i + "]/div/div/article/div/div/div/div[2]/div[2]/div[2]/div[1]";
					String content = driver.findElement(By.xpath(contentXpath)).getText();
					// Printing Tweets
					System.out.println(content);
					System.out.println(

							"\n*******************************************************************************************************************************************************************************");

					// splitting extra long tweets in chunk of 50 chars
					printTweetInChunk(content);
					System.out.println(

							"\n*******************************************************************************************************************************************************************************");

					// System.out.println();
				} else {
					break;
				}

				i++;

			}

		} catch (Exception e) {

		}

	}

	public static void printTweetInChunk(String content) {

		char[] ch = content.toCharArray();

		if (ch.length > 50) {

			float f = ch.length / 50;
			int remainder = ch.length % 50;
			// System.out.println(remainder);
			int temp = Math.round(f);
			System.out.println(temp);
			int t = 0;
			for (int z = 0; z < temp; z++) {

				int y = 50 + t;
				System.out.println(z + 1 + " Chunk of data ");

				while (t < y) {
					System.out.print(ch[t]);
					t++;
				}

				System.out.println();

			}

			if (remainder != 0) {

				System.out.println(temp + 1 + " Chunk of data ");
				System.out.println();
				for (int k = t; k < ch.length; k++) {
					System.out.print(ch[k]);

				}

			}

		}

	}

}
