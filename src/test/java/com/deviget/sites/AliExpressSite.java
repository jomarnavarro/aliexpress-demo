package com.deviget.sites;

import com.deviget.pages.*;
import org.openqa.selenium.WebDriver;

import java.util.Map;
import java.util.Properties;

public class AliExpressSite {
    private SearchPage devGuide;
    private PopUpPage nav;
    private SearchResultsPage componentLeftNav;
    private ArticlePage componentBody;
    private WebDriver driver;
    private Properties props;

    public AliExpressSite(WebDriver driver) {

        this.driver = driver;
        this.props = new Properties();
    }

    public SearchPage search() {
        if (devGuide == null);
            devGuide = new SearchPage(driver);
        return devGuide;
    }

    public PopUpPage popUp() {
        if(nav == null)
            nav = new PopUpPage(driver);
        return nav;
    }

    public SearchResultsPage searchResults() {
        if(componentLeftNav == null)
            componentLeftNav = new SearchResultsPage(driver);
        return componentLeftNav;
    }

    public ArticlePage article() {
        if(componentBody == null)
            componentBody = new ArticlePage(driver);
        return componentBody;
    }

    public void addParameters(Map<String, String> data) {
        this.props.putAll(data);
    }

    public String getParameter(String key) {
        return (String) this.props.get(key);
    }

    public void setParameter(String key, String val) {
        this.props.put(key, val);
    }

    public Properties getParameters() {
        return this.props;
    }

    public void setParameters(Properties props) {
        this.props = props;
    }
}
