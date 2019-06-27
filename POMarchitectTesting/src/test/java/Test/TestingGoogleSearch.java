package Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.GoogleHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestingGoogleSearch {
	static WebDriver driver=null;
	public static void main(String[] args)
	{
		GoogleHomePageTest();
	}
	public static void GoogleHomePageTest() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		GoogleHomePage SearchPage_obj= new GoogleHomePage(driver);
		driver.get("https://google.com");
		SearchPage_obj.EnterTextInSearchBox("hey, How are you");
		SearchPage_obj.Click_Search_button();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		driver.quit();
	}
}
