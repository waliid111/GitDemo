package pckg;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
//import java.lang.Thread;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Locators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		// Wait 5 Seconds until an element shows on the screen (an error, an html element, ...)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		driver.findElement(By.id("inputUsername")).sendKeys("Test Name");
		driver.findElement(By.name("inputPassword")).sendKeys("Test Password");
		driver.findElement(By.className("signInBtn")).click();
		
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		//Thread.sleep(1000); //Stoping the script 1 second to upload moving to the next view
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Username Login");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Email@test.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Test@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("0123456789");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Test Name");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
	}

}
