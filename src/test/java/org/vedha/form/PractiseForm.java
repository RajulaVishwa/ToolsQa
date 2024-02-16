package org.vedha.form;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.vedha.objectrepositry.ElementsPage;

public class PractiseForm extends ElementsPage{
	
	ElementsPage elementPage;
	public String Expected_Name_label="Name";
	public String Expected_frstplaceholder="First Name";
	public String Expected_lastplaceholder = "Last Name";
	public String Expected_emaillabel = "Email";
	public String Expected_txt_Email="name@example.com";
    public String Expected_genderlabel="Gender";
    public String Expected_mobile_label="Mobile(10 Digits)";
    public String Expected_digits="Mobile Number";
    public String Expected_DOB_label="Date of Birth";
    public String Expected_subject_label="Subjects";
    public String Expected_hobbies_label="Hobbies";
    public String Expected_currentAddress_label="Current Address";
    
	@BeforeMethod
	public void StartBrowser() {
		try {
		   driver=chromeBrowser("https://demoqa.com/automation-practice-form");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority=1 , enabled = true , description ="verify and validate the name section", groups="group1")
	public void testcase1() {
		try {
			
			elementPage.lbl_userName();
			String Actual_lblname=elementPage.lbl_userName().getText();
			System.out.println(Actual_lblname);
			Assert.assertEquals(Actual_lblname, Expected_Name_label);
		}
			catch (Exception e) {
				System.out.println(e);;
			}
		}
	@Test(priority=2 , enabled = true , description ="verify and validate the firstname section", groups="group2")
	public void tetcase2() {
		try {
			elementPage.txt_plceholder();
			String Actual_firstplaceholder = elementPage.txt_plceholder().getAttribute(Expected_Name_label);
			elementPage.txt_plceholder().sendKeys("Vishwa");	
			System.out.println(Actual_firstplaceholder);
			Assert.assertEquals(Actual_firstplaceholder, Expected_frstplaceholder);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstName")));
			
		} catch (NoSuchElementException e) {
		     System.out.println(e);
		}
	}
	
	@Test(priority=3 , enabled = true , description ="verify and validate the lastname section", groups="group3")
	public void testcase3() {
		try {
			
			elementPage.txt_lastplceholder();
			String Actual_lastplaceholder =elementPage.txt_lastplceholder().getAttribute("placeholder");
		    elementPage.txt_lastplceholder().sendKeys("Rajula");
		    System.out.println(Actual_lastplaceholder);
		    Assert.assertEquals(Actual_lastplaceholder, Expected_lastplaceholder);
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
			wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("lastName")));
			
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
   @Test(priority=4 , enabled = true , description ="verify and validate email section", groups="group4")
   public void testcase4() {
	   try {
		elementPage.Label_email();
		String Actual_emaillabel=elementPage.Label_email().getText();
		System.out.println(Actual_emaillabel);
		Assert.assertEquals(Actual_emaillabel, Expected_emaillabel);
		
		elementPage.Email_placeholder();
		String Actual_txt_email =elementPage.Email_placeholder().getAttribute("placeholder");
		Assert.assertEquals(Actual_txt_email, Expected_txt_Email);
		
		elementPage.Email_placeholder().sendKeys("rajulavishwa01@gmail.com");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("userEmail")));
		
	} catch (Exception e) {
		System.out.println(e);
	}
   }
   
   @Test(priority=5 , enabled = true , description ="verify the radio button by selecting only one", groups="group5")
   public void testcase5() {
	   try {
		   WebElement txt_genderlabel = driver.findElement(By.xpath("//label[text()='Gender']"));
			String Actual_genderlabel=txt_genderlabel.getText();
			System.out.println(Actual_genderlabel);
			Assert.assertEquals(Actual_genderlabel, Expected_genderlabel);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Gender']")));
			
	
			WebElement maleElement = driver.findElement(By.id("gender-radio-1"));
			boolean selectmale = maleElement.isSelected();
			System.out.print(selectmale);
			
			if (selectmale == true) {
				maleElement.click();
			}

			WebElement femaleElem = driver.findElement(By.xpath("//input[@id=\"gender-radio-1\"]"));
			boolean selfemale = maleElement.isDisplayed();

			if (selfemale == true) {
			maleElement.click();
			}	
			 
			WebElement otherElem = driver.findElement(By.cssSelector("input[id='gender-radio-3']"));
			boolean selectother = maleElement.isDisplayed();
			
			if (selectother == true) {
				maleElement.click();
			}

	} catch (StaleElementReferenceException e) {
		
	 }
   }
   @Test(priority=6 , enabled = true , description ="verify the mobilenumber label and enter value", groups="group6")
   public void testcase6() {
	   try {
			WebElement mobileno_label=driver.findElement(By.id("userNumber-label"));
			String Actual_mobilelabel=mobileno_label.getText();
			System.out.println(Actual_mobilelabel);
			Assert.assertEquals(Actual_mobilelabel, Expected_mobile_label);
			
			WebElement digits = driver.findElement(By.xpath("//input[@placeholder=\"Mobile Number\"]"));
			String Actual_digits = digits.getAttribute("placeholder");
			Assert.assertEquals(Actual_digits, Expected_digits);
			WebElement digitalnum =driver.findElement(By.xpath("//input[@placeholder=\"Mobile Number\"]"));
			digitalnum.sendKeys("9491420707");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
			wait.until(ExpectedConditions.elementToBeSelected(By.id("userNumber")));
			
		} catch (TimeoutException e) {
			System.out.println(e);
		} 
   }
   @Test(priority=7 , enabled = true , description ="verify the DOB and select the value", groups="group7")
   public void testcase7() {
	   try {
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("window.scrollBy(0,350)");
		   
		   WebElement DOB_label=driver.findElement(By.id("dateOfBirth-label"));
			String Actual_DOBlabel= DOB_label.getText();
			System.out.println(Actual_DOBlabel);
			Assert.assertEquals(Actual_DOBlabel, Expected_DOB_label);
		   
		   WebElement dobInput = driver.findElement(By.id("dateOfBirthInput"));
	        dobInput.click();

	        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker")));

	        WebElement yearDropdown = driver.findElement(By.className("react-datepicker__year-select"));
	        yearDropdown.sendKeys("2000");

	        WebElement monthDropdown = driver.findElement(By.className("react-datepicker__month-select"));
	        monthDropdown.sendKeys("February");

	        WebElement day = driver.findElement(By.xpath("//div[@aria-label=\"Choose Monday, February 14th, 2000\"]"));
	        day.click();

	        String selectedDate = dobInput.getAttribute("value");
	        assert selectedDate.equals("14 Feb 2000");
	   }
	  catch (Exception e) {
		System.out.println(e);
	}
  }
   @Test(priority=8 , enabled = true , description ="validate subject label and enter value to verify", groups="group8")
   public void testcase8() {
	   try {
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("window.scrollBy(0,440)");
		   
		   WebElement subject_label=driver.findElement(By.id("subjects-label"));
			String Actual_subjectlabel= subject_label.getText();
			System.out.println(Actual_subjectlabel);
			Assert.assertEquals(Actual_subjectlabel, Expected_subject_label);
			
			 WebElement subjectInput = driver.findElement(By.id("subjectsInput"));
		     subjectInput.sendKeys("Computer Science");

		     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-2-option-0']")));
 
		     WebElement option = driver.findElement(By.xpath("//div[@id='react-select-2-option-0']"));
		     option.click();
		     
		     String selectedSubject = subjectInput.getAttribute("value");
		     assert selectedSubject.equals("");
	} 
	  catch (Exception e) {
		System.out.println(e);
	}   
   }
   @Test(priority=9 , enabled = true , description ="", groups="group9")
   public void testcase9() {
	   try {
		   
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,440)");
		   
	    WebElement hobbies_label = driver.findElement(By.linkText("Hobbies"));
	    String Actual_hobbieslabel= hobbies_label.getText();
	    System.out.println(Actual_hobbieslabel);
	    Assert.assertEquals(Actual_hobbieslabel, Expected_hobbies_label);
			
	    WebElement hobbyCheckbox = driver.findElement(By.id("hobbies-checkbox-1"));
	    hobbyCheckbox.click();
	    assert hobbyCheckbox.isSelected();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	    wait.until(ExpectedConditions.elementToBeSelected(hobbyCheckbox));
	    
	    WebElement hobbyCheckbox2 = driver.findElement(By.id("hobbies-checkbox-2"));
	    hobbyCheckbox2.click();
	    assert hobbyCheckbox2.isSelected();
	    WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(4));
	    wait.until(ExpectedConditions.elementToBeSelected(hobbyCheckbox2));

	    WebElement hobbyCheckbox3 = driver.findElement(By.id("hobbies-checkbox-3"));
	    hobbyCheckbox3.click();
	    assert hobbyCheckbox3.isSelected();
	    WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.elementToBeSelected(hobbyCheckbox3));
	}
	   catch (NoSuchElementException e) {
		System.out.println(e);
	}
   }
   @Test(priority=10 , enabled = true , description ="verify label and enter value", groups="group10")
   public void testcase10() {
	   try {
		    JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,440)");
			
			WebElement lbl_currentaddress = driver.findElement(By.id("currentAddress-label"));
			String Actual_lblCurrentaddress=lbl_currentaddress.getText();
			Assert.assertEquals(Actual_lblCurrentaddress, Expected_currentAddress_label);
			
			WebElement txt_Currentaddressplaceholder = driver.findElement(By.xpath("//textarea[@placeholder=\"Current Address\"]"));
			String Actual_txt_Currentaddress=txt_Currentaddressplaceholder.getAttribute("placeholder");
			Assert.assertEquals(Actual_lblCurrentaddress, Expected_currentAddress_label);
			
			WebElement txt_currentaddress=driver.findElement(By.xpath("//textarea[@placeholder=\"Current Address\"]"));
			txt_currentaddress.sendKeys("SBH COLONY , Saidabad , Hyderabad , Telangana");
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("currentAddress")));
	} catch(Exception e) {
	    System.out.println(e);
	}
   }
   @Test
   public void testcase11() {
	   try {
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("window.scrollBy(0,700)");
		   
		   WebElement html = driver.findElement(By.tagName("html"));
		   html.sendKeys(Keys.chord(Keys.CONTROL, "50"));

		   WebElement stateDropdown = driver.findElement(By.id("state"));
	       Select stateSelect = new Select(stateDropdown);
	       stateSelect.selectByVisibleText("NCR");

	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
	       wait.until(ExpectedConditions.elementToBeClickable(By.id("city")));

	       // Move to city dropdown
	       WebElement cityDropdown = driver.findElement(By.id("city"));
	       Actions actions = new Actions(driver);
	       actions.moveToElement(cityDropdown).click().perform();

	       // Select City
	       WebElement cityOption = driver.findElement(By.xpath("//div[@id='city']//div[text()='Delhi']"));
	       cityOption.click();

	       // Verify the selected State and City
	       String selectedState = stateSelect.getFirstSelectedOption().getText();
	       assert selectedState.equals("NCR");

	       String selectedCity = cityOption.getText();
	       assert selectedCity.equals("Delhi");  
	   
	}
	   catch (NoSuchWindowException e) {
		// TODO: handle exception
	}
  }
   @Test
	public void tescase12() {
		try {
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			   js.executeScript("window.scrollBy(0,700)");
			   
			     String filePath = "";
		        WebElement uploadInput = driver.findElement(By.xpath("//input[@type=\"file\"]"));
		        uploadInput.click();
		    //    uploadInput.sendKeys(filePath);

		        // Wait for the uploaded file to be displayed
		        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(3));
		        wait.until(ExpectedConditions.attributeToBeNotEmpty(uploadInput, "value"));

		        // Verify the uploaded file path
		        String uploadedFilePath = uploadInput.getAttribute("value");
		        assert uploadedFilePath.equals(filePath) : "Uploaded file path is incorrect";
		} catch (NoSuchWindowException e) {
			// TODO: handle exception
		}
	}

}