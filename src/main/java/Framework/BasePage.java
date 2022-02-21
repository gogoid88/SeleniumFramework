package Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends ReportsManager{
	WebDriverWait wait ;
	WebDriver driver;
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 60);
	}
	
	public WebElement waitForElement(WebElement ele) {
		wait.until(ExpectedConditions.visibilityOf(ele));
		return ele;
	}
}
