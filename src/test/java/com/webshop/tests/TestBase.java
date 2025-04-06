package com.webshop.tests;

import com.project.fw.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.lang.reflect.Method;

public class TestBase
{
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", Browser.CHROME.browserName()));//add static. in() for testing in chrome

    @BeforeSuite
    public void setUp()
    {
        app.init();
    }

    @AfterSuite (enabled = false)
    public void tearDown()
    {
        app.stop();
    }


    @BeforeMethod
    public void startTest(Method method)
    {
        logger.info("Start test" +" " +method.getName());
    }

    @AfterMethod
    public void stopTest()
    {
        logger.info("Stop test");
    }




}