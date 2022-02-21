package Framework;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


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
		ReportInstance = new ExtentReports(path);

	}
	
 public static void startNewTest(String name) {
	 currTest = ReportInstance.startTest(name);
 }
 
 public static void clearReports() {
	 if(ReportInstance.getReportId() !=null) {
		 ReportInstance.flush();
		 ReportInstance.close();
	
	 }
 }
 public static void endTest() {
	 ReportInstance.endTest(currTest);
 }
 
 public static void ScreenShot(String path) {
	 path = path.replace("/", "\\");
	 currTest.addScreenCapture(path);
	 
 }
 
 public static void assertEquals(String message ,Object expected, Object actual) {
	 try {
	 Assert.assertEquals(expected, actual);
	 currTest.log(LogStatus.PASS, message );
	 }catch(AssertionError e) {
		 currTest.log(LogStatus.FAIL, message);
	 }
 }
 

 
@Rule
 public TestWatcher watchman= new TestWatcher() {
	 	@Override
         public void failed(Throwable e, Description description) {
        	 currTest.log(LogStatus.FAIL, e.getMessage() + " in " + description.getMethodName());    
         }
	 	@Override
         public void succeeded(Description description) {
        	 currTest.log(LogStatus.PASS, description.getMethodName());
         }
 };
 



 
 
 
 
  
}
