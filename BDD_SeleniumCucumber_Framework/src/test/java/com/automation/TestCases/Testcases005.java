package com.automation.TestCases;

import static junit.framework.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automation.Base.Base;
import com.automation.Pages.Loginfunction;
import com.automation.Pages.CatalogHomePage;
import com.automation.Pages.CatalogQuestionnairePage;
import com.automation.Utility.BrowserUtility;
import com.automation.Utility.CommonMethods;
import com.automation.Utility.ExcelHandler;
import com.automation.Utility.PropertiesFileReader;
import com.automation.Utility.TestDataHandler;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Testcases005 extends Base {

	// PreRequsite
	PropertiesFileReader obj = new PropertiesFileReader();
	Properties properties = null;

	@Test(enabled = true)
	public void ZIFcatalogHomepage() throws IOException, InterruptedException {

		// Report

		test = extent.createTest("ZIFcatalog Home Page Valiation");
		test.createNode("ZIFcatalog Home Page Valiation");

		// Verify valid UserName and valid Password
		try {
			String UserName = testdata.getTestDataInMap().get("UserName");
			String Password = testdata.getTestDataInMap().get("Password");
			new Loginfunction(driver).Enterthecredentials(UserName, Password);

			test.log(Status.PASS, "Valid UserName and Valid Password has been entered and Verified");

			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Valid credentials verification failed");

		}

		// Verify the all the fields
		// Verify the all the fields in ZIF Catalog Homepage
		try {

			new CatalogHomePage(driver).VerifyallfieldsInZIFcatalogHomePage();

			Thread.sleep(2000);
			test.log(Status.PASS, "Successfully verified ZIF Catalog Home Page fields ");

		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Failed to check the ZIF Catalog Homepage ");

		}

	}

	@Test(enabled = true)
	public void zifcatalogBusiness_TechnicalOutcomes() throws IOException, InterruptedException {

		test = extent.createTest("ZIFcatalog Home Page Business and Technical outcomes");
		test.createNode("ZIFcatalog Home Page Business and Technical outcomes");

		// Verify valid UserName and valid Password
		try {
			String UserName = testdata.getTestDataInMap().get("UserName");
			String Password = testdata.getTestDataInMap().get("Password");
			new Loginfunction(driver).Enterthecredentials(UserName, Password);

			test.log(Status.PASS, "Valid UserName and Valid Password has been entered and Verified");

			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Valid credentials verification failed");

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
		}

		// Verify OPEX Optimization in business outcomes
		try {

			new CatalogHomePage(driver).oPEXOptimizationcbxClick();
			new CatalogHomePage(driver).OPEX_Optimizationtechnicaloutcomes();
			test.log(Status.PASS, "Successfully verified Opex optimization technical outcomes ");
			new CatalogHomePage(driver).oPEXOptimizationcbxClick();
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, e);
		}

		// Verify Blueprinting Enterprise in business outcomes
		try {

			new CatalogHomePage(driver).blueprintingEnterprisecbxClick();
			new CatalogHomePage(driver).Blueprinting_Enterprisetechnicaloutcomes();
			test.log(Status.PASS, "Successfully verified Blueprinting Enterprise technical outcomes ");
			new CatalogHomePage(driver).blueprintingEnterprisecbxClick();
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, e);
		}

		// Verify Compute Utilization & Optimization in business outcomes
		try {

			new CatalogHomePage(driver).computeUtilizationcbxClick();
			new CatalogHomePage(driver).Optimization_of_Computetechnicaloutcomes();
			test.log(Status.PASS, "Successfully verified Compute Utilization & Optimization technical outcomes ");
			new CatalogHomePage(driver).computeUtilizationcbxClick();
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, e);
		}

		// Verify Improvement in User Experience in business outcomes
		try {

			new CatalogHomePage(driver).improvementInUsercbxClick();
			new CatalogHomePage(driver).Improvement_in_User_Experiencetechnicaloutcomes();
			test.log(Status.PASS, "Successfully verified Improvement in User Experience technical outcomes ");
			new CatalogHomePage(driver).improvementInUsercbxClick();
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, e);
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
		}

		// Verify Shift Left in business outcomes
		try {

			new CatalogHomePage(driver).improvementInBusinesscbxClick();
			new CatalogHomePage(driver).CAPEX_Optimizationtechnicaloutcomes();
			test.log(Status.PASS, "Successfully verified Shift Left technical outcomes ");
			new CatalogHomePage(driver).improvementInBusinesscbxClick();
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, e);
		}

		// Verify Eliminating Digital Dirt in business outcomes
		try {

			new CatalogHomePage(driver).eliminatingDigitalDirtcbxClick();
			new CatalogHomePage(driver).Eliminating_Digital_Dirttechnicaloutcomes();
			test.log(Status.PASS, "Successfully verified Eliminating Digital Dirt technical outcomes ");
			new CatalogHomePage(driver).eliminatingDigitalDirtcbxClick();
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, e);
		}

		// Verify Improvement in Application Availability in business outcomes
		try {

			new CatalogHomePage(driver).improvementInApplicationcbxClick();
			new CatalogHomePage(driver).Improvement_in_Application_Availabilitytechnicaloutcomes();
			test.log(Status.PASS, "Successfully verified Improvement in Application Availability technical outcomes ");
			new CatalogHomePage(driver).improvementInApplicationcbxClick();
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, e);
		}

	}

	@Test(enabled = true)
	public void zifcatalog_Need_help_panel() throws IOException, InterruptedException {

		test = extent.createTest("ZIFcatalog Need help panel Verifications");
		test.createNode("ZIFcatalog Need help panel Verifications");

		// Verify valid UserName and valid Password
		try {
			String UserName = testdata.getTestDataInMap().get("UserName");
			String Password = testdata.getTestDataInMap().get("Password");
			new Loginfunction(driver).Enterthecredentials(UserName, Password);

			test.log(Status.PASS, "Valid UserName and Valid Password has been entered and Verified");

			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Valid credentials verification failed");

		}

		// Verify Need help in choosing the right business outcome? panel
		try {

			new CatalogHomePage(driver).Click_on_need_help_link();

			test.log(Status.PASS,
					"Successfully verified Need help panel on clicking 'Need help in choosing the right business outcome?' link in homepage  ");

		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, e);
		}

		// Click on all the options in the Needhelp Panel and click on save button

		try {

			new CatalogHomePage(driver).SelectalloptionsinNeedhelp();
			new CatalogHomePage(driver).needhelpSave();

			test.log(Status.PASS,
					"Successfully selected all the options in 'Need help in choosing the right business outcome?' and Saved  ");

		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, e);
		}

	}

	@Test(enabled = true)
	public void zifQuestionnairePageVerifications() throws IOException, InterruptedException {

		test = extent.createTest("ZIFcatalog ZIF questionnaire page Verifications");
		test.createNode("ZIFcatalog ZIF questionnaire page Verifications");

		// Verify valid UserName and valid Password
		try {
			String UserName = testdata.getTestDataInMap().get("UserName");
			String Password = testdata.getTestDataInMap().get("Password");
			new Loginfunction(driver).Enterthecredentials(UserName, Password);

			test.log(Status.PASS, "Valid UserName and Valid Password has been entered and Verified");

			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Valid credentials verification failed");

		}

		// Verify CAPEX Optimization in business outcomes
		try {

			new CatalogHomePage(driver).UnselectAllBusinessoutcomes();
			new CatalogHomePage(driver).cAPEXOptimizationcbxClick();
			// new ZIFCatalogHomePage(driver).CAPEX_Optimizationtechnicaloutcomes();
			test.log(Status.PASS, "Successfully Selected Capex optimization in Business outcomes ");
			// new ZIFCatalogHomePage(driver).cAPEXOptimizationcbxClick();
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, e);
		}

		// Verify OPEX Optimization in business outcomes
		try {

			new CatalogHomePage(driver).oPEXOptimizationcbxClick();
			// new ZIFCatalogHomePage(driver).OPEX_Optimizationtechnicaloutcomes();
			test.log(Status.PASS, "Successfully Selected Opex optimization in Business outcomes ");
			// new ZIFCatalogHomePage(driver).oPEXOptimizationcbxClick();
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, e);
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
			test.log(Status.PASS, "Successfully Entered invalid details in ZIF questionnaire page Verified");

		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, e);
		}

		// Enter all the details in ZIF questionnaire page and click on Build Package
		// button

		try {
			String devices = testdata.getTestDataInMap().get("Devices");
			String apps = testdata.getTestDataInMap().get("Applications");
			String tools = testdata.getTestDataInMap().get("Tools");
			String alerts = testdata.getTestDataInMap().get("Alerts");

			new CatalogQuestionnairePage(driver).enterOnRequired(devices, apps, tools, alerts);
			Thread.sleep(2000);
			new CatalogQuestionnairePage(driver).click_on_BuildPackage();
			Thread.sleep(3000);
			test.log(Status.PASS,
					"Successfully Entered all the details in ZIF questionnaire page and click on Build Package button");

		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, e);
		}

		// Click on Logout button
		try {
			Thread.sleep(2000);
			WebElement LogoutZIFcatalog = driver.findElement(By.xpath("//span[contains(@class,'cp-user')]"));
			assertTrue(LogoutZIFcatalog.isDisplayed());
			LogoutZIFcatalog.click();
			test.log(Status.PASS, "Successfully Logged out of ZIFcatalog Portal ");

		} catch (AssertionError | Exception e) {

			test.log(Status.FAIL, "Logout failed");
		}

	}
}
