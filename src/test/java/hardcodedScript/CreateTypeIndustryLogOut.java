package hardcodedScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateTypeIndustryLogOut {

	public static void main(String[] args) {
		ChromeOptions cm = new ChromeOptions();
		cm.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(cm);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).submit();
		if(driver.getTitle().contains("Home"))
			System.out.println("Home page is displayed");
		else
			System.out.println("Home page is not displayed");
		
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		
		if(driver.getTitle().contains("Organization"))
			System.out.println("Organization page is displayed");
		else
			System.out.println("Organization page is not displayed");
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("TCS11");
		WebElement industry=driver.findElement(By.name("industry"));
		Select s = new Select(industry);
		s.selectByVisibleText("Banking");
		WebElement type =driver.findElement(By.name("accounttype"));
		Select s1=new Select(type);
		s1.selectByVisibleText("Analyst");
		driver.findElement(By.name("button")).click();
		String tcs= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(tcs.contains("TCS11"))
			System.out.println("Organization is created");
		else
			System.out.println("Oganization is not created");
		
		driver.findElement(By.name("Delete")).click();
		driver.switchTo().alert().accept();
		if(driver.getTitle().contains("Organization"))
			System.out.println("Organization page is displayed");
		else
			System.out.println("Ogganization page is not displayed");
		WebElement admin = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])"));
		Actions a = new Actions(driver);
		a.moveToElement(admin).perform();
		driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
		
		
		
		
		

	}

}
