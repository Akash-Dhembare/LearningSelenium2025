package com.akash.dhembare2000.ex_Selenium.ex_30022025;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenium37_InputBox_CheckBox_RadioBox {
    public static void main(String[] args) {
        EdgeDriver driver= new EdgeDriver();

        driver.get("https://awesomeqa.com/practice.html");
        driver.findElement(By.name("firstname")).sendKeys("The Testing Academy");

        // Radio Box
        driver.findElement(By.id("sex-1")).click();

        // Check Box
        driver.findElement(By.id("tool-1")).click();


        //driver.quit();
    }
}
