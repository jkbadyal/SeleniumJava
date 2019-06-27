package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dataProviderTest {
	/*
	 * public static void main(String[] args) { String projectPath =
	 * System.getProperty("user.dir");
	 * testData(projectPath+"/ExcelFolder/Data.xlsx", "Sheet1"); }
	 */

	WebDriver driver;
	ExtentHtmlReporter htmlReport;
	ExtentReports extent ;
	ExtentTest test ;

	@BeforeSuite
	public void beforeSuite() {
		htmlReport= new ExtentHtmlReporter("extentWithDataProvider.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReport);
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	}
	@AfterSuite
	public void ClosingDrivers()
	{
		driver.close();
		driver.quit();
		extent.flush();
	}
	@Test(dataProvider ="anyName")
	public void test1(String userName,String password) {
		test = extent.createTest("Entering UserName & Password using Extent","Testing the DataProviderwith Selanium TestNG and Extent Report");
		test.log(Status.INFO, "Using Log(Status,details)Starting Of Test");
		driver.get("http://testing-ground.scraping.pro/login");
		test.pass("Website Successfully opened");
		driver.findElement(By.id("usr")).sendKeys(userName);
		test.pass("UserName entery SuccesFull");
		driver.findElement(By.id("pwd")).sendKeys(password);
		test.pass("User Password Entered Successfull");
		try {
			test.info("Thread sleep 1 Second");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@DataProvider(name="anyName")
	public Object[][] getData() {
		String projectPath =  System.getProperty("user.dir");
		Object data[][]=testData(projectPath+"/ExcelFolder/Data.xlsx", "Sheet1");
		return data;
	}
	public  Object[][] testData(String projectPath,String sheetName) {
		ExcelUtils excel= new ExcelUtils(projectPath, sheetName);
		int rowCount= excel.getRowCount();
		int colCount=excel.getColumnCount();
		Object data[][]=new Object[rowCount-1][colCount];

		for(int i=1;i<rowCount;i++) {
			for(int j=0;j<colCount;j++) {
				String dataFromCell=excel.getStringCellData(i, j);
				data[i-1][j]=dataFromCell;
			}
		}
		return data;
	}
}
