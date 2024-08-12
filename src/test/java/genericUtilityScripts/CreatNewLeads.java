package genericUtilityScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class CreatNewLeads {

	public static void main(String[] args) {
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
		driver.findElement(By.xpath("(//a[text()='Leads'])[1]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
		if(driver.getTitle().contains("Leads"))
			System.out.println("Leads page is displayed");
		else
			System.out.println("Leads page is not displayed");
		driver.findElement(By.name("firstname")).sendKeys("Pallavi");
		driver.findElement(By.name("lastname")).sendKeys("Desai");
		driver.findElement(By.name("company")).sendKeys("TCS");
		driver.findElement(By.name("button")).click();
		WebElement created = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		if(created.getText().contains("Desai Pallavi"))
			System.out.println("leads is created");
		else
			System.out.println("leads is not created");
		
		driver.findElement(By.name("Duplicate")).click();
		String leadscreated = driver.findElement(By.xpath("//span[contains(text(),'Duplicating \"Pallavi Desai\" ')] ")).getText();
		if(leadscreated.contains("Pallavi Desai"))
			System.out.println("leads is duplicated");
		else
			System.out.println("leads is not duplicated");
		driver.findElement(By.name("button")).click();
		WebElement admin = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a = new Actions(driver);
	    a.moveToElement(admin).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
        driver.quit();
		
			

	}

}
