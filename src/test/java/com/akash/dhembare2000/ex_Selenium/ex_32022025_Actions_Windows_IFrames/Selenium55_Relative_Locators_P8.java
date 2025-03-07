package com.akash.dhembare2000.ex_Selenium.ex_32022025_Actions_Windows_IFrames;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Selenium55_Relative_Locators_P8 {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        options.addArguments("--start-maximized");
        driver = new EdgeDriver(options);
    }

    @Description("Verify Relative Locators")
    @Test
    public void testRL(){
        // toRightOf
        //  LeftOf
        // AboveOf
        // below
        // near

        driver.get("https://awesomeqa.com/practice.html");

        WebElement span_element= driver.findElement(By.xpath("//span[normalize-space()='Years of Experience']"));
        driver.findElement(with(By.xpath("//input[@id='exp-0']")).toRightOf(span_element)).click();


    }

    @AfterTest
    public void closeBrowser() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
