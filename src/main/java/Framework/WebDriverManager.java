package Framework;

import java.io.IOException;
import java.util.LinkedList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


class WebDriverManager {
	enum driverType{
		EDGE,
		CHROME,
		FIREFOX,
		IE
	};
	
	
	static private LinkedList <Driver> driverList = new LinkedList<Driver>();
	private static WebDriver curr; 
	
	public static void startNewDriverInstance() {
		WebDriver driver  = null;
		if(ConfigManager.getDriverType().equals(driverType.EDGE.toString())){
			System.setProperty("webdriver.edge.driver", ConfigManager.getDriverPath());
			 driver = new EdgeDriver();
			Driver d = new Driver(driver);
			driverList.add(d);
			
		}else if (ConfigManager.getDriverType().equals(driverType.CHROME.toString())) {
			System.setProperty("webdriver.chrome.driver", ConfigManager.getDriverPath());
			 driver = new ChromeDriver();
			Driver d = new Driver(driver);
			driverList.add(d);
			
		}else if(ConfigManager.getDriverType().equals(driverType.IE.toString())) {
			System.setProperty("webdriver.ie.driver", ConfigManager.getDriverPath());
			 driver = new InternetExplorerDriver();
			Driver d = new Driver(driver);
			driverList.add(d);
			
		}else if(ConfigManager.getDriverType().equals(driverType.FIREFOX.toString())){ 
			System.setProperty("webdriver.firefox.driver", ConfigManager.getDriverPath());
			 driver = new FirefoxDriver();
			Driver d = new Driver(driver);
			driverList.add(d);
		}else {
			
		}
		driver.manage().window().maximize();
		 if(curr == null)
			 setCurrDriver(driver);
	}
	public static WebDriver getLastDriver() {
		return driverList.getLast().getDriver();
	}
	
	public static WebDriver getFirstDriver() {
		return driverList.getFirst().getDriver();
	}
	
	public static WebDriver getDriver(int index) {
		return driverList.get(index).getDriver();
	}
	
	public static void closeLastDriver() {
		driverList.getLast().getDriver().quit();
		driverList.removeLast();
	}
	
	public static void setCurrDriver(WebDriver dr) {
		curr = dr;
		
	}
	
	public static WebDriver getCurrDriver() {
		return curr;
	}
	public static void launchUrl() {
		curr.get(ConfigManager.getUrl());
	}
	
	public static void closeAllInstances() throws IOException {
		for(Driver driver : driverList) {
			driver.driver.quit();
		}
		Runtime.getRuntime().exec("taskkill /F /IM msedge.exe");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

}
