package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Factory.DriverFactory;

public class LoginPage {
	
	private WebDriver driver;
	//private DriverFactory driverFactory = new DriverFactory();
	
	
	private By email = By.id("email");
	private By password = By.id("passwd");
	private By forgotPasswordLink = By.linkText("Forgot your password?aaa");
	private By SignIn = By.id("SubmitLogin");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;		
	}	
	
	
	public void enter_EmailAddress(String userName) {
		driver.findElement(email).sendKeys(userName);
	}	
	public void enter_Password(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean isForgotPasswordLinkExist() {
		return driver.findElement(forgotPasswordLink).isDisplayed();
	}
	public void click_Signin() {
		driver.findElement(SignIn).click();
	}
	
	public AccountPage doLogin(String usrName, String pwd) {
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=identity");
		enter_EmailAddress(usrName);
		enter_Password(pwd);
		click_Signin();
		return new AccountPage(driver);
	}

}
