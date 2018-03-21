package com.Sel.Config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.stream.FileImageInputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.Sel.Tests.LoginWebAuthTest;

public class browserConfig {

	public WebDriver driver;

	public WebDriver getDriver() {
	
		return driver;
	}

	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\EE\\MyWork\\ZTest\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

	}
	
	public static String getStringProperty(String s) throws IOException
	{
		File file=new File("D:\\EE\\MyWork\\ZTest\\src\\testData\\data.properties");
		FileInputStream fis=new FileInputStream(file);
		Properties pro=new Properties();
		pro.load(fis);
		String prop=pro.getProperty(s);
		
		
		return prop;
	}
	
	
@AfterMethod
	public void takeScreens() throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File file=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("D:\\EE\\MyWork\\ZTest\\screens\\x" + ".png"));
		
	}


}
