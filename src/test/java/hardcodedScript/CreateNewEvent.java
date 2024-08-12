package hardcodedScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateNewEvent {

	public static void main(String[] args) {
		ChromeOptions cm = new ChromeOptions();
		cm.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(cm);
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		if (driver.getTitle().contains("Home"))
			System.out.println("home page is displayed");
		else
			System.out.println("Home page is not displayed");
		
		driver.findElement(By.id("qccombo")).click();

	}
}
