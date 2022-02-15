package Framework;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Type;

import org.openqa.selenium.WebDriver;

public final class  ApplicationManager {
	static ApplicationManager singleton = new ApplicationManager();
	private ApplicationManager() {
		
	}
	static public WebDriver getCurrentDriver() {
		return WebDriverManager.getCurrDriver();
	}
	static public BasePage getPageObject(Class<?> base) {
		return PageObjectManager.getPageObject(base);
	}
	static public void launchBrowser() {
		WebDriverManager.startNewDriverInstance();
	}
	static public void loadConfiguration() throws FileNotFoundException, IOException {
		ConfigManager.loadConfig();
	}
	static public void closeBrowser() {
		WebDriverManager.closeLastDriver();
	}
	
	public static void closeBrowserTask() throws IOException {
		WebDriverManager.closeAllInstances();
	}
	public static void clearReports() {
		ReportsManager.clearReports();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
