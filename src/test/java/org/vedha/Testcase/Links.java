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

public class Links {
	 WebDriver driver;
	 @BeforeMethod
	 public void Startbrowser() {

		 try {
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://demoqa.com/links");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
					
			}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
	  
	 @Test (priority=1, enabled=true, description="Verify if link redirects to home page", groups="sanity")
	 public void testcase11 () {
		  try {
		 String Expected_homelabel="Home";
		 WebElement homelabel=driver.findElement(By.id("simpleLink"));
		 String Actual_homelabel= homelabel.getText();
		 Assert.assertEquals(Actual_homelabel, Expected_homelabel);
		 System.out.println(Actual_homelabel);
		 
		 WebElement link=driver.findElement(By.id("simpleLink"));
		 link.click();
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		 wait.until(ExpectedConditions.elementToBeSelected(link));
		  }
		  catch (Exception e) {
			  System.out.println(e);
		}
	 }
	 @Test(priority=2, enabled=false, description="Verify if link redirects to home page", groups="sanity")
	 public void testcase12() {
		 try {
			String Expected_home2label="Home";
			WebElement home2label=driver.findElement(By.id("dynamicLink"));
			String Actual_home2label=home2label.getText();
			Assert.assertEquals(Actual_home2label, Expected_home2label);
			
			 WebElement link1=driver.findElement(By.id("dynamicLink"));
			 link1.click();
			
			 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(4));
			 wait1.until(ExpectedConditions.elementToBeSelected(link1));
			
		} catch (Exception e) {
			System.out.println(e);
		}
	 }
	  
}
