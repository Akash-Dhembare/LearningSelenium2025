package com.akash.dhembare2000.ex_Selenium.ex_30022025;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Selenium39_Alerts {
    public static void main(String[] args) {
        WebDriver driver= new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //button[@onclick='jsAlert()']
        WebElement jsAlertBox = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        jsAlertBox.click();

        Alert alert= driver.switchTo().alert();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        //button[@onclick='jsConfirm()']
//        WebElement jsConfirmBox = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
//        jsConfirmBox.click();
//        Alert alert= driver.switchTo().alert();
//        // alert.dismiss();
//        alert.accept();

        //button[@onclick='jsPrompt()']
//        WebElement jsPromptBox = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
//        jsPromptBox.click();
//        Alert alert= driver.switchTo().alert();
//        alert.sendKeys("Hi I Am Akash");
//        alert.accept();
       // alert.dismiss();



        String result= driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals(result, "You successfully clicked an alert");
       // Assert.assertEquals(result, "You clicked: Ok");
       // Assert.assertEquals(result, "You entered: Hi I Am Akash");

    }
}
