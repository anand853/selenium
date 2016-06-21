package com.google.test;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;

public class AppiumTest {
	private WebDriver driver;

	/**
	 * Instantiates the {@link #driver} instance by using DesiredCapabilities
	 * which specify the 'iPhone Simulator' device and 'safari' app.
	 * 
	 * @throws Exception
	 */
	@BeforeTest
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "iPhone 6s");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "9.2");
		capabilities.setCapability("browserName", "safari");
		driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	/**
	 * Navigates to http://saucelabs.com/test/guinea-pig and interacts with the
	 * browser.
	 *
	 * @throws Exception
	 */
	@Test
	public void runTest() throws Exception {
		driver.get("http://www.google.com");

		Thread.sleep(2000);
	}

	/**
	 * Closes the {@link #driver} instance.
	 *
	 * @throws Exception
	 */
	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}
}