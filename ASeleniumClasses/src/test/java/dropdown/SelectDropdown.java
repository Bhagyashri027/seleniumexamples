package dropdown;


	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.annotations.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;

	public class SelectDropdown {
		@Test
		
		public void selectDDvalues() {
			
			WebDriver driver = new ChromeDriver();
			driver.get("https://the-internet.herokuapp.com/dropdown");
			
			WebElement dropdown = driver.findElement(By.xpath("//*[@id=\'dropdown\']"));
			Select select = new Select(dropdown);
			
			//select.selectByIndex(1);
			//select.selectByValue("1");
			select.selectByVisibleText("Option 1");
			
			
			
		}

	}
