package pckg;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignementThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		String username = "rahulshettyacademy";
		String password = "learning";
		
		fillForm(driver, wait, username, password);
		addToCart(driver);
		
	}
	
	public static void fillForm(WebDriver driver, WebDriverWait wait, String username, String password)
	{
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElements(By.xpath("//div[@class='form-check-inline']/label/input")).get(1).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		
		Select selectList = new Select(driver.findElement(By.cssSelector("select.form-control")));
		selectList.selectByValue("consult");

		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-card-list[@class='row']")));
	}
	
	public static void addToCart(WebDriver driver)
	{
		//driver.findElements(By.cssSelector(".card-footer .btn-info"));
		List<WebElement> listProducts = driver.findElements(By.xpath("//button[@class='btn btn-info']"));
		for(int i=0; i < listProducts.size(); i++)
		{
			driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
			//System.out.println(driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).getText());
		}
		
		driver.findElement(By.xpath("//div[@id='navbarResponsive']/ul/li/a")).click();
		//driver.findElement(By.partialLinkText("Checkout")).click();
	}
	

}
