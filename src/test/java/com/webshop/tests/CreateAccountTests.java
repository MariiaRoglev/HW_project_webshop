package com.webshop.tests;

import com.project.data.AccountData;
import com.project.models.UserRegData;
import com.project.utils.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    ///// ////////////////////DATA PROVIDERS////////////////////////////

    @Test(dataProvider = "createNewAccount", dataProviderClass = DataProviders.class)//connect method with DataProvider
    public void createNewUserWithDataFromDataProvider(String name,String SurName, String email,String password)
    {
        app.getUser().clickRegBTN();
        app.getUser().chooseGender();
        app.getUser().fillAllFields(new UserRegData().setName(name).
                setSurName(SurName).
                setMail(email).
                setPassword(password));
        app.getUser().registration();
        app.getUser().clickContinueBtn();
        app.getUser().isLogoutBtnPresent();
    }



    @Test(dataProvider = "createNewAccountCSV", dataProviderClass = DataProviders.class)//connect method with DataProvider CSV file
    public void createNewUserWithDataFromDataProviderCSV(UserRegData userRegData)
    {
        app.getUser().clickRegBTN();
        app.getUser().chooseGender();
        app.getUser().fillAllFields(userRegData);
        app.getUser().registration();
        app.getUser().clickContinueBtn();
        app.getUser().isLogoutBtnPresent();
    }












    ///// ////////////////////REGULAR TESTS////////////////////////////
    @Test(enabled = false)
    public void createNewUser ()
    {
        app.getUser().clickRegBTN();
        app.getUser().chooseGender();
        app.getUser().fillAllFields(new UserRegData().setName(AccountData.Name).
                setSurName(AccountData.SurName).
                setMail(AccountData.Email).
                setPassword(AccountData.Password));
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