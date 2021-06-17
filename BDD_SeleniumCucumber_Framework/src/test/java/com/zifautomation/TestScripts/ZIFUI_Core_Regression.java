package com.zifautomation.TestScripts;

import static junit.framework.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.CMPLandingpage;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAIDashboardPage;
import com.zifautomation.Pages.ZIFAIOpportunityCardsPage;
import com.zifautomation.Pages.ZIFAIPredictionPage;
import com.zifautomation.Pages.ZIFAIPrediction_DeviceConfigPage;
import com.zifautomation.Pages.ZIFAIPrediction_FilterPage;
import com.zifautomation.Pages.ZIFAI_AlertsSettingsPage;
import com.zifautomation.Pages.ZIFAI_CaseManagementPage;
import com.zifautomation.Utility.BrowserUtility;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.ExcelHandler;
import com.zifautomation.Utility.PropertiesFileReader;
import com.zifautomation.Utility.TestDataHandler;


public class ZIFUI_Core_Regression extends Base{

	WebDriverWait wait1=null;


	@Test
	public void ZIFUI_Core_RegressionTestcase() throws IOException, InterruptedException {


		//Report 

		test = extent.createTest("ZIFAI Core  Regression");
		test.createNode("ZIFAI Core Regression");


		//Verify all the fields in Login Page

		try {
			new Loginfunction(driver).Check_all_fields_are_present();
			test.log(Status.PASS,"Successfully verified all the fields in Login Page");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Login page field validation failed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}



		//Verify invalid credential
		try {
			String UserName = testdata.getTestDataInMap().get("InvalidUsername");
			String Password = testdata.getTestDataInMap().get("InvalidPassword");
			new Loginfunction(driver)
			.Enterthecredentials(UserName, Password);
			new Loginfunction(driver).getTextOfInvalidUsernameOrpassword();

			test.log(Status.PASS,"Invalid credential has been entered and Verified");

			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Invalid credentials verification failed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}


		// Login to the ZIFAI Portal With valid credentials
		try {
			String UserName = testdata.getTestDataInMap().get("UserName");
			String Password = testdata.getTestDataInMap().get("Password");
			new Loginfunction(driver)
			.Enterthecredentials(UserName, Password);

			test.log(Status.PASS,"Valid credential has been entered");

			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Login failed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}


		// Verify User is in ZIFAI Dashboard Home Page


		String ExpectedTitle = "dashboard";

		String ActualTitle = driver.getCurrentUrl();

		assertTrue(ActualTitle.contains(ExpectedTitle), "User is in dashboard page");
		if((ActualTitle.contains(ExpectedTitle))){

			test.log(Status.PASS,"Successfully logged in and User is in ZIFUI Home Page");

			Thread.sleep(2000);
		}else
		{
			test.log(Status.FAIL, "Login failed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		System.out.println("User is in ZIF UI Dashboard Page");

		// Verify all fields in ZIF UI dashboard page
		try {

			new ZIFAIDashboardPage(driver).CheckallfieldsandImages();
			test.log(Status.PASS,"Successfully verified all the fields in the Dashboard Page");

			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Dashboard page field validdation failed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// Verify all fields in ZIF UI dashboard page
		try {

			new ZIFAIDashboardPage(driver).hoveronAnalyzes();
			test.log(Status.PASS,"Successfully the hover menu is displayed for the Analyzes");
			Thread.sleep(2000);
			new ZIFAIDashboardPage(driver).verifyAnalyzeshovermenufields();
			test.log(Status.PASS,"Successfully verified the fields in the hover menu displayed for Analyzes");
		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Failed in hover menu of Analyzes");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		// Verify all fields in ZIF UI Prediction page
		try {

			new ZIFAIDashboardPage(driver).clickPrediction();
			new ZIFAIPredictionPage(driver).checkuserinPredictionPage();
			test.log(Status.PASS,"Successfully the user is in Prediction page");
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Failed in selecting prediction from Analyzes");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		System.out.println("User is in Prediction Page");


		// Verify all fields in ZIF UI Prediction page
		try {
			new ZIFAIPredictionPage(driver).CheckallfieldsandImages();
			new ZIFAIPredictionPage(driver).checkallpredictionfields();
			test.log(Status.PASS,"Successfully verified all fields in Prediction page");
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Failed in verifying prediction page fields");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		// Verify all fields in ZIF UI Prediction Swim lane
		try {
			new ZIFAIPredictionPage(driver).verifySwinlaneFields();
			test.log(Status.PASS,"Successfully verified all fields Prediction swim lane");
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Failed in verifying prediction swim lane fields");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Available Cards in QA Environment

		driver.navigate().refresh();
		Thread.sleep(2000);

		//Predicted Risk (Warning) opportunity cards 
		try { 
			wait1= new WebDriverWait(driver, 5);
			WebElement Card1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'opp-cards warn-state')][1]")));
			if(Card1.isDisplayed()) 
			{ 
				test.log(Status.PASS,"Predicted Risk (Warning) opportunity cards are displayed");

				new ZIFAIPredictionPage(driver).verifyWarningOppcardDetails();
				Thread.sleep(2000);
				test.log(Status.PASS,"Predicted Risk (Warning) opportunity cards fields are verified");

				WebElement Cardnumber = driver.findElement(By.xpath("((//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'opp-list-id')])[1]"));
				Cardnumber.click();
				Thread.sleep(2000);

				new ZIFAIOpportunityCardsPage(driver).CheckallfieldsinOpportunityCards();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickCPU();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickMemory();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickDisk();
				Thread.sleep(3000);
				new ZIFAIOpportunityCardsPage(driver).showDiskdrivecheck();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).closeAd();
				Thread.sleep(2000);
				test.log(Status.PASS,"Successfuly verified Predicted Risk (Warning) opportunity cards data flow");

			} }catch (Exception e) { 
				test.log(Status.SKIP,"Predicted Risk (Warning) opportunity cards are Not available"); 
			}

		try {
			WebElement Nodata1 = driver.findElement(By.xpath("(//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'no-data-cls')]")); 
			if(Nodata1.isDisplayed()) 
			{ 
				test.log(Status.PASS,"No Data available is displayed in Predicted Risk (Warning)"); } }catch
		(Exception e) { }


		//Currently at Risk (Critical) opportunity cards 
		try {
			wait1= new WebDriverWait(driver, 5);
			WebElement Card2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'opp-cards critical-state')][1]")));	
			if(Card2.isDisplayed()) 
			{ 
				test.log(Status.
						PASS,"Currently at Risk (Critical) opportunity cards are displayed");

				new ZIFAIPredictionPage(driver).verifyCriticalOppcardDetails();
				Thread.sleep(2000);
				test.log(Status.
						PASS,"Currently at Risk (Critical) opportunity cards fields are verified");

				WebElement Cardnumber = driver.findElement(By.xpath("((//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'opp-list-id')])[1]"));
				Cardnumber.click();
				Thread.sleep(2000);

				new ZIFAIOpportunityCardsPage(driver).CheckallfieldsinOpportunityCards();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickCPU();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickMemory();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickDisk();
				Thread.sleep(3000);
				new ZIFAIOpportunityCardsPage(driver).showDiskdrivecheck();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).closeAd();
				Thread.sleep(2000);
				test.log(Status.PASS,"Successfuly verified Currently at Risk (Critical) opportunity cards data flow");
			} 
		}catch (Exception e) { 
			test.log(Status.SKIP,"Currently at Risk (Critical) opportunity cards are Not available"); 
		}

		try { 
			WebElement Nodata1 = driver.findElement(By.xpath("(//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'no-data-cls')]")); 
			if(Nodata1.isDisplayed()) 
			{ 
				test.log(Status.PASS,"No Data available is displayed in Currently at Risk (Critical)");
			}
		}catch (Exception e) { }


		//Processsed opportunity cards 
		try { 
			wait1= new WebDriverWait(driver, 5);
			WebElement Card3 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'opp-cards processed-state')][1]")));
			if(Card3.isDisplayed()) {
				test.log(Status.PASS,"Processed opportunity cards are displayed");

				new ZIFAIPredictionPage(driver).verifyProcessedOppcardDetails();

				test.log(Status.PASS,"Processed opportunity cards fields are verified");

				WebElement Cardnumber = driver.findElement(By.xpath("((//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'opp-list-id')])[1]"));
				Cardnumber.click();
				Thread.sleep(2000);

				new ZIFAIOpportunityCardsPage(driver).CheckallfieldsinOpportunityCards();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickCPU();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickMemory();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickDisk();
				Thread.sleep(3000);
				new ZIFAIOpportunityCardsPage(driver).showDiskdrivecheck();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).closeAd();
				Thread.sleep(2000);
				test.log(Status.PASS,"Successfuly verified Processed opportunity cards data flow"); }
		}catch
		(Exception e) { 
			test.log(Status.SKIP,"Processed opportunity cards are Not available"); 
		}

		try { 
			WebElement Nodata1 = driver.findElement(By.xpath("(//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'no-data-cls')]"));

			if(Nodata1.isDisplayed()) 
			{
				test.log(Status.PASS,"No Data available is displayed in Processed"); 
			}
		}catch(Exception e) { }


		//Lost opportunity cards
		try {
			wait1= new WebDriverWait(driver, 5);
			WebElement Card4 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'opp-cards lost-state')][1]")));			
			if(Card4.isDisplayed())
			{
				test.log(Status.PASS,"Lost opportunity cards are displayed");
				new ZIFAIPredictionPage(driver).verifyLostOppcardDetails();
				Thread.sleep(2000);
				test.log(Status.PASS,"Lost opportunity cards fields are verified");
				//driver.navigate().refresh();
				Thread.sleep(2000);
				WebElement Cardnumber = driver.findElement(By.xpath("((//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'opp-list-id')])[1]"));
				Cardnumber.click();
				Thread.sleep(2000);

				new ZIFAIOpportunityCardsPage(driver).CheckallfieldsinOpportunityCards();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickCPU();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickMemory();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickDisk();
				Thread.sleep(3000);
				new ZIFAIOpportunityCardsPage(driver).showDiskdrivecheck();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).closeAd();
				Thread.sleep(2000);
				test.log(Status.PASS,"Successfuly verified Lost opportunity cards data flow");
			}
		}catch (Exception e) {
			test.log(Status.SKIP, "Lost opportunity cards are Not available");
		}

		try {					
			WebElement Nodata1 = driver.findElement(By.xpath("(//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'no-data-cls')]"));
			if(Nodata1.isDisplayed())
			{
				test.log(Status.PASS,"No Data available is displayed in Lost");
			}
		}catch (Exception e) {
		}



		//Invalid opportunity cards
		try {
			wait1= new WebDriverWait(driver, 5);
			WebElement Card5 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'opp-cards invalid-state')][1]")));
			if(Card5.isDisplayed())
			{
				test.log(Status.PASS,"Invalid opportunity cards are displayed");

				new ZIFAIPredictionPage(driver).verifyInvalidOppcardDetails();
				Thread.sleep(2000);
				test.log(Status.PASS,"Invalid opportunity cards fields are verified");
				//driver.navigate().refresh();
				Thread.sleep(2000);
				WebElement Cardnumber = driver.findElement(By.xpath("((//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'opp-list-id')])[1]"));
				Cardnumber.click();
				Thread.sleep(2000);

				new ZIFAIOpportunityCardsPage(driver).CheckallfieldsinOpportunityCards();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickCPU();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickMemory();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickDisk();
				Thread.sleep(3000);
				new ZIFAIOpportunityCardsPage(driver).showDiskdrivecheck();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).closeAd();
				Thread.sleep(2000);

				test.log(Status.PASS,"Successfuly verified Invalid opportunity cards data flow");
			}
		}catch (Exception e) {
			test.log(Status.SKIP, "Invalid opportunity cards are Not available");
		}

		try {					
			WebElement Nodata1 = driver.findElement(By.xpath("(//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'no-data-cls')]"));
			if(Nodata1.isDisplayed())
			{
				test.log(Status.PASS,"No Data available is displayed in Invalid");
			}
		}catch (Exception e) {
		}



		try {
			boolean adaptorstatus = new ZIFAIPredictionPage(driver).adaptorstatuscheck();
			if(adaptorstatus==true)
			{
				test.log(Status.PASS,"Successfully verified the adaptor status is UP");

				//Click  on Prediction Settings Icon
				try {
					new ZIFAIPredictionPage(driver).PredictionSettingsClick();
					test.log(Status.PASS,"Successfully Clicked on Prediction Settings Icon");
				}catch (Exception e) {
					test.log(Status.FAIL, "Not clicked on Prediction Settings Icon");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}



				//Verify all fields in Prediction Settings page
				try {
					new ZIFAIPredictionPage(driver).PredictionSettingsfieldvalidation();
					test.log(Status.PASS,"Successfully Verified all the fields in Prediction Settings Page");
				}catch (Exception e) {
					test.log(Status.FAIL, "Prediction Settings Page field validation failed");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}


				//Verify all fields in Prediction Settings page
				try {
					new ZIFAIPredictionPage(driver).downloadOneAgent();

					test.log(Status.PASS,"Successfully downloaded one agent and verified");
					Thread.sleep(2000);
				}catch (Exception e) {
					test.log(Status.FAIL, "One Agent download failed");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}

				//Select Device Configuration in Prediction Settings page
				try {
					new ZIFAIPredictionPage(driver).Device_Configuration_Tab();
					test.log(Status.PASS,"Successfully clicked on Device Configuration in Prediction Settings Page");
				}catch (Exception e) {
					test.log(Status.FAIL, "Not clicked on Device Configuration");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}


				//Verify all fields in Prediction Settings Device configuration page
				try {
					//new ZIFAIPrediction_DeviceConfigPage(driver).selectdevicecheck();
					new ZIFAIPrediction_DeviceConfigPage(driver).Counterconfig_CommonFieldValidation();

					test.log(Status.PASS,"Successfully Verified all the fields in the Device configuration page ");
					Thread.sleep(2000);

				}catch (Exception e) {
					test.log(Status.FAIL, "Failed verifying the fields in Device configuration page");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}

				System.out.println("User is in Device config settings page");
				//Verify all fields in Prediction Settings Counter configuration 
				try {
					new ZIFAIPrediction_DeviceConfigPage(driver).Counterconfig_FieldValidation();

					test.log(Status.PASS,"Successfully Verified all the fields in the Counter configuration");
					Thread.sleep(2000);
				}catch (Exception e) {
					test.log(Status.FAIL, "Failed verifying the fields in Counter configuration");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}

				//Verify all fields in Prediction Settings Counter configuration-CPU
				try {
					new ZIFAIPrediction_DeviceConfigPage(driver).CounterconfigCPU_FieldValidation();

					test.log(Status.PASS,"Successfully Verified all the fields in the Counter configuration-CPU");
					Thread.sleep(2000);
				}catch (Exception e) {
					test.log(Status.FAIL, "Failed verifying the fields in Counter configuration-CPU");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}

				//Verify all fields in Prediction Settings Counter configuration-DISK
				try {
					new ZIFAIPrediction_DeviceConfigPage(driver).CounterconfigDisk_FieldValidation();

					test.log(Status.PASS,"Successfully Verified all the fields in the Counter configuration-DISK");
					Thread.sleep(2000);
				}catch (Exception e) {
					test.log(Status.FAIL, "Failed verifying the fields in Counter configuration-DISK");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}


				//Verify all fields in Prediction Settings Counter configuration-Memory
				try {
					new ZIFAIPrediction_DeviceConfigPage(driver).CounterconfigMemory_FieldValidation();

					test.log(Status.PASS,"Successfully Verified all the fields in the Counter configuration-Memory");
					Thread.sleep(2000);
				}catch (Exception e) {
					test.log(Status.FAIL, "Failed verifying the fields in Counter configuration-Memory");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}


				//Select any device and Save the Selected counters for CPU DISK and Memory

				try {
					new ZIFAIPrediction_DeviceConfigPage(driver).selectfirstTwodeviceCheckboxs();
					new ZIFAIPrediction_DeviceConfigPage(driver).clickcounterCPU();
					new ZIFAIPrediction_DeviceConfigPage(driver).ClickSave();
					test.log(Status.PASS,"Successfully selected devices and saved in Counter configuration-CPU");
					Thread.sleep(2000);
				}catch (Exception e) {
					test.log(Status.FAIL, "Failed in saving Counter configuration-CPU");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}

				try {
					//new ZIFAIPrediction_DeviceConfigPage(driver).selectfirstTwodeviceCheckboxs();
					new ZIFAIPrediction_DeviceConfigPage(driver).clickcounterDisk();
					new ZIFAIPrediction_DeviceConfigPage(driver).ClickSave();
					test.log(Status.PASS,"Successfully selected devices and saved in Counter configuration-Disk");
					Thread.sleep(2000);
				}catch (Exception e) {
					test.log(Status.FAIL, "Failed in saving Counter configuration-Disk");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}

				try {
					//new ZIFAIPrediction_DeviceConfigPage(driver).selectfirstTwodeviceCheckboxs();
					new ZIFAIPrediction_DeviceConfigPage(driver).clickcounterMemory();
					new ZIFAIPrediction_DeviceConfigPage(driver).ClickSave();
					test.log(Status.PASS,"Successfully selected devices and saved in Counter configuration-Memory");
					Thread.sleep(2000);
				}catch (Exception e) {
					test.log(Status.FAIL, "Failed in saving Counter configuration-Memory");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}




				//Click on Set Polling Interval and Verify all the fields under Set Polling Interval
				try {
					new ZIFAIPrediction_DeviceConfigPage(driver).clickSetpollinginterval();
					new ZIFAIPrediction_DeviceConfigPage(driver).setpollingIntervalFields();

					test.log(Status.PASS,"Successfully Verified all fields in Set Polling Interval");
					Thread.sleep(2000);
				}catch (Exception e) {
					test.log(Status.FAIL, "Failed verifying fields in Set Polling Interval");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}


				//Select any device and select timings for polling
				try {
					//new ZIFAIPrediction_DeviceConfigPage(driver).selectfirstTwodeviceCheckboxs();
					new ZIFAIPrediction_DeviceConfigPage(driver).selectpollingInterval();
					new ZIFAIPrediction_DeviceConfigPage(driver).ClickSave();
					test.log(Status.PASS,"Successfully the polling intervals have been set for the selected devices and Verified");
					Thread.sleep(2000);
					new ZIFAIPrediction_DeviceConfigPage(driver).selectpollingIntervalSetdefault(); 
				}catch (Exception e) {
					test.log(Status.FAIL, "Failed verifying polling interval for the devices");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}



				//Click on Set Polling Interval and Verify all the fields under Threshold configuration
				try {
					new ZIFAIPrediction_DeviceConfigPage(driver).clickThresholdconfig();
					new ZIFAIPrediction_DeviceConfigPage(driver).thresholdconfigFields();

					test.log(Status.PASS,"Successfully Verified all fields in Threshold configuration");
					Thread.sleep(2000);
				}catch (Exception e) {
					test.log(Status.FAIL, "Failed verifying fields in Threshold configuration");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}

				//Select any device and select none for Threshold config
				try {
					new ZIFAIPrediction_DeviceConfigPage(driver).uncheckThresholdcheckboxes(); 
					new ZIFAIPrediction_DeviceConfigPage(driver).selectfirstTwodeviceCheckboxs();
					new ZIFAIPrediction_DeviceConfigPage(driver).ClickSave();
					test.log(Status.PASS,"Successfully the threshold have been set to none for the selected devices and Verified");
					Thread.sleep(2000);
				}catch (Exception e) {
					test.log(Status.FAIL, "Failed selecting devices");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}

				//Again select the same device and select all the threshold options and save
				try {

					new ZIFAIPrediction_DeviceConfigPage(driver).uncheckThresholdcheckboxes(); 
					new ZIFAIPrediction_DeviceConfigPage(driver).selectfirstTwodeviceCheckboxs();
					new ZIFAIPrediction_DeviceConfigPage(driver).ThresholdcheckboxesClick();
					new ZIFAIPrediction_DeviceConfigPage(driver).ClickSave();
					test.log(Status.PASS,"Successfully the threshold have been set for the selected devices and Verified");
					Thread.sleep(2000);
				}catch (Exception e) {
					test.log(Status.FAIL, "Failed selecting devices and Threshold limit");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}

				//close Settings

				try {
					new ZIFAIPredictionPage(driver).closePredictionsettings();

					test.log(Status.PASS,"Successfully Closed the Prediction settings");
					Thread.sleep(2000);
				}catch (Exception e) {
					test.log(Status.FAIL, "Closing Prediction settings failed");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}


			}else {
				test.log(Status.FAIL, "Adaptor status is down");
				System.out.println("Adaptor status is down");
			}

		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.WARNING, "Failed or Adaptor status is down");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}



		// Verify Alerts Settings Page
		try {

			new ZIFAI_AlertsSettingsPage(driver).hoveronAnalyzes();
			new ZIFAI_AlertsSettingsPage(driver).clickRawdata();
			test.log(Status.PASS,"Successfully User is Navigated to Alerts Page");

			//Settings Icon Enabled
			try {
				new ZIFAI_AlertsSettingsPage(driver).alertSettingsEnabled();
				test.log(Status.PASS,"Successfully verified the Alert Settings is Enabled");

				//Click Settings 
				try {						
					new ZIFAI_AlertsSettingsPage(driver).clickSettings();
					test.log(Status.PASS,"Successfully Clicked on the Alert Settings Icon");						
				}catch (AssertionError | Exception e)  {
					test.log(Status.FAIL, "Failed to click settings Icon");
				}

				//Verify fields in Settings page
				try {						
					new ZIFAI_AlertsSettingsPage(driver).Verifyviewsettingspageaccess();
					test.log(Status.PASS,"Successfully Verified all the fields in the Alert Settings Page");						
				}catch (AssertionError | Exception e)  {
					test.log(Status.FAIL, "Failed verifying the fields in Alerts Settings Page");
				}


			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Settings is Disabled");
			}




		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Failed in Selecting Analytics from Analyzes");

		}

		//--------------------Enter Alerts Code Here-------------------------


		//------------------------------------------------------------



		//Logout of Application
		try {
			new ZIFAIDashboardPage(driver).LogoutClick();
			test.log(Status.PASS,"Successfully Logged out from Dashboard Page");
		}catch (Exception e) {
			test.log(Status.FAIL, "Dashboard page Logout failed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


	}}
