package AppHooks;

import java.util.Properties;

import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



import Factory.DriverFactory;
import Utilities.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	private ConfigReader configreader;
	private DriverFactory driverFactory;
	private Properties propp;
	private WebDriver driver;	
	
	@Before(value = "@skip",order = 0)
	public void skipScenarios(Scenario scenario) {
		System.out.println("SKIPPED Scenario: "+scenario.getName());
		Assume.assumeTrue(false);
		
	}
	@Before(order = 1)
	public void getProperty() {
		configreader = new ConfigReader();
		propp = configreader.init_Prop();		
	}
	
	@Before(order = 2)
	public void launchBrowser() {
		String browser = propp.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.inIt_WebDriver(browser);		
	}
	
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After(order = 1)
	public void takeFailedScenarioScreenShot(Scenario scenario) {
		System.out.println("Tear Down");
		if (scenario.isFailed()) {
			String fileName = scenario.getName().replaceAll(" ","_");
			TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
			byte[] srcScreenshot = takeScreenshot.getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreenshot, "image/png",fileName);
		}
	}
}
