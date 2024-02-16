package org.vedha.Testcase;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Button {

	public WebDriver driver;
	@BeforeMethod
	public void startBrowser() {
		
		try {
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://demoqa.com/buttons");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test(description = "Performing doubleclick button to display its message")

	 public void testcase8(){
	    try {
	    	
	    	//WebElement button = driver.findElement(By.xpath("//span[text()=\"Buttons\"]"));
	    	/*WebElement button = driver.findElement(By.id("item-4"));
	    	button.click();*/
	    	  
	       	   String Expected_doubleclicklabel="Double Click Me";
				WebElement doubleclick =driver.findElement(By.id("doubleClickBtn"));
				String Actual_doubleclicklabel = doubleclick.getText();
				Assert.assertEquals(Actual_doubleclicklabel, Expected_doubleclicklabel);
				System.out.println(Actual_doubleclicklabel);
				
				Actions act = new Actions(driver);
				WebElement doubleclickk =driver.findElement(By.id("doubleClickBtn"));
				act.doubleClick(doubleclickk).perform();
				
				WebElement message= driver.findElement(By.id("doubleClickMessage"));
				if (message.isDisplayed()) {
					System.out.println("Doubleclick is performed");
				}
				/*else {
					System.out.println("Doubleclick is failed to perform");
				}*/
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
				wait.until(ExpectedConditions.elementToBeClickable(By.id("doubleClickBtn"))); 
	    } 
	    catch (NullPointerException e) {
			System.out.println(e);
		}
	}
		@Test	(description = "Performing right click button to display its message")
		public void testcase9() {
			try {
				 String Expected_rightclicklabel="Right Click Me";
					WebElement rightclick =driver.findElement(By.id("rightClickBtn"));
					String Actual_rightclicklabel = rightclick.getText();
					Assert.assertEquals(Actual_rightclicklabel, Expected_rightclicklabel);
					System.out.println(Actual_rightclicklabel);
					
					Actions act1 = new Actions(driver);
					WebElement rightclickk =driver.findElement(By.id("rightClickBtn"));
					act1.contextClick(rightclickk).perform();
					
					WebElement message1= driver.findElement(By.id("rightClickMessage"));
					if (driver.findElement(By.id("rightClickBtn")).isDisplayed()) {
						System.out.println("rightclick is performed");
					}
					
					WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(4));
					wait1.until(ExpectedConditions.elementToBeClickable(By.id("rightClickBtn"))); 
				
			} 
			catch (Exception e) {
				// TODO: handle exception
			}
		}
			@Test (description = "Performing click button to display its message")
			
			public void testcase10() {
			
			try {
				String Expected_clickmelabel="Click Me";
				WebElement clickme =driver.findElement(By.id("sso2q"));
				String Actual_clickmelabel = clickme.getText();
				Assert.assertEquals(Actual_clickmelabel, Expected_clickmelabel);
				System.out.println(Actual_clickmelabel);
				
				Actions act2 = new Actions(driver);
				WebElement clickmee =driver.findElement(By.id("sso2q"));
				act2.click(clickmee).perform();
				
				
				WebElement message2= driver.findElement(By.id("dynamicClickMessage"));
				if (message2.isDisplayed()) {
					System.out.println("You have done a dynamic click");
				}
				
				WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(4));
				wait2.until(ExpectedConditions.elementToBeClickable(By.id("sso2q"))); 
			}
			catch (NoSuchElementException e) {
			// TODO: handle exception
		}
	}
}


