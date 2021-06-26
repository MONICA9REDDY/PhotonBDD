package stepDefinitions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OrganizationTest {
	WebDriver driver;
	@Given("As a user I will launch {string} browser and enter the url {string}")
	public void as_a_user_i_will_launch_browser_and_enter_the_url(String browser, String url) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
	}
	@When("login page is displayed as a user I will enter username {string} and password {string}")
	public void login_page_is_displayed_as_a_user_i_will_enter_username_and_password(String string, String string2) {
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
	}
	@When("click on login")
	public void click_on_login() {
		driver.findElement(By.id("submitButton")).click();
	}
	@When("In home page click on Organization link")
	public void in_home_page_click_on_organization_link() {
		driver.findElement(By.linkText("Organizations")).click();
	}
	@When("click on create oragnization")
	public void click_on_create_oragnization() {
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	}
	@When("In organization name enter {string} and {string}")
	public void in_organization_name_enter_and(String orgName, String dropdown) {
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		System.out.println(dropdown);
	}
	@Then("click on save and verify the data")
	public void click_on_save_and_verify_the_data() {
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String org=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println("Organization creation successfull===>>> "+org);
	}
	@When("I will enter oraganization name and industry dropdown")
	public void i_will_enter_oraganization_name_and_industry_dropdown(io.cucumber.datatable.DataTable dataTable) throws IOException {
	    List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
	    String orgName=data.get(0).get("comapny");
	    String industry=data.get(0).get("dropdown");
	    driver.findElement(By.name("accountname")).sendKeys(orgName);
	    WebElement dropDown=driver.findElement(By.name("industry"));
	    Select sel=new Select(dropDown);
	    sel.selectByVisibleText(industry);
	    
	}

}
