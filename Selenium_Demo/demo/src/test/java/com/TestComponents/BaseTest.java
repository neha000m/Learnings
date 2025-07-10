package com.TestComponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

    public static WebDriver driver;


    public static WebDriver initializeDriver(String browserName) {

        switch(browserName.toLowerCase()) {
            case "chrome":
                // Initialize ChromeDriver
                driver = new ChromeDriver();
                System.setProperty("webdriver.chrome.driver", "/Users/Saurabh/Downloads/chromedriver-mac-x64 2/chromedriver"); // Set the path to your chromedriver
                break;
            case "firefox":
                // Initialize FirefoxDriver
                driver = new FirefoxDriver();
                break;
            case "edge":
                // Initialize EdgeDriver
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browserName);
        }


        // This method should be implemented to initialize the WebDriver
        // For example, it could return a new instance of ChromeDriver, FirefoxDriver, etc.
        return driver;
    }

       public static void startTest(String browserName) {
            //driver = initializeDriver(browserName);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://rahulshettyacademy.com/client");

            // Navigate to the base URL or perform any other setup actions
            // Add any additional setup code here, such as navigating to a URL
        }

        public void tearDown()
	{
		driver.close();
	}
    }
    

