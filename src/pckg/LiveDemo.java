package pckg;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LiveDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		/* 1- Click on button sort on the column
		 * 2- Capture all WebElement into list
		 * 3- Capture text of all WebElements into a new list (original list)
		 * 4- Sort the original list of step 3 -> sorted list
		 * 5- Compare original list vs sorted list
		 */
		
		// Click on button sort on the column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//  Capture all WebElement into list
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
		
		// Capture text of all WebElements into a new list (original list)
		List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());
		
		// Sort the original list of step 3 -> sorted list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		// Compare original list vs sorted list
		Assert.assertTrue(originalList.equals(sortedList));
		
		List<String> price;
		// if price of the vegetable exist on another page
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
		// Scan the name column with getText -> Beans -> print the price of that vegetable
			price = rows.stream().filter(s -> s.getText().contains("Rice"))
				.map(s -> getPriceVegetables(s))
				.collect(Collectors.toList());
			
			price.forEach(s -> System.out.println(s));
			if(price.size() < 1)
			{
				driver.findElement(By.cssSelector("[aria-label$='Next']")).click();
			}
		}while(price.size() < 1);
		
	}

	private static String getPriceVegetables(WebElement s) {
		// TODO Auto-generated method stub
		
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

}
