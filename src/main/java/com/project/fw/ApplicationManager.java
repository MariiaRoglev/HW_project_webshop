package com.project.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ApplicationManager {


    String browser;
    WebDriver driver;

    UserHelper user;
    ProductHelper product;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() {
//for cross-Browser tests

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/");

        user = new UserHelper(driver);
        product = new ProductHelper(driver);
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



