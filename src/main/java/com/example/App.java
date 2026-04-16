package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class App {
    public static void main(String[] args) {

        // Set Chrome options for headless execution (important for Jenkins/Linux)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        // Initialize WebDriver with options
        WebDriver driver = new ChromeDriver(options);

        try {
            // Open website
            driver.get("https://automationexercise.com/product_details/1");

            // Wait setup
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Click "Add to Cart"
            WebElement addToCartButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-default.cart"))
            );
            addToCartButton.click();

            // Close modal popup
            WebElement closeModalButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector(".modal-close"))
            );
            closeModalButton.click();

            // Click Cart
            WebElement cartLink = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector(".shopping_cart a"))
            );
            cartLink.click();

            System.out.println("✅ Product added to the cart successfully.");

        } catch (Exception e) {
            System.out.println("❌ Test failed: " + e.getMessage());
        } finally {
            // Close browser
            driver.quit();
        }
    }
}
