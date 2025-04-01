package com.webshop.tests;

import com.project.models.UserLogInData;
import org.testng.annotations.Test;

public class LoginTests extends TestBase
{
    @Test
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
