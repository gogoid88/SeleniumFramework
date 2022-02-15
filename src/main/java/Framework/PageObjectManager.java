package Framework;

import org.openqa.selenium.support.PageFactory;

class PageObjectManager {
	
	
	public static BasePage getPageObject(Class<?> obj) {
		return (BasePage) PageFactory.initElements(WebDriverManager.getCurrDriver(), obj);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
	}

}
