package com.akash.dhembare2000.ex_Selenium.ex_28022025;


import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium24 {
    // Locators - Find the Web elements
    // Open the URL .app.vwo.com/#/login](https://app.vwo.com/#/login)
    // Find the Email id** and enter the email as admin@admin.com
    // Find the pass inputbox** and enter passwrod as admin.
    // Find and Click on the submit button
    // Verify that the error message is shown "Your email, password, IP address or location did not match"

    @Description ("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void testVWOLoginNegative(){

        // How to find the elements
        // Selenium
        // ID, NAME, CLASS NAME, TAGName,
        // Advance -> Css Selector, Xpath

        // <input type="email" class="text-input W(100%)" name="username" id="login-username" data-qa="hocewoqisi">

        EdgeOptions edgeOptions= new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        // FindElement -> 1 element first web element
        // FindElements -> which can find multiple web elements

        WebDriver driver=  new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com/#/login");
        System.out.println(driver.getTitle());

        Assert.assertEquals(driver.getTitle(), "Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");

        WebElement emailInputBox= driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys("admin@admin.com");

        WebElement passwordInputBox= driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("abcde");

        WebElement signInButton= driver.findElement(By.id("js-login-btn"));
        signInButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement errorMsg = driver.findElement(By.id("js-notification-box-msg"));
        Assert.assertEquals(errorMsg.getText(), "Your email, password, IP address or location did not match");

        driver.quit();
    }
}
