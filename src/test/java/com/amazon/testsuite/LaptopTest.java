package com.amazon.testsuite;

import com.amazon.pages.*;
import com.amazon.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LaptopTest extends TestBase {

    HomePage homePage;
    ProductsResultPage productsResultPage;
    ProductPage productPage;
    CartPage cartPage;

    @BeforeMethod
    public void init(){
        homePage = new HomePage();
        productPage = new ProductPage();
        productsResultPage = new ProductsResultPage();
        cartPage = new CartPage();
    }


    @Test
    @Parameters({"name1", "productName1", "qty1", "expectedMessage1"})
    public void userShouldBeAbleToAddLaptopInTheCartSuccessfully(String name, String productName, String qty, String expectedMessage) throws InterruptedException {
        homePage.enterNameInSearchBox(name);
        homePage.clickOnSubmitButton();
        productsResultPage.findProduct(productName);
        productPage.selectProductQty(qty);
        productPage.addProductToCart();
        cartPage.verifyingAddedToCartMessage(expectedMessage);
    }
}
