package explicitwait;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplicitWaitExamples {
	
	
	@Test
	public void runTest() throws InterruptedException {
		 
        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
      

            // Navigate to the Dynamic Loading page
            driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

            // Example 1: presenceOfElementLocated
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement startButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Start')]")));
            startButton.click();

            // Example 2: visibilityOfElementLocated
            WebElement finishText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
            System.out.println("Finish Text: " + finishText.getText());

            // Navigate to the Challenging DOM page
            driver.get("https://the-internet.herokuapp.com/dynamic_controls");

            // Example 3: elementToBeClickable
            WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("checkbox")));
            checkbox.click();

            // Example 4: invisibilityOfElementLocated
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
            System.out.println("Loading Spinner is invisible");
            
            
            
            // Navigate to the JavaScript Alerts page
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");

            // Example 5: textToBePresentInElement
            WebElement result = driver.findElement(By.id("result"));
            WebElement triggerAlertButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click for JS Alert']")));
            triggerAlertButton.click();
            
            // Handling the alert
            //WebDriverWait alertWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert();
            System.out.println("Alert Text: " + alert.getText());
            alert.accept(); // Accept the alert
            
            wait.until(ExpectedConditions.textToBePresentInElement(result, "You successfuly clicked an alert"));

            // Navigate to the Nested Frames page
            driver.get("https://the-internet.herokuapp.com/nested_frames");

            // Example 9: frameToBeAvailableAndSwitchToIt
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frame-top"));

            // Example 10: presenceOfAllElementsLocatedBy
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("frame")));

            // Navigate to the Dynamic Controls page
            driver.get("https://the-internet.herokuapp.com/dynamic_controls");

            // Example 11: elementToBeSelected
            
            WebElement checkbox3 = driver.findElement(By.id("checkbox"));
            WebElement removeButton = driver.findElement(By.xpath("//button[contains(text(),'Remove')]"));
            removeButton.click();
            wait.until(ExpectedConditions.elementToBeSelected(checkbox3));

            // Example 12: alertIsPresent
            WebElement enableButton = driver.findElement(By.xpath("//button[contains(text(),'Enable')]"));
            enableButton.click();
            wait.until(ExpectedConditions.alertIsPresent());

            // Navigate to the JavaScript Alerts page
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");

            // Example 13: titleContains
            WebElement triggerPromptButton = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
            triggerPromptButton.click();
            wait.until(ExpectedConditions.titleContains("JavaScript Alerts"));

            // Example 14: titleIs
            wait.until(ExpectedConditions.titleIs("The Internet"));

            // Example 15: urlContains
            wait.until(ExpectedConditions.urlContains("javascript_alerts"));

            // Example 16: urlMatches
            wait.until(ExpectedConditions.urlMatches(".*/javascript_alerts"));

            // Example 17: attributeToBe
            WebElement inputField = driver.findElement(By.xpath("//input[@type='text']"));
            wait.until(ExpectedConditions.attributeToBe(inputField, "value", "default value"));

            // Example 18: stalenessOf
            WebElement resetButton = driver.findElement(By.xpath("//button[text()='Reset']"));
            inputField.clear();
            resetButton.click();
            wait.until(ExpectedConditions.stalenessOf(inputField));

            // Close the browser
            driver.quit();
          
	  
        
    }

}
