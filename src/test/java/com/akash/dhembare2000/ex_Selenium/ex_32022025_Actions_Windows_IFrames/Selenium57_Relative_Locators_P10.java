package com.akash.dhembare2000.ex_Selenium.ex_32022025_Actions_Windows_IFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Selenium57_Relative_Locators_P10 {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        options.addArguments("--start-maximized");
        driver = new EdgeDriver(options);
    }

    @Test
    public void testRL3(){
        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");
        driver.switchTo().frame("result");
        WebElement submitBtn= driver.findElement(By.xpath("//button[text()='Submit']"));


        submitBtn.click();

        WebElement element= driver.findElement(By.xpath("//input[@id='username']"));
        WebElement error_element = driver.findElement(with(By.tagName("small")).below(element));

        String errorText= error_element.getText();
        System.out.println(errorText);
        Assert.assertTrue(error_element.isDisplayed());
        Assert.assertEquals(errorText, "Username must be at least 3 characters");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


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
