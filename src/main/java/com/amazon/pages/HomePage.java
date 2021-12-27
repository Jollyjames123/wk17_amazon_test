package com.amazon.pages;

import com.amazon.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage extends Utility {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy (xpath = "//input[@id='twotabsearchtextbox']")
    WebElement searchBox;
    @CacheLookup
    @FindBy (xpath = "//input[@id='nav-search-submit-button']")
    WebElement submitButton;

    public void enterNameInSearchBox(String name){
        pmSendTextToElement(searchBox,name);
        Reporter.log("Entering data in the search box :" + name + "<br>");
    }

    public void clickOnSubmitButton(){
        pmClickOnElement(submitButton);
        Reporter.log("Clicking on the button :" + submitButton.toString() + "<br>");
    }
}
