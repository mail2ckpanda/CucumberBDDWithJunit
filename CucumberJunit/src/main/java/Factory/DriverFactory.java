package Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	//private WebDriver driver;	
	public static ThreadLocal<WebDriver> tl_driver = new ThreadLocal<>();
	/**
	 * This method is used to initialized the thread local driver
	 * on the basis of browser type 
	 * @param Browser
	 * @return
	 */
	public WebDriver inIt_WebDriver(String Browser) {
		System.out.println("initializing the browser: "+Browser);
		if(Browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			tl_driver.set(new ChromeDriver());
		}
		else if (Browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tl_driver.set(new FirefoxDriver());
		}
		else {
			System.out.println("Plz provide valid Browser name: "+Browser);
		}
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		return getDriver();
	} 

	/**
	 * This is used to get the driver with thread local
	 * @return
	 */
	
	public static synchronized WebDriver getDriver() {
	return tl_driver.get();
}
}