package stepDefinitions;


import com.photon.generic.FileUtility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hook {
	//@Before will follow the ascending order
	@Before(order = 0)
	public void before() throws Throwable {
		System.out.println("execute first");
		
		
	}
	
	@Before(order = 1)
	public void setup() throws Throwable {
		System.out.println("inside before method");
		//FileUtility.initializeProp();
		
	}
	
	//@After will exceute in descending order
	@After(order = 1)
	public void tearDown(Scenario scenario) {
		System.out.println("after method");
		if(scenario.isFailed())
		System.out.println(scenario.getName()+" is failed");
		
	}
	@After(order=0)
	public void after() throws Throwable {
		System.out.println("execute last");
		
		
	}
}
