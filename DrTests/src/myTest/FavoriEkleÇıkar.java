package myTest;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class FavoriEkleÇýkar {
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
	  public void FavoritesAddDelete() throws Exception {
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
		
		driver.findElement(By.xpath("//label")).click();
	    driver.findElement(By.xpath("//li[9]/a/i")).click();
	    driver.findElement(By.xpath("//img[@alt='Kitap']")).click(); 
	    driver.findElement(By.xpath("//div[@id='catPageContent']/section/div[2]/div/ul/li[15]")).click();
	    driver.findElement(By.linkText("Fantastik")).click();
	    driver.findElement(By.xpath("//img[@alt='Yüzüklerin Efendisi - Tek Cilt Özel Basým ']")).click();
	    driver.findElement(By.linkText("FAVORÝLERÝME EKLE")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("(//a[contains(@href, 'javascript:;')])[8]")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.linkText("HESABIM")).click();
	    driver.findElement(By.linkText("Listelerim")).click();
	    Thread.sleep(1000);
	    
	    try {
	    	 assertTrue(driver.findElement(By.linkText("Yüzüklerin Efendisi - Tek Cilt Özel Basým")).isDisplayed());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	    driver.findElement(By.xpath("//form[@id='frmInterestedProducts']/section/div/div/div/div/ins")).click();
	    driver.findElement(By.linkText("SÝL")).click();
	    try {
	    	assertEquals("Favori listenizde herhangi bir ürün bulunmamaktadýr.", driver.findElement(By.xpath("//center/p")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	    
	  }
	
	
	
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}