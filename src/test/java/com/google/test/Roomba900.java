package com.google.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Roomba900 {

	String version = "";
	// WebDriver idriver;
	Runner runner = new Runner();
	static WebDriver driver;
	// WebDriverWait wait = new WebDriverWait(driver, 10);
	boolean enabled = false;
	boolean selected = false;

	static Logger log = Logger.getLogger(Roomba900.class.getName());

	@Test
	public void installAPK() {
		runner.configureOfficeNativeAppAppium();
		// runner.configureEmulator();

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

		version = runner.findElement("xpath", "//android.widget.TextView[@text='Vacuuming Robot']").getText();
		Assert.assertEquals(version, "Vacuuming Robot");
		log.info("the text is =>" + version);
	}

	@Test
	public void clickOnRoomba900() {
		runner.scrollDown();
		runner.implicitWait();
		runner.findElement("xpath", "//android.widget.TextView[@text='Roomba 900 Series']").click();

	}

	@Test
	public void verifyThirdPageTitle() {
		runner.scrollDown();
		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/header_title']").getText();
		Assert.assertEquals(version, "Roomba 900 Series");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyDetectedRobots() {

		runner.implicitWait();
		runner.waitForDetected();
		log.info("----verifyDetectedRobots----");
		runner.scrollDown();

		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/detectedRobotText']").getText();
		Assert.assertEquals(version, "Detected Robots");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifySetUpNewRoomba() {
		runner.scrollToLearnMore();
		log.info("----verifySetUpNewRoomba----");
		runner.scrollDown();
		runner.scrollDown();
		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/setUpNewRoomba']").getText();
		Assert.assertEquals(version, "Set Up a New Roomba");
		log.info("the text is =>" + version);

	}

	@Test
	public void clickOnSetUpANewRoomba()

	{
		runner.scrollToLearnMore();
		log.info("----clickOnSetUpANewRoomba----");
		runner.scrollDown();
		runner.scrollDown();
		runner.implicitWait();
		runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/setUpNewRoomba']").click();

	}

	@Test
	public void verifyLearnMore() {
		runner.scrollDown();
		runner.scrollToLearnMore();
		runner.implicitWait();

		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/learnMore']").getText();
		Assert.assertEquals(version, "Learn more");
		log.info("the text is =>" + version);

	}

	@Test
	public void clickOnSetUpNewRoomba() {
		runner.scrollToLearnMore();
		runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/setUpNewRoomba']").click();

	}

	@Test
	public void verifyFourthPageTitle() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/header_title']").getText();
		Assert.assertEquals(version, "Set Up a New Roomba");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyHelloText() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/wifiSettingsTitleIntroSetup']")
				.getText();
		Assert.assertEquals(version, "Hello!");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyDots() {

		runner.implicitWait();
		enabled = runner.findElement("xpath", "//android.widget.ImageButton[@index=2]").isDisplayed();
		Assert.assertEquals(enabled, true);
		// enabled = runner.findElement("xpath",
		// "//android.widget.ImageButton[@index=3]").isDisplayed();
		// Assert.assertEquals(enabled, true);
		// enabled = runner.findElement("xpath",
		// "//android.widget.ImageButton[@index=4]").isDisplayed();
		// Assert.assertEquals(enabled, true);

	}

	@Test
	public void verifyHelloDesc() {

		runner.implicitWait();
		version = runner
				.findElement("xpath", "//*[@index=1 or @package='com.irobot.home' or @class='android.widget.TextView']")
				.getText();
		// Assert.assertEquals(version, "Before we begin, let's make sure you
		// have everything ready to go.");

	}

	@Test
	public void verifySkip() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/nextButton']").getText();
		Assert.assertEquals(version, "Skip");
		log.info("the text is =>" + version);

	}

	@Test
	public void clickOnSkip() {

		runner.implicitWait();
		runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/nextButton']").click();

	}

	@Test
	public void verifyFifthTitle() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/header_title']").getText();
		Assert.assertEquals(version, "Step 1: Confirm Network");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyMobileDeviceText() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/deviceConnected']").getText();
		Assert.assertEquals(version, "Your mobile device is connected to:");
		log.info("the text is =>" + version);
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyWIFI() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/networkName']").getText();
		Assert.assertEquals(version, "Warrior-Test");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyYourRoombaDesc() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//android.widget.TextView[@index=3]").getText();
		Assert.assertEquals(version,
				"Your Roomba will be setup for use on this network. If you prefer a different network, go to Settings to change your device's network. You will need the password for this network.");
		log.info("the text is =>" + version);
	}

	@Test
	public void verifyContinue() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/continueButton']").getText();
		Assert.assertEquals(version, "Continue");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyTrobleShoot() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/footerText']").getText();
		Assert.assertEquals(version, "Troubleshooting");
		log.info("the text is =>" + version);

	}

	@Test
	public void clickOnContinue() {

		runner.implicitWait();
		runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/continueButton']").click();

	}

	@Test
	public void verifySixthTitle() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/header_title']").getText();
		Assert.assertEquals(version, "Step 2: Wi‑Fi Settings");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyNameText() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/table_row_label' and @index=0]")
				.getText();
		Assert.assertEquals(version, "Name");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyWIFIText() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/table_row_text']").getText();
		Assert.assertEquals(version, "Warrior-Test");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyPassword() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//android.widget.TextView[@text='Password']").getText();
		Assert.assertEquals(version, "Password");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyShowPassword() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//android.widget.TextView[@text='Show Password']").getText();
		Assert.assertEquals(version, "Show Password");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyShowAdvancedOptions() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//android.widget.TextView[@text='Show Advanced Options']").getText();
		Assert.assertEquals(version, "Show Advanced Options");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyNote() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/noPasswordRequired']").getText();
		Assert.assertEquals(version, "*Note: If no password is required, leave blank.");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyContinueIn() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/continueButton']").getText();
		Assert.assertEquals(version, "Continue");
		log.info("the text is =>" + version);

	}

	@Test
	public void enterPassword() {

		runner.implicitWait();
		runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/table_row_text']").sendKeys("swtester1234");

	}

	@Test
	public void clickOnContinueIn() {

		runner.implicitWait();
		runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/continueButton']").click();

	}

	@Test
	public void verifySevenTitle() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/header_title']").getText();
		Assert.assertEquals(version, "Step 3: Activate Roomba");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyActiveDesc() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/progress_status']").getText();
		Assert.assertEquals(version,
				"Activate Roomba by pressing and holding the u and t buttons until Roomba generates a tone (about two seconds). Release the buttons and Roomba will flash this light");
		log.info("the text is =>" + version);
	}

	@Test
	public void verifyActiveContinue() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/continueButton']").getText();
		Assert.assertEquals(version, "Continue");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyActiveTrouble() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/footerText']").getText();
		Assert.assertEquals(version, "Troubleshooting");
		log.info("the text is =>" + version);

	}

	@Test
	public void clickOnActiveContinue() {

		runner.implicitWait();
		runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/continueButton']").click();

	}

	@Test
	public void verifyeightTitle() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/header_title']").getText();
		Assert.assertEquals(version, "Step 4: Connecting to Roomba");
		log.info("the text is =>" + version);
	}

	@Test
	public void verifyconnectPageDesc() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/openWifiSettings']").getText();
		Assert.assertEquals(version,
				"If the app does not automatically connect to Roomba, go to Wi‑Fi Settings, connect to Roomba_###, and return to this app.");
		log.info("the text is =>" + version);
	}

	@Test
	public void verifyeightTrouble() {
		runner.scrollForText("Troubleshooting");
		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@text='Troubleshooting']").getText();
		Assert.assertEquals(version, "Troubleshooting");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifySucsessTitle() {
		runner.scrollForText("Success!");
		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/header_title']").getText();
		Assert.assertEquals(version, "Success!");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifySuccessDesc() {
		runner.scrollForText("Roomba is now set up and ready for use.");
		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/successText']").getText();
		Assert.assertTrue(version.contains("Roomba is now set up and ready for use."));
		log.info("the text is =>" + version);

	}

	@Test
	public void verifySuccesscontinue() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/continueButton']").getText();
		Assert.assertEquals(version, "Continue");
		log.info("the text is =>" + version);

	}

	@Test
	public void clickOnSuccessContinue() {

		runner.implicitWait();
		runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/continueButton']").click();
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyProvisionPageTitle() {

		runner.implicitWait();

		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/header_title']").getText();
		Assert.assertEquals(version, "Personalize Roomba");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyRobotInfo() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//android.widget.TextView[@text='Robot Information']").getText();
		Assert.assertEquals(version, "Robot Information");
		log.info("the text is =>" + version);

	}

	@Test
	public void quitDriver() {
		runner.quitDriver();
		log.info("the driver shutting down");
	}

	@Test
	public void verifyRobotName() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/robotnameLabel']").getText();
		Assert.assertEquals(version, "Name");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyLanguage() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/table_row_label']").getText();
		Assert.assertEquals(version, "Language");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyBirthday() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//android.widget.TextView[@text='Birthday']").getText();
		Assert.assertEquals(version, "Birthday");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyOwnerInformation() {
		runner.scrollForText("Owner Information");
		runner.implicitWait();
		version = runner.findElement("xpath", "//android.widget.TextView[@text='Owner Information']").getText();
		Assert.assertEquals(version, "Owner Information");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyEmail() {
		runner.scrollForText("Email");
		runner.implicitWait();
		version = runner.findElement("xpath", "//android.widget.TextView[@text='Email']").getText();
		Assert.assertEquals(version, "Email");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyPostalCode() {
		runner.scrollForText("Postal Code");
		runner.implicitWait();
		version = runner.findElement("xpath", "//android.widget.TextView[@text='Postal Code' or @index=9]").getText();
		Assert.assertEquals(version, "Postal Code");
		log.info("the text is =>" + version);

	}

	@Test
	public void verifyDone() {

		runner.implicitWait();
		version = runner.findElement("xpath", "//android.widget.Button[@resource-id='com.irobot.home:id/btnDone']")
				.getText();
		Assert.assertEquals(version, "Done");
		log.info("the text is =>" + version);

	}

	@Test
	public void enterRoombaName() {
		// runner.scrollForText("Enter robot name");
		runner.implicitWait();
		runner.findElement("xpath",
				"//*[@resource-id='com.irobot.home:id/robotNameInput' or @text='Default' or @index=2 or @index=1 or @index=3]")
				.sendKeys("Roomba_1234");

	}

	@Test
	public void enterEmailID() {
		runner.scrollForText("Required");
		runner.implicitWait();
		runner.findElement("xpath", "//android.widget.EditText[@content-desc='Email']")
				.sendKeys("cigniti_apasunoori@irobot.com");

	}

	@Test
	public void clickOnProvisionDone() {

		runner.implicitWait();
		runner.findElement("xpath", "//*[@resource-id='com.irobot.home:id/btnDone']").click();
		runner.implicitWait();

	}

}
