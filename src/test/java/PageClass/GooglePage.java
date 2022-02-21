package PageClass;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Framework.BasePage;
import Framework.ReportManager;
import Framework.ReportsManager;

public class GooglePage extends BasePage{
	private WebDriver driver;
	public GooglePage(WebDriver driver ) {
		super(driver);
		this.driver = driver;
	}
	@FindBy(name = "q")
	WebElement textbox; 
	
	public void enterText(String val) {
		waitForElement(textbox).sendKeys(val);
		waitForElement(textbox).click();
		
	}
	
	public void checkResults(String val) {
		assertEquals("check search text", val, waitForElement(textbox).getAttribute("value"));
		
	}

	public void getURL(String url) {
		// TODO Auto-generated method stub
		driver.get(url);
	}
	
	
}
