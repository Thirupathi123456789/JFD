package com.selenium.project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateForm {
	
	public static void main(String[] args) {
		

		System.setProperty("webdriver.chrome.driver","C:\\Users\\91918\\Desktop\\java fsd\\selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://profile.oracle.com/myprofile/account/create-account.jspx");	
		WebElement email= driver.findElement(By.name("sView1:r1:0:email"));
		WebElement password= driver.findElement(By.name("sView1:r1:0:password"));
		WebElement retypePassword= driver.findElement(By.name("sView1:r1:0:retypePassword"));
		WebElement country= driver.findElement(By.xpath("//*[@id=\"sView1:r1:0:country::content\"]"));
		WebElement fname= driver.findElement(By.id("sView1:r1:0:firstName::content"));
		WebElement lname= driver.findElement(By.id("sView1:r1:0:lastName::content"));
		WebElement jobtitle= driver.findElement(By.name("sView1:r1:0:jobTitle"));
		WebElement mobileno= driver.findElement(By.name("sView1:r1:0:workPhone"));
		WebElement cmpnyname= driver.findElement(By.name("sView1:r1:0:companyName"));
		WebElement address= driver.findElement(By.name("sView1:r1:0:address1"));
		WebElement city= driver.findElement(By.name("sView1:r1:0:city"));
		WebElement state= driver.findElement(By.id("sView1:r1:0:state::content"));
		WebElement zipcode= driver.findElement(By.xpath("//*[@id=\"sView1:r1:0:postalCode::content\"]"));
		
		
		email.sendKeys(" mail id");// give your mail id
		password.sendKeys("Abc@1");//give valid password 
		retypePassword.sendKeys("Abc@1");
		country.sendKeys("India");
		fname.sendKeys("Thiru");
		lname.sendKeys("GB");
		jobtitle.sendKeys("Java Developer");
		mobileno.sendKeys("1234567890");// give your mobile number
		cmpnyname.sendKeys("GBR");
		address.sendKeys("ATP Dist.");
		city.sendKeys("Atp");
		state.sendKeys("Andhra Pradesh");
		zipcode.sendKeys("515001");
		
		
		
		WebElement createAccount= driver.findElement(By.linkText("Create Account"));
		createAccount.click();
		//driver.close();
	}

}

