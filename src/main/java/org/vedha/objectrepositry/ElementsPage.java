package org.vedha.objectrepositry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.vedha.baseclass.BaseDriver;

public class ElementsPage extends BaseDriver{
	
	String userLabel="userName-label";
	public WebElement lbl_userName () {
		return driver.findElement(By.id(userLabel));
	}
	String txtplaceholder="//input[@placeholder=\"First Name\"]";
	public WebElement txt_plceholder() {
	return driver.findElement(By.xpath(txtplaceholder));
	}
    String txt_lastplaceholder = "//input[@placeholder=\"Last Name\"]";
    public WebElement txt_lastplceholder() {
    return driver.findElement(By.xpath(txt_lastplaceholder));
    }
    String email_label="userEmail-label";
    public WebElement Label_email() {
    return driver.findElement(By.id(email_label));
    }
    String txt_emailplaceholder = "//input[@placeholder=\"name@example.com\"]";
    public WebElement Email_placeholder () {
    	return driver.findElement(By.xpath(txt_emailplaceholder));
    }
}
