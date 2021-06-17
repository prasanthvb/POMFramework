package com.zifautomation.TestCases;
import com.aventstack.extentreports.Status;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAIDashboardPage;
import com.zifautomation.Utility.PropertiesFileReader;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

import static org.testng.Assert.assertEquals;

public class ZIFUI_Testcases101 extends Base {

    // PreRequsite
    PropertiesFileReader obj = new PropertiesFileReader();
    Properties properties = null;


    @Test(enabled = true)
    public void ZIFUIAppsettings_Verifyusermanagement() throws IOException, InterruptedException {

        //Report

        test = extent.createTest("ZIF UI Appsetting Add user page verification");
        test.createNode("ZIF UI Appsetting Add user page verification");

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
            System.out.println(ActualTitle);
            assertEquals(ExpectedTitle, ActualTitle);
            Thread.sleep(2000);
        } catch (AssertionError | Exception e) {
            test.log(Status.FAIL, "Login failed");

        }


// Verify all fields in ZIF UI User management page
        try {

//            //Verify the user management tab
            try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'icons_shaper settings_ic')]")));
            WebElement ClickSettings = driver.findElement(By.xpath("//span[contains(@class,'icons_shaper settings_ic')]"));
                if(ClickSettings.isDisplayed())
                    System.out.println("Displayed");
                {
            ClickSettings.click();
                    test.log(Status.PASS,"App settings is clicked");
//
                }
            }catch (Exception e) {
                test.log(Status.FAIL, "Not able to click the App settings");
                test.addScreenCaptureFromPath(captureScreenShot(driver));
            }
//            new ZIFAIDashboardPage(driver).clickAppSettings();
            //Lost opportunity cards


            //Test case ID -1988

            try {
                WebElement UserManagement = driver.findElement(By.xpath("//span[text()='USER MANAGEMENT']"));
                WebElement DomainManagement = driver.findElement(By.xpath("//span[text()='DOMAIN MANAGEMENT']"));
                WebElement PlatformManagement = driver.findElement(By.xpath("//span[text()='PLATFORM MANAGEMENT']"));


                if(UserManagement.isDisplayed() && DomainManagement.isDisplayed() &&  PlatformManagement.isDisplayed())
                {
                    test.log(Status.PASS,"Management tabs are displayed");
                    System.out.println("Tabs are displayed");

                    test.log(Status.PASS,"Successfuly verified the management tabs");
                }
            }catch (Exception e) {
                test.log(Status.FAIL, "Management tabs are Not available");
            }

            //Test case ID -2001
            //Verify the user management tab
            try {
                WebElement ActiveUsermanagement = driver.findElement(By.xpath("//span[@class='settings-tabs-name-list settings-tabs-name-sel settings-tabs-state-active']"));
                if(ActiveUsermanagement.isDisplayed())
                {
                    test.log(Status.PASS,"User management is displayed by default");
                    System.out.println("User management is displayed by default");
                }
            }catch (Exception e) {
                test.log(Status.FAIL, "User management is not displayed by default");
                test.addScreenCaptureFromPath(captureScreenShot(driver));
            }

//                //Test case ID -2002
//            //Verify the accordions in user management tab
//            try {
//                WebElement Accordiondropdwon = driver.findElement(By.xpath("//input[@placeholder='Search']"));
//                WebElement AllUser = driver.findElement(By.xpath("//span[text()='All Users']"));
//                WebElement Accessgroup = driver.findElement(By.xpath("//span[text()='Access Groups']"));
//
//
//                if(Accordiondropdwon.isDisplayed()) {
//                    Accordiondropdwon.sendKeys("qw");
//                    //Accordiondropdwon.click();
//                System.out.println("Displayed");
//                }
//                if(AllUser.isDisplayed() && Accessgroup.isDisplayed()){
//                    test.log(Status.PASS,"Accordion details are displayed");
//                }
//            }catch (Exception e) {
//                test.log(Status.FAIL, "Accordion details are not displayed");
//                test.addScreenCaptureFromPath(captureScreenShot(driver));
//            }

            //Test case ID -2006

            //Ensure the All Users accordion is available in User Management sub menu and validate the new user creation
            try {

                WebElement Accordiondropdwon = driver.findElement(By.xpath("//span[@class='ui-dropdown-trigger-icon ui-clickable ng-tns-c119-3 pi pi-chevron-down']"));
                WebElement CreatedAddUserbutton = driver.findElement(By.xpath("//span[text()='+ Add New User']"));
                WebElement Accessgroup = driver.findElement(By.xpath("//th[@id='accessgroupid']"));
                WebElement Name = driver.findElement(By.xpath("//th[text()='Name ']"));
                WebElement EmailAddress = driver.findElement(By.xpath("//th[@id='username']"));
                WebElement StatusHeader = driver.findElement(By.xpath("//th[@id='userstatus']"));
                WebElement Actions = driver.findElement(By.xpath("//th[@id='action']"));
                WebElement Searchtextbox = driver.findElement(By.xpath("//input[@placeholder='Search']"));
                WebElement Displaytext = driver.findElement(By.xpath("//div[text()=' Displaying set of all users of this platform ']"));


                if(Accordiondropdwon.isDisplayed() && Accessgroup.isDisplayed() && CreatedAddUserbutton.isDisplayed() && Name.isDisplayed() && EmailAddress.isDisplayed() && StatusHeader.isDisplayed() && Actions.isDisplayed() &&  Searchtextbox.isDisplayed() && Displaytext.isDisplayed()){
                    test.log(Status.PASS,"Header and the accordions details in the user managemment screen are displayed");
                System.out.println("Displayed headers");
                }
            }catch (Exception e) {
                test.log(Status.FAIL, "Header and Accordion details are not displayed");
                test.addScreenCaptureFromPath(captureScreenShot(driver));
            }

            //Test case ID -2007

//            Verify whether the Add new user pop up is displayed in User Management tab
            try {

                WebElement CreatedAddUserbutton = driver.findElement(By.xpath("(//span[text()='+ Add New User'])[1]"));
            //    WebElement AddUserpopup = driver.findElement(By.xpath("//div[@class='ui-grid ui-grid-responsive ui-grid-pad ui-fluid']"));

                if(CreatedAddUserbutton.isDisplayed()) {
                    CreatedAddUserbutton.click();
//                }
//                if(AddUserpopup.isDisplayed()){
                    test.log(Status.PASS,"Add user pop up is displayed");
                    System.out.println("Clicked");
                }
            }catch (Exception e) {
                test.log(Status.FAIL, "Add user popup is not displayed");
                test.addScreenCaptureFromPath(captureScreenShot(driver));
            }

            //Test case ID -2008

//            Verify whether the "Add new User" fields are displayed in the pop up screen

            try {

                WebElement Savebutton = driver.findElement(By.xpath("//span[text()='Save']"));
                WebElement Accessgroup = driver.findElement(By.xpath("//label[@class='ng-tns-c119-9 ui-dropdown-label ui-inputtext ui-corner-all ng-star-inserted']"));
                WebElement Name = driver.findElement(By.xpath("//input[@formcontrolname='name']"));
                WebElement EmailAddress = driver.findElement(By.xpath("//input[@formcontrolname='username']"));
                WebElement StatusHeader = driver.findElement(By.xpath("//label[@class='ng-tns-c119-10 ui-dropdown-label ui-inputtext ui-corner-all ng-star-inserted']"));
                WebElement Closeicon = driver.findElement(By.xpath("//span[@class='ng-tns-c111-8 pi pi-times']"));
                WebElement Addnewuserheader = driver.findElement(By.xpath("//span[text()=' Add New User ']"));
                if(Savebutton.isDisplayed() && Accessgroup.isDisplayed() && Name.isDisplayed() && EmailAddress.isDisplayed() && StatusHeader.isDisplayed() && Closeicon.isDisplayed() && Addnewuserheader.isDisplayed()){
                    test.log(Status.PASS,"The fields in Add user pop up are displayed");
                }
            }catch (Exception e) {
                test.log(Status.FAIL, "The fields in Add user pop up are not displayed");
                test.addScreenCaptureFromPath(captureScreenShot(driver));
            }

            //Test case ID -2010

            //Validate the New user creation by tab out the name field with blank entry
            try {

                WebElement Name = driver.findElement(By.xpath("//input[@formcontrolname='name']"));
                if(Name.isDisplayed()){
                    Name.sendKeys("");
                    Name.sendKeys(Keys.TAB);
                }
                WebElement Nameisrequired = driver.findElement(By.xpath("//span[text()='Name is required']"));

                if(Nameisrequired.isDisplayed()){

                    test.log(Status.PASS,"The 'Name is required' error message is displayed");
                }
            }catch (Exception e) {
                test.log(Status.FAIL, "The 'Name is required' error message is not displayed");
                test.addScreenCaptureFromPath(captureScreenShot(driver));
            }

            //Test case ID -2009

            //Validate the New user creation by tab out the email field with blank entry
            try {

                WebElement email = driver.findElement(By.xpath("//input[@formcontrolname='username']"));
                if(email.isDisplayed()){
                    email.sendKeys("");
                    email.sendKeys(Keys.TAB);
                }
                WebElement Emailisrequired = driver.findElement(By.xpath("//span[text()='Email is required']"));

                if(Emailisrequired.isDisplayed()){

                    test.log(Status.PASS,"The 'Email is required' error message is displayed");
                }
            }catch (Exception e) {
                test.log(Status.FAIL, "The 'Email is required' error message is not displayed");
                test.addScreenCaptureFromPath(captureScreenShot(driver));
            }

            //Test case ID -2040

            //Validate the lengh of the name
            try {

                WebElement Name = driver.findElement(By.xpath("//input[@formcontrolname='name']"));
                if(Name.isDisplayed()){
                    Name.sendKeys("ad");
                    Name.sendKeys(Keys.TAB);
                }
                WebElement Namelength = driver.findElement(By.xpath("//span[text()='Name must be at least 3 characters long']"));

                if(Namelength.isDisplayed()){

                    test.log(Status.PASS,"The 'Name must be at least 3 characters long' error message is displayed");
                }
            }catch (Exception e) {
                test.log(Status.FAIL, "The 'Name must be at least 3 characters long' error message is not displayed");
                test.addScreenCaptureFromPath(captureScreenShot(driver));
            }

            //Test case ID -2013
            //Validate the email invalid message
            try {

                WebElement email = driver.findElement(By.xpath("//input[@formcontrolname='username']"));
                if(email.isDisplayed()){
                    email.sendKeys("");
                    email.sendKeys(Keys.TAB);
                }
                WebElement Emailisinvalid = driver.findElement(By.xpath("//span[text()='Email is invalid']"));

                if(Emailisinvalid.isDisplayed()){

                    test.log(Status.PASS,"The 'Email is invalid' error message is displayed");
                }
            }catch (Exception e) {
                test.log(Status.FAIL, "The 'Email is invalid' error message is not displayed");
                test.addScreenCaptureFromPath(captureScreenShot(driver));
            }

            //Test case ID -2014

            //Validate the save button is disabled
            try {

                WebElement Savebuttondisabled = driver.findElement(By.xpath("//button[@disabled]"));

                if(Savebuttondisabled.isDisplayed()){

                    test.log(Status.PASS,"The save button is disabled");
                }
            }catch (Exception e) {
                test.log(Status.FAIL, "The save button is not disabled");
                test.addScreenCaptureFromPath(captureScreenShot(driver));
            }

            //Test case ID -2128

            //Verify the duplicate error message
            try {

                WebElement Name = driver.findElement(By.xpath("//input[@formcontrolname='name']"));
                if(Name.isDisplayed()){
                    Name.sendKeys("ad");
                    Name.sendKeys(Keys.TAB);
                }

                WebElement email = driver.findElement(By.xpath("//input[@formcontrolname='username']"));
                if(email.isDisplayed()){
                    email.sendKeys("nirmalkumar.g@gavstech.com");
                    email.sendKeys(Keys.TAB);
                }

                WebElement savebutton = driver.findElement(By.xpath("//span[text()='Save']"));
                if(savebutton.isDisplayed()) {
                    savebutton.click();
                }

                WebElement Closeicon = driver.findElement(By.xpath("//span[@class='ng-tns-c111-0 pi pi-times']"));

                WebElement userduplicate = driver.findElement(By.xpath("//span[text()='User creation is failed ( duplicate or invalid user details )']"));

                if(userduplicate.isDisplayed()){
                    Closeicon.click();
                    test.log(Status.PASS,"The 'User creation is failed ( duplicate or invalid user details )' error message is displayed");
                }
            }catch (Exception e) {
                test.log(Status.FAIL, "The 'User creation is failed ( duplicate or invalid user details )' error message is not displayed");
                test.addScreenCaptureFromPath(captureScreenShot(driver));
            }

            //Test case ID -2126

            try {

                WebElement CreatedAddUserbutton = driver.findElement(By.xpath("(//span[text()='+ Add New User'])[1]"));

                if(CreatedAddUserbutton.isDisplayed()) {
                    CreatedAddUserbutton.click();
                }

                WebElement Name = driver.findElement(By.xpath("//input[@formcontrolname='name']"));
                if(Name.isDisplayed()){
                    Name.sendKeys("ad");
                }

                WebElement email = driver.findElement(By.xpath("//input[@formcontrolname='username']"));
                if(email.isDisplayed()){
                    String alphabet = "abcdefghijklmnopqrstuvwxyz";
                    String Emailid = RandomStringUtils.random(5, alphabet);
                    email.sendKeys(Emailid+"@gavstech.com");
                }

                WebElement savebutton = driver.findElement(By.xpath("//span[text()='Save']"));
                if(savebutton.isDisplayed()) {
                    savebutton.click();
                }

                WebElement Successmessage = driver.findElement(By.xpath("//span[text()='User has been created successfully']"));

                if(Successmessage.isDisplayed()){

                    test.log(Status.PASS,"The 'User has been created successfully' message is displayed");
                }
            }catch (Exception e) {
                test.log(Status.FAIL, "The 'User has been created successfully' message is not displayed");
                test.addScreenCaptureFromPath(captureScreenShot(driver));
            }


           



            //Logout of Application
            try {
                new ZIFAIDashboardPage(driver).LogoutClick();
                test.log(Status.PASS,"Successfully Logged out from Dashboard Page");
            }catch (Exception e) {
                test.log(Status.FAIL, "Dashboard page Logout failed");

            }


        } catch (AssertionError | Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Failed in Selecting App settings");

        }


    }

}
