package com.deviget.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComponentPage extends BasePage {

    @FindBy(xpath="//h2[@class='slds-card__header-title']")
    WebElement pageHeader;

    @FindBy(xpath = "//a[@id='example__item']")
    WebElement exampleTab;

    @FindBy(xpath = "//a[@id='documentation__item']")
    WebElement documentationTab;

    @FindBy(xpath = "//a[@id='specification__item']")
    WebElement specificationTab;

    @FindBy(xpath="//input[@name='example']")
    WebElement exampleInput;

    @FindBy(xpath="//button[.='Open in Playground']/parent::*")
    WebElement openInPlaygroundBtn;

    //Dyn object
    String exampleOptionXpath = "//*[@data-value='%s']";

    public ComponentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isAt() {
        return this.waitForElements(pageHeader, exampleTab,
                documentationTab, specificationTab, exampleInput,
                openInPlaygroundBtn);
    }

    public void selectExampleOption(String option) {
        this.jsClick(exampleInput);

        String dataValue = "";
        for(String s: option.split(" "))
            dataValue += s;
        String optionXpath = String.format(exampleOptionXpath, dataValue);
        this.jsClick(optionXpath);

        this.jsClick(openInPlaygroundBtn);
    }
}
