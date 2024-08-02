package selenium;

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

public class Table {
	
	WebDriver driver;
	
  @Test
  public void f() {
	  
	  List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//tbody//tr"));
	  int rowCount = rows.size();
	  List<WebElement> cols = driver.findElements(By.xpath("//table[@id='customers']//th"));
	  int ColCount =cols.size();
	  for(int row = 1;row<rowCount;row++) {
			for(int col = 1;col<=ColCount;col++) {
				
				String actValue = driver.findElement(By.xpath("//table[@id='customers']//tbody//tr["+(row+1)+"]//td["+col+"]")).getText();
				if (actValue.contains("Island Trading")) {
					
					
					System.out.println(row+" : "+col); // print the row and col of searched name.
					System.out.println(actValue);
					
					//Assert.assertEquals(actValue, "Island Trading");
					
					//Assert.assertTrue(actValue.contains("Island Trading"));
					
					
				}
			}
		}
	  
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod() {
  }

}
