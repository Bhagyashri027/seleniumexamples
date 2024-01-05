package windowhandlers;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewWindow {
	WebDriver driver;
	
	@BeforeMethod
	public void startingmethod(){
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/browser-windows");			
	}
	
	@Test
	public void newtabwindow() {
		
		String Parent = driver.getWindowHandle();
		driver.findElement(By.id("tabButton")).click();
		
		Set<String> handles = driver.getWindowHandles();
		
		  
		for(String handle: handles) {
			if(handle.equals(Parent)){
				continue;
		}else
		{
			driver.switchTo().window(handle);
			String firstchildoutput =driver.findElement(By.id("sampleHeading")).getText();
			Assert.assertEquals(firstchildoutput, "This is a sample page");	
			
		}
			
		}
		driver.switchTo().window(Parent);
		driver.findElement(By.id("windowButton")).click();
		
		 handles = driver.getWindowHandles();
		String secondwindow = null;
		
		for(String handle: handles) {
			if(handle.equals(Parent)) {
				continue;
			}else 
			{
				secondwindow = handle;
				driver.switchTo().window(handle);
				String secondchildoutput = driver.findElement(By.id("sampleHeading")).getText();
				Assert.assertEquals(secondchildoutput, "This is a sample page");
			}
		}
		
		driver.switchTo().window(Parent);
		driver.findElement(By.id("messageWindowButton")).click();
		
		handles = driver.getWindowHandles();
		
		for(String handle: handles) {
			if(handle.equals(Parent)) {
				continue;
			}else if(handle.equals(secondwindow)) {
				continue;
				
			}else
			{
				driver.switchTo().window(handle);
		        String thirdchildoutput = driver.findElement(By.xpath("/html/body")).getText();
		        Assert.assertEquals(thirdchildoutput, "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.");
			
			}
	 
		
		}
		driver.switchTo().window(Parent);
		
	}
	
	

}
