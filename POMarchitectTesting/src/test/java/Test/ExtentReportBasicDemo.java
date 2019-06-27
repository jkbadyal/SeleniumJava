package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportBasicDemo {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		ExtentHtmlReporter htmlReport= new ExtentHtmlReporter("extent.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReport);

		ExtentTest test = extent.createTest("Google Search Test using Extent","Description of the 		Google Search test");
		test.log(Status.INFO, "Starting Of Test Case");
		driver.get("http://google.com");
		test.pass("Navigated to Google");
		driver.findElement(By.name("q")).sendKeys("test automation testing");
		test.pass("SearchBox Text Autofilled");
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.name("btnK")).click();
		test.pass("Pressed Enter Key");

		driver.close();
		driver.quit();
		test.pass("Closed Browser");
		test.info("Test Completed");
		extent.flush();//This will add everything to the file

	}

}
