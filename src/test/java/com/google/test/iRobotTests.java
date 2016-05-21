package com.google.test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.test.Runner;

/**
 * Unit test for simple App.
 */
public class iRobotTests {
	String url = "http://www.irobot.com";
	String version = "";
	// WebDriver idriver;
	Runner runner = new Runner();
	static WebDriver driver;
	// WebDriverWait wait = new WebDriverWait(driver, 10);

	@Test
	public void installAPK() {
		runner.configureOfficeNativeAppAppium();

	}

	@Test
	public void checkWelCome() {
		// check the title

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/header_title']").getText();

		Assert.assertEquals("Welcome!", version);
		System.out.println("the text is =>" + version);

	}

	@Test
	public void setUpText() {
		runner.scrollDown();
		runner.scrollDown();

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/setupNewText']").getText();

		Assert.assertEquals("Set Up a New Roomba", version);
		System.out.println("the text is =>" + version);

	}

	@Test
	public void AppLangText() {
		runner.scrollDown();
		runner.scrollDown();
		runner.implicitWait();
		version = runner
				.findElement("xpath", "//android.widget.TextView[@resource-id='com.irobot.home:id/table_row_label']")
				.getText();

		Assert.assertEquals("App Language", version);
		System.out.println("the text is =>" + version);

	}

	@Test
	public void Automatic() {
		runner.scrollDown();
		runner.scrollDown();
		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/table_row_text']").getText();

		Assert.assertEquals("Automatic (set by device)", version);
		System.out.println("the text is =>" + version);

	}

	@Test
	public void stayInformed() {
		runner.scrollDown();
		runner.scrollDown();

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/signUpText']").getText();

		Assert.assertEquals("Stay Informed", version);
		System.out.println("the text is =>" + version);

	}

	@Test
	public void about() {
		runner.scrollDown();
		runner.scrollDown();
		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@text='About this App']").getText();

		Assert.assertEquals("About this App", version);
		System.out.println("the text is =>" + version);

	}

	@Test
	public void aboutDesc() {
		runner.scrollDown();

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@content-desc='id/setUpNewRoomba']").getText();

		Assert.assertEquals(
				"This app works with the Roomba 900 series. It provides control of robots and access to settings anywhere you are. It also aids with maintenance and troubleshooting as needed.",
				version);
		System.out.println("the text is =>" + version);

	}

	@Test
	public void checkBuild() {
		runner.scrollDown();
		runner.scrollDown();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/appVersion']").getText();
		Assert.assertEquals("Version 1.5-release#28", version);
		System.out.println("the build version is =>" + version);

	}
	//

	@Test
	public void clickOnSetUpNewRoomba() {

		runner.implicitWait();
		runner.findElement("xpath", "//*[@text='Set Up a New Roomba']").click();
		;

	}

	// 2nd page
	@Test
	public void verifyPageTiltle() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@text='Set Up a New Roomba']").getText();
		Assert.assertEquals("Set Up a New Roomba", version);
		// System.out.println("the build version is =>" + version);

	}

	@Test
	public void verifyHelloTiltle() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@text='Hello!']").getText();
		Assert.assertEquals("Hello!", version);
		// System.out.println("the build version is =>" + version);

	}

	@Test
	public void verifyHelloDesc() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@class='android.widget.TextView' and @index=2]").getText();
		Assert.assertEquals("Before we begin, let's make sure you have everything ready to go.", version);

	}

	@Test
	public void verifyButtonTitle() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@text='Next']").getText();
		Assert.assertEquals("Next", version);

	}

	@Test
	public void clickOnNext() {

		runner.implicitWait();
		runner.findElement("xpath", "//*[@text='Next']").click();
		Assert.assertEquals("Next", version);

	}
	// third page

	@Test
	public void ThirdPageTitle() {

		runner.implicitWait();
		version = runner
				.findElement("xpath",
						"//*[@resource-id='com.irobot.home:id/header_title' and @index=0 and @class='android.widget.TextView']")
				.getText();
		Assert.assertEquals("Set Up a New Roomba", version);

	}

	@Test
	public void setUpHomeBase() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@text='Set up Home Base']").getText();
		Assert.assertEquals("Set up Home Base", version);

	}

	@Test
	public void setUpHomeBaseDesc() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//android.widget.TextView[@index=2]").getText();
		Assert.assertEquals(
				"Place the Home Base charging station in an area with good Wi‑Fi coverage, against a wall, and use the power cord to connect it to an outlet.",
				version);

	}

	@Test
	public void clickOnNextButton3rdPage() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//android.widget.Button[@index=3]").getText();
		Assert.assertEquals("Next", version);
		runner.findElement("xpath", "//android.widget.Button[@index=3]").click();

	}

}
