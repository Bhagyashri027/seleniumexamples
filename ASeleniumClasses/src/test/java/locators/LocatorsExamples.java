package locators;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorsExamples {
	
	@Test
	public void locatelement() {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://the-internet.herokuapp.com/");
	
	WebElement formlink = driver.findElement(By.linkText("Form Authentication"));
	formlink.click();
	
	WebElement uname = driver.findElement(By.id("username"));
	uname.sendKeys("tomsmith");
	
	WebElement password = driver.findElement(By.name("password"));
	password.sendKeys("SuperSecretPassword!");
	
	WebElement button= driver.findElement(By.xpath("//*[@id=\'login\']/button/i"));
	button.click();
	
	WebElement successmessage = driver.findElement(By.id("flash"));
	String title = successmessage.getText();
	
	Assert.assertTrue(title.contains("You logged into a secure area!"));
	driver.close();
	

	}
}
