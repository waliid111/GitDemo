package pckg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AssignementSix {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		/* 1- Select any CheckBox from CheckBox List and Grab its Label(Text)
		 * 2- Go to the DropDow and Select the same label as option's Label (the selectbox label should come from the label of checkbox not Hard Coded)
		 * 3- Enter the Label of Selected CheckBox on Edit Box of Alert (should come from a variable of Step-1 not Hard Coded)
		 * 4- Click on Button Alert and verify if text from Step-1 is printed on the alert or not
		 * 5- Not Hard Code => the Script should be Dynamic Based on selected CheckBox
		 */
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// get text from Selected Checkbox
		String myOptionText = driver.findElement(By.xpath("//label[@for='benz']")).getText();
		System.out.println(myOptionText);
		
		driver.findElement(By.id("checkBoxOption2")).click();
		
		// go to select list
		WebElement mySelectList = driver.findElement(By.id("dropdown-class-example"));
	
		// select an element based on label of Chekcbox
		Select mySelection = new Select(mySelectList);
		mySelection.selectByVisibleText(myOptionText);
		
//		// fill the text field with checkbox label
		driver.findElement(By.id("name")).sendKeys(myOptionText);
		
//		// click alert button
		driver.findElement(By.id("alertbtn")).click();
		
//		//Verify if alert contain same text as my chosed checkbox
		String textAlert = driver.switchTo().alert().getText().split("Hello ")[1].split(",")[0];
		System.out.println(textAlert);
		
		// i can use also   if(text.contains(opt))
		Assert.assertEquals(textAlert, myOptionText, "Not Matching");
		

	}

}
