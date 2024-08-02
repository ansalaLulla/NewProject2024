package testNG;

import org.testng.annotations.Test;

import utility.ScreenshotClass;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class NewTest {

	WebDriver driver;
	ScreenshotClass sh;

	@Test
	public void MouseHover_Tooltip() {
		
		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		Actions act = new Actions(driver);
		WebElement live = driver.findElement(By.xpath("//h4[text()='Live ']/ancestor::a"));
//		System.out.println(live.getLocation());
//		act.moveByOffset(384, 639).perform();
		act.moveToElement(live).build().perform();
		String expectedTooltip = "Live1";
		String actualTooltip = live.getAttribute("title");
		System.out.println(actualTooltip);
		Assert.assertEquals(actualTooltip, expectedTooltip);
		
	}
	@Test
	  public void iFrame() {
				driver.navigate().to("https://demoqa.com/frames");
				driver.navigate().refresh();
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
	

	@BeforeMethod
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.get("https://www.browserstack.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void afterMethod(ITestResult itr) throws IOException {  //ITestResult is interface
		
		if(itr.getStatus()==ITestResult.FAILURE) //if ITestResult status and our test result is failed
		{
			sh = new ScreenshotClass();
			
			sh.takeScreenShot(driver, itr.getName());
	
		}
	}
}
