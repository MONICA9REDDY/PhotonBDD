package iorunner;


import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.photon.generic.FileUtility;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@Test
@CucumberOptions(
		features = ".\\src\\test\\java\\features\\Login.feature",
		glue={"stepDefinitions"},
		dryRun = false,
		monochrome = true,
		tags = "@SmokeTest and @RegressionTest",
		plugin = {//"pretty",
				"html:target/htmlreport.html",
				//"json:target/jsonreport.json",
				//"junit:target/junitreport.html",
				"rerun:target/rerun.txt",
				
				}
		)
public class Runner extends AbstractTestNGCucumberTests{
	@Parameters("browser")
	@BeforeClass
	public void configBC(String browser) throws Throwable {
		
		FileUtility.initializeProp();
		
		 FileUtility.prop.get().setProperty("browser", browser);
		
	}
	
	@AfterClass
	public void configAC() {
		
	}
	
}
