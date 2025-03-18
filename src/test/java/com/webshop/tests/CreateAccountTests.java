package com.webshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase
{
    @Test
    public void createNewUser ()
    {
        //click Register button
        click(By.className("ico-register"));

        //fill in all fields with valid data

        //gender
        click(By.id("gender-female"));

        //firstname
        click(By.name("FirstName"));
        type(By.name("FirstName"), "Ivan");
        //lastname
        click(By.name("LastName"));
        type(By.name("LastName"), "Ivanov");

        //Email
        click(By.name("Email"));
        type(By.name("Email"), "opvanovivan@gamil.com");

        //PWD
        click(By.name("Password"));
        type(By.name("Password"), "QwertyQwerty1!");

        //confirm PWD
        click(By.name("ConfirmPassword"));
        type(By.name("ConfirmPassword"), "QwertyQwerty1!");

        //Click Register button
        click(By.name("register-button"));

        //check that an element is present
        Assert.assertTrue(IsElementPresent(By.className("button-1")));
    }


}
