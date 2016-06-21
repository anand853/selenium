package com.google.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class AndroidWebtest {
	public static void main(String[] args) {

		String page_url = "https://www.google.com";
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("browserName", "Chrome");
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("platformVersion", "6.0.1");
		desiredCapabilities.setCapability("device", "Android");
		desiredCapabilities.setCapability("deviceName", "SAMSUNG-SM-G92-V");

		URL url = null;
		try {
			url = new URL("http://localhost:4723/wd/hub");
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}
		RemoteWebDriver remoteWebDriver = new RemoteWebDriver(url, desiredCapabilities);

		remoteWebDriver.get(page_url);
		String pageTitle = remoteWebDriver.getTitle();

		Assert.assertEquals("Google", pageTitle);

		remoteWebDriver.quit();

	}

}
