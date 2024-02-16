package org.vedha.baseclass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class BaseDriver {
	
	protected WebDriver driver=null;
	//This below method launches browser
	public WebDriver chromeBrowser(String url) {
		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		return driver;
		
		
	
		
	}
}
