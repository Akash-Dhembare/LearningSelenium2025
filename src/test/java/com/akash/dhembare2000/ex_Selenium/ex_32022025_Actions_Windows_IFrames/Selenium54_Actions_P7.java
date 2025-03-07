package com.akash.dhembare2000.ex_Selenium.ex_32022025_Actions_Windows_IFrames;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium54_Actions_P7 {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        options.addArguments("--start-maximized");
        driver = new EdgeDriver(options);
    }

    @Description("Verify File Upload and Drag and Drop")
    @Test
    public void testDNDandFU(){
//        driver.get("https://awesomeqa.com/selenium/upload.html");
//
//        WebElement fileUpload= driver.findElement(By.xpath("//input[@type='file']"));
//        String dir= System.getProperty("user.dir");
//
//        System.out.println(dir);
//
//        fileUpload.sendKeys(dir+"/src/test/java/com/akash/dhembare2000/ex_Selenium/ex_32022025_Actions_Windows_IFrames/Hello.txt");
//        driver.findElement(By.xpath("//input[@type='submit']")).click();

        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        Actions actions= new Actions(driver);

        WebElement from = driver.findElement(By.xpath("//div[@id='column-a']"));
        WebElement to = driver.findElement(By.xpath("//div[@id='column-b']"));

        actions.dragAndDrop(from,to).build().perform();

       // actions.clickAndHold(from).moveToElement(to).release(to).build().perform();
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
