package com.deviget.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComponentReferenceBodyPage extends BasePage {

    @FindBy(xpath="//*[@id='skip-target-content']//h2")
    WebElement header;

    @FindBy(xpath="//button[.='Filters']")
    WebElement filterButton;

    @FindBy(css="div.viewer-tiles")
    WebElement componentsContainer;

    public ComponentReferenceBodyPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isAt() {
        return waitForElements(header, filterButton, componentsContainer);
    }
}
