package com.webshop.tests;

import com.project.data.UserData;
import com.project.models.UserLogInData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveItemFromCartTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition()
    {
        if(!app.getUser().IsLoginBtnPresent())
        {
            app.getUser().clickLogoutBTN();
        }

        //Login
        app.getUser().clickLoginBtn();
        app.getUser().enterEmailAndPWD(new UserLogInData().setMail(UserData.EMAIL).setPWD(UserData.PASSWORD));
        app.getUser().Login();
        app.getUser().isLogoutBtnPresent();

        //Add product to cart
        app.getProduct().clickAddProToCart();

        app.getProduct().clickOnLogo();
    }



    @Test
    public void RemoveFromCart()
    {
        int cartBefore = app.getProduct().QtyOfProduct();

        app.getProduct().clickOnCartFromHeader();
        app.getProduct().checkLine();
        app.getProduct().updateShoppingCart();

        app.getProduct().pause(1000);

        int cartAfter = app.getProduct().QtyOfProduct();

        Assert.assertEquals(cartAfter,cartBefore);
    }


}

