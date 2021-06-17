package com.zifautomation.TestCases;

import static junit.framework.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import com.zifautomation.Pages.ZIFAI_CaseManagementPage;
import com.zifautomation.Utility.BrowserUtility;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.ExcelHandler;
import com.zifautomation.Utility.PropertiesFileReader;
import com.zifautomation.Utility.TestDataHandler;

import bsh.Console;

public class ZIFUI_Testcases102 extends Base {

	// PreRequsite
	PropertiesFileReader obj= new PropertiesFileReader();
	Properties properties = null;



	@Test(enabled = true)
	public void ZIFUICase_Management_Suppression() throws IOException, InterruptedException {

		//Report 

		test = extent.createTest("ZIF UI Case Management Suppression");
		test.createNode("ZIF UI Case Management Suppression");

		//Verify valid UserName and valid Password
		try {
			String UserName = testdata.getTestDataInMap().get("UserName");
			String Password = testdata.getTestDataInMap().get("Password");

			new Loginfunction(driver)
			.Enterthecredentials(UserName, Password);
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Login failed");

		}

		// Verify User is in ZIF UI Home Page

		try {
			String ExpectedTitle = "ZIF";
			String ActualTitle = driver.getTitle();
			assertEquals(ExpectedTitle, ActualTitle);
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Login failed");

		}


		// Verify all fields in ZIF UI dashboard page
		try {

			new ZIFAIDashboardPage(driver).hoveronAnalyzes();
			new ZIFAIDashboardPage(driver).clickAnalytics();




			//Turn off Live Feed
			try {
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).Turnofflivefeed();
				test.log(Status.PASS,"Live Feed Is Turned Off");
			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Live Feed is off");
			}



			//Verify multiple description 
			try {
				
				new ZIFAI_CaseManagementPage(driver).ClickonanyAlertswith5or4or3();
				Thread.sleep(2000);
				test.log(Status.PASS,"Verified Expand and Collapse of Alert model");
				test.log(Status.PASS,"Verified Same Descriptions on correlated Alerts section");
				test.log(Status.PASS,"Verified Same Descriptions on TimeLine section");
				
			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Failed to check the Description of the Alerts");
			}





			//Logout of Application 
			try { new ZIFAIDashboardPage(driver).LogoutClick();
			test.log(Status.PASS,"Successfully Logged out "); }catch
			(AssertionError | Exception e) { test.log(Status.FAIL,
					"Dashboard page Logout failed"); }


		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Failed in Selecting Analytics from Analyzes");

		}



	}

}




