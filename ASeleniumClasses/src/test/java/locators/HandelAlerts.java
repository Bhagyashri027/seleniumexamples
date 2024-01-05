package locators;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HandelAlerts {
	WebDriver driver = new ChromeDriver();
	
	@BeforeMethod
	
	public void intitalmethod() {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement javascriptsalert = driver.findElement(By.linkText("JavaScript Alerts"));
		javascriptsalert.click();
		
	}
	
	@Test
	
	public void JSAlertMessage() {
	
	WebElement JSAlert =  driver.findElement(By.xpath("//*[@id=\'content\']/div/ul/li[1]/button"));
	JSAlert.click();
	
	Alert JSAlertobj = driver.switchTo().alert();
	JSAlertobj.accept();
	
	WebElement JSAlertsuccess = driver.findElement(By.id("result"));
	String title = JSAlertsuccess.getText();
	
	Assert.assertTrue(title.contains("You successfully clicked an alert"));

	
	
	}
	

	@Test
	
	public void JSAlertConfirm() {

		
		WebElement JSAlertConfirm = driver.findElement(By.xpath("//*[@id=\'content\']/div/ul/li[2]/button"));
		JSAlertConfirm.click();
		
		Alert confirmobj = driver.switchTo().alert();
		confirmobj.accept();
		
		WebElement confirmmessage = driver.findElement(By.id("result"));
		String title = confirmmessage.getText();
		
		Assert.assertTrue(title.contains("You clicked: Ok"));
		
		
	}
	
	@Test
	
	public void JSAlertdismiss() {
		
		WebElement JSAlertConfirm = driver.findElement(By.xpath("//*[@id=\'content\']/div/ul/li[2]/button"));
		JSAlertConfirm.click();
		
		Alert dismissobj = driver.switchTo().alert();
		dismissobj.dismiss();
		
		WebElement confirmmessage = driver.findElement(By.id("result"));
		String title = confirmmessage.getText();
		
		Assert.assertTrue(title.contains("You clicked: Cancel"));
		
		
	}
	
	@Test
	public void JSPromttesting() {
		
		WebElement JSPromt = driver.findElement(By.xpath("//*[@id='content']/div/ul/li[3]/button"));
		JSPromt.click();
		
		Alert JSPromtOk = driver.switchTo().alert();
		JSPromtOk.sendKeys("I am Shree");
		JSPromtOk.accept();
		
		WebElement confirmmessage = driver.findElement(By.id("result"));
		String title = confirmmessage.getText();
		
		Assert.assertTrue(title.contains("You entered: I am Shree"));
		
		
	
	}
	
	@AfterMethod
	public void endmethod() {
		driver.close();
	}
	

}
