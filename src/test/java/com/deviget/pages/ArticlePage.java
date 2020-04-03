package com.deviget.pages;

import com.deviget.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ArticlePage extends BasePage {

    @FindBy(css=".magnifier-cover")
    WebElement mainProductImg;

    @FindBy(css=".product-quantity-tip")
    WebElement availableProductsDiv;

    String relatedItemCss = ".may-like-item";

    List<WebElement> recItems;

    public ArticlePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isAt() {
        ArrayList<String> windowIds = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowIds.get(windowIds.size() - 1));
        return waitForElements(mainProductImg, availableProductsDiv);
    }

    public int getAvailability() {
        String availableItemsStr = availableProductsDiv.getText();
        try {
            int availability = Integer.parseInt(availableItemsStr.split(" ")[0]);
            if(availability > 0)
                return availability;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int getNumberOfRecommendations(int minimumItems) {
        recItems = wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(
                        By.cssSelector(relatedItemCss), minimumItems - 1)
        );
        return recItems.size();
    }

    public void clickRecommendation(int i) {
        recItems.get(i - 1).click();
    }
}
