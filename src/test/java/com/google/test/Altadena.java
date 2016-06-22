package com.google.test;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Altadena {

	String version = "";
	// WebDriver idriver;
	Runner runner = new Runner();

	// WebDriverWait wait = new WebDriverWait(driver, 10);
	boolean enabled = false;
	boolean selected = false;
	static Logger log = Logger.getLogger(Runner.class.getName());

	@Test
	public void installAPK() {
		runner.configureOfficeNativeAppAppium();

	}

	@Test
	public void verifyAcceptAgreementText() {
		runner.implicitWait();
		version = runner
				.findElement("xpath",
						"//android.widget.TextView[@resource-id='com.irobot.home:id/user_agreement_checkbox_text']")
				.getText();

		Assert.assertEquals("Accept End User License Agreement (required)", version);
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyAcceptAgreementCheckBox() {
		runner.implicitWait();

		enabled = runner
				.findElement("xpath",
						"//android.widget.CheckBox[@resource-id='com.irobot.home:id/userAgreementCheckbox']")
				.isEnabled();

		Assert.assertEquals(true, enabled);
		log.info("the check is enabled ? => " + version);

	}

	@Test
	public void verifyAcceptAgreementReview() {
		runner.implicitWait();
		version = runner
				.findElement("xpath",
						"//android.widget.TextView[@resource-id='com.irobot.home:id/review_user_agreement_text']")
				.getText();

		Assert.assertEquals("Review", version);
		log.info("the text is =>" + version);

	}
	// add in testng xml

	@Test
	public void AppLangText() {
		runner.scrollDown();
		runner.scrollDown();
		runner.implicitWait();
		version = runner
				.findElement("xpath", "//android.widget.TextView[@resource-id='com.irobot.home:id/table_row_label']")
				.getText();

		Assert.assertEquals("App Language", version);
		log.info("the text is =>" + version);

	}

	@Test
	public void Automatic() {

		runner.scrollDown();
		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/table_row_text']").getText();

		Assert.assertEquals("Automatic (set by device)", version);
		log.info("the text is =>" + version);

	}

	@Test
	public void stayInformed() {

		runner.scrollDown();

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/emailSignup']").getText();

		Assert.assertEquals("Stay Informed", version);
		log.info("the text is =>" + version);

	}

	@Test
	public void aboutThisApp() {
		runner.scrollDown();
		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@text='About this App']").getText();

		Assert.assertEquals("About this App", version);
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyButtonNextDisabled() {
		runner.scrollDown();
		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/nextButton']").getText();

		Assert.assertEquals("Next", version);
		log.info("the text is =>" + version);

		enabled = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/nextButton']").isEnabled();

		Assert.assertEquals(false, enabled);
		log.info("the next button is enabled ? =>" + enabled);

	}

	@Test
	public void clickOnAggrement() {
		runner.scrollDown();
		runner.implicitWait();
		runner.findElement("xpath",
				"//android.widget.CheckBox[@resource-id='com.irobot.home:id/userAgreementCheckbox']").click();

		version = runner
				.findElement("xpath",
						"//android.widget.CheckBox[@resource-id='com.irobot.home:id/userAgreementCheckbox']")
				.getAttribute("checked");

		selected = Boolean.valueOf(version);
		log.info("the check box is version ? =>" + version);
		log.info("the check box is selected ? =>" + selected);
		// Assert.assertEquals(true, version);
		Assert.assertEquals(true, selected);

	}

	@Test
	public void clickOnNext() {
		runner.scrollDown();
		runner.implicitWait();
		runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/nextButton']").click();

	}

	@Test
	public void verifyPageTitle() {
		runner.scrollDown();
		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/header_title']").getText();
		Assert.assertEquals(version, "Select a Robot");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyRoomba900() {
		runner.scrollDown();
		runner.implicitWait();
		version = runner.findElement("xpath", "//android.widget.TextView[@text='Roomba 900 Series']").getText();
		Assert.assertEquals(version, "Roomba 900 Series");
		log.info("the text is =>" + version);

		version = runner.findElement("xpath", "//android.widget.TextView[@text='Vacuuming Robot']").getText();
		Assert.assertEquals(version, "Vacuuming Robot");
		log.info("the text is =>" + version);
	}

	@Test
	public void verifyAltadena() {
		runner.scrollDown();
		runner.implicitWait();
		version = runner.findElement("xpath", "//android.widget.TextView[@text='Braava jet']").getText();
		Assert.assertEquals(version, "Braava jet");
		log.info("the text is =>" + version);

		version = runner.findElement("xpath", "//android.widget.TextView[@text='Mopping Robot']").getText();
		Assert.assertEquals(version, "Mopping Robot");
		log.info("the text is =>" + version);

	}

	@Test
	public void clickOnAlradena() {
		runner.scrollDown();
		runner.implicitWait();
		runner.findElement("xpath", "//android.widget.TextView[@text='Braava jet']").click();

	}

	@Test
	public void verifyThirdPageTitle() {
		runner.scrollDown();
		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/header_title']").getText();
		Assert.assertEquals(version, "Braava jet");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyaddABraavaJet() {
		runner.scrollDown();
		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/addRobot']").getText();
		Assert.assertEquals(version, "Add a Braava jet");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyLearnMore() {
		runner.scrollDown();
		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/learnMore']").getText();
		Assert.assertEquals(version, "Learn more");
		log.info("the text is =>" + version);

	}

	@Test
	public void clickOnaddABraavaJet() {

		runner.implicitWait();
		runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/addRobot']").click();

	}

	@Test
	public void verifyfifthPageTitle() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/header_title']").getText();
		Assert.assertEquals(version, "Set Up a New Braava jet");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyChargeText() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/setupSubtitle']").getText();
		Assert.assertEquals(version, "Charge");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyChargeDesc() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/setupDescription']").getText();
		Assert.assertEquals(version, "The battery charger indicator will turn solid green when it is done charging.");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyImageButtons() {
		// TODO i do not see any attribute values getting changed for selected
		// or
		// none selected buttons. so would be diff to validate its clicked or
		// not.
		// will check with dev on this
		runner.implicitWait();
		selected = runner.findElement("xpath", "//android.widget.ImageButton[@index=2]").isDisplayed();
		Assert.assertEquals(selected, true, "for 1st button");

		selected = runner.findElement("xpath", "//android.widget.ImageButton[@index=3]").isDisplayed();
		Assert.assertEquals(selected, true, "for 2nd button");

			}

	@Test
	public void verifySkipButton() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/nextButton']").getText();
		Assert.assertEquals(version, "Skip");
		log.info("the text is =>" + version);

	}

	@Test
	public void clickOnSkipButton() {

		runner.implicitWait();
		runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/nextButton']").click();

	}

	@Test
	public void verifySixthPageTitle() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/header_title']").getText();
		Assert.assertEquals(version, "Connect to Braava jet");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyTurnOnTheRobot() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/setupSubtitle']").getText();
		Assert.assertEquals(version, "Turn on the Robot");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyTurnOnTheRobotDesc() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/setupDescription']").getText();
		Assert.assertEquals(version,
				"Press CLEAN once to wake up the robot. The robot needs to be located within a 10ft radius.");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyLetsGoButton() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/nextButton']").getText();
		Assert.assertEquals(version, "Let's Go!");
		log.info("the text is =>" + version);

	}

	@Test
	public void clickOnLetsGoButton() {

		runner.implicitWait();
		runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/nextButton']").click();

	}

	@Test
	public void verifySeventhPageTitle() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/header_title']").getText();
		Assert.assertEquals(version, "Select Robot to Register");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyAvalableAltadena() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/robotName']").getText();
		Assert.assertEquals(version, "GP-braavaJet");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyAvalableAltadenaDesc() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/robotId']").getText();
		Assert.assertEquals(version, "ID: 0x436918c931525078");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyRefreshButton() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/refreshButton']").getText();
		Assert.assertEquals(version, "Refresh");
		log.info("the text is =>" + version);

	}

	@Test
	public void clickOnAltadena() {
		runner.implicitWait();
		runner.implicitWait();
		runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/robotId']").click();

	}

	@Test
	public void altadenaHome() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/robotCleanStatus']").getText();
		Assert.assertEquals(version, "Connected.");
		log.info("the text is =>" + version);

	}

	@Test
	public void quitDriver() {
		// driver.quit();
		log.info("the driver shutting down:: start=>");
		runner.quitDriver();
		log.info("the driver shutting down");
	}

}
