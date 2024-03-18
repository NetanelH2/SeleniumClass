package org.example.General;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationTests {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
// Google
        driver.get("https://www.google.com/");
        checkUrl(driver, "https://www.google.com/");
// Amazon
        driver.get("https://www.amazon.com/");
        checkUrl(driver, "https://www.amazon.com/");
        driver.quit();
    }
    public static void checkUrl(WebDriver driver, String url) {
        if (driver.getCurrentUrl().equals(url)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
    }
}