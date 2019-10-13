package myTest;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class DrLogin {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\cemal\\eclipse-workspace\\SampleDemo\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://www.google.com.tr";
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	 @Test
	  public void LoginTest() throws Exception {
	    driver.get("http://www.dr.com.tr/");
	    Thread.sleep(3000);
	    driver.findElement(By.linkText("ÜYE GÝRÝÞÝ")).click();
	    driver.findElement(By.id("EmailField")).clear();
	    driver.findElement(By.id("EmailField")).sendKeys("Email");
	    driver.findElement(By.id("PasswordField")).click();
	    driver.findElement(By.id("PasswordField")).clear();
	    driver.findElement(By.id("PasswordField")).sendKeys("password");
	    driver.findElement(By.xpath("//section/div/div/div")).click();
	    driver.findElement(By.id("login_btn")).click();
		Thread.sleep(1000);
		try {
			 assertTrue(driver.findElement(By.linkText("HESABIM")).isDisplayed());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	  }

	 
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}