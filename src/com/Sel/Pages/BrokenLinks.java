package com.Sel.Pages;


import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;





public class BrokenLinks{
	
	
	public WebDriver driver;
	URL nUrl;
	HttpURLConnection httpcon;
	public BrokenLinks(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	public void BrokenLinksOnPage() throws Exception 
	{
		List<WebElement> link=driver.findElements(By.xpath("//a[@href]"));
		System.out.println("Number Of Links :" +link.size());
		for(int i=0;i<link.size();i++)
		{
			
			String url=link.get(i).getAttribute("href");
			//System.out.println(url);
			
			try {
			nUrl= new URL(url);
			httpcon=(HttpURLConnection)nUrl.openConnection();
			httpcon.setConnectTimeout(2000);
			httpcon.connect();
			}catch(Exception e)
			{
				System.out.println(url + "---------------------------- Not Working");
			}
			
			if(httpcon.getResponseCode()==200)
			{
				System.out.println(url + " - " +httpcon.getResponseMessage());
			}
			else if(httpcon.getResponseCode()==404)
			{
				System.out.println(url + " - " +httpcon.getResponseMessage());
			}
		
		}
		
	}
	

}
