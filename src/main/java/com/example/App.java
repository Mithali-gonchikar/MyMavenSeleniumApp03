package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class App {

    public static void main(String[] args) {

        // Launch Chrome Browser
        WebDriver driver = new ChromeDriver();

        // Open Automation Exercise website
        driver.get("https://automationexercise.com/product_details/1");

        // Maximize window
        driver.manage().window().maximize();

        // Wait for elements
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click Add to Cart
        WebElement addToCart = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".btn.btn-default.cart")));

        addToCart.click();

        // Click Continue Shopping in popup
        WebElement continueShopping = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".btn-success")));

        continueShopping.click();

        // Click Cart button
        WebElement cartButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".fa-shopping-cart")));

        cartButton.click();

        System.out.println("Product added to cart successfully!");

        // Close browser
        driver.quit();
    }
}
