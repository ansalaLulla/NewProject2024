package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrameExample {
	
public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/frames");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		 
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
		
		/*
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?org/openqa/selenium/package-summary.html");
		
		driver.switchTo().frame("packageListFrame");
		
		WebElement org_openqa_selenium = driver.findElement(By.xpath("//a[@href='org/openqa/selenium/package-frame.html']"));
		
		org_openqa_selenium.click();
		
		driver.switchTo().parentFrame();
		
		driver.switchTo().frame("packageFrame");
		WebElement org_openqa_seleniumText = driver.findElement(By.xpath("//a[@href='package-summary.html']"));
		System.out.println(org_openqa_seleniumText.getText());
		driver.switchTo().parentFrame();*/
		
	}

}
