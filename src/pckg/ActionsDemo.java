package pckg;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class ActionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		
		Actions actionMouse = new Actions(driver);
		
		WebElement moveMouse = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		WebElement textBox = driver.findElement(By.id("twotabsearchtextbox"));
		
		actionMouse.moveToElement(textBox).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		//Move to Specific Element
		actionMouse.moveToElement(moveMouse).contextClick().build().perform();
		
		//
		

	}

}
