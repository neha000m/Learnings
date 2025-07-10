package com.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageLocator {
  
    WebDriver driver;
    public LoginPageLocator(WebDriver driver) {
        this.driver = driver;
    }

    // Locators for the login page elements
    public static final String USER_EMAIL = "userEmail";
    public static final String USER_PASSWORD = "userPassword";
    public static final String LOGIN_BUTTON = "login";
    
    public void setUsername() {
        System.out.println("OnLoginPage");
       By userEmailLocator = By.id(USER_EMAIL);
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
    wait.until(ExpectedConditions.visibilityOfElementLocated(userEmailLocator));
           // driver.findElement(By.id("userEmail")).click();


       driver.findElement(By.xpath("//input[@type='email']")).sendKeys("anshika@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
		driver.findElement(By.id("login")).click();
        // This method can be used to set the username input field
        // Implementation can be added later
       // This method can be used to retrieve the username input field
        // Implementation can be added later
    }
    
    
}
