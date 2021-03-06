package sample;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo {

	String spreadsheetId = "1ty-PpPVeeyqPsJj9W3t7Wo-z5wqONcUZRq0ZR06xWF8";
	@Test
	public void login() {
		try {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\BrowserDriversEXE\\chromedriver.exe"); 	
			WebDriver driver = new ChromeDriver();
			driver.get("https://demoqa.com/login");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			ReadWriteGoogleSheet sample = new ReadWriteGoogleSheet();
			String str = sample.getData(spreadsheetId, "Username");
			
			driver.findElement(By.id("userName")).sendKeys(str);
			driver.findElement(By.id("password")).sendKeys("Password1$");
			
			driver.quit();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
