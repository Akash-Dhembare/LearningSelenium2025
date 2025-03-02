package com.akash.dhembare2000.ex_Selenium.ex_28022025;


import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium25 {

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

        // Link Text - Full Match
        // and Partial Only work -  Contains - Partial Match
        //
        // a tag
        // <a
        // href="https://vwo.com/free-trial/?utm_medium=website&amp;utm_source=login-page&amp;utm_campaign=mof_eg_loginpage"
        // class="text-link" data-qa="bericafeqo">
        // Start a free trial
        //
        // </a>

//        WebElement linkedText = driver.findElement(By.linkText("Start a free trial"));
//        linkedText.click();

        WebElement partial_linkedText = driver.findElement(By.partialLinkText("free trial"));
        partial_linkedText.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
