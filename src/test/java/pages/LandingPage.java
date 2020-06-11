package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	WebDriver driver;

	@FindBy(name="q")
	WebElement queryBox;
	

	@FindBy(name="btnK")
	WebElement searchButton;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterSearchTerm(String term) {
		queryBox.sendKeys(term);
	}
	
	public SearchResultsPage clickSearch() {
		searchButton.click();
		return new SearchResultsPage(driver);
	}
}
