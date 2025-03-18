package com.webshop.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    WebDriver driver; //refuctoring 1

    @BeforeMethod //refuctoring 2
    public void preconditions()
    {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://demowebshop.tricentis.com/");
    }

    @AfterMethod(enabled = false) //refuctoring 3
    public void afterMethod()
    {
        driver.quit();
    }

    public boolean IsElementPresent (By locator) //refuctoring 4
    {
        return driver.findElements(locator).size()>0;
    }

    public void type(By locator, String text) //refuctoring 5
    {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) //refuctoring 6
    {
        driver.findElement(locator).click();
    }
}
