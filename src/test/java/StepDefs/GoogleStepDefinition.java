package StepDefs;

import java.awt.AWTException;
import java.awt.event.KeyEvent;


import Module.GoogleModule;
import PageClass.GooglePage;
import Utilities.RobotActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleStepDefinition {
	GoogleModule module ; 
	
	public GoogleStepDefinition() {
		// TODO Auto-generated constructor stub
		module = new GoogleModule();
	}
	
	@Given("{string} is launched on browser")
	public void getURL(String url) {
		module.getURL(url);
	}

	@Given("Enter search text string {string}")
	public void enter_search_text_string(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    module.enterSearch(string);
	}
	@When("Enter search text string")
	public void enterSearch(String val) {
		module.enterSearch(val);
	}
	
	@Then("results will be shown for {string}")
	public void results_will_be_shown(String val) {
	    // Write code here that turns the phrase above into concrete actions
	    module.checkResults(val);
	}



	@Then("click enter")
	public void click() throws AWTException {
		RobotActions.enterKey(KeyEvent.VK_ENTER);
	}
	
	
}
