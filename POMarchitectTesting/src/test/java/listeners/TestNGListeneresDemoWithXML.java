package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestNGListeneresDemoWithXML {
	
	@Test
	public void test1() {
		System.out.println("Inside Test 1");
	}
	@Test

	public void test2() {
		System.out.println("Inside Test 2");

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("test automation testing");
		driver.findElement(By.name("Eror")).sendKeys("test automation testing");
		driver.close();
		driver.quit();
	}
	@Test

	public void test3() {
		System.out.println("Inside Test 3");
		throw new SkipException("Skipped the Test");
	}
}
