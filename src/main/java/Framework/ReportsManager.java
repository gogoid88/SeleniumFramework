package Framework;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.model.Log;

import junit.framework.TestCase;


public class ReportsManager{
	static ExtentTest currTest;
	static ExtentReports ReportInstance;
	public static void getInstance() {
		 
		SimpleDateFormat DatFr = new SimpleDateFormat("MMDDYY HH:MM:SS");
		String timestamp = DatFr.format(new Date()).replace(":", "_") ;
		String path = new StringBuilder(ConfigManager.getReportLocation()).append("\\").append(timestamp).toString();
		File folder =   new File(path);
		folder.mkdirs();
		path = new StringBuilder(path).append("\\").append( timestamp).append(".html").toString();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
		sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Test Execution Report");

        ReportInstance = new ExtentReports();
        ReportInstance.attachReporter(sparkReporter);
        ReportInstance.setSystemInfo("OS", System.getProperty("os.name"));
        ReportInstance.setSystemInfo("Environment", "QA");
        ReportInstance.setSystemInfo("User", System.getProperty("user.name"));
		 

	}
	
 public static void startNewTest(String name) {
	 currTest = ReportInstance.createTest(name);
 }
 
 public static void clearReports() {
	 if(ReportInstance.getReport() !=null) {
		 ReportInstance.flush();
	 }
 }
 public static void endTest() {
	 ReportInstance.flush();
 }
 
 public static void ScreenShot(String path) {
	 path = path.replace("/", "\\");
	 ((ExtentTest) currTest).addScreenCaptureFromPath(path);
	 
 }
 
 public static void assertEquals(String message ,Object expected, Object actual) {
	 try {
	 Assert.assertEquals(expected, actual);
	 currTest.pass( message );
	 }catch(AssertionError e) {
		 currTest.fail( message);
	 }
 }
 

 
@Rule
 public TestWatcher watchman= new TestWatcher() {
	 	@Override
         public void failed(Throwable e, Description description) {
        	 currTest.fail(e.getMessage() + " in " + description.getMethodName());    
         }
	 	@Override
         public void succeeded(Description description) {
        	 currTest.pass( description.getMethodName());
         }
 };
 



 
 
 
 
  
}
