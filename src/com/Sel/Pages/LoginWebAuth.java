package com.Sel.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import com.Sel.Config.browserConfig;

public class LoginWebAuth {
	public WebDriver driver;
	
	public LoginWebAuth(WebDriver driver) {

		this.driver = driver;
		
	}

	
	public void lauchSite() {

		try {
			driver.get(browserConfig.getStringProperty("URL"));
			driver.manage().window().maximize();
			WebElement btn_search= driver.findElement(By.xpath("//input[@value='Google Search']"));
			WebDriverWait wait=new WebDriverWait(driver, 5l);
			wait.until(ExpectedConditions.elementToBeClickable(btn_search));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	public String getPageTitle() {
		String title = null;
		try {
			title = (driver.getTitle());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return title;
	}

}
