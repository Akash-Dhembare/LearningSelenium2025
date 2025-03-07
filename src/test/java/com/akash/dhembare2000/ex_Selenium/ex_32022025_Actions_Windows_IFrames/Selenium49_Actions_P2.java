package com.akash.dhembare2000.ex_Selenium.ex_32022025_Actions_Windows_IFrames;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium49_Actions_P2 {
    EdgeDriver driver;

    @BeforeTest
    public void startBrowser(){
        EdgeOptions options= new EdgeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--InPrivate");

        driver= new EdgeDriver(options);
    }

    @Description("Verify Actions")
    @Test
    public void test_actions(){
        driver.get("https://www.spicejet.com/");
        WebElement FromLocation= driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/div/div/input"));

        Actions actions= new Actions(driver);

        actions.moveToElement(FromLocation).click().sendKeys("MUM").build().perform();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @AfterTest
    public void closeBrowser(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
