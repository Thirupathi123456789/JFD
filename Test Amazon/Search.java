package com.selenium.project2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Search {
	WebDriver driver;
  @Test
  public void search() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\91918\\Desktop\\java fsd\\selenium\\chromedriver.exe ");
			driver = new ChromeDriver();
			driver.get("https://www.amazon.in/");
			WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
			WebElement search1=driver.findElement(By.id("nav-search-submit-button"));
			//WebElement cart=driver.findElement(By.id("add-to-cart-button"));
			search.sendKeys("laptops under 50000");
			search1.submit();
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
