package hardcodedScript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class CreateANewContact {

	public static void main(String[] args) throws AWTException {
		ChromeOptions cm = new ChromeOptions();
		cm.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(cm);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		if(driver.getTitle().contains("Home"))
			System.out.println("home page is displayed");
		else
			System.out.println("Home page is not displayed");
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		if(driver.getTitle().contains("Contacts"))
			System.out.println("Contacts page is displayed");
		else
			System.out.println("Contacts page is not displayed");
		
		driver.findElement(By.name("firstname")).sendKeys("Pallavi");
		driver.findElement(By.name("lastname")).sendKeys("Desai");
		String parWindow = driver.getWindowHandle();
		System.out.println(parWindow);
		driver.findElement(By.xpath("(//img[@alt='Select'])[1])")).click();
		Set<String> windows = driver.getWindowHandles();
		for(String winHandle:driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		
	   // driver.findElement(By.name("button")).click();
	    WebElement admin = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	    Actions a = new Actions(driver);
	    a.moveToElement(admin).perform();
	    driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
       // driver.quit();
		
		
		
		
		

	}

}
