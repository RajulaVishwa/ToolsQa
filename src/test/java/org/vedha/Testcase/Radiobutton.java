package org.vedha.Testcase;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Radiobutton {
	
  WebDriver driver;
	
	@BeforeMethod
	public void StartBrowser() {
		try {
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://demoqa.com/radio-button");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	 @Test
	    public void RadioButtonHandling() {
		 try {
			    String Expected_label="Do you like the site?";
				WebElement txt_label = driver.findElement(By.className("mb-3"));
				String Actual_label=txt_label.getText();
				
				Assert.assertEquals(Actual_label, Expected_label);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"mb-3\"]")));
		 
		        WebElement yesRadioButton = driver.findElement(By.xpath("//label[text()='Yes']/preceding-sibling::input"));
		        yesRadioButton.click();
		        Assert.assertTrue(yesRadioButton.isSelected(), "Yes radio button is selected");
		       
		        WebElement impressiveRadioButton = driver.findElement(By.xpath("//label[text()='Impressive']/preceding-sibling::input"));
		        Assert.assertFalse(impressiveRadioButton.isSelected(), "Impressive radio button is unchecked");
		        
		        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(4));
				wait1.until(ExpectedConditions.elementToBeClickable(By.name("like")));
		
		       
		}
		 catch (Exception e) {
			
		}
	 }    
}
