package com.deviget.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArticlePage extends BasePage {

    @FindBy(css=".magnifier-cover")
    WebElement mainProductImg;

    @FindBy(css=".product-quantity-tip")
    WebElement availableProductsDiv;

    String relatedItemCss = ".may-like-item";

    public ArticlePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isAt() {
        return waitForElements(mainProductImg, availableProductsDiv);
    }
}
