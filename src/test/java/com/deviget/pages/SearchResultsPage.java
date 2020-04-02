package com.deviget.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultsPage extends BasePage {

    @FindBy(css="div.next-pagination-pages button[aria-label*='Next page']")
    WebElement nextPageBtn;

    String itemListCss = "ul.list-items";
    String itemLinkCss = "a.item-title";

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
