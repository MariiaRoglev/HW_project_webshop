package com.webshop.tests;

import com.project.models.UserRegData;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase
{

    @Test(enabled = false)
    public void createNewUser ()
    {
        app.getUser().clickRegBTN();
        app.getUser().chooseGender();
        app.getUser().fillAllFields(new UserRegData().setName("Ivan").setSurName("Ivanov").setMail("IvanN@gamil.com").setPassword("QwertyQwerty1!"));
        app.getUser().registration();
        app.getUser().clickContinueBtn();
        app.getUser().isLogoutBtnPresent();
    }

    @Test
    public void createUserWithEmptyEmail ()
    {
        app.getUser().clickRegBTN();
        app.getUser().chooseGender();
        app.getUser().fillAllFields(new UserRegData().setName("Ivan").setSurName("Ivanov").setMail("").setPassword("QwertyQwerty1!"));
        app.getUser().registration();
        app.getUser().RegErrorDisplayed();
    }


}