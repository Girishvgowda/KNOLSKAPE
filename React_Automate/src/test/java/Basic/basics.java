package Basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class basics {
		WebDriver driver;
		public File f;
		public FileInputStream fi;
		public static Properties repo=new Properties();
		
		
		public void  LoadpropertiesFile() throws IOException {
			f=new File(System.getProperty("user.dir")+"\\config.properties");
			fi=new FileInputStream(f);
			repo.load(fi);
		}
		public WebDriver lanchbrowser() throws IOException
		{
			LoadpropertiesFile();
			String browser=repo.getProperty("browser");
			try {
				if (browser.equalsIgnoreCase("Firefox")) {
					driver = new FirefoxDriver();
				} 
				else if (browser.equalsIgnoreCase("Chrome")) {
					System.setProperty("webdriver.chrome.driver",
							System.getProperty("user.dir")+"\\Exe\\chromedriver.exe");
					driver = new ChromeDriver();
				} 
			
			} catch (WebDriverException e) {
				System.out.println(e.getMessage());
			}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(repo.getProperty("url"));
		return driver;
		}
		public void exit() {
			driver.close();
		}
}