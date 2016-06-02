package com.google.test;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class iOSDriver {
	public static void main(String[] args) {
		iOSDriver iosDriver = new iOSDriver();
		try {
			iosDriver.setUp();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	private AppiumDriver<IOSElement> driver;

	private WebElement row;

	public void setUp() throws Exception {
		// set up appium
		// File classpathRoot = new File(System.getProperty("user.dir"));
		File resourcesDirectory = new File("src/test/resources");
		File appDir = new File(resourcesDirectory, "/apps");
		File app = new File(appDir, "irobot-enterprise.35.ipa");
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "8.1");
		capabilities.setCapability("deviceName", "iPhone 6S");
		capabilities.setCapability("app", app.getAbsolutePath());

		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

}
