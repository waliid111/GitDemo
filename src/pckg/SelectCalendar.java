package pckg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SelectCalendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		System.out.println(driver.findElement(By. id("Div1")).getAttribute("style"));
		//System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		//System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
		System.out.println(driver.findElement(By. id("Div1")).getAttribute("style"));
		
		driver.findElement(By.xpath("//div[@id='Div1']/button[@class='ui-datepicker-trigger']")).click();
		driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-active']")).click();
		
		//System.out.println(driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-active']")).getText());

		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
		{
			System.out.println("It is Enabled");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
			
	}

}
