package Test;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
public class ExtentWithTestNG {
	static WebDriver driver=null;
	ExtentHtmlReporter htmlReport;
	ExtentReports extent ;
	ExtentTest test ;
	@BeforeSuite
	public void beforeSuite() {
		htmlReport= new ExtentHtmlReporter("extentNew.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReport);
	}
	@BeforeMethod
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	}
	@Test
	public void Test() throws IOException {
		test = extent.createTest("Google Search Test Number 1 using Extent","Description of the Google Search test");
		test.log(Status.INFO, "Using Log(Status,details)Starting Of Test Case Number 1");
		driver.get("http://google.com");
		test.pass("Navigated to Google");
		driver.findElement(By.name("q")).sendKeys("test automation testing");
		test.pass("SearchBox Text Autofilled");
		/*
		 * test.fail("Error ScreenShot",
		 * MediaEntityBuilder.createScreenCaptureFromBase64String("screenshot.png").
		 * build());
		 */
		//test.pass("Error Message ").addScreenCaptureFromBase64String("ScreenSchot.png");


		try {
			Thread.sleep(50);
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.findElement(By.name("btnK")).click();
		test.pass("Pressed Enter Key");
	}
	@Test
	public void Test2() throws IOException {
		test = extent.createTest("Google Search Test Number 2 using Extent","Description of the Google Search test");
		test.log(Status.INFO, "Starting Of Test Case Number 2");
		driver.get("http://google.com");
		test.pass("Navigated to Google");
		driver.findElement(By.name("q")).sendKeys("test automation testing");
		test.pass("SearchBox Text Autofilled");
		try {

			Thread.sleep(50);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		driver.findElement(By.name("btnI")).click();
		test.fail("Pressed Enter Key");
	}
	@AfterMethod
	public void afterTest() {
		driver.close();
		driver.quit();
		test.info("Drivers closed Successully");

	}
	@AfterSuite
	public void afterSuit() {
		test.info("Suit Completed Successully");
		extent.flush();//This will add everything to the file
	}
}