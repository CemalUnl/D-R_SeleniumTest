package myTest;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SepetEkleCýkar {
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
	  public void CartAddDelete() throws Exception {
		 driver.get("http://www.dr.com.tr/");
		 Thread.sleep(3000);
		    driver.findElement(By.linkText("ÜYE GÝRÝÞÝ")).click();
		    driver.findElement(By.id("EmailField")).clear();
		    driver.findElement(By.id("EmailField")).sendKeys("email");
		    driver.findElement(By.id("PasswordField")).click();
		    driver.findElement(By.id("PasswordField")).clear();
		    driver.findElement(By.id("PasswordField")).sendKeys("password");
		    driver.findElement(By.id("login_btn")).click();
		    driver.findElement(By.xpath("//input[@type='text']")).clear();
		    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("nutuk");
		    driver.findElement(By.id("searchIcon")).click();
		    driver.findElement(By.linkText("SEPETE EKLE")).click(); 
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("(//a[contains(@href, 'javascript:;')])[55]")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.linkText("SEPETÝM")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//input[@value='SEPETE GÝT']")).click();
		    Thread.sleep(1000);
		   
	    try {
	    	assertTrue(driver.findElement(By.linkText("Nutuk")).isDisplayed());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	    driver.findElement(By.xpath("//div[@id='cartList']/section/form/section[2]/div/div[3]/div/div/div/ins")).click();
	    driver.findElement(By.id("choose-product-remove")).click();
	    try {
	    	 assertEquals("Sepetinizde ürün bulunmuyor!", driver.findElement(By.xpath("//div[@id='cartList']/section/section/div/div/h3")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	   
	    
	  }
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}