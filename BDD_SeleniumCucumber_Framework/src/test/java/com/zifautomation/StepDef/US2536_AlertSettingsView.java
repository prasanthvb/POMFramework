package com.zifautomation.StepDef;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.zifautomation.Listeners.ExtentReportListener;
import com.zifautomation.Pages.CMPLandingpage;

import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAI_AlertsSettingsPage;
import com.zifautomation.Utility.BrowserUtility;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.ExcelHandler;
import com.zifautomation.Utility.PropertiesFileReader;
import com.zifautomation.Utility.TestDataHandler;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import static junit.framework.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class US2536_AlertSettingsView extends ExtentReportListener
{
	PropertiesFileReader obj= new PropertiesFileReader();
	TestDataHandler testdata=new TestDataHandler();
	private WebDriver driver;
	CommonMethods cm=null;
	Loginfunction Login = null;

	Properties properties;



@Given("Open chrome browser and enter the ZIF UI url for Alerts Active User With Access to view Settings Page")
	public void open_chrome_browser_and_enter_the_ZIF_UI_url_for_Alerts_Active_User_With_Access_to_view_Settings_Page() {
		    try {
					properties = obj.getProperty();
					String sheet1="AlertSettings";
					String TestCaseId1="US2536";
					Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(properties.getProperty("BddTestDatapath"), sheet1, TestCaseId1);
					testdata.setTestDataInMap(TestDataInMap);
				} catch (Exception e) {

					e.printStackTrace();
				}  
				ExtentTest logInfo=null;
				try {

					test = extent.createTest(Feature.class, "Alerts - Active User With Access to view Settings Page");
					//test=test.createNode(Scenario.class, "Validate Alert Settings Click Enabled Functionalities");
					logInfo=test.createNode(new GherkinKeyword("Given"), "open_chrome_browser_and_enter_the_url");
					String Browser = testdata.getTestDataInMap().get("Browser");
					String URL = testdata.getTestDataInMap().get("Url");
					driver=BrowserUtility.OpenBrowser(driver, Browser, URL);
					//logInfo.pass("Opened chrome browser and entered url");
					//logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

				} catch (AssertionError | Exception e) {
					e.printStackTrace();
					testStepHandle("FAIL",driver,logInfo,e);
				}
		    
		}

		@Given("Login with valid Alert Settings Click Enabled Email ID and Password")
		public void login_with_valid_Alert_Settings_Click_Enabled_Email_ID_and_Password() {
		    //-------------------------------------------Login Change-----------------------------------------------------------------------
		    ExtentTest logInfo=null;
				try {
					
					test=test.createNode(Scenario.class, "Validate Alert Settings Click Enabled Functionalities");
					logInfo=test.createNode(new GherkinKeyword("Given"), "login_with_valid_Alert_Settings_Click_Enabled_Email_ID_and_Password");
					String UserName = testdata.getTestDataInMap().get("UserNamewithAccess");
					String Password = testdata.getTestDataInMap().get("PasswordwithAccess");
					//String url = testdata.getTestDataInMap().get("Url");
					new Loginfunction(driver).Enterthecredentials(UserName, Password);

					//String currentUrl = driver.getCurrentUrl();

					//if(currentUrl.contains(url)) {
				//		new Loginfunction(driver).Enterthecredentials(UserName, Password);
					//}
					logInfo.pass("Successfully user is in ZIF UI HomePage");
					logInfo.addScreenCaptureFromPath(captureScreenShot(driver));


				} catch (AssertionError | Exception e) {
					testStepHandle("FAIL",driver,logInfo,e);
				}

		}
		
		@Given("Login with valid Alert Settings Click Enabled Email ID and Password for Tooltip")
		public void login_with_valid_Alert_Settings_Click_Enabled_Email_ID_and_Password_for_Tooltip() {
		    //-------------------------------------------Login Change-----------------------------------------------------------------------
		    ExtentTest logInfo=null;
				try {
					
					test=test.createNode(Scenario.class, "Validate Alert Settings Icon Tooltip");
					logInfo=test.createNode(new GherkinKeyword("Given"), "login_with_valid_Alert_Settings_Click_Enabled_Email_ID_and_Password_for_Tooltip");
					String UserName = testdata.getTestDataInMap().get("UserNamewithAccess");
					String Password = testdata.getTestDataInMap().get("PasswordwithAccess");
					//String url = testdata.getTestDataInMap().get("Url");
					new Loginfunction(driver).Enterthecredentials(UserName, Password);

					//String currentUrl = driver.getCurrentUrl();

					//if(currentUrl.contains(url)) {
				//		new Loginfunction(driver).Enterthecredentials(UserName, Password);
					//}
					logInfo.pass("Successfully user is in ZIF UI HomePage");
					logInfo.addScreenCaptureFromPath(captureScreenShot(driver));


				} catch (AssertionError | Exception e) {
					testStepHandle("FAIL",driver,logInfo,e);
				}

		}

		@When("Navigate to Alerts Page")
		public void navigate_to_Alerts_Page() {

				ExtentTest logInfo=null;
				try {
					logInfo=test.createNode(new GherkinKeyword("When"), "navigate_to_Alerts_Page");
					new ZIFAI_AlertsSettingsPage(driver).hoveronAnalyzes();
					new ZIFAI_AlertsSettingsPage(driver).clickRawdata();
					logInfo.pass("Successfully User is Navigated to Alerts Page");
					logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

				} catch (AssertionError | Exception e) {
					testStepHandle("FAIL",driver,logInfo,e);
				}
		    
		}

		@Then("Verify that the Alert Settings is Enabled")
		public void verify_that_the_Alert_Settings_is_Enabled() {
		    
			ExtentTest logInfo=null;
				try {
					logInfo=test.createNode(new GherkinKeyword("Then"), "verify_that_the_Alert_Settings_is_Enabled");
					new ZIFAI_AlertsSettingsPage(driver).alertSettingsEnabled();
					logInfo.pass("Successfully verified the Alert Settings is Enabled");
					logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

				} catch (AssertionError | Exception e) {
					testStepHandle("FAIL",driver,logInfo,e);
				}
		    
		}

		@When("Click on Enabled Alert Settings")
		public void click_on_Enabled_Alert_Settings() {
		    ExtentTest logInfo=null;
				try {
					logInfo=test.createNode(new GherkinKeyword("When"), "click_on_Enabled_Alert_Settings");
					new ZIFAI_AlertsSettingsPage(driver).clickSettings();
					logInfo.pass("Successfully Clicked on the Alert Settings Icon");
					logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

				} catch (AssertionError | Exception e) {
					testStepHandle("FAIL",driver,logInfo,e);
				}
		    
		}

		@Then("Verify that User is able to click on Alert Settings")
		public void verify_that_User_is_able_to_click_on_Alert_Settings() {
		    ExtentTest logInfo=null;
				try {
					logInfo=test.createNode(new GherkinKeyword("Then"), "verify_that_User_is_able_to_click_on_Alert_Settings");
					new ZIFAI_AlertsSettingsPage(driver).Verifyviewsettingspageaccess();
					logInfo.pass("Successfully Verified that the user is able to click on the Alert Settings Icon");
					logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

				} catch (AssertionError | Exception e) {
					testStepHandle("FAIL",driver,logInfo,e);
				}
		    
		}

		@Given("Login with valid Alert Settings Click Disabled Email ID and Password")
		public void login_with_valid_Alert_Settings_Click_Disabled_Email_ID_and_Password() {
		    //-------------------------------------------Login Change-----------------------------------------------------------------------
			  ExtentTest logInfo=null;
				try {
					logInfo=test.createNode(new GherkinKeyword("Given"), "login_with_valid_Alert_Settings_Click_Disabled_Email_ID_and_Password");
					String UserName = testdata.getTestDataInMap().get("UserName");
					String Password = testdata.getTestDataInMap().get("Password");
					

						new Loginfunction(driver).Enterthecredentials(UserName, Password);
					
					logInfo.pass("Successfully user is in ZIF UI HomePage");
					logInfo.addScreenCaptureFromPath(captureScreenShot(driver));


				} catch (AssertionError | Exception e) {
					testStepHandle("FAIL",driver,logInfo,e);
				}
		    
		}

		@Then("Verify that the Alert Settings is Disabled")
		public void verify_that_the_Alert_Settings_is_Disabled() {
		    
		    	ExtentTest logInfo=null;
				try {
					logInfo=test.createNode(new GherkinKeyword("Then"), "verify_that_the_Alert_Settings_is_Disabled");
					new ZIFAI_AlertsSettingsPage(driver).alertSettingsdisabled();
					logInfo.pass("Successfully verified the Alert Settings is Disabled");
					logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

				} catch (AssertionError | Exception e) {
					testStepHandle("FAIL",driver,logInfo,e);
				}
		}

		@When("Click on Disabled Alert Settings")
		public void click_on_Disabled_Alert_Settings() {
		    
		    ExtentTest logInfo=null;
				try {
					logInfo=test.createNode(new GherkinKeyword("When"), "click_on_Disabled_Alert_Settings");
					new ZIFAI_AlertsSettingsPage(driver).clickSettings();
					logInfo.pass("Clicked on the Alert Settings Icon");
					//logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

				} catch (AssertionError | Exception e) {
					testStepHandle("FAIL",driver,logInfo,e);
				}
		}

		@Then("Verify that User is not able to click on the Disabled Alert Settings")
		public void verify_that_User_is_not_able_to_click_on_the_Disabled_Alert_Settings() {
		    ExtentTest logInfo=null;
				try {
					logInfo=test.createNode(new GherkinKeyword("Then"), "verify_that_User_is_not_able_to_click_on_the_Disabled_Alert_Settings");
					new ZIFAI_AlertsSettingsPage(driver).alertSettingsdisabled();
					logInfo.pass("Successfully verified that the user is not able to click on the Alert Settings Icon");
					logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

				} catch (AssertionError | Exception e) {
					testStepHandle("FAIL",driver,logInfo,e);
				}
		    
		}

		@When("Mouse hover on Alert Settings Icon")
		public void mouse_hover_on_Alert_Settings_Icon() {
		     ExtentTest logInfo=null;
				try {
					logInfo=test.createNode(new GherkinKeyword("When"), "mouse_hover_on_Alert_Settings_Icon");
					new ZIFAI_AlertsSettingsPage(driver).settingstooltip();

				} catch (AssertionError | Exception e) {
					testStepHandle("FAIL",driver,logInfo,e);
				}
		    
		}

		@Then("Verify that User is able see the tooltip as Settings")
		public void verify_that_User_is_able_see_the_tooltip_as_Settings() {
		     ExtentTest logInfo=null;
				try {
					logInfo=test.createNode(new GherkinKeyword("Then"), "verify_that_User_is_able_see_the_tooltip_as_Settings");
					new ZIFAI_AlertsSettingsPage(driver).settingstooltip();
					logInfo.pass("Successfully verified the tooltip on the Alert Settings Icon");
					logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

				} catch (AssertionError | Exception e) {
					testStepHandle("FAIL",driver,logInfo,e);
				}
		    
		}

		@Given("Login with valid Alert Settings View Enabled Email ID and Password")
		public void login_with_valid_Alert_Settings_View_Enabled_Email_ID_and_Password() {
		        //-------------------------------------------Login Change-----------------------------------------------------------------------
			  ExtentTest logInfo=null;
				try {
					test=test.createNode(Scenario.class, "Validate Alert Settings View Enabled Functionalities");
					logInfo=test.createNode(new GherkinKeyword("Given"), "login_with_valid_Alert_Settings_View_Enabled_Email_ID_and_Password");
					String UserName = testdata.getTestDataInMap().get("UserNamewithAccess");
					String Password = testdata.getTestDataInMap().get("PasswordwithAccess");
					
						new Loginfunction(driver).Enterthecredentials(UserName, Password);
					
					logInfo.pass("Successfully user is in ZIF UI HomePage");
					//logInfo.addScreenCaptureFromPath(captureScreenShot(driver));


				} catch (AssertionError | Exception e) {
					testStepHandle("FAIL",driver,logInfo,e);
				}
		    
		}

		@Then("Verify the user is able to view all the fields in the Alert Settings Page")
		public void verify_the_user_is_able_to_view_all_the_fields_in_the_Alert_Settings_Page() {
		    
		     ExtentTest logInfo=null;
				try {
					logInfo=test.createNode(new GherkinKeyword("Then"), "verify_the_user_is_able_to_view_all_the_fields_in_the_Alert_Settings_Page");
					new ZIFAI_AlertsSettingsPage(driver).Verifyviewsettingspageaccess();
					logInfo.pass("Successfully Verified all the fields in the Alert Settings Page");
					logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

				} catch (AssertionError | Exception e) {
					testStepHandle("FAIL",driver,logInfo,e);
				}
		}

		@Given("Login with valid Alert Settings View Disabled Email ID and Password")
		public void login_with_valid_Alert_Settings_View_Disabled_Email_ID_and_Password() {
		 //-------------------------------------------Login Change-----------------------------------------------------------------------
			  ExtentTest logInfo=null;
				try {
					logInfo=test.createNode(new GherkinKeyword("Given"), "login_with_valid_Alert_Settings_View_Disabled_Email_ID_and_Password");
					String UserName = testdata.getTestDataInMap().get("UserName");
					String Password = testdata.getTestDataInMap().get("Password");
					
						new Loginfunction(driver).Enterthecredentials(UserName, Password);
					
					logInfo.pass("Successfully user is in ZIF UI HomePage");
					logInfo.addScreenCaptureFromPath(captureScreenShot(driver));


				} catch (AssertionError | Exception e) {
					testStepHandle("FAIL",driver,logInfo,e);
				}
		    
		}

		@Then("Verify the user is not able to view all the fields in the Alert Settings Page")
		public void verify_the_user_is_not_able_to_view_all_the_fields_in_the_Alert_Settings_Page() {
		    
			 ExtentTest logInfo=null;
				try {
					logInfo=test.createNode(new GherkinKeyword("Then"), "verify_the_user_is_not_able_to_view_all_the_fields_in_the_Alert_Settings_Page");
					new ZIFAI_AlertsSettingsPage(driver).Verifyviewsettingspageaccess(); 
					//------------------------------------------------Verifyviewsettingspageaccess check this put from UI for not able to view
					logInfo.pass("Successfully Verified that the user is not able to view the fields in Alert Settings Page");
					logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

				} catch (AssertionError | Exception e) {
					testStepHandle("FAIL",driver,logInfo,e);
				}
		    
		}
	
}

