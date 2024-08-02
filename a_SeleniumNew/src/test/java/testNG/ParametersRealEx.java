package testNG;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class ParametersRealEx {
	
	WebDriver driver;
  
  @BeforeMethod
  public void beforeMethod() {
	  
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
  }
  
  @Test
  @Parameters({"searchText"})
  public void f(String text) {
	  
	  WebElement searchBox = driver.findElement(By.id("APjFqb"));
	  searchBox.sendKeys(text);
  }
  
  @AfterMethod
  public void afterMethod() {
  }

}
