package com.akash.dhembare2000.ex_Selenium.ex_28022025;


import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium26 {


    @Test
    public void testRadioButtonClick() {
        WebDriver driver= new EdgeDriver();
        driver.get("https://awesomeqa.com/practice.html");

        WebElement gender_female=driver.findElement(By.id("sex-1"));
        gender_female.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
