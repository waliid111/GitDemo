package pckg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignementSeven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 1- Print Number of rows should be 11
		 * 2- print Number of Columns should be 3
		 * 3- print all the text of second Row : Instructor|Course|Price
		 */
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		ArrayList<String> elementsRow2 = new ArrayList<String>();
		int j = 1;
		
		System.out.println("Number of Rows = "+driver.findElements(By.cssSelector(".table-display tr")).size());
		System.out.println("Number of Columns = "+driver.findElements(By.cssSelector(".table-display th")).size());
		
		List<WebElement> row2 = driver.findElements(By.cssSelector(".table-display tr:nth-child(3) td"));
		
		for(int i=0; i < row2.size(); i++)
		{
			elementsRow2.add(row2.get(i).getText());
			
			if (j == row2.size())
			{
				System.out.println("Row 2 is "+elementsRow2.toString());
				break;
			}
			j++;
		}

	}

}
