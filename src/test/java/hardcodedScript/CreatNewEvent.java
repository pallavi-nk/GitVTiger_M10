package hardcodedScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreatNewEvent {

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
		driver.findElement(By.xpath("(//a[text()='Calendar'])[1]")).click();
		WebElement add =driver.findElement(By.xpath("//td[@class='calAddButton']"));
		Actions a = new Actions(driver);
		a.moveToElement(add).perform();
		driver.findElement(By.id("addcall")).click();
		driver.findElement(By.name("subject")).sendKeys("confrence");
		WebElement status = driver.findElement(By.id("eventstatus"));
		status.click();
		Select s = new Select(status);
		s.selectByVisibleText("Held");
		WebElement priority = driver.findElement(By.id("taskpriority"));
		priority.click();
		Select s1= new Select(priority);
		s1.selectByVisibleText("Medium");
		WebElement hr = driver.findElement(By.xpath("(//select[@id='starthr'])[1]"));
		Select s2=new Select(hr);
		s2.selectByIndex(02);
		WebElement min= driver.findElement(By.xpath("(//select[@id='startmin'])[1]"));
		min.click();
		Select s3 = new Select(min);
		min.click();
		s3.selectByIndex(10);
		
		WebElement pm = driver.findElement(By.xpath("(//select[@id='startfmt'])[1]"));
		pm.click();
		Select s4 = new Select(pm);
		s4.selectByVisibleText("PM");
		WebElement endhr=driver.findElement(By.xpath("(//select[@id='endhr'])[1]"));
		endhr.click();
		Select s5= new Select(endhr);
		s5.selectByIndex(03);
		WebElement endmin=driver.findElement(By.xpath("//select[@id='endmin']"));
		endmin.click();
		Select s7 = new Select(endmin);
		s7.selectByIndex(10);
		WebElement endfmt=driver.findElement(By.xpath("//select[@id='endfmt']"));
		endfmt.click();
		Select s8 = new Select(endfmt);
		s8.selectByVisibleText("PM");
		driver.findElement(By.name("eventsave")).click();
		
		WebElement admin = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a1 = new Actions(driver);
		a1.moveToElement(admin).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
        driver.quit();
		
		 
		

	}

}
