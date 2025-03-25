package com.webshop.tests;

import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase
{
    @Test
    public void createNewUser ()
    {
        clickRegBTN();
        chooseGender();
        fillAllFields(new UserRegData().setName("Ivan").setSurName("Ivanov").setMail("ttfopdvanovivaon@gamil.com").setPassword("QwertyQwerty1!"));
        registration();
        clickContinueBtn();
        isLogoutBtnPresent();
    }

    @Test
    public void createExistedUser ()
    {
        clickRegBTN();
        chooseGender();
        fillAllFields(new UserRegData().setName("Ivan").setSurName("Ivanov").setMail("ttfopdvanovivaon@gamil.com").setPassword("QwertyQwerty1!"));
        registration();
        RegErrorDisplayed();
    }


}