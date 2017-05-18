package Generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Action {
	
	WebDriver driver;
	Actions var = new Actions(driver);
	public static void moveToSpecifiedElement(WebDriver driver, WebElement element) {
		Actions var = new Actions(driver);
		var.moveToElement(element).build().perform();
	}
	public static void pageWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public static void Sleep(WebDriver driver) throws InterruptedException {
		Thread.sleep(1000);
	}
	public static void doubleClick(WebDriver driver,WebElement element) throws InterruptedException {
		Actions var = new Actions(driver);
		var.doubleClick(element).build().perform();
	}
	

}
