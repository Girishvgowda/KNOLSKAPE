package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Generic.Action;


public class Homepage {
	
	private static WebElement element = null;
	
	public static WebElement textBox(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@class='new-todo']"));
		return element;
	}

	public static List<WebElement> CheckboxtoCompleted(WebDriver driver) {
		return( driver.findElements(By.xpath("//div[@class='view']/input")));
		 
	}

	public static WebElement CompletedLink(WebDriver driver) {
		element = driver.findElement(By.linkText("Completed"));
		return element;
	}
	public static List<WebElement> deleteIcon(WebDriver driver) {
		return(driver.findElements(By.xpath("//div[@class='view']/button")));
		 
	}
	public static WebElement ElementsList(WebDriver driver) {
		element = driver.findElement(By.xpath("//ul[@class='todo-list']/li/div"));
		return element;
	}
	public static WebElement firstElementToEdit(WebDriver driver) {
		element = driver.findElement(By.xpath("//ul[@class='todo-list']/li[1]/div/label"));
		return element;
	}
	public static WebElement editField(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@class='edit']"));
		return element;
	}
	public static WebElement ActiveLink(WebDriver driver) {
		element = driver.findElement(By.linkText("Active"));
		return element;
	}

	public static WebElement AllLink(WebDriver driver) {
		element = driver.findElement(By.linkText("All"));
		return element;
	}

	public static WebElement ClearCompleted(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//button[@class='clear-completed']"));
		return element;
	}
	public static WebElement nameCount(WebDriver driver) {
		element = driver.findElement(By
				.tagName("strong"));
		return element;
	}
	
	
	/**
	 * @param This method will add Names
	 */
	
	public static void addText(WebDriver driver, String us) {
		textBox(driver).sendKeys(us);
		textBox(driver).sendKeys(Keys.ENTER);
		}
	/**
	 * @param This method will delete all added names
	 */
	public static void deleteAllNames(WebDriver driver) throws InterruptedException {
		List<WebElement> Deleteicon = deleteIcon(driver);
		for (WebElement value : Deleteicon) {
			WebElement List = ElementsList(driver);
			Action.moveToSpecifiedElement(driver, List);
			Action.Sleep(driver);
			value.click();
		}
	}
	/**
	 * @param This method will edit the first column
	 */
	public static void editText(WebDriver driver, String us) throws InterruptedException {
		Action.doubleClick(driver, firstElementToEdit(driver));
		Action.Sleep(driver);
		editField(driver).clear();
		Action.Sleep(driver);
		editField(driver).sendKeys(us);
		editField(driver).sendKeys(Keys.ENTER);
		}
	/**
	 * @param This method will Count the number of names and assert
	 */
	public static void assertGetNameCount(WebDriver driver,int number)
	{
		String name=nameCount(driver).getText();
		int result = Integer.parseInt(name);
		Assert.assertEquals(result, number, "Name count not matched");
	}
}
