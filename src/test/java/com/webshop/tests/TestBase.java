package com.webshop.tests;

import com.project.fw.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase
{
    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", Browser.CHROME.browserName()));//add static. in() for testing in chrome

    //@BeforeMethod
    @BeforeSuite
    public void setUp()
    {
        app.init();
    }

    //@AfterMethod(enabled = false)
    @AfterSuite (enabled = false)
    public void tearDown()
    {
        app.stop();
    }


}