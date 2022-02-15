package Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import Framework.ApplicationManager;



public class RobotActions {
	Actions  act = new Actions(ApplicationManager.getCurrentDriver());
	
	public static void enterKey(int key) throws AWTException {
		Robot robo = new Robot();
		robo.keyPress(key);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
