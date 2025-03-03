package com.akash.dhembare2000.ex_Selenium.ex_29022025;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium29 {
    @Description("Verify that Free trial expire message in idrive.com")
    @Test
    public void test_verify_expire_page(){

        EdgeOptions edgeOptions= new EdgeOptions();
        edgeOptions.addArguments("--InPrivate");
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver= new EdgeDriver(edgeOptions);
        driver.get("https://www.idrive360.com/enterprise/login");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement username= driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("augtest_040823@idrive.com");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("123456");

        WebElement signInBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        signInBtn.click();

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement errorMsg= driver.findElement(By.xpath("//h5[@class='id-card-title']"));
        System.out.println(errorMsg.getText());

        Assert.assertEquals(errorMsg.getText(), "Your free trial has expired");

        driver.quit();
    }
}
