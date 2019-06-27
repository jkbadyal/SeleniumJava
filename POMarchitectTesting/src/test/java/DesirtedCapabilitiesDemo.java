import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DesirtedCapabilitiesDemo {
	public static void main(String... args) {

		ChromeOptions options = new ChromeOptions();
	/*	options.setCapability("ignoreProtectedModeSetting", true);*/
 		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver(options);
	
	
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("I");
		driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);
		driver.close();
		driver.quit();
	}



}
