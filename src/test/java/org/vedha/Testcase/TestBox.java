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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestBox {
	
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
	public void toolsqaTC1() {
		try {
			String Expected_userName_label="Full Name";
			WebElement lbl_Username = driver.findElement(By.id("userName-label"));
			String Actual_lblUsername=lbl_Username.getText();
			System.out.println(Actual_lblUsername);
			Assert.assertEquals(Actual_lblUsername, Expected_userName_label);	
			WebElement txt_Usernameplaceholder = driver.findElement(By.xpath("//input[@placeholder=\"Full Name\"]"));
			String Actual_txt_Username=txt_Usernameplaceholder.getAttribute("placeholder");
			txt_Usernameplaceholder.sendKeys("Vishwa");
			Assert.assertEquals(Actual_txt_Username, Expected_userName_label);	
			//WebElement txt_userName=driver.findElement(By.xpath("//input[@placeholder=\"Full Name\"]"));
		//	txt_userName.sendKeys("Vishwa");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("userName")));
			
		} catch (Exception e) {
			
		}
		
	}
	@Test
	public void toolsqTC2() {
	try {
		String Expected_userEmail_label="Email";
		WebElement lbl_email = driver.findElement(By.id("userEmail-label"));
		String Actual_lblemail=lbl_email.getText();
		Assert.assertEquals(Actual_lblemail, Expected_userEmail_label);	
		String Expected_txt_Email="name@example.com";
		WebElement txt_emailplaceholder = driver.findElement(By.xpath("//input[@placeholder=\"name@example.com\"]"));
		String Actual_txt_email=txt_emailplaceholder.getAttribute("placeholder");
		Assert.assertEquals(Actual_txt_email, Expected_txt_Email);
		WebElement txt_email=driver.findElement(By.xpath("//input[@placeholder=\"name@example.com\"]"));
		txt_email.sendKeys("rajulavishwa01@gmail.com");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("userEmail")));
	} catch (Exception e) {
		// TODO: handle exception
	}
			
					
	}
@Test
	public void toolsqaTC3 (){
		try {
			String Expected_currentAddress_label="Current Address";
			WebElement lbl_currentaddress = driver.findElement(By.id("currentAddress-label"));
			String Actual_lblCurrentaddress=lbl_currentaddress.getText();
			lbl_currentaddress.sendKeys();
			Assert.assertEquals(Actual_lblCurrentaddress, Expected_currentAddress_label);	
			WebElement txt_Currentaddressplaceholder = driver.findElement(By.xpath("//textarea[@placeholder=\"Current Address\"]"));
			String Actual_txt_Currentaddress=txt_Currentaddressplaceholder.getAttribute("placeholder");
			Assert.assertEquals(Actual_lblCurrentaddress, Expected_currentAddress_label);	
			WebElement txt_currentaddress=driver.findElement(By.xpath("//textarea[@placeholder=\"Current Address\"]"));
			txt_currentaddress.sendKeys("SBH COLONY , Saidabad , Hyderabad , Telangana");
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("currentAddress")));
		} catch (Exception e) {
			// TODO: handle exception
		}
			
	}
@Test
   public void toolsqaTC4() {
	   try {
		   String Expected_permanentAddress_label="Permanent Address";
			
		   WebElement lbl_permanentaddress = driver.findElement(By.id("permanentAddress-label"));
			String Actual_lblPermanentaddress=lbl_permanentaddress.getText();
			Assert.assertEquals(Actual_lblPermanentaddress, Expected_permanentAddress_label);	
			
			WebElement txt_Permanentaddressplaceholder = driver.findElement(By.id("permanentAddress"));
			String Actual_txt_Permanentaddress=txt_Permanentaddressplaceholder.getAttribute("id");
			Assert.assertEquals(Actual_lblPermanentaddress, Expected_permanentAddress_label);
			
			WebElement txt_Permanentaddress=driver.findElement(By.id("permanentAddress"));
			txt_Permanentaddress.sendKeys("SBH COLONY , Saidabad , Hyderabad , Telangana");
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("permanentAddress"))); 
	} catch (NoSuchElementException e) {
		// TODO: handle exception
	}  
   }

  @Test
  public void toolsqaTC5() {
	  try {
		String Expected_label="Submit";
		WebElement submitButton=driver.findElement(By.xpath("//div[@class=\"text-right col-md-2 col-sm-12\"]"));
		String Actual_label=submitButton.getText();
		Assert.assertEquals(Actual_label, Expected_label);
		WebElement button=driver.findElement(By.id("submit"));
		button.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("submit"))); 
	  } catch (Exception e) {
	  } 
  }
}
