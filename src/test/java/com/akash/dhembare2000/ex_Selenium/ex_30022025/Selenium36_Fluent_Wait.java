package com.akash.dhembare2000.ex_Selenium.ex_30022025;


import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

import static com.akash.dhembare2000.ex_Selenium.ex_30022025.WaitHelpers.checkVisibilityByFluentWait;

// Explicit Wait
public class Selenium36_Fluent_Wait {
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
        edgeOptions.addArguments("--InPrivate");

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

//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }



//        WebDriverWait wait1= new WebDriverWait(driver, Duration.ofSeconds(3));
//        wait1.until(ExpectedConditions.visibilityOf(errorMsg));
//
//        WebDriverWait wait2= new WebDriverWait(driver, Duration.ofSeconds(3));
//        wait2.until(ExpectedConditions.textToBePresentInElement(errorMsg, "Your email, password, IP address or location did not match"));


        //Fluent Wait
//        FluentWait<WebDriver> wait= new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(10))
//                        .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
//
//        WebElement errorMsg= wait.until(new Function<WebDriver, WebElement>() {
//            public WebElement apply(WebDriver webDriver) {
//                return driver.findElement(By.xpath("//div[@class='notification-box-description']"));
//            }
//        });

        WebElement error_message= checkVisibilityByFluentWait(driver, By.className("notification-box-description"));


        System.out.println(error_message.getText());
       Assert.assertEquals(error_message.getText(), "Your email, password, IP address or location did not match");

        driver.quit();
    }
}
