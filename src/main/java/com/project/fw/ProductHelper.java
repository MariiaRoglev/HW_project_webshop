package com.project.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductHelper extends BaseHelper
{

    public ProductHelper(WebDriver driver)
    {
        super(driver);
    }

    public static void prInListEqualPrInCart(String productInCart, String productInList) {
        Assert.assertEquals(productInCart, productInList);
    }

    public void clickOnCartFromHeader() {
        click(By.xpath("//span[text()='Shopping cart']"));
    }

    public void clickOnCartFromPopUp() {
        click(By.cssSelector("[href='/cart']"));
    }

    public void clickOnLogo() {
        click(By.cssSelector("[src='/Themes/DefaultClean/Content/images/logo.png']"));
    }

    public void clickAddProToCart() {
        click(By.cssSelector("[onclick*='31/1/1']"));
    }

    public void checkPopUpAppears() {
        Assert.assertTrue(IsElementPresent(By.xpath("//p[text()='The product has been added to your ']")));
    }

    public String getProductInCart() {
        String productInCart = this.driver.findElement(By.cssSelector("tbody:nth-child(3) tr:nth-child(1) td:nth-child(3) [href='/141-inch-laptop']")).getText();
        return productInCart;
    }

    public String getProductInList() {
        String productInList = this.driver.findElement(By.cssSelector("div:nth-child(3) h2:first-child [href='/141-inch-laptop']")).getText();
        return productInList;
    }

    public void updateShoppingCart() {
        click(By.name("updatecart"));
    }

    public void checkLine()
    {
        click(By.name("removefromcart"));
    }

    public int QtyOfProduct() {
        if (IsElementPresent(By.cssSelector("tbody:nth-child(3) tr:nth-child(1) td:nth-child(3) [href='/141-inch-laptop']"))) {
            return driver.findElements(By.cssSelector("tbody:nth-child(3) tr:nth-child(1) td:nth-child(3) [href='/141-inch-laptop']")).size();
        }
        {
            return 0;
        }
    }


    public void deleteProduct()
    {
        click(By.name("removefromcart"));
        click(By.name("updatecart"));
    }
}
