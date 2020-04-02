package com.deviget.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavPage extends BasePage {

    @FindBy(xpath = "//a[@title='Component Reference']")
    WebElement componentRefLnk;

    @FindBy(xpath =    "//a[@title='Developer Guide']")
    WebElement devGuideLnk;

    public NavPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isAt() {
        return waitForElements(componentRefLnk, devGuideLnk);
    }

    public void clickComponentRefLink() {
        this.jsClick(componentRefLnk);
    }

}
