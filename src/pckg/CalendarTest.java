package pckg;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalendarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		String month = "6";
		String day = "15";
		String year = "2027";
		
		String[] expextedDate = {month, day, year};

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.findElement(By.linkText("Top Deals")).click();
		
		Set<String> tabs = driver.getWindowHandles();
		Iterator<String> iterator = tabs.iterator();
		String parentTab = iterator.next();
		String childTab = iterator.next();
		driver.switchTo().window(childTab);
		
		driver.findElement(By.className("react-date-picker__inputGroup")).click();
		
		driver.findElement(By.className("react-calendar__navigation__label")).click();
		driver.findElement(By.className("react-calendar__navigation__label")).click();
		
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month) - 1).click();
		driver.findElement(By.xpath("//abbr[text()='"+day+"']")).click();
		
		
		List<WebElement> actualDate = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		for(int i=0; i < actualDate.size(); i++)
		{
			System.out.println(actualDate.get(i).getAttribute("value"));
			Assert.assertEquals(actualDate.get(i).getAttribute("value"), expextedDate[i]);
		
		}
		
		driver.close();
		driver.switchTo().window(parentTab).close();
	}

}
