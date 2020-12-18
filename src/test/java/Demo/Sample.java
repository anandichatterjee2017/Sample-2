package Demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Sample {

	@Test
	public void login() {
		try {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\BrowserDriversEXE\\chromedriver.exe"); 	
			WebDriver driver = new ChromeDriver();
			driver.get("https://demoqa.com/login");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			driver.findElement(By.id("userName")).sendKeys("Arunava");
			driver.findElement(By.id("password")).sendKeys("Password1$");
			
			driver.quit();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
