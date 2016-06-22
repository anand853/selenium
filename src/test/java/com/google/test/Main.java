package com.google.test;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

/**
 * Created by cigniti_apasunoori on 6/21/16.
 */
public class Main {
    static AndroidDriver androidDriver;

    public static void main(String s[]) {
        {
            System.out.print("started");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "Galaxy S5");
            capabilities.setCapability("version", "5.0");
            capabilities.setCapability("appPackage", "com.irobot.home");
            capabilities.setCapability("appActivity", "com.irobot.home.SplashActivity_");
            capabilities.setCapability("app", "/Users/cigniti_apasunoori/Downloads/irobot-debug.apk");

            try {
                androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);



            } catch (MalformedURLException e1) {

                e1.printStackTrace();
            }
            System.out.print("ends");


        }
    }
}
