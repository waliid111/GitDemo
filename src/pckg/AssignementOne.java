package pckg;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AssignementOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("checkBoxOption1")).click();
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		driver.findElement(By.id("checkBoxOption1")).click();
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		int size = driver.findElements(By.xpath("//input[@type='checkbox']")).size();
		Assert.assertEquals(driver.findElements(By.xpath("//input[@type='checkbox']")).size(), size);
		Assert.assertEquals(driver.findElements(By.xpath("//input[@type='checkbox']")).size(), 3);

	}

}
