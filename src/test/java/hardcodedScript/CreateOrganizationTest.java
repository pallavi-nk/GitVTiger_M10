package hardcodedScript;



import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganizationTest {

	public static void main(String[] args)  {
		ChromeOptions cm = new ChromeOptions();
		cm.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(cm);
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		if(driver.getTitle().contains("Home"))
			System.out.println("home page is displayed");
		else
			System.out.println("Home page is not displayed");
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		if (driver.getTitle().contains("Organization"))
			System.out.println("Organization page is displayed");
		else
			System.out.println("Organization page is not displayed");
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				
		driver.findElement(By.name("accountname")).sendKeys("Org.BMS11");
		driver.findElement(By.name("button")).click();
		 WebElement header=driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		 if(header.getText().contains("Org.BMS11"))
			 System.out.println("Organization is created");
		 else
			 System.out.println("Organization is not created");
		 driver.findElement(By.name("Delete")).click();
		 driver.switchTo().alert().accept();
		 WebElement admin = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 Actions a = new Actions(driver);
		 a.moveToElement(admin).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
        driver.quit();
		
		
		

		
	}

}
