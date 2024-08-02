package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class NewTest1 {
	WebDriver driver;
	
  @Test
  public void iFrame() {
	  		//Finding all iframe tags on a web page
			List<WebElement> elements = driver.findElements(By.tagName("iframe"));
			int numberOfTags = elements.size();
			System.out.println("No. of Iframes on this Web Page are: " +numberOfTags);
			 
			// Switch to the frame using the frame id
			System.out.println("Switching to the frame");
			driver.switchTo().frame("aswift_0");
			 
			// Print the frame source code
			System.out.println("Frame Source" +driver.getPageSource());
			 
			// Switch back to main web page
			driver.switchTo().defaultContent();
  }
  @Test
  public void getTitle() {
	  String actualTitle = driver.getTitle();
	  Assert.assertEquals(actualTitle, "DEMOQA");
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  	driver = new ChromeDriver();
		driver.get("https://demoqa.com/frames");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod() {
  }

}
