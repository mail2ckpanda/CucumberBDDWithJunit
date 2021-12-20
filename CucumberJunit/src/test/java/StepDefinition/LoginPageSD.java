package StepDefinition;

import org.testng.Assert;

import Factory.DriverFactory;
import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginPageSD {
	private String loginPageTitle;
	DriverFactory driverFactory = new DriverFactory();
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	

	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
	    loginPageTitle = loginPage.getLoginPageTitle();
	    System.out.println("Login Page Title is: "+loginPageTitle);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String title) {
	   Assert.assertTrue(loginPageTitle.contains(title));
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
	    Assert.assertTrue(loginPage.isForgotPasswordLinkExist());
	}

	@When("user enters username {string}")
	public void user_enters_username(String email) {
	    loginPage.enter_EmailAddress(email);
	}

	@When("user enters password {string}")
	public void user_enters_password(String pwd) {
		loginPage.enter_Password(pwd);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.click_Signin();
	}
	
	}
