package com.deviget.sites;

import com.deviget.pages.*;
import org.openqa.selenium.WebDriver;

import java.util.Map;
import java.util.Properties;

public class AliExpressSite {
    private DeveloperGuidePage devGuide;
    private NavPage nav;
    private ComponentReferenceLeftNavPage componentLeftNav;
    private ComponentReferenceBodyPage componentBody;
    private ComponentPage component;
    private PlaygroundPage playground;
    private WebDriver driver;
    private Properties props;

    public AliExpressSite(WebDriver driver) {

        this.driver = driver;
        this.props = new Properties();
    }

    public DeveloperGuidePage devGuide() {
        if (devGuide == null);
            devGuide = new DeveloperGuidePage(driver);
        return devGuide;
    }

    public NavPage nav() {
        if(nav == null)
            nav = new NavPage(driver);
        return nav;
    }

    public ComponentReferenceLeftNavPage componentLeftNav() {
        if(componentLeftNav == null)
            componentLeftNav = new ComponentReferenceLeftNavPage(driver);
        return componentLeftNav;
    }

    public ComponentReferenceBodyPage componentBody() {
        if(componentBody == null)
            componentBody = new ComponentReferenceBodyPage(driver);
        return componentBody;
    }

    public ComponentPage component() {
        if(component == null)
            component = new ComponentPage(driver);
        return component;
    }

    public PlaygroundPage playground() {
        if(playground == null)
            playground = new PlaygroundPage(driver);
        return playground;
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

}
