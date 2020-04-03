package com.deviget.pages;

import com.deviget.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PopUpPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'dialog')]//a[.='x']")
    WebElement closePopUpIcon;

    @FindBy(css = ".next-dialog-close")
    WebElement nextCloseIcon;

    @FindBy(xpath = "//div[contains(@class, 'dialog')]//h4")
    WebElement popUpHeader;

    public PopUpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isAt() {
        return waitForElements(closePopUpIcon, popUpHeader);
    }

    public void dismissPopUpHome() {
        tryClick(closePopUpIcon, nextCloseIcon);

    }

    public void dismissNextPopUp() {
        tryClick(nextCloseIcon);
    }
}
