package Framework;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;

 class WindowManager {
	private LinkedList<String> windowList;
	public WindowManager() {
		windowList= new LinkedList<String>();
	}
	
	public void openNewWindow() {
		((JavascriptExecutor) WebDriverManager.getCurrDriver()).executeScript("window.open()");
		
	}
	public LinkedList<String> getWindows(){
		return windowList;
	}
	public void switchToLatestWindow() {
		Set<String> handles = WebDriverManager.getCurrDriver().getWindowHandles();
		HashSet<String> logged = new HashSet(windowList);
		for(String handle : handles) {
			if(!logged.contains(handle)) {
				windowList.add(handle);
			}
		}
		WebDriverManager.getCurrDriver().switchTo().window(windowList.getLast());
	}
	public void switchToParent() {
		windowList.removeLast();
		WebDriverManager.getCurrDriver().close();
		WebDriverManager.getCurrDriver().switchTo().window(windowList.getLast());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
