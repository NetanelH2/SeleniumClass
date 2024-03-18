package org.example.Authentication;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SignUp {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

        driver.get("https://prd.canvusapps.com/signup");
        fillSignUpForm(driver);
        assertSignUp(driver);
        driver.quit();
    }
    public static void fillSignUpForm(WebDriver driver) {
        Faker faker = new Faker();
        String fullName = faker.name().fullName();
        String email = faker.internet().emailAddress();
        System.out.println(email);
        String password = "123456";
        String confirmPassword = "123456";
        String companyName = faker.company().name();
        driver.findElement(By.id("user_name")).sendKeys(fullName);
        driver.findElement(By.id("user_email")).sendKeys(email);
        driver.findElement(By.id("user_password")).sendKeys(password);
        driver.findElement(By.id("user_password_confirmation")).sendKeys(confirmPassword);
        driver.findElement(By.id("company_name")).sendKeys(companyName);
        driver.findElement(By.cssSelector("input[value='Sign up']")).click();
       }
    public static void assertSignUp(WebDriver driver) {
        String successfulMessage = driver.findElement(By.cssSelector("#signup > h2")).getText();
        String currentURL = driver.getCurrentUrl();
        if (successfulMessage.equals("Congratulations!")) {
            System.out.println("Sign up was successful");
        } else {
            System.out.println("Sign up was not successful");
        }
        if (currentURL.equals("https://prd.canvusapps.com/register")) {
            System.out.println("URL is current");
        } else {
            System.out.println("Sign up was not successful");
        }
    }
}