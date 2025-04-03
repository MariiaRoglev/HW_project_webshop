package com.project.fw;

import com.project.models.UserLogInData;
import com.project.models.UserRegData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UserHelper extends BaseHelper
{


    public UserHelper(WebDriver driver) {
        super(driver);
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


    public void clickLogoutBTN()
    {
        click(By.cssSelector("[href='/logout']"));
    }

    public boolean IsLoginBtnPresent()
    {
        return IsElementPresent(By.cssSelector("[href='/login']"));
    }
}


