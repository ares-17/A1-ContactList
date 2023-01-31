
//File risulta attualmente aggiornato per webdriver chrome headless!
package com.example.TesiIntegrazioneProgettoEsterno;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test2 {
private static WebDriver driver;
private boolean acceptNextAlert = true;
private static StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
		
		  // Init chromedriver
		  //String chromeDriverPath = "/home/runner/work/Tesi-StrumentoGenerale/Tesi-StrumentoGenerale/chromedriver_v94_linux64/chromedriver";
		  //System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		  WebDriverManager.chromedriver().setup();
		  System.setProperty("webdriver.chrome.whitelistedIps", "");
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--no-sandbox","--ignore-certificate-errors");
		  driver = new ChromeDriver(options);  
		  
		  
		  
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
  @Test
  public void test2() throws Exception {
    driver.get("http://localhost:3001/");
    driver.findElement(By.xpath("//td[@title=\"mobile\"]")).click();
    driver.findElement(By.xpath("//input[@formcontrolname=\"firstName\"]")).click();
    driver.findElement(By.xpath("//input[@formcontrolname=\"firstName\"]")).clear();
    driver.findElement(By.xpath("//input[@formcontrolname=\"firstName\"]")).sendKeys("Marco");
    driver.findElement(By.xpath("//input[@formcontrolname=\"lastName\"]")).click();
    driver.findElement(By.xpath("//input[@formcontrolname=\"lastName\"]")).clear();
    driver.findElement(By.xpath("//input[@formcontrolname=\"lastName\"]")).sendKeys("De Luca");
    driver.findElement(By.xpath("//input[@ng-reflect-name=\"email\"]")).click();
    driver.findElement(By.xpath("//input[@ng-reflect-name=\"email\"]")).clear();
    driver.findElement(By.xpath("//input[@ng-reflect-name=\"email\"]")).sendKeys("marco@marco");
    driver.findElement(By.xpath("//button[normalize-space()='Create']")).click();
    driver.findElement(By.xpath("//button[@class=\"btn btn-warning\"]")).click();
    //ERROR: Caught exception [unknown command []]
  }


 @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }

}
