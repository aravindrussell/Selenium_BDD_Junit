package org.example.manager;

import org.example.action.HomePageActions;
import org.example.action.LoginAction;
import org.example.reporting.ExtendReporting;
import org.example.utility.DateTimeUtility;
import org.example.utility.PropertiesUtility;
import org.example.utility.WebDriverUtility;

import java.util.Properties;

public class PageObjectManager {

    private HomePageActions homePageActions;
    private LoginAction loginAction;
    private WebDriverUtility webDriverUtility;
    private PropertiesUtility propertiesUtility;
    private ExtendReporting extendReporting;
    private DateTimeUtility dateTimeUtility;

    public HomePageActions getHomePageActions(){
        return (homePageActions == null) ? homePageActions = new HomePageActions() : homePageActions;
    }

    public LoginAction getLoginAction(){
        return (loginAction == null) ? loginAction = new LoginAction() : loginAction;
    }

    public WebDriverUtility getWebDriverUtility(){
        return (webDriverUtility == null) ? webDriverUtility = new WebDriverUtility() : webDriverUtility;
    }

    public PropertiesUtility getPropertiesUtility(String path){
        return (propertiesUtility == null) ? propertiesUtility = new PropertiesUtility(path) : propertiesUtility;
    }

    public ExtendReporting getExtendReporting(){
        return (extendReporting == null) ? extendReporting = new ExtendReporting() : extendReporting;
    }

    public DateTimeUtility getDateTimeUtility(){
        return (dateTimeUtility == null) ? dateTimeUtility = new DateTimeUtility() : dateTimeUtility;
    }
}
