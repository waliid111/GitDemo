package pckg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AssignementTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.findElement(By.name("name")).sendKeys("Test Name");
		driver.findElement(By.name("email")).sendKeys("Email@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("PassWord");
		driver.findElement(By.id("exampleCheck1")).click();
		
		WebElement dropdownlist = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdownoption = new Select(dropdownlist);
		dropdownoption.selectByVisibleText("Male");
		
		driver.findElement(By.id("inlineRadio2")).click();
		driver.findElement(By.name("bday")).sendKeys("11/15/2024");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String successmessage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
		
		System.out.println(successmessage.split("\n")[1]);
		//System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());
		
		
		

	}

}
