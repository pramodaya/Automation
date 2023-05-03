package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = getWebDriver();

        // Navigate to the Google.com URL
        driver.get("https://breathment.com/home");

        // Find the element that triggers the popup modal
        WebElement popupTrigger = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));

        // Click the element to trigger the popup modal
        popupTrigger.click();

        login(driver);

        // Wait for 5 seconds to allow the user to see the logged in page
        Thread.sleep(5000);

        // Close the browser
        driver.quit();
    }

    private static void login(WebDriver driver) {
        // Find the login anchor element
        WebElement loginAnchor = driver.findElement(By.xpath("//a[contains(@href,'/login')]"));

        // Click on the login anchor element
        loginAnchor.click();
        // Find the email and password input fields
        WebElement emailInput = driver.findElement(By.id("input-email"));
        WebElement passwordInput = driver.findElement(By.id("input-password"));

        // Enter the email and password values
        emailInput.sendKeys("rock@gmail.com");
        passwordInput.sendKeys("rockpassword");

        // Find the login button
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));

        // Click on the login button
        loginButton.click();
    }

    private static WebDriver getWebDriver() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "driver//chrome_driver//chromedriver");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();
        return driver;
    }

}