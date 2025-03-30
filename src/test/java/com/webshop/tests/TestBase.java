package com.webshop.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    WebDriver driver; //refuctoring 1

    public static void prInListEqualPrInCart(String productInCart, String productInList) {
        Assert.assertEquals(productInCart, productInList);
    }

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
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }



    public void click(By locator) //refuctoring 6
    {
        driver.findElement(locator).click();
    }

    public void isLogoutBtnPresent() {
        Assert.assertTrue(IsElementPresent(By.cssSelector("[href='/logout']")));
    }

    public void Login() {
        click(By.cssSelector("input[value='Log in']"));
    }

    public void enterEmailAndPWD(UserLogInData userLogInData)
    {
        type(By.name("Email"), userLogInData.getMail());
        type(By.name("Password"), userLogInData.getPWD());
    }

    public void clickLoginBtn() {
        click(By.cssSelector("[href='/login']"));
    }

    public void chooseGender() {
        click(By.id("gender-female"));
    }

    public void fillAllFields(UserRegData userData) {
        type(By.name("FirstName"), userData.getName());
        type(By.name("LastName"), userData.getSurName());
        type(By.name("Email"), userData.getMail());
        type(By.name("Password"), userData.getPassword());
        type(By.name("ConfirmPassword"), userData.getPassword());
    }

    public void registration() {
        click(By.name("register-button"));
    }

    public void clickRegBTN() {
        click(By.className("ico-register"));
    }

    public void clickContinueBtn() {
        click(By.cssSelector("input[value='Continue']"));
    }

    public void RegErrorDisplayed() {
        Assert.assertTrue(IsElementPresent(By.xpath("//span[text()='Email is required.']")));
    }

    public void LoginErrorDisplayed() {
        Assert.assertTrue(IsElementPresent(By.xpath("//span[text()='Login was unsuccessful. Please correct the errors and try again.']")));
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

    public void clickOnCartFromHeader() {
        click(By.xpath("//span[text()='Shopping cart']"));
    }

    public void clickOnCartFromPopUp() {
        click(By.cssSelector("[href='/cart']"));
    }

    public void clickOnLogo() {
        click(By.cssSelector("[src='/Themes/DefaultClean/Content/images/logo.png']"));
    }

    public void clickAddProToCart() {
        click(By.cssSelector("[onclick*='31/1/1']"));
    }

    public void checkPopUpAppears() {
        Assert.assertTrue(IsElementPresent(By.xpath("//p[text()='The product has been added to your ']")));
    }

    public String getProductInCart() {
        String productInCart = getProductInList("tbody:nth-child(3) tr:nth-child(1) td:nth-child(3) [href='/141-inch-laptop']");
        return productInCart;
    }

    public String getProductInList(String cssSelector) {
        String productInList = this.driver.findElement(By.cssSelector(cssSelector)).getText();
        return productInList;
    }
}