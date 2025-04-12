package com.webshop.tests;

import com.project.data.AccountData;
import com.project.models.UserRegData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase
{
    @BeforeMethod
    public void ensurePrecondition()//we need precondition to be ensure that Loginbtn is present, or click smth to present it
    {
        if(!app.getUser().IsLoginBtnPresent())
        {
            app.getUser().clickLogoutBTN();
        }
    }


    @Test(enabled = false)
    public void createNewUser ()
    {
        app.getUser().clickRegBTN();
        app.getUser().chooseGender();
        app.getUser().fillAllFields(new UserRegData().setName(AccountData.Name).setSurName(AccountData.SurName).setMail(AccountData.Email).setPassword(AccountData.Password));
        app.getUser().registration();
        app.getUser().clickContinueBtn();
        app.getUser().isLogoutBtnPresent();
    }

    @Test
    public void createUserWithEmptyEmail ()
    {
        app.getUser().clickRegBTN();
        app.getUser().chooseGender();
        app.getUser().fillAllFields(new UserRegData().setName(AccountData.Name).setSurName(AccountData.SurName).setMail("").setPassword(AccountData.Password));
        app.getUser().registration();
        app.getUser().RegErrorDisplayed();
    }


}