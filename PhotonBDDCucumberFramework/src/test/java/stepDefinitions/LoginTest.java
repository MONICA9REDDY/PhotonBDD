package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.photon.generic.FileUtility;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;


public class LoginTest {
	private WebDriver driver;
	LoginPage loginPage;
	@Given("I want to launch the browser and I will enter the url")
	public void i_want_to_launch_the_browser_and_i_will_enter_the_url() {
	  String browser= FileUtility.getKeyValue("browser");
	  if(browser.equals("chrome")) {
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
	  }
	  else if(browser.equals("firefox")) {
		  WebDriverManager.firefoxdriver().setup();
		  driver=new FirefoxDriver();
	  }
	  String url=FileUtility.getKeyValue("url");
	  driver.get(url);
	  
	}

	@When("login page is displayed I will enter username and password")
	public void login_page_is_displayed_i_will_enter_username_and_password() {
	     loginPage=new LoginPage(driver);
	     String username=FileUtility.getKeyValue("username");
	     String password=FileUtility.getKeyValue("password");
	     loginPage.login(username, password);
	}

	@And("click on login button")
	public void click_on_login_button() {
	   loginPage.submit();
	}

	@Then("It should navigate me to Home page")
	public void it_should_navigate_me_to_home_page() {
	  String title=  driver.getTitle();
	  System.out.println("Home page Title==>>: "+title);
	  driver.close();
	}
	
	@When("login page is displayed I will enter username {string} and password {string}")
	public void login_page_is_displayed_i_will_enter_username_and_password(String username, String password) {
		loginPage.login(username, password);
	}

	@Then("Error message should be displayed for user")
	public void error_message_should_be_displayed_for_user() {
	    String errMsg=loginPage.getErrorMsgText();
	    System.out.println(errMsg);
	    driver.close();
	}
	
	@Then("Error message should be displayed {string}")
	public void error_message_should_be_displayed(String string) {
	    String errMsg=loginPage.getErrorMsgText();   
	   Assert.assertEquals(string, errMsg);
	}
}
