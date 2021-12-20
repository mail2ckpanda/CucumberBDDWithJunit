package StepDefinition;



import java.util.List;
import java.util.Map;

import org.junit.Assert;

import Factory.DriverFactory;
import Pages.AccountPage;
import Pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountPageSD {

	AccountPage accountPage;
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credential) {
		List<Map<String,String>> cred = credential.asMaps();
		String username = cred.get(0).get("username");
		String password = cred.get(0).get("password");
		LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
		accountPage = loginPage.doLogin(username, password);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		System.out.println(accountPage.getAccountPageTitle());
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable dataTable) {
		List<String> exp_sections = dataTable.asList();
		List<String> act_secltionList = accountPage.getSectionsList();
		Assert.assertTrue(act_secltionList.containsAll(exp_sections));	    
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(int expSectionscount) {
		int actSectionsCount = accountPage.getSectionsCount();		
		Assert.assertEquals(expSectionscount, actSectionsCount);
	}
	
}
