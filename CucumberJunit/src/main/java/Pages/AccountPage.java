package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
	
	private WebDriver driver;
	
	private By list_sections = By.cssSelector("div#center_column li");
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;		
	}
	
	public String getAccountPageTitle() {
		return driver.getTitle();
	}
	
	public List<String> getSectionsList() {
		List<String> actSectionList = new ArrayList<String>(); 
		List<WebElement> ListSection = driver.findElements(list_sections);
		for(WebElement e:ListSection) {
			actSectionList.add(e.getText());
		}
		return actSectionList;
	}
	
	public int getSectionsCount() {
		List<WebElement> sections = driver.findElements(list_sections);
		return sections.size();
	}

}
