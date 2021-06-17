package com.zifautomation.Pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ZIFAI_CaseManagementPage {
	WebDriver driver;

	public ZIFAI_CaseManagementPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using="//span[text()='Dashboard']")
	private WebElement dashboardTitle;

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
	@FindBy(how = How.XPATH, using="//*[contains(@class,'hover_menus')]")
	private WebElement analyzeshovermenu;

	@FindBy(how = How.XPATH, using="//*[contains(@class,'hover_menus')]//*[contains(text(),'OPERATIONS')]")
	private WebElement operationheader;

	@FindBy(how = How.XPATH, using="//*[contains(@class,'hover_menus')]//*[contains(text(),'RawData')]")
	private WebElement SMrawdata;

	@FindBy(how = How.XPATH, using="//*[contains(@class,'hover_menus')]//*[contains(text(),'Analytics')]")
	private WebElement SManalytics;

	@FindBy(how = How.XPATH, using="//*[contains(@class,'hover_menus')]//*[contains(text(),'Predictions')]")
	private WebElement SMpredictions;


	@FindBy(how = How.XPATH, using="//*[contains(text(),'Operations')]")
	private WebElement OperationsTitle;
	@FindBy(how = How.XPATH, using="//*[contains(text(),'ANALYTICS :')]")
	private WebElement ANALYTICShdr;
	@FindBy(how = How.XPATH, using="//*[contains(text(),'CASE MANAGEMENT')]")
	private WebElement caseManagementLink;
	@FindBy(how = How.XPATH, using="//*[contains(text(),'INCIDENT ANALYTICS')]")
	private WebElement incidentAnalyticsLink;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'SECURITY')]")
	private WebElement securitylink;
	
	
	//Suppression 
	
	@FindBy(how = How.XPATH, using="//div[contains(@class,'supp_img_h')]")
	private WebElement supressionicon;
	@FindBy(how = How.XPATH, using="//div[contains(@ptooltip,'Suppression')]")
	private WebElement supressionTooltip;
	
	//Correlation
	
	@FindBy(how = How.XPATH, using="//div[contains(@class,'gtm_img_n')]")
	private WebElement Correlationicon;
	@FindBy(how = How.XPATH, using="//div[contains(@ptooltip,'Correlation')]")
	private WebElement CorrelationTooltip;
	
	
	
	
	//adaptor status
	@FindBy(how = How.XPATH, using="//span[contains(text(),'ZIF Adapter Status')]")
	private WebElement adaptorstatustext;
	@FindBy(how = How.XPATH, using="//span[contains(@class,'zif-health-status')]")
	private WebElement adaptorhealthstatus;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'zif-health-up')]")
	private WebElement adaptorhealthstatusup;
	@FindBy(how = How.XPATH, using="//span[contains(@class,'zif-health-down')]")
	private WebElement adaptorhealthstatusdown;
	
	//live feed 
	@FindBy(how = How.XPATH, using="//*[contains(@class,'enable-menu tab-livefeed')]")
	private WebElement livefeedon;
	@FindBy(how = How.XPATH, using="//*[contains(@class,'enable-menu tab-pausefeed')]")
	private WebElement livefeedoff;
	
	//Filter
	@FindBy(how = How.XPATH, using="//div[contains(@class,'filters')]")
	private WebElement filterIcon;
	@FindBy(how = How.XPATH, using="//div[contains(@class,'filter')]")
	private WebElement filterIconwithdots;
	
	//Export
	@FindBy(how = How.XPATH, using="//div[contains(@class,'tab-export')]")
	private WebElement ExportrIcon;
	@FindBy(how = How.XPATH, using="//div[contains(@ptooltip,'Export')]")
	private WebElement ExportTooltip;
	
	//Preference 
	@FindBy(how = How.XPATH, using="//div[contains(@class,'tab-pref')]")
	private WebElement prefereceIcon;
	@FindBy(how = How.XPATH, using="//div[contains(@class,'tab-apply_pref')]")
	private WebElement prefereceIconwithdots;
	@FindBy(how = How.XPATH, using="//div[contains(@ptooltip,'Preferences')]")
	private WebElement prefereceIconTooltip;
	// Case Management Settings Icon
	@FindBy(how = How.XPATH, using="//div[contains(@class,'settings')]")
	private WebElement alertSettingsIcon;
	@FindBy(how = How.XPATH, using="//div[contains(@class,'tab-settings enable-menu')]")
	private WebElement alertSettingsIconenabled;
	@FindBy(how = How.XPATH, using="//div[contains(@class,'tab-settings disabled-menu')]")
	private WebElement alertSettingsIconDisabled;
	@FindBy(how = How.XPATH, using="//*[contains(@ptooltip,'Settings')]")
	private WebElement alertSettingsTooltip;
	
	
	
	//Alert with 2 - 5 same Description
	
	@FindBy(how = How.XPATH, using="(//*[@class='case-second-txt padding-bell' and text()='2'])[1]")
	private WebElement Alertwith2;
	@FindBy(how = How.XPATH, using="(//*[@class='case-second-txt padding-bell' and text()='3'])[1]")
	private WebElement Alertwith3;
	@FindBy(how = How.XPATH, using="(//*[@class='case-second-txt padding-bell' and text()='4'])[1]")
	private WebElement Alertwith4;
	@FindBy(how = How.XPATH, using="(//*[@class='case-second-txt padding-bell' and text()='5'])[1]")
	private WebElement Alertwith5;
	
	
	
	//Inside Alert
	
	@FindBy(how = How.XPATH, using="//*[contains(text(),'Acknowledge')]")
	private WebElement AlertAcknowledge;
	@FindBy(how = How.XPATH, using="//*[contains(text(),'Export')]")
	private WebElement AlertExport;
	@FindBy(how = How.XPATH, using="//*[contains(text(),'Edit')]")
	private WebElement AlertEdit;
	@FindBy(how = How.XPATH, using="//*[contains(text(),'Expand')]")
	private WebElement AlertExpand;
	@FindBy(how = How.XPATH, using="//*[contains(text(),'Collapse')]")
	private WebElement AlertCollapse;
	@FindBy(how = How.XPATH, using="//*[contains(@class,'closeAd')]")
	private WebElement AlertClose;
	
	@FindBy(how = How.XPATH, using="//*[contains(text(),'Root cause')]")
	private WebElement AlertRootcause;
	@FindBy(how = How.XPATH, using="//*[contains(text(),'Correlated Alerts')]")
	private WebElement CorrelatedAlerts;
	@FindBy(how = How.XPATH, using="//*[contains(text(),'Timeline')]")
	private WebElement Timeline;
	
	
	
	// First Alerts ID and its Status
	
	@FindBy(how = How.XPATH, using="(//*[@class='analytics_id'])[1]")
	private WebElement FirtsAlertID;
	@FindBy(how = How.XPATH, using="(//*[contains(@class,'case-first-left-icon-2-new')])[1]")
	private WebElement FirtsAlertNewStatus;
	@FindBy(how = How.XPATH, using="(//*[contains(@class,'case-first-left-icon-2-assigned')])[1]")
	private WebElement FirtsAlertAssignedStatus;
	@FindBy(how = How.XPATH, using="(//*[contains(@class,'case-first-left-icon-2 corr_inprogress')])[1]")
	private WebElement FirtsAlertInprogressStatus;
	@FindBy(how = How.XPATH, using="(//*[contains(@class,'case-first-left-icon-2-closed')])[1]")
	private WebElement FirtsAlertClosedStatus;
	
	
	
	
	// Edit Alerts Status 
	@FindBy(how = How.XPATH, using="//*[contains(@formcontrolname,'status')]")
	private WebElement StatusDD;
	@FindBy(how = How.XPATH, using="//*[contains(@aria-label,'New')]")
	private WebElement DDNewStatus;
	@FindBy(how = How.XPATH, using="//*[contains(@aria-label,'Assigned')]")
	private WebElement DDAssignedStatus;
	@FindBy(how = How.XPATH, using="//*[contains(@aria-label,'InProgress')]")
	private WebElement DDInprogressStatus;
	@FindBy(how = How.XPATH, using="//*[contains(@aria-label,'Closed')]")
	private WebElement DDClosedStatus;
	
	@FindBy(how = How.XPATH, using="(//*[contains(text(),'Notes')]/following::*//textarea)[1]")
	private WebElement NotesText;
	@FindBy(how = How.XPATH, using="(//*[contains(text(),'Reference')]/following::*//textarea)[1]")
	private WebElement ReferenceText;
	
	@FindBy(how = How.XPATH, using="//*[contains(text(),'Apply')]")
	private WebElement ApplyEdit;
	@FindBy(how = How.XPATH, using="//*[contains(text(),'Clear')]")
	private WebElement ClearEdit;
	
	
	// Total Alert cases available
		@FindBy(how = How.XPATH, using="//*[contains(@class,'case-heading-outer')]//div")
		private WebElement TotalCasescount;
		
		
	//No data found
		@FindBy(how = How.XPATH, using="//*[contains(text(),'No Data Found')]")
		private WebElement Nodatafound;
		
	// Preferences and Filter Same columns
	//Preferences
		@FindBy(how = How.XPATH, using="//input[@formcontrolname='caseId']")
		private WebElement PrefCaseID;
		@FindBy(how = How.XPATH, using="//input[@formcontrolname='severity']")
		private WebElement PrefSeverity;
		@FindBy(how = How.XPATH, using="//input[@formcontrolname='toolName']")
		private WebElement PrefToolName;
		@FindBy(how = How.XPATH, using="//*[contains(text(),'Apply')]")
		private WebElement PrefApply;
		@FindBy(how = How.XPATH, using="//*[contains(text(),'Cancel')]")
		private WebElement Prefcancel;
		@FindBy(how = How.XPATH, using="//*[contains(@class,'ui-dialog-titlebar-close')]")
		private WebElement Prefclose;
		
		
		//Filter
		@FindBy(how = How.XPATH, using="//input[@formcontrolname='caseIdfl']")
		private WebElement FilterCaseID;
		@FindBy(how = How.XPATH, using="//input[@formcontrolname='caseseverity']")
		private WebElement FilterSeverity;
		@FindBy(how = How.XPATH, using="//input[@formcontrolname='casetoolName']")
		private WebElement FilterToolName;
		@FindBy(how = How.XPATH, using="//*[contains(text(),'Apply')]")
		private WebElement FilterApply;
		@FindBy(how = How.XPATH, using="//*[contains(text(),'Clear')]")
		private WebElement FilterClear;
		@FindBy(how = How.XPATH, using="//*[contains(@class,'ui-dialog-titlebar-close')]")
		private WebElement Filterclose;
					
	//--------------------------------End Of Locators-------------------------------
	//--------------------------------Methods----------------------------------------
	
	
	public void CheckallfieldsandImages(){

		assertTrue(zifIclogo.isDisplayed());
		assertTrue(dashboardTitle.isDisplayed());
		assertTrue(dashboardicon.isDisplayed());
		assertTrue(analyzeIcon.isDisplayed());
		assertTrue(analyzesubmenuIcon.isDisplayed());
		assertTrue(settingsIcon.isDisplayed());
		assertTrue(qwaitIcon.isDisplayed());
		assertTrue(searchcommonIcon.isDisplayed());
		assertTrue(logoutIcon.isDisplayed());

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
	
	public void clickRawData(){

		SMrawdata.click();
	}

	public void LogoutClick(){

		logoutIcon.click();
	}
	
	public void clickAppSettings(){
	settingsIcon.click();
	}
	
	public void clickAnalytics(){
		SManalytics.click();
		}
	
	
	public void Turnofflivefeed() {
		try {
			if(livefeedon.isDisplayed()) {
				livefeedon.click();
				Thread.sleep(2000);
				assertTrue(livefeedoff.isDisplayed());
			}
		}catch (Exception e) {
		}
	}
	
	public void AlertsExpandandCollapse() {
		try {
			AlertExpand.click();
			Thread.sleep(2000);
			assertTrue(AlertCollapse.isDisplayed());
			AlertCollapse.click();
			assertTrue(AlertExpand.isDisplayed());
			AlertExpand.click();
			Thread.sleep(2000);
			
		}catch (Exception e) {
		}
	}
	
	public void AlertsDescriptionTitles() {
		try {
			assertTrue(AlertRootcause.isDisplayed());
			assertTrue(CorrelatedAlerts.isDisplayed());
			assertTrue(Timeline.isDisplayed());			
		}catch (Exception e) {
		}
	}
	
	
	public void ClickonanyAlertswith5or4or3() {
		try {
			if(Alertwith5.isDisplayed()) {
				Alertwith5.click();
				Thread.sleep(2000);
				//Alert Expand and collapse verified
				AlertsExpandandCollapse();
				AlertsDescriptionTitles();
				CorrelatedAlerts.click();
				
				//Verify 5 records with same description in Correlated Alerts
				List<WebElement> records = driver.findElements(By.xpath("//*[contains(@class,'correlated-alerts-record-outer')]"));
				int size = records.size();
				if(size==5) {
					for(int i=2;i<=5;i++) {
						WebElement FirstDesc = driver.findElement(By.xpath("(//*[contains(@class,'correlated-alerts-record-desc')]//div[1])[1]"));
						String Desc1 = FirstDesc.getText();
						WebElement nextdesc = driver.findElement(By.xpath("(//*[contains(@class,'correlated-alerts-record-desc')]//div[1])["+i+"]"));
						String Next = nextdesc.getText();
						assertTrue(Next.equals(Desc1));
					}
				}
				
				//Verify 5 records with same description in Timeline
				Timeline.click();
				List<WebElement> Trecord = driver.findElements(By.xpath("//*[contains(@class,'timeline-panel')]"));
				int size1 = Trecord.size();
				if(size1==5) {
					for(int i=2;i<=5;i++) {
						WebElement FirstDesc = driver.findElement(By.xpath("(//*[contains(@class,'timeline-desc')]//following::div[1])[1]"));
						String Desc1 = FirstDesc.getText();
						WebElement nextdesc = driver.findElement(By.xpath("//*[contains(@class,'timeline-desc')]//following::div[1])["+i+"]"));
						String Next = nextdesc.getText();
						assertTrue(Next.equals(Desc1));
					}
					AlertClose.click();
				}
			}else if (Alertwith4.isDisplayed()) {
				Alertwith4.click();
				Thread.sleep(2000);
				//Alert Expand and collapse verified
				AlertsExpandandCollapse();
				AlertsDescriptionTitles();
				CorrelatedAlerts.click();
				
				//Verify 4 records with same description in Correlated Alerts
				List<WebElement> records = driver.findElements(By.xpath("//*[contains(@class,'correlated-alerts-record-outer')]"));
				int size = records.size();
				if(size==4) {
					for(int i=2;i<=4;i++) {
						WebElement FirstDesc = driver.findElement(By.xpath("(//*[contains(@class,'correlated-alerts-record-desc')]//div[1])[1]"));
						String Desc1 = FirstDesc.getText();
						WebElement nextdesc = driver.findElement(By.xpath("(//*[contains(@class,'correlated-alerts-record-desc')]//div[1])["+i+"]"));
						String Next = nextdesc.getText();
						assertTrue(Next.equals(Desc1));
					}
				}
				
				//Verify 5 records with same description in Timeline
				Timeline.click();
				List<WebElement> Trecord = driver.findElements(By.xpath("//*[contains(@class,'timeline-panel')]"));
				int size1 = Trecord.size();
				if(size1==4) {
					for(int i=2;i<=4;i++) {
						WebElement FirstDesc = driver.findElement(By.xpath("(//*[contains(@class,'timeline-desc')]//following::div[1])[1]"));
						String Desc1 = FirstDesc.getText();
						WebElement nextdesc = driver.findElement(By.xpath("//*[contains(@class,'timeline-desc')]//following::div[1])["+i+"]"));
						String Next = nextdesc.getText();
						assertTrue(Next.equals(Desc1));
					}AlertClose.click();
					}
				}else if (Alertwith3.isDisplayed()){
						Alertwith3.click();
						Thread.sleep(2000);
						//Alert Expand and collapse verified
						AlertsExpandandCollapse();
						AlertsDescriptionTitles();
						CorrelatedAlerts.click();
						
						//Verify 3 records with same description in Correlated Alerts
						List<WebElement> records = driver.findElements(By.xpath("//*[contains(@class,'correlated-alerts-record-outer')]"));
						int size = records.size();
						if(size==3) {
							for(int i=2;i<=3;i++) {
								WebElement FirstDesc = driver.findElement(By.xpath("(//*[contains(@class,'correlated-alerts-record-desc')]//div[1])[1]"));
								String Desc1 = FirstDesc.getText();
								WebElement nextdesc = driver.findElement(By.xpath("(//*[contains(@class,'correlated-alerts-record-desc')]//div[1])["+i+"]"));
								String Next = nextdesc.getText();
								assertTrue(Next.equals(Desc1));
							}
						}
						
						//Verify 3 records with same description in Timeline
						Timeline.click();
						List<WebElement> Trecord = driver.findElements(By.xpath("//*[contains(@class,'timeline-panel')]"));
						int size1 = Trecord.size();
						if(size1==3) {
							for(int i=2;i<=3;i++) {
								WebElement FirstDesc = driver.findElement(By.xpath("(//*[contains(@class,'timeline-desc')]//following::div[1])[1]"));
								String Desc1 = FirstDesc.getText();
								WebElement nextdesc = driver.findElement(By.xpath("//*[contains(@class,'timeline-desc')]//following::div[1])["+i+"]"));
								String Next = nextdesc.getText();
								assertTrue(Next.equals(Desc1));
							}AlertClose.click();
							}
					}else if (Alertwith2.isDisplayed()){
						Alertwith2.click();
						Thread.sleep(2000);
						//Alert Expand and collapse verified
						AlertsExpandandCollapse();
						AlertsDescriptionTitles();
						CorrelatedAlerts.click();
						
						//Verify 2 records with same description in Correlated Alerts
						List<WebElement> records = driver.findElements(By.xpath("//*[contains(@class,'correlated-alerts-record-outer')]"));
						int size = records.size();
						if(size==2) {
							for(int i=2;i<=2;i++) {
								WebElement FirstDesc = driver.findElement(By.xpath("(//*[contains(@class,'correlated-alerts-record-desc')]//div[1])[1]"));
								String Desc1 = FirstDesc.getText();
								WebElement nextdesc = driver.findElement(By.xpath("(//*[contains(@class,'correlated-alerts-record-desc')]//div[1])["+i+"]"));
								String Next = nextdesc.getText();
								assertTrue(Next.equals(Desc1));
							}
						}
						
						//Verify 2 records with same description in Timeline
						Timeline.click();
						List<WebElement> Trecord = driver.findElements(By.xpath("//*[contains(@class,'timeline-panel')]"));
						int size1 = Trecord.size();
						if(size1==2) {
							for(int i=2;i<=2;i++) {
								WebElement FirstDesc = driver.findElement(By.xpath("(//*[contains(@class,'timeline-desc')]//following::div[1])[1]"));
								String Desc1 = FirstDesc.getText();
								WebElement nextdesc = driver.findElement(By.xpath("//*[contains(@class,'timeline-desc')]//following::div[1])["+i+"]"));
								String Next = nextdesc.getText();
								assertTrue(Next.equals(Desc1));
							}AlertClose.click(); 
							}
					}
			
		}catch (Exception e) {
		}
	}
	
	public void AlertDetailsClose() {
		try {
			assertTrue(AlertClose.isDisplayed());
			AlertClose.click();		
		}catch (Exception e) {
		}
	}

	public void ClickFirstAlert() {
		try {
			assertTrue(FirtsAlertID.isDisplayed());
			FirtsAlertID.click();		
		}catch (Exception e) {
		}
	}
	
	public void ClickEditandAssignNew() {
		try {
			assertTrue(AlertEdit.isDisplayed());
			AlertEdit.click();
			ClearEdit.click();
			StatusDD.click();
			Thread.sleep(2000);
			DDNewStatus.click();
			ReferenceText.sendKeys("New Status Verification");
			NotesText.sendKeys("New Status Verification");
			ApplyEdit.click();
			Thread.sleep(2000);
			assertTrue(FirtsAlertNewStatus.isDisplayed());
		}catch (Exception e) {
		}
	}
	public void ClickEditandAssignAssigned() {
		try {
			assertTrue(AlertEdit.isDisplayed());
			AlertEdit.click();
			ClearEdit.click();
			StatusDD.click();
			Thread.sleep(2000);
			DDAssignedStatus.click();
			ReferenceText.sendKeys("Assigned Status Verification");
			NotesText.sendKeys("Assigned Status Verification");
			ApplyEdit.click();
			Thread.sleep(2000);
			assertTrue(FirtsAlertAssignedStatus.isDisplayed());	
		}catch (Exception e) {
		}
	}
	public void ClickEditandAssignInprogress() {
		try {
			assertTrue(AlertEdit.isDisplayed());
			AlertEdit.click();
			ClearEdit.click();
			StatusDD.click();
			Thread.sleep(2000);
			DDInprogressStatus.click();
			ReferenceText.sendKeys("Inprogress Status Verification");
			NotesText.sendKeys("Inprogress Status Verification");
			ApplyEdit.click();
			Thread.sleep(2000);
			assertTrue(FirtsAlertInprogressStatus.isDisplayed());		
		}catch (Exception e) {
		}
	}
	
	public void ClickEditandAssignClosed() {
		try {
			assertTrue(AlertEdit.isDisplayed());
			AlertEdit.click();
			ClearEdit.click();
			StatusDD.click();
			Thread.sleep(2000);
			DDClosedStatus.click();
			ReferenceText.sendKeys("Closed Status Verification");
			NotesText.sendKeys("Closed Status Verification");
			ApplyEdit.click();
			Thread.sleep(2000);
			assertTrue(FirtsAlertClosedStatus.isDisplayed());		
		}catch (Exception e) {
		}
	}
	
	public String GetTotalAlertCount() {		
			String Totalcount = TotalCasescount.getText();
		return Totalcount;
		}
	
	public void ClearFilterandPreference() {		
		try {
			prefereceIcon.click();
			PrefCaseID.clear();
			PrefSeverity.clear();
			PrefToolName.clear();
			PrefApply.click();
			Thread.sleep(2000);
		}catch (Exception e) {
			
		}
	}
	
	public void CheckSeverityviaPreftoFilter() {
		try {
			String getTotalAlertCount = GetTotalAlertCount();
			assertTrue(prefereceIcon.isDisplayed());
			prefereceIcon.click();	
			PrefSeverity.clear();
			PrefSeverity.sendKeys("Low");
			PrefApply.click();
			Thread.sleep(2000);
			String changecountofPref = GetTotalAlertCount();
			assertFalse(getTotalAlertCount.equalsIgnoreCase(changecountofPref));
			
			filterIcon.click();
			FilterSeverity.clear();
			FilterSeverity.sendKeys("Low");
			FilterApply.click();
			Thread.sleep(2000);
			String changecountofBoth = GetTotalAlertCount();
			assertTrue(changecountofPref.equalsIgnoreCase(changecountofBoth));
						
			filterIcon.click();
			FilterSeverity.clear();
			FilterSeverity.sendKeys("High");
			FilterApply.click();
			Thread.sleep(2000);
			assertTrue(Nodatafound.isDisplayed());
			
			
		}catch (Exception e) {
		}
	}
	
	public void CheckSeverityviaFiltertoPref() {
		try {
			assertTrue(prefereceIcon.isDisplayed());
			FirtsAlertID.click();		
		}catch (Exception e) {
		}
	}
	

}
