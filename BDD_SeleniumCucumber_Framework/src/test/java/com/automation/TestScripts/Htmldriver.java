package com.automation.TestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class Htmldriver {

	@Test
	public void run() {
		WebDriver driver = new HtmlUnitDriver(BrowserVersion.INTERNET_EXPLORER_11);
		// WebDriver driver = new HtmlUnitDriver(BrowserVersion.)
		// Set implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Open "Google.com and search SoftwareTestingMaterial.com"
		driver.get("https://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("softwaretestingmaterial.com");
		element.submit();
		// Click on Software Testing Material link
		driver.findElement(By.linkText("Software Testing Material")).click();
		// Get the title of the site and store it in the variable Title
		String Title = driver.getTitle();
		// Print the title
		System.out.println("I am at " + Title);

	}

}
