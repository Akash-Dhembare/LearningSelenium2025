package com.akash.dhembare2000.ex_Selenium.ex_28022025;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium27 {
    @Test
    public void testFreeTrialErrorMsg(){
        EdgeOptions edgeOptions= new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver= new EdgeDriver(edgeOptions);
        driver.get("https://vwo.com/free-trial/?utm_medium=website&utm_source=login-page&utm_campaign=mof_eg_loginpage");

        WebElement email= driver.findElement(By.id("page-v1-step1-email"));
        email.sendKeys("1234");

        WebElement checkBoxPolicyAccept = driver.findElement(By.name("gdpr_consent_checkbox"));
        checkBoxPolicyAccept.click();

        List<WebElement> buttonList= driver.findElements(By.tagName("button"));
        buttonList.get(0).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement errorMsg= driver.findElement(By.className("invalid-reason"));

        System.out.println(errorMsg.getText());
        Assert.assertEquals(errorMsg.getText(), "The email address you entered is incorrect.");

        driver.quit();
    }
}
