package org.vedha.Testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Checkbox {
	
	WebDriver driver;
	
	@BeforeMethod
	public void StartBrowser() {
		try {
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://demoqa.com/text-box");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void checkboxTC() {
		try {
			WebElement checkboxclick=driver.findElement(By.id("item-1"));
			checkboxclick.click();
			String Expected_label="Home";
			WebElement home_label=driver.findElement(By.xpath("//span[@class=\"rct-title\"]"));
			String ActualLabel_home = home_label.getText();
			Assert.assertEquals(Expected_label, Expected_label);
			
			WebElement checkbox = driver.findElement(By.xpath("//span[@class=\"rct-title\"]"));
			checkbox.click();
			
		    Assert.assertTrue(true,"home checkbox is clicked");
		    WebElement expand = driver.findElement(By.xpath("//button[@class=\"rct-option rct-option-expand-all\"]"));
		    expand.click();
		     
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
			wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//button[@type=\"button\"]")));
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

}
