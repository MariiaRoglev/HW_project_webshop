package com.webshop.tests;

import org.testng.annotations.Test;

public class LoginTests extends TestBase
{
    @Test
    public void LoginPositive()
    {
        clickLoginBtn();
        enterEmailAndPWD(new UserLogInData().setMail("KashaSasha@gmail.com").setPWD("KashaSasha!"));
        Login();
        isLogoutBtnPresent();
    }

    @Test
    public void LoginEmptyEmail()
    {
        clickLoginBtn();
        enterEmailAndPWD(new UserLogInData().setMail("").setPWD("KashaSasha!"));
        Login();
        LoginErrorDisplayed();
    }


}
