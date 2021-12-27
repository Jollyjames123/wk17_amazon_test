package com.amazon.pages;

import com.amazon.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ProductPage extends Utility {

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//select[@id='quantity']")
    WebElement productQty;
    @CacheLookup
    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    WebElement addToCartButton;

    public void selectProductQty(String qty) {
        pmSelectByVisibleTextFromDropDown(productQty, qty);
        Reporter.log("Selecting the quantity: " + qty);

    }

    public void addProductToCart() {
        pmClickOnElement(addToCartButton);
        Reporter.log("Clicking on add to cart button: " + addToCartButton.toString());
    }

}
