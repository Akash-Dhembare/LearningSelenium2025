package com.akash.dhembare2000.ex_Selenium.ex_31022025;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium40_SVG_P1 {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions options= new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--start-maximized");
        options.addArguments("--InPrivate");
        driver = new EdgeDriver(options);
    }

    @Description("Verify that the after search, results are visible")
    @Test
    public void test_flipkart_search(){
        String url= "https://www.flipkart.com/";
        driver.get(url);

        // Step 1 - Enter the "macmini" in the inputbox
        driver.findElement(By.name("q")).sendKeys("macmini");

        // Step 2 - Click on the svg element
        List<WebElement> svgElements = driver.findElements(By.xpath("//*[name()='svg']"));
        svgElements.get(0).click();

        List<WebElement> titleResults = driver.findElements(By.xpath("//div[contains(@data-id, 'CPU')]/div/a[2]"));
        for(WebElement title : titleResults){
            System.out.println(title.getText());
        }
    }

    @AfterTest
    public void closeBrowser(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
