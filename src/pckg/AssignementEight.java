package pckg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AssignementEight {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		/*
		 * 1- Enter 3 letters of desired Country
		 * 2- Move Mouse to the desired Country
		 * 3- Verify if Country is printed on the Selected Box
		 */

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		String country = "United States (USA)";
		
		driver.findElement(By.id("autocomplete")).sendKeys(country.subSequence(0, 3));
		Thread.sleep(2000);
		
		List<WebElement> selectCountry = driver.findElements(By.className("ui-menu-item-wrapper"));
		
		Actions mouseAction = new Actions(driver);
		
		for(int i = 0; i < selectCountry.size(); i++)
		{
			//System.out.println(selectCountry.get(i).getText());
			if(selectCountry.get(i).getText().equals(country))
			{
				mouseAction.moveToElement(driver.findElement(By.xpath("//li/div[text()='"+country+"']"))).click().build().perform();
				break;
			}
		}
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
		
		//driver.close();
	}

}
