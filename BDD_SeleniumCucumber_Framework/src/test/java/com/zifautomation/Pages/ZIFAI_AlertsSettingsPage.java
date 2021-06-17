package com.zifautomation.Pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zifautomation.Utility.CommonMethods;

public class ZIFAI_AlertsSettingsPage {

	WebDriver driver;


	public ZIFAI_AlertsSettingsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



	@FindBy(how = How.XPATH, using="//div[@class='zif-ic_logo']")
	private WebElement zifIclogo;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'dashboard_ic')]")
	private WebElement dashboardicon;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'analyze_ic')]")
	private WebElement analyzeIcon;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'analyze_ic')]//following-sibling::span")
	private WebElement analyzesubmenuIcon;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'settings_ic')]")
	private WebElement settingsIcon;


	//analyzes hover
	@FindBy(how = How.XPATH, using="//span[contains(@class,'hover_menus')]")
	private WebElement analyzeshovermenu;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'hover_menus')]//span[contains(text(),'OPERATIONS')]")
	private WebElement operationheader;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'hover_menus')]//span[contains(text(),'RawData')]")
	private WebElement SMrawdata;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'hover_menus')]//span[contains(text(),'Analytics')]")
	private WebElement SManalytics;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'hover_menus')]//span[contains(text(),'Predictions')]")
	private WebElement SMpredictions;



	@FindBy(how = How.XPATH, using="//div[contains(text(),'Operations')]")
	private WebElement operationsTitle;
	@FindBy(how = How.XPATH, using="//div[contains(text(),'RAWDATA')]")
	private WebElement rawdataTitle;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'ALERTS')]")
	private WebElement alertsLink;
	

	//adaptor status
	@FindBy(how = How.XPATH, using="//span[contains(text(),'ZIF Adapter Status')]")
	private WebElement adaptorstatustext;
	@FindBy(how = How.XPATH, using="//span[contains(@class,'zif-health-status')]")
	private WebElement adaptorhealthstatus;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'zif-health-up')]")
	private WebElement adaptorhealthstatusup;
	@FindBy(how = How.XPATH, using="//span[contains(@class,'zif-health-down')]")
	private WebElement adaptorhealthstatusdown;

	@FindBy(how = How.XPATH, using="//*[contains(@class,'tab-livefeed')]")
	private WebElement LivefeedIcon;
	@FindBy(how = How.XPATH, using="//*[contains(@class,'tab-export')]")
	private WebElement expoertIcon;
	@FindBy(how = How.XPATH, using="//*[contains(@class,'pref')]")
	private WebElement prefereceIcon;
	
	//AlertSettings
	@FindBy(how = How.XPATH, using="//div[contains(@class,'settings')]")
	private WebElement alertSettingsIcon;
	@FindBy(how = How.XPATH, using="//div[contains(@class,'tab-settings enable-menu')]")
	private WebElement alertSettingsIconenabled;
	@FindBy(how = How.XPATH, using="//div[contains(@class,'tab-settings disabled-menu')]")
	private WebElement alertSettingsIconDisabled;
	@FindBy(how = How.XPATH, using="//*[contains(@ptooltip,'Settings')]")
	private WebElement alertSettingsTooltip;
	
	
	@FindBy(how = How.XPATH, using="//*[contains(@class,'filter')]")
	private WebElement alertFilterIcon;

	
	
	//Alert Settings Page
	@FindBy(how = How.XPATH, using="//*[contains(text(),'Settings')]")
	private WebElement SettingsHeader;
	@FindBy(how = How.XPATH, using="//*[contains(@Class,'close-icon')]")
	private WebElement Settingsclose;
	@FindBy(how = How.XPATH, using="//*[contains(text(),'Event Rule Processing')]")
	private WebElement EventRuleProcessingHeader;
	
	@FindBy(how = How.XPATH, using="//*[contains(text(),'All Rules')]")
	private WebElement AllRules;
	@FindBy(how = How.XPATH, using="//*[contains(text(),'Configuration rules to generate alerts')]")
	private WebElement ConfigureRulestoGenerateAlerts;
	@FindBy(how = How.XPATH, using="//*[contains(text(),'Create new rule')]")
	private WebElement CreateNewRuleBTN;

	//Rule in Settings Page
	@FindBy(how = How.XPATH, using="//tbody//tr[1]")
	private WebElement CreatedRule;
	//Update the column name and the First Rule list
	
	
	//Create New Rule
	@FindBy(how = How.XPATH, using="")
	private WebElement CreatenewRuleheader;
	@FindBy(how = How.XPATH, using="")
	private WebElement ToolName;
	@FindBy(how = How.XPATH, using="")
	private WebElement ResourceType;
	@FindBy(how = How.XPATH, using="")
	private WebElement RuleName;
	@FindBy(how = How.XPATH, using="")
	private WebElement InventoryGrp;
	@FindBy(how = How.XPATH, using="")
	private WebElement DeviceName;
	@FindBy(how = How.XPATH, using="")
	private WebElement RuleStatus;
	@FindBy(how = How.XPATH, using="")
	private WebElement Alertpriority;
	@FindBy(how = How.XPATH, using="")
	private WebElement ConsecutiveLimit;
	@FindBy(how = How.XPATH, using="")
	private WebElement AlertMessage;
	@FindBy(how = How.XPATH, using="")
	private WebElement RuleDescription;
	
	@FindBy(how = How.XPATH, using="")
	private WebElement ValidateRuleBTN;
	@FindBy(how = How.XPATH, using="")
	private WebElement SaveBTN;
	@FindBy(how = How.XPATH, using="")
	private WebElement SaveBTNenabled;
	@FindBy(how = How.XPATH, using="")
	private WebElement SaveBTNdisabled;
	@FindBy(how = How.XPATH, using="")
	private WebElement CancelBTN;
	
	@FindBy(how = How.XPATH, using="")
	private WebElement ToolNameDD;

	
	@FindBy(how = How.XPATH, using="")
	private WebElement ResourceTypeDD;
	@FindBy(how = How.XPATH, using="")
	private WebElement RuleNameTxtbx;
	@FindBy(how = How.XPATH, using="")
	private WebElement InventoryGrpDD;
	@FindBy(how = How.XPATH, using="")
	private WebElement DeviceNameDD;
	@FindBy(how = How.XPATH, using="")
	private WebElement RuleStatusDD;
	@FindBy(how = How.XPATH, using="")
	private WebElement AlertpriorityDD;
	@FindBy(how = How.XPATH, using="")
	private WebElement ConsecutiveLimitDD;
	@FindBy(how = How.XPATH, using="")
	private WebElement AlertMessageTxtbx;
	@FindBy(how = How.XPATH, using="")
	private WebElement RuleDescriptionTxtbx;
	@FindBy(how = How.XPATH, using="")
	private WebElement ExpressionCountersDD;

	
	//Tool Name Select Value
	@FindBy(how = How.XPATH, using="")
	private WebElement ToolNameValue;
	
	//Resource Type values
	@FindBy(how = How.XPATH, using="")
	private WebElement CPU;
	@FindBy(how = How.XPATH, using="")
	private WebElement Memory;
	@FindBy(how = How.XPATH, using="")
	private WebElement Disk;
	@FindBy(how = How.XPATH, using="")
	private WebElement Network;
	@FindBy(how = How.XPATH, using="")
	private WebElement Syslog;
	@FindBy(how = How.XPATH, using="")
	private WebElement Eventlog;
	@FindBy(how = How.XPATH, using="")
	private WebElement SNMP;
	
	//Inventory Group Value
	@FindBy(how = How.XPATH, using="")
	private WebElement InventoryGRPval1;
	@FindBy(how = How.XPATH, using="")
	private WebElement InventoryGRPval2;
	
	
	//Device Name Value
	@FindBy(how = How.XPATH, using="")
	private WebElement DeviceNameVal1;
	@FindBy(how = How.XPATH, using="")
	private WebElement DeviceNameVal2;
		
	//Rule Status  Value
	@FindBy(how = How.XPATH, using="")
	private WebElement Activestatus;
	@FindBy(how = How.XPATH, using="")
	private WebElement Inactivestatus;
	
	//Alert Priority values
	@FindBy(how = How.XPATH, using="")
	private WebElement Critical;
	@FindBy(how = How.XPATH, using="")
	private WebElement High;
	@FindBy(how = How.XPATH, using="")
	private WebElement Medium;
	@FindBy(how = How.XPATH, using="")
	private WebElement Low;
	@FindBy(how = How.XPATH, using="")
	private WebElement Warning;
	@FindBy(how = How.XPATH, using="")
	private WebElement Information;
	
	
	
	
	//Consecutive Limit values
		@FindBy(how = How.XPATH, using="")
		private WebElement CL1;
		@FindBy(how = How.XPATH, using="")
		private WebElement CL2;
		@FindBy(how = How.XPATH, using="")
		private WebElement CL3;
		@FindBy(how = How.XPATH, using="")
		private WebElement CL4;
		@FindBy(how = How.XPATH, using="")
		private WebElement CL5;
		@FindBy(how = How.XPATH, using="")
		private WebElement CL6;
		@FindBy(how = How.XPATH, using="")
		private WebElement CL7;
		@FindBy(how = How.XPATH, using="")
		private WebElement CL8;
		@FindBy(how = How.XPATH, using="")
		private WebElement CL9;
		@FindBy(how = How.XPATH, using="")
		private WebElement CL10;
		
		
		
		//Expression Values
		@FindBy(how = How.XPATH, using="")
		private WebElement Expression;
		@FindBy(how = How.XPATH, using="")
		private WebElement Condition;
		@FindBy(how = How.XPATH, using="")
		private WebElement Value;
		@FindBy(how = How.XPATH, using="")
		private WebElement operator;
		@FindBy(how = How.XPATH, using="")
		private WebElement addExpression;
		@FindBy(how = How.XPATH, using="")
		private WebElement Removeexpression;
		@FindBy(how = How.XPATH, using="")
		private WebElement counterDD;
		@FindBy(how = How.XPATH, using="")
		private WebElement ConditionDD;
		@FindBy(how = How.XPATH, using="")
		private WebElement ValueDD;
		@FindBy(how = How.XPATH, using="")
		private WebElement OperatorDD;
		@FindBy(how = How.XPATH, using="")
		private WebElement FirstExpressionCheckbox;
		@FindBy(how = How.XPATH, using="")
		private WebElement SecondExpressionCheckbox;
	
		
		//Counters value 
		@FindBy(how = How.XPATH, using="")
		private WebElement CPUvalue;
		@FindBy(how = How.XPATH, using="")
		private WebElement MemoryValue;
		@FindBy(how = How.XPATH, using="")
		private WebElement Diskvalue;
		
		
		//Condition Value
		@FindBy(how = How.XPATH, using="")
		private WebElement lessthan;
		@FindBy(how = How.XPATH, using="")
		private WebElement greaterthan;
		@FindBy(how = How.XPATH, using="")
		private WebElement equal;
		
		//Value
		
		//Pass the random value to Xpath after taking or in the Script
		@FindBy(how = How.XPATH, using="")
		private WebElement valueonetoten;
		
		
		//Operator value
		@FindBy(how = How.XPATH, using="")
		private WebElement And;
		@FindBy(how = How.XPATH, using="")
		private WebElement OR;
		
		
		
	//Validation Message
		@FindBy(how = How.XPATH, using="")
		private WebElement partialdatavalidationmessage;
		@FindBy(how = How.XPATH, using="")
		private WebElement missingOptionalvalidationmsg;
		@FindBy(how = How.XPATH, using="")
		private WebElement validatedsuccessmsg;
		@FindBy(how = How.XPATH, using="")
		private WebElement InvalidExpressionmsg;

		
		
		
		
		
	public void hoveronAnalyzes(){

		Actions act = new Actions(driver);
		act.moveToElement(analyzeIcon).perform();
		assertTrue(analyzeshovermenu.isDisplayed());
	}


	public void verifyAnalyzeshovermenufields(){

		assertTrue(operationheader.isDisplayed());
		assertTrue(SMrawdata.isDisplayed());
		assertTrue(SManalytics.isDisplayed());
		assertTrue(SMpredictions.isDisplayed());
	}


	public void clickPrediction(){

		SMpredictions.click();
	}
	public void clickRawdata(){

		SMrawdata.click();
	}
	public void clickanalytics(){

		SManalytics.click();
	}
	
	public void clickSettings() {
		try {
			alertSettingsIcon.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	public void NavigatetoAlertpage() {
		new CommonMethods(driver).MovetoElement(analyzeIcon);
		SMrawdata.click();
	}
	
	public void settingstooltip() {
		new CommonMethods(driver).MovetoElement(alertSettingsIcon);
		assertTrue(alertSettingsTooltip.isDisplayed());
	}
	
	public void alertSettingsEnabled() {
		assertTrue(alertSettingsIconenabled.isDisplayed());
	}
	public void alertSettingsdisabled() {
		assertTrue(alertSettingsIconDisabled.isDisplayed());
	}
	
	//Settings Page enabled view
	public void Verifyviewsettingspageaccess() {
		assertTrue(SettingsHeader.isDisplayed());
		assertTrue(Settingsclose.isDisplayed());
		assertTrue(EventRuleProcessingHeader.isDisplayed());
	}
	//Settings page Disabled view
	public void Verifyviewsettingspageaccessdisabled() {
		assertTrue(SettingsHeader.isDisplayed());
		assertTrue(Settingsclose.isDisplayed());
		try {
		assertFalse(EventRuleProcessingHeader.isDisplayed());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public void createnewRuleBtnEnabled() {
		assertTrue(CreateNewRuleBTN.isDisplayed());
	}
	public void createnewRuleBtnNotavailable() {
		try {
		assertFalse(CreateNewRuleBTN.isDisplayed());
		}
		catch (Exception e) {
		}
	}
	
	public void CreateNewRuleClick() {
		try {
		if(CreateNewRuleBTN.isDisplayed())
		{
			CreateNewRuleBTN.click();
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void verifyslidewindowFields() {
		assertTrue(CreatenewRuleheader.isDisplayed());
		assertTrue(ToolName.isDisplayed());
		assertTrue(ToolNameDD.isDisplayed());
		assertTrue(ResourceType.isDisplayed());
		assertTrue(ResourceTypeDD.isDisplayed());
		assertTrue(RuleName.isDisplayed());
		assertTrue(RuleNameTxtbx.isDisplayed());
		assertTrue(InventoryGrp.isDisplayed());
		assertTrue(InventoryGrpDD.isDisplayed());
		assertTrue(ConsecutiveLimit.isDisplayed());
		assertTrue(ConsecutiveLimitDD.isDisplayed());
		assertTrue(AlertMessage.isDisplayed());
		assertTrue(AlertMessageTxtbx.isDisplayed());
		assertTrue(RuleDescription.isDisplayed());
		assertTrue(RuleDescriptionTxtbx.isDisplayed());
		assertTrue(Expression.isDisplayed());
		assertTrue(ExpressionCountersDD.isDisplayed());
		
		
		assertTrue(ValidateRuleBTN.isDisplayed());
		assertTrue(SaveBTN.isDisplayed());
		assertTrue(CancelBTN.isDisplayed());
	}
	
	public void ClickonToolNameDropdown() {
		try {
		if(ToolNameDD.isDisplayed())
		{
			ToolNameDD.click();
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifyToolNameDropdownValues() {
		assertTrue(ToolNameValue.isDisplayed());
	}
	
	public void ClickonResourceTypeDropdown() {
		try {
		if(ResourceTypeDD.isDisplayed())
		{
			ResourceTypeDD.click();
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void verifyResourceTypeDropdownValues() {
		assertTrue(CPU.isDisplayed());
		assertTrue(Memory.isDisplayed());
		assertTrue(Disk.isDisplayed());
		assertTrue(Network.isDisplayed());
		assertTrue(Syslog.isDisplayed());
		assertTrue(Eventlog.isDisplayed());
		assertTrue(SNMP.isDisplayed());
	}
	
	public void SelectanyResourceType() {
		CPU.click();
	}
	
	
	public void EnterValueinRuleName(String RuleName) {
		
		RuleNameTxtbx.sendKeys(RuleName);
	}
	
	public int GetValueinRuleName() {
		
		String rulename=RuleNameTxtbx.getText();
		int count = 0;    
        
        //Counts each character except space    
        for(int i = 0; i < rulename.length(); i++) {    
            if(rulename.charAt(i) != ' ')    
                count++;    
        }    
		return count;
	}
	
	
	public void EnterValueinRuleDescription(String RuleName) {
		
		RuleDescriptionTxtbx.sendKeys(RuleName);
	}
	
	public int GetValueinRuleDescription() {
		
		String ruleDesc=RuleDescriptionTxtbx.getText();
		int count = 0;    
        
        //Counts each character except space    
        for(int i = 0; i < ruleDesc.length(); i++) {    
            if(ruleDesc.charAt(i) != ' ')    
                count++;    
        }    
		return count;
	}
	
	public void EnterValueinAlertMessage(String RuleName) {
		
		AlertMessageTxtbx.sendKeys(RuleName);
	}
	
	public int GetValueinAlertMessage() {
		
		String ruleDesc=AlertMessageTxtbx.getText();
		int count = 0;    
        
        //Counts each character except space    
        for(int i = 0; i < ruleDesc.length(); i++) {    
            if(ruleDesc.charAt(i) != ' ')    
                count++;    
        }    
		return count;
	}
	
	public void ClickonruleStatusDropdown() {
		try {
		if(RuleStatusDD.isDisplayed())
		{
			RuleStatusDD.click();
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void verifyruleStatusDropdownValues() {
		assertTrue(Activestatus.isDisplayed());
		assertTrue(Inactivestatus.isDisplayed());
		
	}
	
	public void clickonAlertprioritydropdown() {
		try {
		if(AlertpriorityDD.isDisplayed())
		{
			AlertpriorityDD.click();
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void verifyAlertprioritydropdownValues() {
		assertTrue(Critical.isDisplayed());
		assertTrue(High.isDisplayed());
		assertTrue(Medium.isDisplayed());
		assertTrue(Low.isDisplayed());
		assertTrue(Warning.isDisplayed());
		assertTrue(Information.isDisplayed());
	}
	
	public void clickonConsecutiveOccdropdown() {
		try {
		if(ConsecutiveLimitDD.isDisplayed())
		{
			ConsecutiveLimitDD.click();
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void verifyConsecutiveOccdropdownValues() {
		assertTrue(CL1.isDisplayed());
		assertTrue(CL2.isDisplayed());
		assertTrue(CL3.isDisplayed());
		assertTrue(CL4.isDisplayed());
		assertTrue(CL5.isDisplayed());
		assertTrue(CL6.isDisplayed());
		assertTrue(CL7.isDisplayed());
		assertTrue(CL8.isDisplayed());
		assertTrue(CL9.isDisplayed());
		assertTrue(CL10.isDisplayed());
		
	}
	
	
	public void selectallmandatorydropdownsAndValidate() {
		try {
			ToolNameDD.click();
			ToolNameValue.click();
		}catch (Exception e) {
		}
		try {
			ResourceTypeDD.click();
			CPU.click();
		}catch (Exception e) {
		}
		
		try {
			RuleStatusDD.click();
			Activestatus.click();
		}catch (Exception e) {
		}
		try {
			AlertpriorityDD.click();
			High.click();
		}catch (Exception e) {
		}
		try {
			ConsecutiveLimitDD.click();
			CL9.click();
		}catch (Exception e) {
		}
		
		try {
			Thread.sleep(2000);
			ValidateRuleBTN.click();
		} catch (Exception e) {
		}
		
	}
	
	public void EnterallmandatorytextboxAndValidate() {
		RuleNameTxtbx.clear();
		RuleNameTxtbx.sendKeys("Validate");
		RuleNameTxtbx.clear();
		AlertMessageTxtbx.sendKeys("Validate the Alert Message");
		RuleDescriptionTxtbx.clear();
		RuleDescriptionTxtbx.sendKeys("Validate the Rule Description");
		try {
			Thread.sleep(2000);
			ValidateRuleBTN.click();
		} catch (Exception e) {
		}
	}
	
	public void SelectallfieldsexceptOptional() {
		try {
			ToolNameDD.click();
			ToolNameValue.click();
		}catch (Exception e) {
		}
		try {
			ResourceTypeDD.click();
			CPU.click();
		}catch (Exception e) {
		}
		
		try {
			RuleStatusDD.click();
			Activestatus.click();
		}catch (Exception e) {
		}
		try {
			AlertpriorityDD.click();
			High.click();
		}catch (Exception e) {
		}
		try {
			ConsecutiveLimitDD.click();
			CL9.click();
		}catch (Exception e) {
		}
		RuleNameTxtbx.clear();
		RuleNameTxtbx.sendKeys("Validate");
		RuleNameTxtbx.clear();
		AlertMessageTxtbx.sendKeys("Validate the Alert Message");
		RuleDescriptionTxtbx.clear();
		RuleDescriptionTxtbx.sendKeys("Validate the Rule Description");
		
	}
	
	public void SelectbetweenOptional() {
		String[] arr = {"I", "D"};
        int randIdx = ThreadLocalRandom.current().nextInt(arr.length);
        String randomElem = arr[randIdx];
        
        if(randomElem=="I") {
        	InventoryGrpDD.click();
        	InventoryGRPval1.click();
        }else {
			DeviceNameDD.click();
			DeviceNameVal1.click();
		}
        
        try {
			Thread.sleep(2000);
			ValidateRuleBTN.click();
		} catch (Exception e) {
		}
	}
	
	
	public void PartialvalidationErrormessage() {		
	assertTrue(partialdatavalidationmessage.isDisplayed());	
	}	
	public void missingoptionalvalidationErrormessage() {
		assertTrue(missingOptionalvalidationmsg.isDisplayed());
	}	
	public void InvalidExpressionErrormessage() {
		assertTrue(InvalidExpressionmsg.isDisplayed());
	}
	public void validationsuccessrmessage() {
		assertTrue(validatedsuccessmsg.isDisplayed());
	}
	public void ChecksavebtnDisabled() {		
		assertTrue(SaveBTNdisabled.isDisplayed());	
		}
	public void Checksavebtnenabled() {		
		assertTrue(SaveBTNenabled.isDisplayed());	
		}
	public void clickCancelBtn() {				
		try {
			CancelBTN.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		}
	public void clickSaveBtn() {				
		try {
			SaveBTN.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		}
public void clickValidatRuleeBtn() {		
		try {
			ValidateRuleBTN.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		}
	
	public void selectvalidExpression() {	
		System.out.println("Need To update the Expression Part per code");
	}
	public void VerifyRuleinSettingspage() {		
		System.out.println("Need To update the Expression Part per code");
	}
	
	public void SelectcountervalueExpression() {
		try {
			counterDD.click();
			Thread.sleep(2000);
			CPUvalue.click();
		}catch (Exception e) {			
		}	
	}
	public void selectGreaterthan() {
		try {
			ConditionDD.click();
			Thread.sleep(2000);
			greaterthan.click();
		}catch (Exception e) {	
		}	
	}
	public void selectLessthan() {
		try {
			ConditionDD.click();
			Thread.sleep(2000);
			lessthan.click();
		}catch (Exception e) {	
		}	
	}
	public void selectequal() {
		try {
			ConditionDD.click();
			Thread.sleep(2000);
			equal.click();
		}catch (Exception e) {	
		}	
	}
	public void selectAndoperator() {
		try {
			OperatorDD.click();
			Thread.sleep(2000);
			And.click();
		}catch (Exception e) {	
		}	
	}
	public void selectORoperator() {
		try {
			OperatorDD.click();
			Thread.sleep(2000);
			OR.click();
		}catch (Exception e) {	
		}	
	}
	
}
