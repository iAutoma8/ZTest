package com.Sel.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.Sel.Config.browserConfig;
import com.Sel.Pages.BrokenLinks;

public class BrokenLinkTest  extends browserConfig{
	
	
	public WebDriver driver;
	
	BrokenLinks links;
	
	@BeforeClass
	public void setDriver()
	{
		driver=getDriver();
	} 

	@Test
	public void verifyBrokenLinks() throws Exception
	{
		
		links=new BrokenLinks(driver);
		links.BrokenLinksOnPage();
		
		
	}
	

}
