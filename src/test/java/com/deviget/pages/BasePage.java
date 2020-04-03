package com.deviget.pages;

import com.deviget.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 15);
        this.actions = new Actions(driver);
    }

    protected boolean waitForElements(WebElement ... elems) {
        for(WebElement w: elems) {
            moveToElement(w);
            WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(w));
            if (!elem.isDisplayed())
                return false;
        }
        return true;
    }

    protected void jsClick(WebElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
        sleep(Constants.SHORT_WAIT);
    }

    protected void jsClick(By by) {
        this.jsClick(wait.until(ExpectedConditions.elementToBeClickable(by)));
    }

    protected void jsClick(String xpath) {
        this.jsClick(By.xpath(xpath));
    }

    protected void moveToElement(WebElement elem) {
        actions.moveToElement(elem).build();
    }

    protected void moveToElement(By by) {
        moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(by)));
    }

    protected void moveToElement(String xpath) {
        moveToElement(By.xpath(xpath));
    }

    protected void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        sleep(Constants.SHORT_WAIT);
    }

    protected void jsReset(WebElement elem) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", elem);
        sleep(Constants.SHORT_WAIT);
    }

    public void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void tryClick(WebElement elem) {
        int timeEllapsed = 0;
        while(timeEllapsed < Constants.MEDIUM_WAIT) {
            try {
                elem.click();
                break;
            } catch (Exception e) {
                this.sleep(Constants.TINY_WAIT);
                timeEllapsed += Constants.TINY_WAIT;
            }
        }
    }
    public void tryClick(WebElement... elem) {
        int timeEllapsed = 0;
        int index = 0;
        int length = elem.length;
        while(timeEllapsed < Constants.MEDIUM_WAIT) {
            try {
                elem[index].click();
                index = (index + 1) % length;
                break;
            } catch (Exception e) {
                this.sleep(Constants.TINY_WAIT);
                timeEllapsed += Constants.TINY_WAIT;
            }
        }
    }
}