package myTest;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class AlarmListe {
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
	  public void AlarmAddDelete() throws Exception {
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
			Thread.sleep(2000);
		    driver.findElement(By.xpath("//input[@type='text']")).clear();
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("The Imitation Game");
		    Thread.sleep(1000);
		    driver.findElement(By.id("searchIcon")).click();
		    driver.findElement(By.linkText("DETAYA GÝT")).click();
		    driver.findElement(By.id("openAlarm")).click();
		    driver.findElement(By.id("price-set")).click();
		    driver.findElement(By.id("price-set")).clear();
		    driver.findElement(By.id("price-set")).sendKeys("15");
		    driver.findElement(By.id("date-set")).click();
		    driver.findElement(By.id("date-set")).clear();
		    driver.findElement(By.id("date-set")).sendKeys("1");
		    driver.findElement(By.id("addToAlarmButton")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("(//a[contains(@href, 'javascript:;')])[7]")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.linkText("HESABIM")).click();
		    driver.findElement(By.linkText("Listelerim")).click();
		    driver.findElement(By.linkText("Alarm Listem")).click();
		    Thread.sleep(1000);
		    try {
		    	assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[Alarm listenizde herhangi bir ürün bulunmamaktadýr.]*//center/p[Alarm listenizde herhangi bir ürün bulunmamaktadýr.]*$"));
		    	} catch (Error e){
				verificationErrors.append(e.toString());
			}
		    driver.findElement(By.xpath("//form[@id='frmAlarmProducts']/section/div/div/div/div/ins")).click();
		    driver.findElement(By.linkText("SÝL")).click();
		    
		    try {
		    	assertEquals("Alarm listenizde herhangi bir ürün bulunmamaktadýr.", driver.findElement(By.xpath("//center/p")).getText());
			} catch (Error e) {
				verificationErrors.append(e.toString());
			}
	  }
 
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}