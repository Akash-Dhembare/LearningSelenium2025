package com.akash.dhembare2000.ex_Selenium.ex_28022025;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeWork2 {
    @Test
    public void testRegisterAwsomeQA(){
        EdgeOptions edgeOptions= new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--InPrivate");

        WebDriver driver= new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com/#/login");

        WebElement username = driver.findElement(By.id("login-username"));
        username.sendKeys("akash@gmail.com");

        WebElement password = driver.findElement(By.id("login-password"));
        password.sendKeys("Akash@2000");

        WebElement login = driver.findElement(By.id("js-login-btn"));
        login.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement successMsg= driver.findElement(By.className("page-sub-title"));
        System.out.println(successMsg.getText());

        Assert.assertEquals(successMsg.getText(), "Hi Akash Dhembare, here's an overview of your experience optimization journey");


        driver.quit();

    }
}
