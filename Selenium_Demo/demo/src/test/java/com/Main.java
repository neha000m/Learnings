package com;

import org.openqa.selenium.WebDriver;

import com.PageObjects.AddToCartPageLocator;
import com.PageObjects.LoginPageLocator;
import com.TestComponents.BaseTest;

import TestGenerator.ExcelData;

public class Main extends BaseTest {

    public static void main(String[] args) throws Exception {
        // This is the main method where the program starts
        System.out.println("Hello, World!");
        
       WebDriver driver= BaseTest.initializeDriver("chrome"); // Initialize the WebDriver with Chrome
        // You can replace "chrome" with "firefox" or "edge" as needed

       BaseTest.startTest("chrome"); // Initialize the WebDriver with Chrome
       Thread.sleep(2000); // Wait for 2 seconds to ensure the page loads properly
        LoginPageLocator loginPage = new LoginPageLocator(driver);
        AddToCartPageLocator addToCartPage = new AddToCartPageLocator(driver); 
        ExcelData excelData = new ExcelData(driver);
        excelData.getData(); // Retrieve data from the Excel file 

        //loginPage.setUsername(); 
        addToCartPage.addToCartLocator("ZARA COAT 3");// Set the username and password using the LoginPageLocator
       
        // You can add more code here to perform specific tasks
        // For example, you can call methods, create objects, etc.
    }
    
}
