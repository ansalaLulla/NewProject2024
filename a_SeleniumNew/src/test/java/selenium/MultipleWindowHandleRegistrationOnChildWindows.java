package selenium;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowHandleRegistrationOnChildWindows {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent window handle : "+parentWindowHandle);
		
		WebElement openNewWindowsBtn = driver.findElement(By.id("newWindowsBtn"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", openNewWindowsBtn);
		openNewWindowsBtn.click();
		
		Set<String> handles_AllOpenedWindows = driver.getWindowHandles(); 
		System.out.println(handles_AllOpenedWindows);
		
		for (String handle : handles_AllOpenedWindows) {
			
			
			if(!handle.equalsIgnoreCase(parentWindowHandle)) {
				
				driver.switchTo().window(handle);
				
				String WindowTitle = driver.getTitle();
				
				if(WindowTitle.equals("Basic Controls - H Y R Tutorials"))
				{
				driver.manage().window().maximize();
								
				WebElement firstName = driver.findElement(By.id("firstName"));
				firstName.sendKeys("ansala");
				
				WebElement lastName = driver.findElement(By.id("lastName"));
				lastName.sendKeys("lulla");
				
				WebElement female = driver.findElement(By.id("femalerb"));
				female.click();		
				
				
				WebElement english = driver.findElement(By.id("englishchbx"));
				english.click();
				
				WebElement register = driver.findElement(By.id("registerbtn"));
				register.click();
				
				Thread.sleep(2000);
				
				//driver.close();
				
				}
				
				
				
				if(WindowTitle.equals("XPath Practice - H Y R Tutorials"))
				{
				driver.manage().window().maximize();
								
				WebElement firstName = driver.findElement(By.xpath("(//input[@name='name'])[1]"));
				firstName.sendKeys("ansala");
				
				
				
				Thread.sleep(2000);
				
				//driver.close();
				
				}
				
			}
		}
		
		driver.switchTo().window(parentWindowHandle);
		//driver.quit();

	}

	
}
