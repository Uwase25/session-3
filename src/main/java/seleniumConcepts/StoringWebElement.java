package seleniumConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StoringWebElement {

	WebDriver driver;

	@Before
	public void launchBrowser() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://techfios.com/billing/?ng=login/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void LoginTest() {

		// its good to test all codes in the try block
		try {
			// Storing Web ELement or save
			// Element library
			WebElement USERNAME_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@id='username']"));
			WebElement PASSWORD_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@id='password']"));
			WebElement SIGNIN_BUTTON_ELEMENT = driver
					.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));
			// WebElement DASHBOARD_FIELD_ELEMENT =
			// driver.findElement(By.xpath("//h2[contains(text(),'Dashboard')]"));

			/*
			 * Another way of Storing web element using By Class
			 * 
			 * By USERNAME_FIELD_LOCATOR=(By.xpath("//input[@id='username']")); //By is type
			 * By PASSWORD_FIELD_LOCATOR= (By.xpath("//input[@id='password']")); By
			 * By SIGNIN_BUTTON_LOCATOR=
			 * (By.xpath("/html/body/div/div/div/form/div[3]/button")); By
			 * DASHBOARD_FIELD_LOCATOR= (By.xpath("//h2[contains(text(),' Dashboard ')]"));
			 * 
			 * driver.findElement(USERNAME_FIELD_LOCATOR).sendKeys("demo@techfios.com");
			 * driver.findElement(PASSWORD_FIELD_LOCATOR).sendKeys("abc123");
			 * driver.findElement(SIGNIN_BUTTON_LOCATOR).click();
			 */

			USERNAME_FIELD_ELEMENT.clear(); // TO Clear the user name field
			USERNAME_FIELD_ELEMENT.sendKeys("demo@techfios.com");
			PASSWORD_FIELD_ELEMENT.sendKeys("abc123");
			
			PASSWORD_FIELD_ELEMENT.clear();
			SIGNIN_BUTTON_ELEMENT.click();

			// boolean pageTitleDisplayStatus; // Global variable for try and catch to be
			// able to declare boolean
			// try {
			// WebElement DASHBOARD_FIELD_ELEMENT =
			// driver.findElement(By.xpath("//h2[contains(text(),'Dashboard')]"));
			// pageTitleDisplayStatus = true;

		} catch (Exception e) { // e for exception
			e.printStackTrace(); // if any thing goes wrong it will print the error message

			// printStackTrace() is a method of displaying exception or error

		}

		// Using Explicity wait
		// WebDriverWait wait= new WebDriverWait(driver,3); //(driver, time=seconds)
		// wait.until(ExpectedConditions.invisibilityOf(DASHBOARD_FIELD_ELEMENT));

		// to assert: validate a test
		// Assert.assertTrue("Dashboard page not found!!", pageTitleDisplayStatus);
	}

	@After
	public void tearDown() {
		driver.close(); // close kills the process of the web driver the one we initiated
		driver.quit(); // quit closes the browser
	}
}