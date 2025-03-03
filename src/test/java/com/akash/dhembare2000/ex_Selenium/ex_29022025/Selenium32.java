package com.akash.dhembare2000.ex_Selenium.ex_29022025;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium32 {
    @Description ("Verify that app.vwo.com login success")
    @Test
    public void testVWOLogin(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--InPrivate");
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver= new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com/#/login");

        WebElement username= driver.findElement(By.xpath("//input[@id='login-username']"));
        username.sendKeys("akash@gmail.com");

        WebElement password= driver.findElement(By.xpath("//input[@id='login-password']"));
        password.sendKeys("Akash@2000");

        WebElement SignInBtn= driver.findElement(By.xpath("//button[@id='js-login-btn']"));
        SignInBtn.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement pageHeading = driver.findElement(By.xpath("//h1[@class='page-heading']"));
        System.out.println(pageHeading.getText());

        Assert.assertEquals(pageHeading.getText(), "Dashboard");

        driver.quit();

    }
}
