package pckg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount'")).isSelected());
		//System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount'")).isSelected());
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount'")).click();
		//System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount'")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount'")).isSelected());
		
		//Count the number of Checkboxes
		//System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(), 6);
		
		
//		driver.findElement(By.id("divpaxinfo")).click();
//		Thread.sleep(2000);
//		
////		int i = 1;
////		while(i < 5)
////		{
////			driver.findElement(By.id("hrefIncAdt")).click();
////			i++;
////		}
//		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
//		for(int i=1; i < 5; i++)
//		{
//			driver.findElement(By.id("hrefIncAdt")).click();
//		}
//		
////		driver.findElement(By.id("hrefIncChd")).click();
////		driver.findElement(By.id("hrefIncInf")).click();
//		driver.findElement(By.id("btnclosepaxoption")).click();
//		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		
	}

}
