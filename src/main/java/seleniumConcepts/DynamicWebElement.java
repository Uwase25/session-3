package seleniumConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebElement {

	WebDriver driver;

	@Before
	public void launchBrowser() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cnn.com/world");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test
	public void dealWithDynamicWebElement() {

		driver.findElement(By.xpath("//ul[@class='cn cn-list-hierarchical-xs cn--idx-2 cn-coverageContainer_3FC44C1D-B590-FC74-DDB7-AE3B16C4AADA']/descendant::span[1]")).click();
		
	}
		@After
		public void tearzdown() {
		driver.close();	
		driver.quit();
	}
}
