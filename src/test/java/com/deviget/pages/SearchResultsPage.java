package com.deviget.pages;

import com.deviget.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchResultsPage extends BasePage {

    String nextPageButtonCss="button[aria-label*='Next page']";
    String itemListCss = "ul.list-items";
    String itemLinkCss = "a.item-title";
    String productItemCss = "li.list-item";

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickNextPage() {
        List<WebElement> articleList = wait.until(
                ExpectedConditions.numberOfElementsToBe(
                        By.cssSelector(productItemCss), 60
                )
        );
        scrollIntoView(articleList.get(articleList.size() - 1));
        sleep(Constants.LONG_WAIT);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(nextPageButtonCss)
                )
        ).click();
    }

    public void selectFirstArticle() {
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(itemLinkCss)
                )
        ).click();
    }

}
