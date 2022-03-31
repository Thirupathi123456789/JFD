package com.selenium.project2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AddToCart {
	WebDriver driver;
  @Test
  public void cart() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\91918\\Desktop\\java fsd\\selenium\\chromedriver.exe ");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/Acer-A515-56-36UT-Display-i3-1115G4-Processor/dp/B08VKT45K4/ref=sr_1_4?crid=3AKZW0BQZHJMF&keywords=laptops+under+50000&qid=1648525841&sprefix=laptops+under+50000%2Caps%2C757&sr=8-4");
		WebElement cart=driver.findElement(By.id("add-to-cart-button"));
		cart.submit();
	  
  }
}
