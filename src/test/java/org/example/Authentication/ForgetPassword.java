package org.example.Authentication;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ForgetPassword {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.get("https://alexanderalexander.canvusapps.com/password_resets/new");
        fillForgetPasswordForm(driver);
        assertForgetPassword(driver);
        driver.quit();
    }

    public static void fillForgetPasswordForm(WebDriver driver) {
        String email = "leslie.ankunding@gmail.com";
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.cssSelector("input[value='Reset Password']")).click();
    }

    public static void assertForgetPassword(WebDriver driver) {
        String successfulMessage = driver.findElement(By.cssSelector(".alert.alert-notice.alert-block.notice")).getText();
        String currentURL = driver.getCurrentUrl();
        if (successfulMessage.equals("Email sent with password reset instructions.!")) {
            System.out.println("Can't reset password!");
        } else {
            System.out.println("Reset Password Completed.");
        }
        if (currentURL.equals("https://alexanderalexander.canvusapps.com/login")) {
            System.out.println("URL is current");
        } else {
            System.out.println("Wrong URL!");
        }
    }
}