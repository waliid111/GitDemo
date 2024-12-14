package pckg;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException, InterruptedException {
		// TODO Auto-generated method stub
		
		 //broken URL
        //Step 1 - IS to get all urls tied up to the links using Selenium
        //  Java methods will call URL's and gets you the status code
        //if status code >400 then that url is not working-> link which tied to url is broken
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(2000);
		
		List<WebElement> allLinks = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		SoftAssert softAssert = new SoftAssert();
		
		for(WebElement link:allLinks)
		{
			String url = link.getAttribute("href");
			
			HttpURLConnection connexion = (HttpURLConnection) new URI(url).toURL().openConnection();
			connexion.setRequestMethod("HEAD");
			connexion.connect();
			int responseCode = connexion.getResponseCode();
			
			System.out.println(responseCode);
			
			// Hard Assert it stop the program when condition is false
			//Assert.assertTrue(responseCode < 400, "The link with Text "+link.getText()+" is broken with the code "+responseCode);
			
			// Soft Assert it keeps the program running even if it catch i false condition
			softAssert.assertTrue(responseCode < 400, "The link with Text "+link.getText()+" is broken with the code "+responseCode);
		}
		
		// it is important to assert all because it pass on all stored assert and when it find the error/failure it shows error
		softAssert.assertAll();
		
	}

}
