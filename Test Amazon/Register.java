package com.selenium.project2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Register {	
	WebDriver driver;
	
  @Test
  public void Reg() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\91918\\Desktop\\java fsd\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/ap/register?showRememberMe=true&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3F_encoding%3DUTF8%26ref_%3Dnav_ya_signin&prevRID=KP0NSHW50SNSG4AHX46S&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&prepopulatedLoginId=&failedSignInCount=0&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=usflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		WebElement name=driver.findElement(By.id("ap_customer_name"));
		WebElement email=driver.findElement(By.id("ap_email"));
		WebElement pass=driver.findElement(By.id("ap_password"));
		WebElement repass=driver.findElement(By.id("ap_password_check"));
		name.sendKeys("Thiru");
		email.sendKeys("Thiru@gmail.com");
		pass.sendKeys("1234@12");
		repass.sendKeys("1234@12");
		WebElement register=driver.findElement(By.id("continue"));
		register.submit();	
  }
    @BeforeMethod
	public void beforeMethod() {
		System.out.println("Starting Test On Chrome Browser");
	}
	
	@AfterMethod
	public void afterMethod() {
		 driver.close();
		System.out.println("Finished Test On Chrome Browser");
	}
}
