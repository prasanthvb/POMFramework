package com.zifautomation.Pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ZIFAIAppSettingsPage {
	WebDriver driver;

	public ZIFAIAppSettingsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using="//span[contains(text(),'USER MANAGEMENT')]")
	private WebElement Usermanagementtab;

	@FindBy(how = How.XPATH, using="//span[contains(text(),'PLATFORM MANAGEMENT')]")
	private WebElement PlatformManagementtab;

	@FindBy(how = How.XPATH, using="//span[contains(text(),'DOMAIN MANAGEMENT')]")
	private WebElement DomainManagementtab;

	@FindBy(how = How.XPATH, using="//button[contains(@label,'Add New User')]")
	private WebElement AddnewUserbutton;

	@FindBy(how = How.XPATH, using="//input[contains(@placeholder,'Search')]")
	private WebElement searchTextbox;

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

	@FindBy(how = How.XPATH, using="//span[contains(@class,'hover_menus')]//div[contains(text(),'Raw Data')]")
	private WebElement SMrawdata;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'hover_menus')]//div[contains(text(),'Analytics')]")
	private WebElement SManalytics;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'hover_menus')]//div[contains(text(),'Predictions')]")
	private WebElement SMpredictions;





}
