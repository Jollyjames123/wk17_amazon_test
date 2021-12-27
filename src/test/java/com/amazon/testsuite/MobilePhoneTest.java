package com.amazon.testsuite;

import com.amazon.customlisteners.CustomListeners;
import com.amazon.pages.CartPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.ProductPage;
import com.amazon.pages.ProductsResultPage;
import com.amazon.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class MobilePhoneTest extends TestBase {

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
    @Parameters({"name2", "productName2", "qty2", "expectedMessage2"})
    public void userShouldBeAbleToAddLaptopInTheCartSuccessfully(String name, String productName, String qty, String expectedMessage) throws InterruptedException {
        homePage.enterNameInSearchBox(name);
        homePage.clickOnSubmitButton();
        productsResultPage.findProduct(productName);
        productPage.selectProductQty(qty);
        productPage.addProductToCart();
        cartPage.verifyingAddedToCartMessage(expectedMessage);
    }
}
