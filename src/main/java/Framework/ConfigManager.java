package Framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

class ConfigManager {
	enum driverTYPE{
		EDGE,
		CHROME,
		FIREFOX,
		IE
	};
	static private Properties config = new Properties();
	static private String url;
	static private String driverType;
	public static void loadConfig() throws FileNotFoundException, IOException {
		config.load(new FileInputStream(new File("src/main/resources/Application.properties")));
		driverType = config.getProperty("driver");
		url = config.getProperty("URL");
		ReportsManager.getInstance();
	}
	
	public static String getReportLocation() {
		return config.getProperty("Report.path");
	}
	public static String getDriverType() {
		return driverType;
	}
	
	public static String getDriverPath() {
			return config.getProperty(driverType+ ".path");
		}
	
	
	public  static String getUrl() {
		return url;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
