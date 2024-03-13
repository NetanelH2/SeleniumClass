package org.example;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork {
        public static void main(String[] args) {
            WebDriver driver = new ChromeDriver();
            WebDriverManager.chromedriver().setup();
            driver.get("https://devexpress.github.io/testcafe/example");
            fillForm(driver);
            assertForm(driver);
            driver.quit();
        }
        public static void fillForm(WebDriver driver) {
            Faker faker = new Faker();
            String fullName = "Netanel Harush";
            String feedbackField = faker.internet().emailAddress();
            driver.findElement(By.id("developer-name")).sendKeys(fullName);
            driver.findElement(By.id("remote-testing")).click();
            driver.findElement(By.id("reusing-js-code")).click();
            driver.findElement(By.id("background-parallel-testing")).click();
            driver.findElement(By.id("continuous-integration-embedding")).click();
            driver.findElement(By.id("traffic-markup-analysis")).click();
            driver.findElement(By.id("tried-test-cafe")).click();
            driver.findElement(By.id("comments")).sendKeys(feedbackField);
            driver.findElement(By.id("submit-button")).click();
        }
        public static void assertForm(WebDriver driver) {
            String successfulMessage = driver.findElement(By.id("article-header")).getText();
            String currentURL = driver.getCurrentUrl();
            if (successfulMessage.equals("Thank you, Netanel Harush!")) {
                System.out.println("Form successfully has been sent");
            } else {
                System.out.println("Can't send form");
            }
            if (currentURL.equals("https://devexpress.github.io/testcafe/example/thank-you.html")) {
                System.out.println("URL is current");
            } else {
                System.out.println("URL is wrong");
            }
        }
    }