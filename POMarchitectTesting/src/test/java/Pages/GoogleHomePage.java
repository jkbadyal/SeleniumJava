package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage {

	WebDriver driver = null;
	static By textBox_search= By.name("q");
	static By search_button =By.name("btnK");

	public GoogleHomePage(WebDriver driver){
		this.driver=driver;
	}
	public  void EnterTextInSearchBox(String text) {
		driver.findElement(textBox_search).sendKeys(text);
		//driver.findElement(textBox_search).sendKeys(Keys.ESCAPE);
	}
	public  void Click_Search_button() {
		driver.findElement(textBox_search).sendKeys(Keys.ENTER);;
	}
}
