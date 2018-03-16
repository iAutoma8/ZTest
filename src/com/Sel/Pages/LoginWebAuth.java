package com.Sel.Pages;

import org.openqa.selenium.WebDriver;
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
