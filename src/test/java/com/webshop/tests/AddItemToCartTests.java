package com.webshop.tests;

import com.project.fw.ProductHelper;
import com.project.models.UserLogInData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition()
    {
        if(!app.getUser().IsLoginBtnPresent())
        {
            app.getUser().clickLogoutBTN();
        }
    }

    @Test

    public void preconditionLogin()
    {

        app.getUser().clickLoginBtn();
        app.getUser().clickLoginBtn();
        app.getUser().enterEmailAndPWD(new UserLogInData().setMail("KashaSasha@gmail.com").setPWD("KashaSasha!"));
        app.getUser().Login();
        app.getUser().isLogoutBtnPresent();
    }


    @Test

    public void AddToCart() {
        //check that Element exists in list of products
        String productInList = app.getProduct().getProductInList();

        app.getProduct().clickAddProToCart();
        app.getProduct().pause(3000);
        app.getProduct().checkPopUpAppears();
        app.getProduct().clickOnCartFromPopUp();
        app.getProduct().clickOnLogo();
        app.getProduct().clickOnCartFromHeader();

        //check that Element exists in Cart of products
        String productInCart = app.getProduct().getProductInCart();

        //check that productInList is equal to productInCart
        ProductHelper.prInListEqualPrInCart(productInCart, productInList);
    }
}
//------------------------------------------------------------------------------------------------

////add first product
//        click(By.cssSelector("[onclick*='31/1/1']"));
//
//        pause(3000);
//        //check that Pop-Up appears
//        Assert.assertTrue(IsElementPresent(By.xpath("//p[text()='The product has been added to your ']")));
//
//        //open cart from popUP
//        click(By.cssSelector("[href='/cart']"));
//
//        //return to Main Page
//        click(By.cssSelector("[src='/Themes/DefaultClean/Content/images/logo.png']"));
//
//        //open cart from Shopping cart button in header
//        click(By.xpath("//span[text()='Shopping cart']"));
//
//        //check that prod was added
//        int productInCart = product();
//
//        Assert.assertEquals(productInCart, productInList);

//public class addAndRemove extends testBase
//{
//@BeforeMethod

//public void login()
//{
//    clickLoginBTN();
//    type(By.id("Email"),"Reaw12@gamil.com");
//        type(By.id("Password"),"QazWSx123!");
//    LogIn();
//
//    //click AddToCart button
//    //click AddToCart button
//    click(By.cssSelector("[onclick*='31/1/1']"));
//    pause(3000);
//    click(By.cssSelector("[onclick*='31/1/1']"));
//
//    pause(3000);
//
//    click(By.cssSelector("[onclick*='72/1/1']"));
//    click(By.cssSelector("[onclick*='/addproducttocart/details/72/1']"));
//
//    }
//
//    @AfterMethod
//    public void cleanTheCart()
//    {
//        //open cart from Shopping cart button in header
//        click(By.xpath("//span[text()='Shopping cart']"));
//
//        //check the First product
//        click(By.cssSelector("tr:nth-child(1) td:nth-child(1) [type='checkbox']"));
//
//        //check the Second product
//        click(By.cssSelector("tr:nth-child(2) td:nth-child(1) [type='checkbox']"));
//
//        //click Update = Remove
//        click(By.cssSelector("[name='updatecart']"));
//    }
//
//
//@Test
//        public void addProduct() //was added in Login
//{
////    //click AddToCart button
////    click(By.cssSelector("[onclick*='31/1/1']"));
////
////    pause(3000);
////
////    click(By.cssSelector("[onclick*='72/1/1']"));
////    click(By.cssSelector("[onclick*='/addproducttocart/details/72/1']"));
//
////check popUp
//    org.testng.Assert.assertTrue(isElementPresent(By.xpath("//p[text()='The product has been added to your ']")));
//
//    //open cart from popUP
//    click(By.cssSelector("[href='/cart']"));
//
//    //return to Main Page
//    click(By.cssSelector("[src='/Themes/DefaultClean/Content/images/logo.png']"));
//
//    //open cart from Shopping cart button in header
//    click(By.xpath("//span[text()='Shopping cart']"));
//}
//
//    @Test
//    public void removeBothRowsOfProduct()
//    {
//        //open cart from Shopping cart button in header
//        click(By.xpath("//span[text()='Shopping cart']"));
//
//        //check qty of products before
//        int sizeBefore = sizeOfProducts(); //create method "sizeOfProducts"
//
//        //check the First product
//        click(By.cssSelector("tr:nth-child(1) td:nth-child(1) [type='checkbox']"));
//
//        //check the Second product
//        click(By.cssSelector("tr:nth-child(2) td:nth-child(1) [type='checkbox']"));
//
//        //click Update = Remove
//        click(By.cssSelector("[name='updatecart']"));
//
//        pause(3000);
//
//        //verify that the product was remove. QTY of pr. after removing
//        int sizeAfter = sizeOfProducts();
//
//        Assert.assertEquals(sizeAfter,sizeBefore-2); //should be equal
//    }
//
//    @Test
//    public void removeOneRowOfProduct()
//    {
//        //open cart from Shopping cart button in header
//        click(By.xpath("//span[text()='Shopping cart']"));
//
//        //check qty of products before
//        int sizeBefore = sizeOfProducts(); //create method "sizeOfProducts"
//
//        //check the product
//        click(By.cssSelector("tr:nth-child(1) td:nth-child(1) [type='checkbox']"));
//
//        //click Update = Remove
//        click(By.cssSelector("[name='updatecart']"));
//
//        pause(3000);
//
//        //verify that the product was remove. QTY of pr. after removing
//        int sizeAfter = sizeOfProducts();
//
//        Assert.assertEquals(sizeAfter,sizeBefore-1); //should be equal
//    }
//
//    //@Test
//    public void removeQtyOfProduct()
//    {
//        //open cart from Shopping cart button in header
//        click(By.xpath("//span[text()='Shopping cart']"));
//
//        //check qty in card
//        int sizeBefore = sizeOfProducts();
//
//        //click on QTY field
//        driver.findElement(By.cssSelector("tr:nth-child(1) td:nth-child(5) [type='text']")).click();
//        //driver.findElement(By.cssSelector("[value='5']")).click();
//
//        //remove old qty
//        driver.findElement(By.cssSelector("tr:nth-child(1) td:nth-child(5) [type='text']")).clear();
//
//        //add new qty
//        driver.findElement(By.cssSelector("tr:nth-child(1) td:nth-child(5) [type='text']")).sendKeys("1");
//
//        //click Update shopping cart button
//        click(By.cssSelector("[name='updatecart']"));
//
//        pause(3000);
//
//        //verify that the product was remove. QTY of pr. after removing
//
//
//
//    }
//
//
//
//
//    //time after click!!!!!!!!!!
//    public void pause (int millis)
//    {
//        try
//        {
//            Thread.sleep(millis);
//        }
//        catch (InterruptedException e)
//        {
//            throw new RuntimeException(e);
//        }
//    }
//
////check the value of products in the cart !!!!!!!!!!
//public int sizeOfProducts()
//{
//    if (isElementPresent(By.cssSelector("[name='removefromcart']")))
//    {
//        return driver.findElements(By.cssSelector("[name='removefromcart']")).size();
//    }
//    {
//        return 0;
//    }
//}
//
//}
