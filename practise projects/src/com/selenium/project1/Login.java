package com.selenium.project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91918\\Desktop\\java fsd\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://login.oracle.com/mysso/signon.jsp?request_id=-4782010454026398257");

		WebElement email = driver.findElement(By.name("ssousername"));
		WebElement pass = driver.findElement(By.name("password"));

		email.sendKeys("thirupathidevarala@gmail.com");// enter your mail id
		pass.sendKeys("Thiru@123");

		WebElement signin = driver.findElement(By.id("signin_button"));
		signin.submit();
	}

}

