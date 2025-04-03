package com.project.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager
{

    WebDriver driver;

    UserHelper user;
    ProductHelper product;



    public void init() {


        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/");

        user=new UserHelper(driver);
        product=new ProductHelper(driver);
    }




    public void stop() {
        driver.quit();
    }

    public UserHelper getUser() {
        return user;
    }

    public ProductHelper getProduct() {
        return product;
    }


}
