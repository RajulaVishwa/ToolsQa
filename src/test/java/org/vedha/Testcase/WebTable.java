package org.vedha.Testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTable {
	WebDriver driver;
	
	@BeforeMethod
	public void startBrowser() {
		try {
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://demoqa.com/webtables");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testcase13() {
		try {
			WebElement addbutton= driver.findElement(By.id("addNewRecordButton"));
			addbutton.click();
			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(4));
			wait2.until(ExpectedConditions.elementToBeClickable(By.id("addNewRecordButton")));
			
				
				String Expected_firstName_label = "First Name";
				WebElement lbl_firstname = driver.findElement(By.id("firstName-label"));
				String Actual_firstname=lbl_firstname.getText();
				Assert.assertEquals(Actual_firstname, Expected_firstName_label);
				WebElement name_Given=driver.findElement(By.id("firstName"));
				name_Given.sendKeys("vishwajith");
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstName")));
				
				String Expected_lastName_label = "Last Name";
				WebElement lbl_lastname = driver.findElement(By.id("lastName-label"));
				String Actual_lastname=lbl_lastname.getText();
				Assert.assertEquals(Actual_lastname, Expected_lastName_label);
				WebElement lastname_Given=driver.findElement(By.id("lastName"));
				lastname_Given.sendKeys("rajula");
				WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
				wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("lastName")));
				
				String Expected_emailidName_label = "Email";
				WebElement lbl_emailidname = driver.findElement(By.id("userEmail-label"));
				String Actual_emailidname= lbl_emailidname.getText();
				Assert.assertEquals(Actual_emailidname, Expected_emailidName_label);
				
				String Expected_emailidName = "name@example.com";
				WebElement emailidname = driver.findElement(By.xpath("//input[@placeholder=\"name@example.com\"]"));
				String Actual_emailidname_n=emailidname.getAttribute("placeholder");
				Assert.assertEquals(Actual_emailidname_n, Expected_emailidName);
				
				WebElement email_nameGiven=driver.findElement(By.id("userEmail"));
				email_nameGiven.sendKeys("rajulavishwa01@gmail.com");
				WebDriverWait waitt = new WebDriverWait(driver, Duration.ofSeconds(3));
				waitt.until(ExpectedConditions.presenceOfElementLocated(By.id("userEmail")));
				
				
				String Expected_age_label = "Age";
				WebElement lbl_age = driver.findElement(By.id("age-label"));
				String Actual_age=lbl_age.getText();
				Assert.assertEquals(Actual_age, Expected_age_label);
				WebElement age_given=driver.findElement(By.id("age"));
				age_given.sendKeys("25");
				WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(3));
				wait3.until(ExpectedConditions.presenceOfElementLocated(By.id("age")));
				
				
				String Expected_salary_label = "Salary";
				WebElement lbl_salary = driver.findElement(By.id("salary-label"));
				String Actual_salary=lbl_salary.getText();
				Assert.assertEquals(Actual_salary, Expected_salary_label);
				WebElement salary_given=driver.findElement(By.id("salary"));
				salary_given.sendKeys("300000");
				WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(3));
				wait4.until(ExpectedConditions.presenceOfElementLocated(By.id("salary")));
				

				String Expected_department_label = "Department";
				WebElement lbl_department = driver.findElement(By.id("department-label"));
				String Actual_department=lbl_department.getText();
				Assert.assertEquals(Actual_department, Expected_department_label);
				WebElement department=driver.findElement(By.id("department"));
				department.sendKeys("Automation Tester");
				WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(3));
				wait5.until(ExpectedConditions.presenceOfElementLocated(By.id("department")));
				
				WebElement submit=driver.findElement(By.id("submit"));
				submit.getCssValue("background-colour");
				submit.click();
				WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(3));
				wait6.until(ExpectedConditions.elementToBeClickable(submit));
				
				WebElement edit_button=driver.findElement(By.id("edit-record-4"));
				edit_button.click();
				WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(3));
				wait7.until(ExpectedConditions.elementToBeClickable(edit_button));
				
				Actions act=new Actions(driver);
				WebElement name_edit=driver.findElement(By.xpath("//input[@value=\"vishwajith\"]"));
				act.sendKeys(Keys.BACK_SPACE).click(name_edit).sendKeys("vish");
				WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(3));
				wait8.until(ExpectedConditions.textToBePresentInElementValue(name_edit, "vish"));
				
				WebElement submit_edit=driver.findElement(By.id("submit"));
				submit_edit.getCssValue("background-colour");
				submit_edit.click();
				WebDriverWait wait9 = new WebDriverWait(driver, Duration.ofSeconds(3));
				wait9.until(ExpectedConditions.elementToBeClickable(submit_edit));
				
				Actions act1=new Actions(driver);
				WebElement delete_button=driver.findElement(By.id("delete-record-3"));
				act1.click(delete_button);
				WebDriverWait wait10 = new WebDriverWait(driver, Duration.ofSeconds(3));
				wait10.until(ExpectedConditions.elementToBeClickable(delete_button));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	@Test
	public void tescase12() {
		try {
			 String filePath = "/path/to/picture.jpg";
		        WebElement uploadInput = driver.findElement(By.id("uploadPicture"));
		        uploadInput.sendKeys(filePath);

		        // Wait for the uploaded file to be displayed
		        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(3));
		        wait.until(ExpectedConditions.attributeToBeNotEmpty(uploadInput, "value"));

		        // Verify the uploaded file path
		        String uploadedFilePath = uploadInput.getAttribute("value");
		        assert uploadedFilePath.equals(filePath) : "Uploaded file path is incorrect";
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
