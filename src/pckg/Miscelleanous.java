package pckg;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.apache.commons.io.FileUtils;

public class Miscelleanous {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		//Maximize Browser
		driver.manage().window().maximize();
		
		//Delete Cookies
		driver.manage().deleteAllCookies();
		//driver.manage().deleteCookieNamed("abcd");
		
		driver.get("https://google.com/");
		
		//Take Screenshot
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(src, new File("C:\\Users\\Strix\\SeleniumScreens\\capture-01.png"));

	}

}
