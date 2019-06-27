package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoITDemo {
	public static void main(String[] args) throws Exception {
		AutoITTest();
	}
	public static void AutoITTest() throws Exception {


		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String path=System.getProperty("user.dir");
		driver.get("http://s000.tinyupload.com/index.php?");
		driver.findElement(By.name("uploaded_file")).click();
		Runtime.getRuntime().exec(path+"/AutoIT/test.exe");
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td[1]/img")).click();
		Thread.sleep(4000);
		driver.close();
		driver.quit();
	}
}
