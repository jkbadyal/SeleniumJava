package Test;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumWaitDemo {
	WebDriver driver ;
	@Parameters("browserName")
	@BeforeTest
	public void loadDriver(@Optional("chrome") String browserName) {
		System.out.println("Thread Id : "+Thread.currentThread().getId()+" "+browserName);
		if(browserName.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver= new InternetExplorerDriver();
		}
	}
	@Test
	public void runTest() {
		//IMPLICIT WAIT
		/*
		 * driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		 */		driver.get("https://google.com");
		 driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input")).sendKeys("Using xpath...");
		 //EXPLICIT WAIT
		 /*
		  * WebDriverWait wait= new WebDriverWait(driver, 10); WebElement elemet=
		  * wait.until(ExpectedConditions.elementToBeClickable(By.name("ansbdjasdgh")));
		  * driver.findElement(By.className("asjdkshd"));
		  */
		 driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input")).clear();
		 driver.findElement(By.name("q")).sendKeys("selenium");

		 // Waiting 15 seconds for an element to be present on the page, checking
		 // for its presence once every 1 seconds.
		 Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				 .withTimeout(Duration.ofSeconds(15))
				 .pollingEvery(Duration.ofSeconds(1))
				 .ignoring(NoSuchElementException.class);

		 WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			 public WebElement apply(WebDriver driver) {
				 WebElement linkElement= driver.findElement(By.className("q qs"));
				 driver.findElement(By.className("q qs")).click();		
				 return linkElement;
			 }
		 });
	}
	@AfterTest
	public void closeDriver() {
		driver.close();
		driver.quit();
		System.out.println("End of test case"+ Thread.currentThread().getId());
	}
}
