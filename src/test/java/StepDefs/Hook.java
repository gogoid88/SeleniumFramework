package StepDefs;

import Framework.ReportsManager;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {
		
	
	@Before
	public void beforeScenario(Scenario scenario) {
		
		ReportsManager.startNewTest(scenario.getName());
		
	}
	@After
	public void endScenario() {
		ReportsManager.endTest();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
