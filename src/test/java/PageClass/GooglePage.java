package PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Framework.BasePage;

public class GooglePage extends BasePage{
	private WebDriver driver;
	public GooglePage(WebDriver driver ) {
		super(driver);
		this.driver = driver;
	}
	@FindBy(id = "input")
	WebElement textbox; 
	
	public void enterText(String val) {
		waitForElement(textbox).sendKeys(val);
	}

	public void getURL(String url) {
		// TODO Auto-generated method stub
		driver.get(url);
	}
	
	
}
