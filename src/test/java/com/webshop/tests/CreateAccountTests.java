package com.webshop.tests;

import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase
{
    @Test
    public void createNewUser ()
    {
        clickRegBTN();
        chooseGender();
        fillAllFields(new UserRegData().setName("Ivan").setSurName("Ivanov").setMail("IvanN@gamil.com").setPassword("QwertyQwerty1!"));
        registration();
        clickContinueBtn();
        isLogoutBtnPresent();
    }

    @Test
    public void createUserWithEmptyEmail ()
    {
        clickRegBTN();
        chooseGender();
        fillAllFields(new UserRegData().setName("Ivan").setSurName("Ivanov").setMail("").setPassword("QwertyQwerty1!"));
        registration();
        RegErrorDisplayed();
    }


}