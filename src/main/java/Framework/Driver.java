package Framework;

import org.openqa.selenium.WebDriver;

public class Driver{
	WebDriver driver;
	WindowManager winM;
	
	public Driver(WebDriver driver) {
		this.driver = driver;
		winM = new WindowManager();
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
}
