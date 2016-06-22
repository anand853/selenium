package com.google.test;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Runner {

    public static AndroidDriver androidDriver = null;
    static WebDriver driver;
    static Properties prop = new Properties();
    static OutputStream output = null;
    static Logger log = Logger.getLogger(Runner.class.getName());
    Runner runner;
    WebElement element;
	String osName;
	String driverPath;
	List<WebElement> elementList;
	String result = "";
	InputStream inputStream;
	WebDriverWait wait;
	String home = System.getProperty("user.home");
	String download = "/Downloads/";

	public static void main(String[] args) {
		Runner r = new Runner();
		try {
			r.getPropValues();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.info(System.getProperty("os.name"));
		log.info(System.getProperty("os.version"));
		log.info(System.getProperty("path.separator"));
		log.info(System.getProperty("user.dir"));
		log.info(System.getProperty("user.home"));
		log.info(System.getProperty("user.name"));
		log.info(System.getProperty("os.arch"));
		log.info(System.getProperty("line.separator"));
		log.info(System.getProperty("java.version"));
		log.info(System.getProperty("java.vendor.url"));
		log.info(System.getProperty("java.vendor"));
		log.info(System.getProperty("java.home"));
		log.info(System.getProperty("java.class.path"));
		log.info(System.getProperty("file.separator"));

		log.info(r.getOSVersion());
	}

    public static String returnPropertyValue() {
        String propValue = "";
        try {
            prop.load(App.class.getClassLoader().getResourceAsStream("config.properties"));

            // get the property value and print it out
            propValue = prop.getProperty("driverChannel");

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return propValue;

    }

    public String getOSVersion() {
        return System.getProperty("os.name");

    }

	public WebDriver lauchDriver(String browser) {

		osName = getOSVersion();
		if (osName.equalsIgnoreCase("Windows 10")) {
			driverPath = "C:\\Building\\WebDriver\\drivers\\chromedriver_win32\\chromedriver.exe";
		} else {
			driverPath = "/usr/local/bin/chromedriver";
		}

		System.setProperty("webdriver.chrome.driver", driverPath);
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		if (browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
		if (browser.equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver();
		}
		return driver;
	}

	public void getToPage(String url) {
		driver.get(url);
	}

	public String getPageTitle() {
		return driver.getTitle();

	}

	public boolean isElementDisplayedInThePage(String locatorType, String string2) {

		if (locatorType.equalsIgnoreCase("name")) {
			return driver.findElement(By.name(string2)).isDisplayed();
		}
		if (locatorType.equalsIgnoreCase("id")) {
			return driver.findElement(By.id(string2)).isDisplayed();
		}
		if (locatorType.equalsIgnoreCase("css")) {
			return driver.findElement(By.cssSelector(string2)).isDisplayed();
		}
		if (locatorType.equalsIgnoreCase("xpath")) {
			return driver.findElement(By.xpath(string2)).isDisplayed();
		}
		if (locatorType.equalsIgnoreCase("classname")) {
			return driver.findElement(By.className(string2)).isDisplayed();
		}
		return false;

	}

	public boolean isElementEnabledInThePage(String locatorType, String string2) {

		if (locatorType.equalsIgnoreCase("name")) {
			return driver.findElement(By.name(string2)).isEnabled();
		}
		if (locatorType.equalsIgnoreCase("id")) {
			return driver.findElement(By.id(string2)).isEnabled();
		}
		if (locatorType.equalsIgnoreCase("css")) {
			return driver.findElement(By.cssSelector(string2)).isEnabled();
		}
		if (locatorType.equalsIgnoreCase("xpath")) {
			return driver.findElement(By.xpath(string2)).isEnabled();
		}
		if (locatorType.equalsIgnoreCase("classname")) {
			return driver.findElement(By.className(string2)).isEnabled();
		}
		return false;

	}

	public void closeBrowser() {
		driver.close();

	}

	public void shutDownDriver() {
		driver.quit();

	}

	public WebElement findElement(String locatorType, String string2) {

		if (Runner.returnPropertyValue().equalsIgnoreCase("mobile")) {
			driver = androidDriver;

			if (locatorType.equalsIgnoreCase("name")) {
				element = driver.findElement(By.name(string2));

			}
			if (locatorType.equalsIgnoreCase("id")) {
				element = driver.findElement(By.id(string2));
			}
			if (locatorType.equalsIgnoreCase("css")) {
				element = driver.findElement(By.cssSelector(string2));
			}
			if (locatorType.equalsIgnoreCase("xpath")) {
				element = driver.findElement(By.xpath(string2));
			}
			if (locatorType.equalsIgnoreCase("classname")) {
				element = driver.findElement(By.className(string2));
			}
		} else {
			driver = driver;
		}
		return element;

	}

	public List<WebElement> findElements(String locatorType, String string2) {

		if (locatorType.equalsIgnoreCase("name")) {
			elementList = driver.findElements(By.name(string2));

		}
		if (locatorType.equalsIgnoreCase("id")) {
			elementList = driver.findElements(By.id(string2));
		}
		if (locatorType.equalsIgnoreCase("css")) {
			elementList = driver.findElements(By.cssSelector(string2));
		}
		if (locatorType.equalsIgnoreCase("xpath")) {
			elementList = driver.findElements(By.xpath(string2));
		}
		if (locatorType.equalsIgnoreCase("classname")) {
			elementList = driver.findElements(By.className(string2));
		}
		return elementList;

	}

	public void hoverOnElement(String locatorType, String searchTerm) {
		Actions action = new Actions(driver);

		if (locatorType.equalsIgnoreCase("name")) {
			element = driver.findElement(By.name(searchTerm));
			action.moveToElement(element).build().perform();

		}
		if (locatorType.equalsIgnoreCase("id")) {
			element = driver.findElement(By.id(searchTerm));
			action.moveToElement(element).build().perform();
		}
		if (locatorType.equalsIgnoreCase("css")) {
			element = driver.findElement(By.cssSelector(searchTerm));
			action.moveToElement(element).build().perform();
		}
		if (locatorType.equalsIgnoreCase("xpath")) {
			element = driver.findElement(By.xpath(searchTerm));
			action.moveToElement(element).build().perform();
		}
		if (locatorType.equalsIgnoreCase("classname")) {
			element = driver.findElement(By.className(searchTerm));
			action.moveToElement(element).build().perform();
		}

	}

	public void mazimizePage() {
		driver.manage().window().maximize();

	}

	public WebDriver configureWebAppAppium() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "5.1");
		capabilities.setCapability("deviceName", "XT1053");
		capabilities.setCapability("platformName", "Android");
		capabilities.setPlatform(Platform.ANDROID);
		capabilities.setCapability("device", "android");
		capabilities.setCapability("app", "chrome");
		try {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Building\\WebDriver\\drivers\\chromedriver_win32\\chromedriver.exe");
			driver = new RemoteWebDriver(new URL("http://127.0.0.1:9512/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;

	}

    //working
    public WebDriver configureNativeAppAppium() {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "XT1053");
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("platformVersion", "5.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "codepath.apps.demointroandroid");
		capabilities.setCapability("appActivity", "codepath.apps.demointroandroid.DemoSelector");
		capabilities.setCapability("device", "android");

		try {

			driver = new RemoteWebDriver(new URL("http://localhost:9512/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}
		return driver;

	}

	public WebDriver configureOfficeNativeAppAppium() {
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
		return androidDriver;

	}

	public String getPropValues() throws IOException {

		try {
			Properties prop = new Properties();
			String propFileName = "config.properties";

			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}

			Date time = new Date(System.currentTimeMillis());

			String user = prop.getProperty("deviceName");
			String company1 = prop.getProperty("platformVersion");
			String company2 = prop.getProperty("platformName");
			String company3 = prop.getProperty("appActivity");

			result = "Company List = " + company1 + ", " + company2 + ", " + company3;
			log.info(result + "\nProgram Ran on " + time + " by user=" + user);
		} catch (Exception e) {
			log.info("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return result;
	}

	public void validateHomeScreen() {

		// String pageTitle = findElement("xpath", "//*[@resource-id =
		// 'com.irobot.home:id/header_title']").getText();

		element = androidDriver.findElement(By.xpath("//*[@resource-id = 'com.irobot.home:id/header_title']"));
		// Assert.assertEquals(element.getText(), "Welcome!");
	}

	public WebElement implicitWait() {

		if (Runner.returnPropertyValue().equalsIgnoreCase("mobile")) {
			driver = androidDriver;

		}
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		return element;

	}

	public void scrollDown() {

		Dimension dimensions = androidDriver.manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		int scrollStart = screenHeightStart.intValue();
		// log.info("screen starts=" + scrollStart);

		Double screenHeightEnd = dimensions.getHeight() * 0.2;
		int scrollEnd = screenHeightEnd.intValue();
		// log.info("screen ends=" + scrollEnd);
		int i;
		androidDriver.swipe(0, scrollStart, 0, scrollEnd, 2000);

	}

	public void scrollToLearnMore() {
		String text = "Learn more";
		androidDriver.scrollTo(text);

	}

	public void scrollForText(String str) {
		androidDriver.scrollTo(str);

	}

	public void waitForDetected() {
		String text = "Detected Robots";
		androidDriver.scrollTo(text);

	}

	public void quitDriver() {
		log.info("started==>");
		log.info("started=187=>");
		// androidDriver = null;
		log.info("quit end==>");

	}

	public WebDriver configureEmulator() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.PLATFORM, "Android");
		capabilities.setCapability("deviceName", "Android Emulator");
		// capabilities.setCapability("deviceName", "SAMSUNG-SM-G290V");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.irobot.home");
		capabilities.setCapability("appActivity", "com.irobot.home.SplashActivity_");
		capabilities.setCapability("app", "/Users/cigniti_apasunoori/Downloads/irobot-debug.apk");
		capabilities.setCapability("autoWebview", true);
		try {
			androidDriver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
			log.info("---appiums is ready to go ahead---");
		} catch (MalformedURLException e1) {

			e1.printStackTrace();
		}

		return driver;

	}

}
