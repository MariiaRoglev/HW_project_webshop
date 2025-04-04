package com.project.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseHelper
{

    WebDriver driver;

    public BaseHelper(WebDriver driver)
    {
        this.driver=driver;
    }

    public boolean IsElementPresent (By locator)
    {
        return  driver.findElements(locator).size()>0;
    }

    public void type(By locator, String text)
    {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator)
    {
        driver.findElement(locator).click();
    }

    //need to wait before assertion
        public void pause (int millis)
        {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
}
