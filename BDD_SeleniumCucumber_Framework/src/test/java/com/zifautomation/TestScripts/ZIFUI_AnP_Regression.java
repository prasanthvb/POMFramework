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
import com.zifautomation.Pages.ZIFAI_CaseManagementPage;
import com.zifautomation.Utility.BrowserUtility;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.ExcelHandler;
import com.zifautomation.Utility.PropertiesFileReader;
import com.zifautomation.Utility.TestDataHandler;


public class ZIFUI_AnP_Regression extends Base{

	WebDriverWait wait1=null;


	@Test
	public void ZIFUI_AnP_RegressionTestcase() throws IOException, InterruptedException {


		//Report 

		test = extent.createTest("ZIFAI A&P Regression");
		test.createNode("ZIFAI A&P Regression");


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


			
			//-------------------------------------------------------------------------------------------------------------
			//-----------------------------------------------Filter--------------------------------------------------------
			//-------------------------------------------------------------------------------------------------------------
			
			//verify Filter option is Displayed
			try {
				Thread.sleep(3000);
				new ZIFAIPrediction_FilterPage(driver).Filteroptiondisplayed();
				test.log(Status.PASS,"Filter icon is present in the Prediction screen");
			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Filter icon is not present in the Prediction screen");
			}



			//Click on Filter and Verify the fields
			try {
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).clickFilter();
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).verifyFilteroptions();
				test.log(Status.PASS,"Filter Popup is displayed with the below options.\r\n" + 
						" - Filter-Title\r\n" + 
						" - Opportunity ID\r\n" + 
						" - Device Name\r\n" + 
						" - Resource Group\r\n" + 
						" - Counters \r\n" + 
						" - Drive / Mount Name\r\n" + 
						"along with Apply and Clear button\r\n" + 
						"X icon\r\n" + 
						"");
			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Filter option field validation failed");
			}




			//Verify that the Counter and Driver / Mount drop down is Disabled

			try {
				new ZIFAIPrediction_FilterPage(driver).verifycounterdropdowndisabled();
				new ZIFAIPrediction_FilterPage(driver).verifydrivedropdowndisabled();
				test.log(Status.PASS,"Counter and Driver / Mount drop down are Disabled");
			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Counter and Driver / Mount drop down are enabled");
			}


			//Verify the Resource Group dropdown

			try {
				new ZIFAIPrediction_FilterPage(driver).ClickResourceGroupdropdown();
				new ZIFAIPrediction_FilterPage(driver).verifyResourcedropdownfields();
				test.log(Status.PASS,"Below are the static values displayed in resource group\r\n" + 
						" - cpu\r\n" + 
						" - memory\r\n" + 
						" - disk\r\n" + 
						" - network");
			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Resource Group drop down field validation failed");
			}


			//Select the Resource Type as "CPU/Memory/Network/Disk" and Verify Drive/Mount Name drop down should be disabled and Counters drop down is enabled

			try {
				new ZIFAIPrediction_FilterPage(driver).selectCPUResource();
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).verifycounterdropdownenabled();
				new ZIFAIPrediction_FilterPage(driver).verifydrivedropdowndisabled();
				test.log(Status.PASS,"Drive / Mount Name drop down is disabled and Counters drop down is enabled on Selecting Resource Groups as CPU");
			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Drive / Mount Name drop down and Counters drop downs behaviour on Selecting Resource Groups as CPU failed");
			}

			try {

				new ZIFAIPrediction_FilterPage(driver).ClickResourceGroupdropdown();
				new ZIFAIPrediction_FilterPage(driver).selectMemoryResource();
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).verifycounterdropdownenabled();
				new ZIFAIPrediction_FilterPage(driver).verifydrivedropdowndisabled();
				test.log(Status.PASS,"Drive / Mount Name drop down is disabled and Counters drop down is enabled on Selecting Resource Groups as Memory");
			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Drive / Mount Name drop down and Counters drop downs behaviour on Selecting Resource Groups as Memory failed");
			}

			
			try {
				new ZIFAIPrediction_FilterPage(driver).ClickResourceGroupdropdown();
				new ZIFAIPrediction_FilterPage(driver).selecDiskResource();
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).verifycounterdropdownenabled();
				new ZIFAIPrediction_FilterPage(driver).verifydrivedropdowndisabled();
				test.log(Status.PASS,"Drive / Mount Name drop down is disabled and Counters drop down is enabled on Selecting Resource Groups as Disk");
			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Drive / Mount Name drop down and Counters drop downs behaviour on Selecting Resource Groups as Disk failed");
			}


			//Enter Device Name and Verify that Drive / Mount Name drop down is enabled
			try {

				String deviceName = testdata.getTestDataInMap().get("ValidDeviceName");
				new ZIFAIPrediction_FilterPage(driver).enterDeviceNamevalue(deviceName);
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).verifydrivedropdownenabled();
				test.log(Status.PASS,"Drive / Mount Name drop down is enabled On Entering Device Name for Disk");
			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Drive / Mount Name drop down is Disabled On Entering Device Name for Disk");
			}


			//Enter Device Name and Verify that Drive / Mount Name drop down is enabled
			try {
				new ZIFAIPrediction_FilterPage(driver).ClickResourceGroupdropdown();
				new ZIFAIPrediction_FilterPage(driver).selectCPUResource();
				Thread.sleep(2000);
				String deviceName = testdata.getTestDataInMap().get("ValidDeviceName");
				new ZIFAIPrediction_FilterPage(driver).enterDeviceNamevalue(deviceName);
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).ApplyButton();
				new ZIFAIPrediction_FilterPage(driver).VerifyDeviceNameoppCardOnFilter(deviceName);
				test.log(Status.PASS,"Filter is applied successfully for Valid Device Name");
			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Filter is failed for Valid Device Name or Cards not available");
			}



			//Enter InValid Device Name and click on Apply button and verify the Filter is applied and NO DATA AVAILABLE is Displayed
			try {
				new ZIFAIPrediction_FilterPage(driver).clickFilter();
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).ClearButton();
				Thread.sleep(2000);
				
				String deviceName = testdata.getTestDataInMap().get("InvalidDeviceName");
				new ZIFAIPrediction_FilterPage(driver).enterDeviceNamevalue(deviceName);
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).ApplyButton();
				new ZIFAIPrediction_FilterPage(driver).VerifyNoDATAforInvalidFilter();
				test.log(Status.PASS,"Filter is applied successfully for InValid Device Name and NO DATA AVAILABLE is found");
			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Filter is failed for InValid Device Name or Cards are available");
			}


			//Enter Valid OPP ID and click on Apply button and verify the Filter is applied
			try {
				new ZIFAIPrediction_FilterPage(driver).clickFilter();
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).ClearButton();
				Thread.sleep(2000);
				
				String oppId = testdata.getTestDataInMap().get("ValidOppID");
				new ZIFAIPrediction_FilterPage(driver).enterOppcardvalue(oppId);
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).ApplyButton();
				new ZIFAIPrediction_FilterPage(driver).VerifyOPPIDoppCardOnFilter(oppId);
				test.log(Status.PASS,"Filter is applied successfully for Valid Opp Card ID");
			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Filter is failed for Valid Opp ID or Cards not available");
			}

			//Enter InValid OPP ID and click on Apply button and verify the Filter is applied and NO DATA AVAILABLE is Displayed
			try {
				new ZIFAIPrediction_FilterPage(driver).clickFilter();
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).ClearButton();
				Thread.sleep(2000);
				
				String oppId = testdata.getTestDataInMap().get("InvalidOppID");
				new ZIFAIPrediction_FilterPage(driver).enterOppcardvalue(oppId);
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).ApplyButton();
				new ZIFAIPrediction_FilterPage(driver).VerifyNoDATAforInvalidFilter();
				test.log(Status.PASS,"Filter is applied successfully for InValid Opp Card ID and NO DATA AVAILABLE is found");
			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Filter is failed for InValid Opp ID or Cards are available");
			}


			//Select Resource Group as CPU and any Counters and Click on Apply button

			try {
				new ZIFAIPrediction_FilterPage(driver).clickFilter();
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).ClearButton();
				Thread.sleep(2000);
				

				new ZIFAIPrediction_FilterPage(driver).ClickResourceGroupdropdown();
				new ZIFAIPrediction_FilterPage(driver).selectCPUResource();
				Thread.sleep(2000);

				new ZIFAIPrediction_FilterPage(driver).ClickCountersdropdown();
				new ZIFAIPrediction_FilterPage(driver).selectCPUcounter();
				Thread.sleep(2000);

				String counter = testdata.getTestDataInMap().get("CPUcounter");

				new ZIFAIPrediction_FilterPage(driver).ApplyButton();
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).VerifyDeviceNameoppCardOnFilter(counter);

				test.log(Status.PASS,"Filter is applied successfully for CPU and counters and  Valid Opp Card ID are displayed");
			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Filter is failed for InValid Opp ID or Cards not available");
			}



			//Select Resource Group as Memory and any Counters and Click on Apply button

			try {
				new ZIFAIPrediction_FilterPage(driver).clickFilter();
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).ClearButton();
				Thread.sleep(2000);

				new ZIFAIPrediction_FilterPage(driver).ClickResourceGroupdropdown();
				new ZIFAIPrediction_FilterPage(driver).selectMemoryResource();
				Thread.sleep(2000);

				new ZIFAIPrediction_FilterPage(driver).ClickCountersdropdown();
				new ZIFAIPrediction_FilterPage(driver).selectMemorycounter();
				Thread.sleep(2000);

				String counter = testdata.getTestDataInMap().get("Memorycounter");

				new ZIFAIPrediction_FilterPage(driver).ApplyButton();
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).VerifyDeviceNameoppCardOnFilter(counter);

				test.log(Status.PASS,"Filter is applied successfully for Memory and counters and Valid Opp Card ID are displayed");
			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Filter is failed for InValid Opp ID or Cards not available");
			}


			//Select Resource Group as Disk and any Counters and Click on Apply button

			try {
				new ZIFAIPrediction_FilterPage(driver).clickFilter();
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).ClearButton();
				Thread.sleep(2000);

				new ZIFAIPrediction_FilterPage(driver).ClickResourceGroupdropdown();
				new ZIFAIPrediction_FilterPage(driver).selecDiskResource();
				Thread.sleep(2000);

				new ZIFAIPrediction_FilterPage(driver).ClickCountersdropdown();
				new ZIFAIPrediction_FilterPage(driver).selectDiskcounter();
				Thread.sleep(2000);

				String counter = testdata.getTestDataInMap().get("Diskcounter");

				new ZIFAIPrediction_FilterPage(driver).ApplyButton();
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).VerifyDeviceNameoppCardOnFilter(counter);

				test.log(Status.PASS,"Filter is applied successfully for Disk and counters and Valid Opp Card ID are displayed");
			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Filter is failed for InValid Opp ID or Cards not available");
			}

			try {
				new ZIFAIPrediction_FilterPage(driver).clickFilter();
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).ClearButton();
				new ZIFAIPrediction_FilterPage(driver).closeFilter();
				Thread.sleep(2000);
			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Filter is failed for InValid Opp ID or Cards not available");
			}
			
			//-------------------------------------------------------------------------------------------------------------------------------------------------
			//-------------------------------------------------------------------------------------------------------------------------------------------------
			//-------------------------------------------------------------------------------------------------------------------------------------------------

			
			
		//	Usha Code
			//Verify user is able to click on Export to Excel under Predicted Risk
			/*try {
					new ZIFAI_Prediction_ExportToExcel(driver).clickonexportunderPredictedRiskcard();
					test.log(Status.PASS,"User is successfully clicked on export to excel under PRC ");
					Thread.sleep(2000);
				} catch (AssertionError | Exception e) {
					//e.printStackTrace();
					test.log(Status.FAIL, "User is not able click on export to excel under PRC");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				

		//Verify user is able to click on Export to Excel under Critical
				try {
					new ZIFAI_Prediction_ExportToExcel(driver).clickonexportunderCritical();
					test.log(Status.PASS,"User is successfully clicked on export to excel under CRL ");
					Thread.sleep(2000);
				} catch (AssertionError | Exception e) {
					//e.printStackTrace();
					test.log(Status.FAIL, "User is not able click on export to excel under CRL");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}

		//Verify user is able to click on Export to Excel under Processed
						try {
							new ZIFAI_Prediction_ExportToExcel(driver).clickonexportunderProcessed();
							test.log(Status.PASS,"User is successfully clicked on export to excel under Processed ");
							Thread.sleep(2000);
						} catch (AssertionError | Exception e) {
							//e.printStackTrace();
							test.log(Status.FAIL, "User is not able click on export to excel under Processed");
							test.addScreenCaptureFromPath(captureScreenShot(driver));
					
		*/
				
				
				
				//Verify user is able to click on Export to Excel under Lost
						try {
						//	new ZIFAI_Prediction_ExportToExcel(driver).clickonexportunderLost();
							String dirPath = "C:\\Users\\usha.thangavelu\\Downloads";
							new CommonMethods(driver);
							CommonMethods.isFileDownloaded(dirPath,"usha");
							test.log(Status.PASS,"User is successfully clicked on export to excel under Lost ");
							Thread.sleep(2000);
						} 
						catch (AssertionError | Exception e1) {
							e1.printStackTrace();
							test.log(Status.FAIL, "User is not able click on export to excel under Lost");
							test.addScreenCaptureFromPath(captureScreenShot(driver));
						}

		//Verify user is able to click on Export to Excel under Invalid
						try {
						//	new ZIFAI_Prediction_ExportToExcel(driver).clickonexportunderInvalid();
							test.log(Status.PASS,"User is successfully clicked on export to excel under Invalid ");
							Thread.sleep(2000);
						} 
						catch (AssertionError | Exception e2)
						{
							e2.printStackTrace();
							test.log(Status.FAIL, "User is not able click on export to excel under Invalid");
							test.addScreenCaptureFromPath(captureScreenShot(driver));
						}
			
			
			
			
			
			//-------------------------------------------------------------------------------------------------------------------------------------------------
			//-------------------------------------------------------------------------------------------------------------------------------------------------
			//-------------------------------------------------------------------------------------------------------------------------------------------------



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
				
				// Edit and Assign Status and verify
				try {					
					new ZIFAI_CaseManagementPage(driver).ClickFirstAlert();
					Thread.sleep(2000);
					new ZIFAI_CaseManagementPage(driver).ClickEditandAssignNew();					
					test.log(Status.PASS,"Successfully Edited the Alert with New Status and Verified");					
				}catch (AssertionError | Exception e)  {
					test.log(Status.FAIL, "Failed to verify the New Alerts Status update");
				}
				
				try {					
					new ZIFAI_CaseManagementPage(driver).ClickFirstAlert();
					Thread.sleep(2000);
					new ZIFAI_CaseManagementPage(driver).ClickEditandAssignAssigned();					
					test.log(Status.PASS,"Successfully Edited the Alert with Assigned Status and Verified");					
				}catch (AssertionError | Exception e)  {
					test.log(Status.FAIL, "Failed to verify the Assigned Alerts Status update");
				}
				
				try {					
					new ZIFAI_CaseManagementPage(driver).ClickFirstAlert();
					Thread.sleep(2000);
					new ZIFAI_CaseManagementPage(driver).ClickEditandAssignInprogress();					
					test.log(Status.PASS,"Successfully Edited the Alert with InProgress Status and Verified");					
				}catch (AssertionError | Exception e)  {
					test.log(Status.FAIL, "Failed to verify the InProgress Alerts Status update");
				}
				
				try {					
					new ZIFAI_CaseManagementPage(driver).ClickFirstAlert();
					Thread.sleep(2000);
					new ZIFAI_CaseManagementPage(driver).ClickEditandAssignClosed();
					
					test.log(Status.PASS,"Successfully Edited the Alert with Closed Status and Verified");
					//Added Here
					new ZIFAI_CaseManagementPage(driver).AlertDetailsClose();
				}catch (AssertionError | Exception e)  {
					test.log(Status.FAIL, "Failed to verify the Closed Alerts Status update");
				}
				
				
				
				//Check Preference AND Filter changes
				
				try {					
					new ZIFAI_CaseManagementPage(driver).ClickFirstAlert();
					Thread.sleep(2000);
					new ZIFAI_CaseManagementPage(driver).ClickEditandAssignClosed();
					
					test.log(Status.PASS,"Successfully verified Severity for Preference First and Filter Next");
					//Added Here
					new ZIFAI_CaseManagementPage(driver).AlertDetailsClose();
				}catch (AssertionError | Exception e)  {
					test.log(Status.FAIL, "Failed to verify the Closed Alerts Status update");
				}
				
				
				
				
				
			} catch (AssertionError | Exception e) {
				e.printStackTrace();
				test.log(Status.FAIL, "Failed in Selecting Analytics from Analyzes");

			}
			




			//Logout of Application
			try {
				new ZIFAIDashboardPage(driver).LogoutClick();
				test.log(Status.PASS,"Successfully Logged out from Dashboard Page");
			}catch (Exception e) {
				test.log(Status.FAIL, "Dashboard page Logout failed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

			
			}

	}
