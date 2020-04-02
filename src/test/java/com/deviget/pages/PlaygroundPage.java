package com.deviget.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Properties;

public class PlaygroundPage extends BasePage {

    @FindBy(xpath="//table[contains(@class, 'slds-table_edit')]")
    WebElement dataTbl;

    public PlaygroundPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private WebElement previewIframe;

    public boolean isAt() {
        driver.switchTo().frame(0);
        previewIframe = driver.findElement(By.xpath("//iframe[@name='preview']"));
        driver.switchTo().frame(previewIframe);
        return waitForElements(dataTbl);
    }

    public void editRow(Properties props) {
        editSingleColumn(props, "Label","dt-inline-edit-text");
        editSingleColumn(props, "Website",  "dt-inline-edit-url");
        editSingleColumn(props, "Phone", "dt-inline-edit-phone");
        editSingleColumn(props, "CloseAt", "dt-inline-edit-datetime");
        editSingleColumn(props, "Balance", "dt-inline-edit-currency");
    }

    public String getValue(Properties props, String column) {
        WebElement colElem = findColumnElement(props, column);
        return colElem.getText().split("\n")[0];
    }

    //(dyn) dataRow
    String dataRowXpath = "//table//tr[%s]";

    //(dyn) labelCol
    String genericColXpath = "/%s[@data-label='%s']";

    //(dyn) generic edit button
    String genericEditButtonXpath = "//button";

    //(dyn) label edit txt
    String singleColTxtXpath = "//input[@name = '%s']";

    String rowNumberElemXpath = ".//span[contains(@class, 'slds-row-number')]";

    public void editSingleColumn(Properties props, String column, String txtName) {
        WebElement rowElem = displayFields(props, column);
        //finds column Textfield and fills it up.
        String colFieldXpath = String.format(singleColTxtXpath, txtName);
        WebElement singleTxt = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(colFieldXpath)
                )
        );
        singleTxt.clear();
        singleTxt.sendKeys(props.getProperty(column));
        //finds the row number elem on the left and clicks on it to save the edits.
        rowElem.findElement(By.xpath(rowNumberElemXpath)).click();
    }

    public WebElement displayFields(Properties props, String column) {
        //finds rowelement by row number
        String rowXpath = String.format(dataRowXpath, props.getProperty("rowNumber"));
        WebElement rowElem = driver.findElement(By.xpath(rowXpath));
        //Gets the column element and moves to it, so 'pencil' icon shows up.
        String rowTag = column.equals("Label") ? "th" : "td";
        String colXpath = String.format(genericColXpath, rowTag, column);
        WebElement colElem = rowElem.findElement(By.xpath("."+ colXpath));
        moveToElement(colElem);
        //gets pencil icon and clicks on it.
        WebElement editButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(rowXpath+colXpath+genericEditButtonXpath)
                )
        );
        jsClick(editButton);
        return rowElem;
    }

    public WebElement findColumnElement(Properties props, String column) {
        //finds rowelement by row number
        String rowXpath = String.format(dataRowXpath, props.getProperty("rowNumber"));
        WebElement rowElem = driver.findElement(By.xpath(rowXpath));
        //Gets the column element and moves to it, so 'pencil' icon shows up.
        String rowTag = column.equals("Label") ? "th" : "td";
        String colXpath = String.format(genericColXpath, rowTag, column);
        WebElement colElem = rowElem.findElement(By.xpath("."+ colXpath));
        return colElem;
    }

    String lastTableRow = "//table//tr[@data-row-key-value][last()]";

    public void showDetailsLastRow() {
        String lastDownCaretIconXpath = lastTableRow + "//td[last()]//button";
        WebElement caretIcon = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(lastDownCaretIconXpath)));
        this.moveToElement(caretIcon);
        wait.until(ExpectedConditions.visibilityOf(caretIcon));
        jsClick(caretIcon);
        caretIcon.click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//a[.='Show details']")
                )
        ).click();
    }

    public boolean validateLastRowDetails() {

        String lastNameColumnXpath = lastTableRow + "//th[@data-label = 'Name']";
        WebElement lastNameColumn = driver.findElement(By.xpath(lastNameColumnXpath));
        WebElement recordDetailsName = driver.findElement(By.xpath("//dt[@title='Name']/following-sibling::dd"));

        String lastBalanceColumnXpath = lastTableRow + "//td[@data-label = 'Balance']";
        WebElement lastBalanceColumn = driver.findElement(By.xpath(lastBalanceColumnXpath));
        WebElement recordDetailsBalance = driver.findElement(By.xpath("//dt[@title='Balance']/following-sibling::dd"));

        return lastNameColumn.getText().equals(recordDetailsName.getText()) &&
                lastBalanceColumn.getText().equals(recordDetailsBalance.getText());
    }
}
