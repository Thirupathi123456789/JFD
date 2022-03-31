package com.selenium.project2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {
	WebDriver driver;
  @Test
  public void login() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\91918\\Desktop\\java fsd\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();	
		driver.get("https://www.amazon.com/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_custrec_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
		WebElement email=driver.findElement(By.name("email"));
		WebElement con=driver.findElement(By.id("continue"));
		con.click();
		//WebElement pass1=driver.findElement(By.xpath("//*[@id=\"ap_password\"]"));
		//driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();	
		email.sendKeys("Thiru@gmail.com");
		con.submit();

  }
  @Test (dependsOnMethods = "login")
  public void login1() {
	WebElement pass1=driver.findElement(By.xpath("//*[@id=\"ap_password\"]"));
	WebElement sign=driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]"));	
	pass1.sendKeys("1234@1");
	sign.submit();
  }
    @BeforeMethod
	public void beforeMethod() {
		System.out.println("Starting Test On Chrome Browser");
	}	
	@AfterMethod
	public void afterMethod() {		
		System.out.println("Finished Test On Chrome Browser");
	}
}
