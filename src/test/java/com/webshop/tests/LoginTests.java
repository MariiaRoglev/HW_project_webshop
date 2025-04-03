package com.webshop.tests;

import com.project.models.UserLogInData;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase
{
    @BeforeMethod
    public void ensurePrecondition()
    {
        if(!app.getUser().IsLoginBtnPresent())
        {
            app.getUser().clickLogoutBTN();
        }
    }

    @Test//(priority = 1)
    public void LoginPositive()
    {
        app.getUser().clickLoginBtn();
        app.getUser().enterEmailAndPWD(new UserLogInData().setMail("KashaSasha@gmail.com").setPWD("KashaSasha!"));
        app.getUser().Login();
        app.getUser().isLogoutBtnPresent();
    }

    @Test
    public void LoginEmptyEmail()
    {
        app.getUser().clickLoginBtn();
        app.getUser().enterEmailAndPWD(new UserLogInData().setMail("").setPWD("KashaSasha!"));
        app.getUser().Login();
        app.getUser().LoginErrorDisplayed();
    }


}
