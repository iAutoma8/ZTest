package com.Sel.Tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Sel.Config.browserConfig;
import com.Sel.Pages.LoginWebAuth;

import utills.excelUtllity;

public class LoginWebAuthTest extends browserConfig {

	public WebDriver driver;
	LoginWebAuth login;
	SoftAssert sa = new SoftAssert();

	@BeforeClass
	public void setDriver() {

		driver = getDriver();

	}

	@Test
	void verifyPageTitle() {
		login = new LoginWebAuth(driver);

		try {
			login.lauchSite();

			// sa.assertEquals(login.getPageTitle(),excelUtllity.getExcelKeyValue("title1"));
			Assert.assertEquals(login.getPageTitle(), excelUtllity.getExcelKeyValue("title1")
					);

		} catch (Exception e) {
			System.out.println("Title is not Matched: Failed");
		}

	}

	@Test
	void zAfter() {
		System.out.println("Working Fine");
		System.out.println("After Hard Asserts");
	}

}
