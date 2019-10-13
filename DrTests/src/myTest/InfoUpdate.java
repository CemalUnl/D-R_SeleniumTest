package myTest;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class InfoUpdate {
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
	  public void Update() throws Exception {
	    driver.get("http://www.dr.com.tr/");
	    Thread.sleep(3000);
	    driver.findElement(By.linkText("ÜYE GÝRÝÞÝ")).click();
	    driver.findElement(By.id("EmailField")).clear();
	    driver.findElement(By.id("EmailField")).sendKeys("email");
	    driver.findElement(By.id("PasswordField")).click();
	    driver.findElement(By.id("PasswordField")).clear();
	    driver.findElement(By.id("PasswordField")).sendKeys("password");
	    driver.findElement(By.xpath("//section/div/div/div")).click();
	    driver.findElement(By.id("login_btn")).click();
		Thread.sleep(1000);
		 driver.findElement(By.linkText("HESABIM")).click();
		 Thread.sleep(3000);
		    driver.findElement(By.xpath("//div[2]/div/a/span[2]")).click();
		    driver.findElement(By.xpath("//a[contains(text(),'ÖÐRENCÝ')]")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//div[2]/div[3]/a/span[2]")).click();
		    driver.findElement(By.xpath("//a[contains(text(),'Ýzmir')]")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//div[5]/a/span[2]")).click();
		    driver.findElement(By.xpath("(//a[contains(text(),'Lisans')])[2]")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.linkText("Bilgilerimi Güncelle")).click();
		    Thread.sleep(3000);
	    try {
	    	assertEquals("ÖÐRENCÝ", driver.findElement(By.xpath("//div[2]/div/a/span")).getText());
	        assertEquals("Lisans", driver.findElement(By.xpath("//div[5]/a/span")).getText());
	        assertEquals("Ýzmir", driver.findElement(By.xpath("//div[2]/div[3]/a/span")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	  }

	 
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}