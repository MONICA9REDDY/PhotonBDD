package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	private WebElement usernameTF;
	
	@FindBy(name="user_password")
	private WebElement passwordTF;
	
	@FindBy(id="submitButton")
	private WebElement submitBtn;
	
	@FindBy(xpath="//div[@class='errorMessage']")
	private WebElement errorMsgTxt;
	

	public WebElement getErrorMsgTxt() {
		return errorMsgTxt;
	}

	public WebElement getUsernameTF() {
		return usernameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public void login(String username, String password) {
		usernameTF.sendKeys(username);
		passwordTF.sendKeys(password);
	}
	
	public void submit() {
		submitBtn.click();
	}
	
	public String getErrorMsgText() {
		return errorMsgTxt.getText();
	}
	
}
