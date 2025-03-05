package com.akash.dhembare2000.ex_Selenium.ex_30022025;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Selenium38_Select_Static {
    public static void main(String[] args) {
        WebDriver driver= new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();

        WebElement selectBox= driver.findElement(By.id("dropdown"));

        Select select= new Select(selectBox);
        // select.selectByVisibleText("Option 2");
        select.selectByIndex(2);
    }
}
