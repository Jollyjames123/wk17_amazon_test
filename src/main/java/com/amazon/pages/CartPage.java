package com.amazon.pages;

import com.amazon.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CartPage extends Utility {
    public CartPage(){
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Added to Cart')]")
    WebElement addedToCartMessage;

    public void verifyingAddedToCartMessage(String expectedMessage) throws InterruptedException {
        //String actualMessage = pmGetTextFromElement(addedToCartMessage);
        pmVerifyElements(addedToCartMessage, expectedMessage, "Incorrect message");
        Thread.sleep(5000);
        Reporter.log("Verifying the Message :" + expectedMessage);
    }
}
