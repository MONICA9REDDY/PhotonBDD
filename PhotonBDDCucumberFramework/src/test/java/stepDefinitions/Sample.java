package stepDefinitions;

import io.cucumber.java.en.When;

public class Sample{

	@When("exceute Hook")
	public void exceute_hook() {
	    System.out.println("inside =====>>>>"+getClass());
	}

}
