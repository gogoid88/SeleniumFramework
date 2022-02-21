package Module;
//////////////////////////////////////
import Framework.ApplicationManager;
import Framework.BasePage;
import PageClass.GooglePage;

public class GoogleModule {
	 GooglePage page;
	 
	 public GoogleModule() {
		page = (GooglePage) ApplicationManager.getPageObject(GooglePage.class); 
	 }
	 
	 public void enterSearch(String val) {
			page.enterText(val);
			
		}

	public void getURL(String url) {
		// TODO Auto-generated method stub
		page.getURL(url);
	}
	
	public void checkResults(String val) {
		page.checkResults(val);
	} 
}
