package com.automation.TestScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automation.Base.Base;
import com.automation.Pages.CatalogHomePage;
import com.automation.Pages.CatalogQuestionnairePage;
import com.automation.Pages.Loginfunction;
import com.aventstack.extentreports.Status;

public class CatalogRegression extends Base {

	@Test
	public void ZIFCatalogRegressionTestcase() throws IOException {

		// Report

		test = extent.createTest("ZIF catalog Regression");
		test.createNode("ZIF Catalog Regression");

		// Verify all the fields in Login Page

		try {
			new Loginfunction(driver).Check_all_fields_are_present();
			test.log(Status.PASS, "Successfully verified all the fields in Login Page");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Login page field validation failed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// Verify Invalid UserName and Invalid Password
		try {
			String UserName = testdata.getTestDataInMap().get("InvalidUsername");
			String Password = testdata.getTestDataInMap().get("InvalidPassword");
			new Loginfunction(driver).Enterthecredentials(UserName, Password);
			new Loginfunction(driver).getTextOfInvalidUsernameOrpassword();

			test.log(Status.PASS, "Invalid UserName and Invalid Password has been entered and Verified");

			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Invalid credentials verification failed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// Login to the CMP Portal With valid credentials
		try {
			String UserName1 = testdata.getTestDataInMap().get("UserName");
			String Password1 = testdata.getTestDataInMap().get("Password");
			new Loginfunction(driver).Enterthecredentials(UserName1, Password1);
			/*
			 * WebElement Logout1 =
			 * driver.findElement(By.xpath("//span[contains(@class,'cp-user')]"));
			 * if(Logout1.isDisplayed()) { Logout1.click(); Thread.sleep(2000); new
			 * Loginfunction(driver) .Enterthecredentials(UserName1, Password1); }
			 */
			test.log(Status.PASS, "Valid credential has been entered, Logged in Successfully");
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Login failed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// Verify the all the fields in ZIF Catalog Homepage
		try {

			new CatalogHomePage(driver).VerifyallfieldsInZIFcatalogHomePage();

			Thread.sleep(2000);
			test.log(Status.PASS, "Successfully verified ZIF Catalog Home Page fields ");
			System.out.println("User is in ZIF Catalog Home Page");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Failed to check the ZIF Catalog Homepage ");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// Verify CAPEX Optimization in business outcomes
		try {

			new CatalogHomePage(driver).UnselectAllBusinessoutcomes();
			new CatalogHomePage(driver).cAPEXOptimizationcbxClick();
			new CatalogHomePage(driver).CAPEX_Optimizationtechnicaloutcomes();
			test.log(Status.PASS, "Successfully verified Capex optimization technical outcomes ");
			new CatalogHomePage(driver).cAPEXOptimizationcbxClick();
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// Verify OPEX Optimization in business outcomes
		try {

			new CatalogHomePage(driver).oPEXOptimizationcbxClick();
			new CatalogHomePage(driver).OPEX_Optimizationtechnicaloutcomes();
			test.log(Status.PASS, "Successfully verified Opex optimization technical outcomes ");
			new CatalogHomePage(driver).oPEXOptimizationcbxClick();
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// Verify Blueprinting Enterprise in business outcomes
		try {

			new CatalogHomePage(driver).blueprintingEnterprisecbxClick();
			new CatalogHomePage(driver).Blueprinting_Enterprisetechnicaloutcomes();
			test.log(Status.PASS, "Successfully verified Blueprinting Enterprise technical outcomes ");
			new CatalogHomePage(driver).blueprintingEnterprisecbxClick();
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// Verify Compute Utilization & Optimization in business outcomes
		try {

			new CatalogHomePage(driver).computeUtilizationcbxClick();
			new CatalogHomePage(driver).Optimization_of_Computetechnicaloutcomes();
			test.log(Status.PASS, "Successfully verified Compute Utilization & Optimization technical outcomes ");
			new CatalogHomePage(driver).computeUtilizationcbxClick();
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// Verify Improvement in User Experience in business outcomes
		try {

			new CatalogHomePage(driver).improvementInUsercbxClick();
			new CatalogHomePage(driver).Improvement_in_User_Experiencetechnicaloutcomes();
			test.log(Status.PASS, "Successfully verified Improvement in User Experience technical outcomes ");
			new CatalogHomePage(driver).improvementInUsercbxClick();
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		// Verify Improvement in Business Service Assurance in business outcomes
		try {

			new CatalogHomePage(driver).improvementInBusinesscbxClick();
			new CatalogHomePage(driver).CAPEX_Optimizationtechnicaloutcomes();
			test.log(Status.PASS,
					"Successfully verified Improvement in Business Service Assurance technical outcomes ");
			new CatalogHomePage(driver).improvementInBusinesscbxClick();
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// Verify Shift Left in business outcomes
		try {

			new CatalogHomePage(driver).improvementInBusinesscbxClick();
			new CatalogHomePage(driver).CAPEX_Optimizationtechnicaloutcomes();
			test.log(Status.PASS, "Successfully verified Shift Left technical outcomes ");
			new CatalogHomePage(driver).improvementInBusinesscbxClick();
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// Verify Eliminating Digital Dirt in business outcomes
		try {

			new CatalogHomePage(driver).eliminatingDigitalDirtcbxClick();
			new CatalogHomePage(driver).Eliminating_Digital_Dirttechnicaloutcomes();
			test.log(Status.PASS, "Successfully verified Eliminating Digital Dirt technical outcomes ");
			new CatalogHomePage(driver).eliminatingDigitalDirtcbxClick();
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// Verify Improvement in Application Availability in business outcomes
		try {

			new CatalogHomePage(driver).improvementInApplicationcbxClick();
			new CatalogHomePage(driver).Improvement_in_Application_Availabilitytechnicaloutcomes();
			test.log(Status.PASS, "Successfully verified Improvement in Application Availability technical outcomes ");
			new CatalogHomePage(driver).improvementInApplicationcbxClick();
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// Verify Need help in choosing the right business outcome? panel
		try {

			new CatalogHomePage(driver).Click_on_need_help_link();

			test.log(Status.PASS,
					"Successfully verified Need help panel on clicking 'Need help in choosing the right business outcome?' link in homepage  ");

		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// Click on all the options in the Needhelp Panel and click on save button

		try {

			new CatalogHomePage(driver).SelectalloptionsinNeedhelp();
			new CatalogHomePage(driver).needhelpSave();

			test.log(Status.PASS,
					"Successfully selected all the options in 'Need help in choosing the right business outcome?' and Saved  ");

		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// Select Control Cloud Sprawl in business outcomes and click on Proceed button
		try {

			new CatalogHomePage(driver).controlCloudSprawlcbxClick();
			Thread.sleep(2000);
			new CatalogHomePage(driver).proceedbutton();
			Thread.sleep(3000);
			test.log(Status.PASS,
					"Successfully Selected Control Cloud Sprawl in business outcomes and click on Proceed button  ");

		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// Verify all the fields in ZIF questionnaire page
		try {

			new CatalogQuestionnairePage(driver).verify_all_fields();
			Thread.sleep(2000);

			test.log(Status.PASS, "Successfully verified all the fields in ZIF questionnaire page");
			System.out.println("User is in ZIF questionnaire page");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// Enter all the invalid details in ZIF questionnaire page and click on Build
		// Package button

		try {
			String tdevices = testdata.getTestDataInMap().get("TextDevices");
			String tapps = testdata.getTestDataInMap().get("TextApplications");
			String ttools = testdata.getTestDataInMap().get("TextTools");
			String talerts = testdata.getTestDataInMap().get("TextAlerts");

			new CatalogQuestionnairePage(driver).enterOnRequired(tdevices, tapps, ttools, talerts);
			Thread.sleep(2000);
			new CatalogQuestionnairePage(driver).click_on_BuildPackage();
			Thread.sleep(3000);
			test.log(Status.PASS, "Successfully Entered invalid details in ZIF questionnaire page and verified");

		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// Enter all the details in ZIF questionnaire page and click on Build Package
		// button

		try {
			String devices = testdata.getTestDataInMap().get("Devices");
			String apps = testdata.getTestDataInMap().get("Applications");
			String tools = testdata.getTestDataInMap().get("Tools");
			String alerts = testdata.getTestDataInMap().get("Alerts");
			String deploymenttype = testdata.getTestDataInMap().get("deploymentType");
			new CatalogQuestionnairePage(driver).enterOnRequired(devices, apps, tools, alerts);
			Thread.sleep(2000);
			new CatalogQuestionnairePage(driver).selectdeployment(deploymenttype);
			Thread.sleep(2000);
			new CatalogQuestionnairePage(driver).click_on_BuildPackage();
			Thread.sleep(3000);
			test.log(Status.PASS,
					"Successfully Entered all the details in ZIF questionnaire page and click on Build Package button");

		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// Verify build is downloaded

		try {
			new CatalogQuestionnairePage(driver).downloadedImg();
			test.log(Status.PASS, "Successfully the build package is downloaded");
			System.out.println("User is in package download success page");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// Logout of Application
		try {

			Thread.sleep(2000);

			WebElement Logout = driver.findElement(By.xpath("//span[contains(@class,'cp-user')]"));

			Logout.click();
			Thread.sleep(2000);
			test.log(Status.PASS, "Successfully Logged out of ZIF catalog Application");

		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

	}
}
