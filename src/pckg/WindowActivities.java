package pckg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		//Run window in maximized Mode
		driver.manage().window().maximize();
		
		//get wait until all page is fully loaded
		driver.get("https://google.com");
		
		//navigate doesn't wait just one element is loaded then could navigate to another TAB
		driver.navigate().to("https://rahulshettyacademy.com/");
		
		//Click the back button to return to first Page
		driver.navigate().back();
		
		//Click the forward button to come back to second Page
		driver.navigate().back();

	}

}
