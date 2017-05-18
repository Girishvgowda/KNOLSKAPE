package Script;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Basic.basics;
import Generic.Action;
import Pages.Homepage;

public class Script extends basics {
	WebDriver driver;
	String name="Giri";
	@BeforeTest
	public void setup() throws IOException
	{
		driver=lanchbrowser();
		Action.pageWait(driver);
	}
	//Adds 5 names
	@Test(priority=1)
	public void AddUseNames() {
		
		for(int i=0;i<5;i++)
		{
		Homepage.addText(driver, name+i);
		System.out.println("User Added="+name+i);
		}
		Homepage.assertGetNameCount(driver, 5);
	}
	//click on Complete check box 
	@Test(priority=2)
	public void complete() throws InterruptedException
	{
	for (int j = 0; j <= 1; j++) {
		Homepage.CheckboxtoCompleted(driver).get(j).click();
	} 
	System.out.println("Checked 2 Names");
	Action.Sleep(driver);
	
	}
	//click on Complete link 
	@Test(priority=3)
	public void Completed() throws InterruptedException
	{
		Homepage.CompletedLink(driver).click();
		System.out.println("Displaying Completed names");
		Action.Sleep(driver);
	}
	//click on Active link 
	@Test(priority=4)
	public void Active() throws InterruptedException
	{
		Homepage.ActiveLink(driver).click();
		System.out.println("Displaying Active names");
		Action.Sleep(driver);
	}
	//click on All link 
	@Test(priority=5)
	public void All() throws InterruptedException
	{
		Homepage.AllLink(driver).click();
		System.out.println("Displaying All names");
		Action.Sleep(driver);
	}
	//click on Clear Completed button 
	@Test(priority=6)
	public void ClearCompleted() throws InterruptedException
	{
		Homepage.ClearCompleted(driver).click();
		System.out.println("Cleared completed names");
		Action.Sleep(driver);
	}
	//edits the 1st row
	@Test(priority=7)
	public void editNames() throws InterruptedException {
		Homepage.editText(driver, "Edit_"+name);
		System.out.println("Name edited");
	}
	//Deletes all the rows
	@Test(priority=8)
	public void Delete() throws InterruptedException
	{
		Homepage.assertGetNameCount(driver, 3);
		Homepage.deleteAllNames(driver);
		
	}
	
@AfterTest
public void quit()
{
	exit();
	}
}
