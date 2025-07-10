package com.PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPageLocator {
WebDriver driver;
    public AddToCartPageLocator(WebDriver driver) {
        this.driver = driver;   

    }

    public static final String ADD_TO_CART_BUTTON = "add-to-cart-button";
    public void handlePopups() {
        Alert alert = driver.switchTo().alert();
String alertText = alert.getText();
System.out.println("Alert text: " + alertText);
alert.accept(); // or alert.dismiss();
        // This method can be used to handle any popups that may appear
        // Implementation can be added later
        System.out.println("Handling popups if any");
    }   

    public void addToCartLocator(String itemName ) {
        // This method can be used to add an item to the cart
        // Implementation can be added later
        By itemLocator = By.xpath("//h5[contains(text(),'" + itemName + "')]/following-sibling::button[@id='" + ADD_TO_CART_BUTTON + "']");
        driver.findElement(itemLocator).click();
        handlePopups();
        System.out.println("Item added to cart: " + itemName);
       // driver.findElement(button[@id='cart']")).click();
    }




    
}
