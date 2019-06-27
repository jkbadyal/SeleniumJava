package Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.GoogleHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

	public class TestNG_Demo {
	static WebDriver driver=null;
	
	@BeforeTest
	public void DriverLoading() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	}
	@Test
	public static void GoogleHomePageTest() {
		GoogleHomePage SearchPage_obj= new GoogleHomePage(driver);
		driver.get("https://google.com");
		SearchPage_obj.EnterTextInSearchBox("Raptors");
		SearchPage_obj.Click_Search_button();
		}
	@Test
	public static void GoogleHomePageTest4() {
		GoogleHomePage SearchPage_obj= new GoogleHomePage(driver);
		driver.get("https://google.com");
		SearchPage_obj.EnterTextInSearchBox("Raptors");
		SearchPage_obj.Click_Search_button();
		}
		
	@AfterTest
	public void ClosingDrivers()
	{
		driver.close();
		driver.quit();
		System.out.println("Testing Complete Successully");
	}
}
