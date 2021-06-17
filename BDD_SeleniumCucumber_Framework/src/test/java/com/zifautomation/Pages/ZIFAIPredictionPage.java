package com.zifautomation.Pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.zifautomation.Base.Base;

public class ZIFAIPredictionPage extends Base{
	WebDriver driver;

	public ZIFAIPredictionPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using="//span[text()='Operations']")
	private WebElement PredictionTitle;

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

	@FindBy(how = How.XPATH, using="//span[contains(@class,'await_ic')]")
	private WebElement qwaitIcon;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'search_common_ic')]")
	private WebElement searchcommonIcon;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'logout_ic')]")
	private WebElement logoutIcon;

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


	@FindBy(how = How.XPATH, using="//div[contains(text(),'OPPORTUNITIES')]")
	private WebElement opportunitiesTitle;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'RESOURCE UTILIZATION')]")
	private WebElement resourceutilizationlink;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'USER EXPERIENCE')]")
	private WebElement userexperiencelink;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'TRANSACTION UTILIZATION')]")
	private WebElement transactionutilizationlink;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'SECURITY')]")
	private WebElement securitylink;

	//adaptor status
	@FindBy(how = How.XPATH, using="//span[contains(text(),'ZIF Adapter Status')]")
	private WebElement adaptorstatustext;
	@FindBy(how = How.XPATH, using="//span[contains(@class,'zif-health-status')]")
	private WebElement adaptorhealthstatus;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'zif-health-up')]")
	private WebElement adaptorhealthstatusup;
	@FindBy(how = How.XPATH, using="//span[contains(@class,'zif-health-down')]")
	private WebElement adaptorhealthstatusdown;

	@FindBy(how = How.XPATH, using="//div[contains(@class,'filters')]")
	private WebElement filterIcon;
	@FindBy(how = How.XPATH, using="//div[contains(@class,'settings')]")
	private WebElement predictionsettingsIcon;
	@FindBy(how = How.XPATH, using="//div[contains(@class,'pref')]")
	private WebElement prefereceIcon;


	//SwinLanes

	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[1]//div[contains(text(),'Predicted Risk (Warning)')]")
	private WebElement Predictedrisk;
	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[2]//div[contains(text(),'Currently at Risk (Critical)')]")
	private WebElement currentlyAtrisk;
	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[2]//div[contains(text(),'(Impact <= 60 mins)')]")
	private WebElement currentlyAtriskImpact;
	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[3]//div[contains(text(),'Processed')]")
	private WebElement processed;
	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[4]//div[contains(text(),'Lost')]")
	private WebElement lost;
	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[5]//div[contains(text(),'Invalid')]")
	private WebElement invalid;




	//Predict Risk Lane Opportunity cards
	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'opp-cards lost-state')][1]")
	private WebElement PRcard1;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'opp-list-more')])[1]")
	private WebElement PRcardlistmore;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'more-info-box')])[1]")
	private WebElement PRcardlistmorehovermenu;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Business Process')])[1]")
	private WebElement PRcardhoverop1;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Services')])[1]")
	private WebElement PRcardhoverop2;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Applications')])[1]")
	private WebElement PRcardhoverop3;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Devices')])[1]")
	private WebElement PRcardhoverop4;

	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[1]//span[contains(@ptooltip,'Est. Time to Impact')])[1]")
	private WebElement PRcardEstTimetoImpact;

	//Acknowledge Option 
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'opp-card-action opp-card-unack')])[1]")
	private WebElement PRcardunack;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'opp-card-action ic_ack')])[1]")
	private WebElement PRcardack;

	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'opp-card-action opp-card-export')])[1]")
	private WebElement PRcardexport;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'opp-card-action opp-card-notes')])[1]")
	private WebElement PRcardnotes;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'opp-card-action opp-card-reso')])[1]")
	private WebElement PRcardreso;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'opp-card-action opp-card-decline')])[1]")
	private WebElement PRcarddecline;

	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'no-data-cls')]")
	private WebElement PRnodataAvailable;

	//Currently at Risk (Critical) Lane Opportunity cards
	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'opp-cards lost-state')][1]")
	private WebElement CRcard1;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'opp-list-more')])[1]")
	private WebElement CRcardlistmore;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'more-info-box')])[1]")
	private WebElement CRcardlistmorehovermenu;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Business Process')])[1]")
	private WebElement CRcardhoverop1;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Services')])[1]")
	private WebElement CRcardhoverop2;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Applications')])[1]")
	private WebElement CRcardhoverop3;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Devices')])[1]")
	private WebElement CRcardhoverop4;

	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[2]//span[contains(@ptooltip,'Est. Time to Impact')])[1]")
	private WebElement CRcardEstTimetoImpact;

	//Acknowledge Option 
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'opp-card-action opp-card-unack')])[1]")
	private WebElement CRcardunack;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'opp-card-action ic_ack')])[1]")
	private WebElement CRcardack;

	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'opp-card-action opp-card-export')])[1]")
	private WebElement CRcardexport;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'opp-card-action opp-card-notes')])[1]")
	private WebElement CRcardnotes;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'opp-card-action opp-card-reso')])[1]")
	private WebElement CRcardreso;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'opp-card-action opp-card-decline')])[1]")
	private WebElement CRcarddecline;

	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'no-data-cls')]")
	private WebElement CRnodataAvailable;


	//Processed Lane Opportunity cards
	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'opp-cards lost-state')][1]")
	private WebElement PDcard1;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'opp-list-more')])[1]")
	private WebElement PDcardlistmore;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'more-info-box')])[1]")
	private WebElement PDcardlistmorehovermenu;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Business Process')])[1]")
	private WebElement PDcardhoverop1;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Services')])[1]")
	private WebElement PDcardhoverop2;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Applications')])[1]")
	private WebElement PDcardhoverop3;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Devices')])[1]")
	private WebElement PDcardhoverop4;

	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[3]//span[contains(@ptooltip,'Est. Time to Impact')])[1]")
	private WebElement PDcardEstTimetoImpact;

	//Acknowledge Option 
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'opp-card-action opp-card-unack')])[1]")
	private WebElement PDcardunack;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'opp-card-action ic_ack')])[1]")
	private WebElement PDcardack;

	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'opp-card-action opp-card-export')])[1]")
	private WebElement PDcardexport;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'opp-card-action opp-card-notes')])[1]")
	private WebElement PDcardnotes;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'opp-card-action opp-card-reso')])[1]")
	private WebElement PDcardreso;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'opp-card-action opp-card-decline')])[1]")
	private WebElement PDcarddecline;

	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'no-data-cls')]")
	private WebElement PDnodataAvailable;

	//Lost Lane Opportunity cards
	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'opp-cards lost-state')][1]")
	private WebElement LTcard1;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'opp-list-more')])[1]")
	private WebElement LTcardlistmore;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'more-info-box')])[1]")
	private WebElement LTcardlistmorehovermenu;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Business Process')])[1]")
	private WebElement LTcardhoverop1;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Services')])[1]")
	private WebElement LTcardhoverop2;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Applications')])[1]")
	private WebElement LTcardhoverop3;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Devices')])[1]")
	private WebElement LTcardhoverop4;

	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[4]//span[contains(@ptooltip,'Est. Time to Impact')])[1]")
	private WebElement LTcardEstTimetoImpact;

	//Acknowledge Option 
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'opp-card-action opp-card-unack')])[1]")
	private WebElement LTcardunack;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'opp-card-action ic_ack')])[1]")
	private WebElement LTcardack;

	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'opp-card-action opp-card-export')])[1]")
	private WebElement LTcardexport;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'opp-card-action opp-card-notes')])[1]")
	private WebElement LTcardnotes;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'opp-card-action opp-card-reso')])[1]")
	private WebElement LTcardreso;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'opp-card-action opp-card-decline')])[1]")
	private WebElement LTcarddecline;

	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'no-data-cls')]")
	private WebElement LTnodataAvailable;



	//Invalid Lane Opportunity cards
	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'opp-cards lost-state')][1]")
	private WebElement IVcard1;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'opp-list-more')])[1]")
	private WebElement IVcardlistmore;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'more-info-box')])[1]")
	private WebElement IVcardlistmorehovermenu;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Business Process')])[1]")
	private WebElement IVcardhoverop1;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Services')])[1]")
	private WebElement IVcardhoverop2;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Applications')])[1]")
	private WebElement IVcardhoverop3;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Devices')])[1]")
	private WebElement IVcardhoverop4;

	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[5]//span[contains(@ptooltip,'Est. Time to Impact')])[1]")
	private WebElement IVcardEstTimetoImpact;

	//Acknowledge Option 
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'opp-card-action opp-card-unack')])[1]")
	private WebElement IVcardunack;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'opp-card-action ic_ack')])[1]")
	private WebElement IVcardack;

	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'opp-card-action opp-card-export')])[1]")
	private WebElement IVcardexport;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'opp-card-action opp-card-notes')])[1]")
	private WebElement IVcardnotes;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'opp-card-action opp-card-reso')])[1]")
	private WebElement IVcardreso;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'opp-card-action opp-card-decline')])[1]")
	private WebElement IVcarddecline;

	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'no-data-cls')]")
	private WebElement IVnodataAvailable;








	
	












	//Installation and Activation of ZIF One Agent
	@FindBy(how = How.XPATH, using="//div[contains(text(),'Installation and Activation of ZIF One Agent')]")
	private WebElement InstallationandActivationHeader;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Device Configuration')]")
	private WebElement DeviceConfig;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Integration')]")
	private WebElement Integration;
	@FindBy(how = How.XPATH, using="//div[contains(@class,'closeAd')]")
	private WebElement closeAd;

	//Integration
	@FindBy(how = How.XPATH, using="//div[contains(text(),'Integrate with existing monitoring tool')]")
	private WebElement Intergratelink;
	@FindBy(how = How.XPATH, using="//div[contains(text(),'Download ZIF One Agent')]")
	private WebElement DownloadoneAgent;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Download is in progress')]")
	private WebElement downloadProgress;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Download is complete')]")
	private WebElement downloadcomplete;

	//Device Configuration


	@FindBy(how = How.XPATH, using="//span[contains(text(),'Select by Device')]")
	private WebElement selectdevice;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Select by Category')]")
	private WebElement selectcategory;




	public void checkuserinPredictionPage(){

		assertTrue(PredictionTitle.isDisplayed());
	}


	public void CheckallfieldsandImages(){

		assertTrue(zifIclogo.isDisplayed());
		assertTrue(PredictionTitle.isDisplayed());
		assertTrue(opportunitiesTitle.isDisplayed());
		assertTrue(dashboardicon.isDisplayed());
		assertTrue(analyzeIcon.isDisplayed());
		assertTrue(analyzesubmenuIcon.isDisplayed());
		assertTrue(settingsIcon.isDisplayed());
		assertTrue(qwaitIcon.isDisplayed());
		assertTrue(searchcommonIcon.isDisplayed());
		assertTrue(logoutIcon.isDisplayed());

	}

	public void checkallpredictionfields(){

		assertTrue(resourceutilizationlink.isDisplayed());
		assertTrue(transactionutilizationlink.isDisplayed());
		assertTrue(userexperiencelink.isDisplayed());
		assertTrue(securitylink.isDisplayed());
		assertTrue(adaptorstatustext.isDisplayed());
		assertTrue(adaptorhealthstatus.isDisplayed());
		assertTrue(filterIcon.isDisplayed());
		assertTrue(predictionsettingsIcon.isDisplayed());
		assertTrue(prefereceIcon.isDisplayed());

	}

	public void verifySwinlaneFields(){
		assertTrue(Predictedrisk.isDisplayed());
		assertTrue(currentlyAtrisk.isDisplayed());
		assertTrue(currentlyAtriskImpact.isDisplayed());
		assertTrue(processed.isDisplayed());
		assertTrue(lost.isDisplayed());
		assertTrue(invalid.isDisplayed());		
	}


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

	public void LogoutClick(){

		logoutIcon.click();
	}

	public boolean adaptorstatuscheck() {
		try {
			adaptorhealthstatusup.isDisplayed();
			return true;
		}catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}}

	public void PredictionSettingsClick(){

		predictionsettingsIcon.click();

	}

	public void PredictionSettingsfieldvalidation(){
		assertTrue(InstallationandActivationHeader.isDisplayed());
		assertTrue(Integration.isDisplayed());
		assertTrue(DeviceConfig.isDisplayed());
		assertTrue(closeAd.isDisplayed());
		assertTrue(Intergratelink.isDisplayed());
		assertTrue(DownloadoneAgent.isDisplayed());
	}

	public void downloadOneAgent() {
		WebDriverWait wait=new WebDriverWait(driver,20);
		DownloadoneAgent.click();
		WebElement downloadinprogress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Download is in progress')]")));
		downloadinprogress.isDisplayed();

		WebElement downloadcompleted = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Download is complete')]")));
		downloadcompleted.isDisplayed();
	}

	public void closePredictionsettings() {
		closeAd.click();
	}

	public void Integration_Tab() {
		Integration.click();
	}

	public void Device_Configuration_Tab() {
		DeviceConfig.click();
	}

	public void verifyWarningOppcardDetails() {
	
	assertTrue(PRcardlistmore.isDisplayed());
	assertTrue(PRcardEstTimetoImpact.isDisplayed());
	assertTrue(PRcardexport.isDisplayed());
	assertTrue(PRcardnotes.isDisplayed());
	assertTrue(PRcardreso.isDisplayed());
	assertTrue(PRcarddecline.isDisplayed());


	Actions act = new Actions(driver);
	act.moveToElement(PRcardlistmore).perform();
	assertTrue(PRcardlistmorehovermenu.isDisplayed());
	assertTrue(PRcardhoverop1.isDisplayed());
	assertTrue(PRcardhoverop2.isDisplayed());
	assertTrue(PRcardhoverop3.isDisplayed());
	assertTrue(PRcardhoverop4.isDisplayed());
	
	}
	
	public void verifyCriticalOppcardDetails() {
	assertTrue(CRcardlistmore.isDisplayed());
	assertTrue(CRcardEstTimetoImpact.isDisplayed());
	assertTrue(CRcardexport.isDisplayed());
	assertTrue(CRcardnotes.isDisplayed());
	assertTrue(CRcardreso.isDisplayed());
	assertTrue(CRcarddecline.isDisplayed());


	Actions act = new Actions(driver);
	act.moveToElement(CRcardlistmore).perform();
	assertTrue(CRcardlistmorehovermenu.isDisplayed());
	assertTrue(CRcardhoverop1.isDisplayed());
	assertTrue(CRcardhoverop2.isDisplayed());
	assertTrue(CRcardhoverop3.isDisplayed());
	assertTrue(CRcardhoverop4.isDisplayed());
	
	}
	
	public void verifyProcessedOppcardDetails() {
	assertTrue(PDcardlistmore.isDisplayed());
	assertTrue(PDcardEstTimetoImpact.isDisplayed());
	assertTrue(PDcardexport.isDisplayed());
	assertTrue(PDcardnotes.isDisplayed());
	assertTrue(PDcardreso.isDisplayed());
	assertTrue(PDcarddecline.isDisplayed());


	Actions act = new Actions(driver);
	act.moveToElement(PDcardlistmore).perform();
	assertTrue(PDcardlistmorehovermenu.isDisplayed());
	assertTrue(PDcardhoverop1.isDisplayed());
	assertTrue(PDcardhoverop2.isDisplayed());
	assertTrue(PDcardhoverop3.isDisplayed());
	assertTrue(PDcardhoverop4.isDisplayed());
	}
	
	public void verifyLostOppcardDetails() {

		assertTrue(LTcardlistmore.isDisplayed());
		assertTrue(LTcardEstTimetoImpact.isDisplayed());
		assertTrue(LTcardexport.isDisplayed());
		assertTrue(LTcardnotes.isDisplayed());
		assertTrue(LTcardreso.isDisplayed());
		assertTrue(LTcarddecline.isDisplayed());


		Actions act = new Actions(driver);
		act.moveToElement(LTcardlistmore).perform();
		assertTrue(LTcardlistmorehovermenu.isDisplayed());
		assertTrue(LTcardhoverop1.isDisplayed());
		assertTrue(LTcardhoverop2.isDisplayed());
		assertTrue(LTcardhoverop3.isDisplayed());
		assertTrue(LTcardhoverop4.isDisplayed());

	}

	public void verifyInvalidOppcardDetails() {

		assertTrue(IVcardlistmore.isDisplayed());
		assertTrue(IVcardEstTimetoImpact.isDisplayed());
		assertTrue(IVcardexport.isDisplayed());
		assertTrue(IVcardnotes.isDisplayed());
		assertTrue(IVcardreso.isDisplayed());
		assertTrue(IVcarddecline.isDisplayed());


		Actions act = new Actions(driver);
		act.moveToElement(IVcardlistmore).perform();
		assertTrue(IVcardlistmorehovermenu.isDisplayed());
		assertTrue(IVcardhoverop1.isDisplayed());
		assertTrue(IVcardhoverop2.isDisplayed());
		assertTrue(IVcardhoverop3.isDisplayed());
		assertTrue(IVcardhoverop4.isDisplayed());

	}
}
