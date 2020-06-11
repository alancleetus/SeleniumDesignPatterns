package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {

	WebDriver driver;

	@FindBy(name="q")
	WebElement queryBox;
	

	@FindBy(name="btnK")
	WebElement searchButton;
	
	@FindBy(xpath="//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/div[2]/ul/li")
	List<WebElement> listOfSuggestions;
	
	@FindBy(linkText="Videos")
	WebElement videosTabButton;
	
	@FindBy(id="result-stats")
	WebElement statsText;
	
	public SearchResultsPage(WebDriver driver) {
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
	
	public void clickQueryBox() {
		queryBox.click();
	}
	
	public void clickSuggestion(int i) {
		listOfSuggestions.get(i).click();
	}
	
	public void clickVideosTab() {
		videosTabButton.click();
	}
	
	public String getResultText()
	{
		return statsText.getText();
	}
}
