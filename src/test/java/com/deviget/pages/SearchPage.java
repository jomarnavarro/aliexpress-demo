package com.deviget.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BasePage {

	// page members
	@FindBy(id="search-key")
	WebElement searchTxt;

	@FindBy(css=".search-button")
	WebElement searchBtn;

	String searchOptionsXpath = "//li[contains(@data-value, '%s')]";

	public SearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public boolean isAt() {
		return waitForElements(searchTxt, searchBtn);
	}

	public void goTo(String url) {
		driver.get(url);
	}

	public void searchArticle(String article) {
		searchTxt.clear();
		searchTxt.sendKeys(article);
		searchBtn.click();
	}
}
