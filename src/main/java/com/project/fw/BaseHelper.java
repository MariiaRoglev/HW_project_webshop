package com.project.fw;

import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

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

    //to take screenshot
    public String takeScreenshot() throws IOException {
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("screenshots/screen-" + System.currentTimeMillis() + ".png");


        try
        {
            Files.copy(tmp, screenshot);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        return screenshot.getAbsolutePath();
    }





}
