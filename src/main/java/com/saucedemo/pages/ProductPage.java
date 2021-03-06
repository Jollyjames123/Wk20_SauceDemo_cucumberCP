package com.saucedemo.pages;

import com.saucedemo.drivermanager.ManageDriver;
import com.saucedemo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage extends Utility {
    //logger defined to print logs
    private static final Logger log = LogManager.getLogger(ProductPage.class.getName());

    //to initialise webelements @findby annotations for this page
    public ProductPage() {
        PageFactory.initElements(ManageDriver.driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//select[@class='product_sort_container']")
    WebElement filterDropdown;

    @CacheLookup
    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    WebElement cartButton;

    @FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory']")
    List<WebElement> products;


    public void selectingFromDropDown(String selection) {
        //pmClickOnElement(filterDropdown);
        log.info("Sorting the products by prices: " + selection);
        pmSelectByContainsTextFromDropDown(filterDropdown, selection);

    }

    public void addingToCart() throws InterruptedException {

       for (int i = 0; i < products.size(); i++) {
            if (i == 0 || i == products.size() - 1) {
                log.info("Adding product to the cart: " + products.get(i).toString());
                Thread.sleep(1000);
                pmClickOnElement(products.get(i));
            }
        }
    }

    public void clickOnCart() {
        log.info("Clicking on the cart button: " + cartButton.toString());
        pmClickOnElement(cartButton);
    }


}
