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

import java.util.List;
import java.util.Set;

public class Selenium52_Actions_Windows_Iframe_P5 {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        options.addArguments("--start-maximized");
        driver = new EdgeDriver(options);
    }

    @Description("Verify IFrame (app.vwo.com)")
    @Test
    public void testIFrame(){
        driver.get("https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String parentWindowHandle = driver.getWindowHandle();
        System.out.println("Parent Window Handle -> "+parentWindowHandle);

        List<WebElement> list_heatmaps = driver.findElements(By.xpath("//div[@data-qa='yedexafobi']"));

        Actions actions= new Actions(driver);
        actions.moveToElement(list_heatmaps.get(0)).click().build().perform();

        try {
            Thread.sleep(13000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Set<String> allHandles = driver.getWindowHandles();
        System.out.println("All Handles -> "+allHandles);

        for(String handle : allHandles){
            if(!handle.equals(parentWindowHandle)){
                driver.switchTo().window(handle);
                System.out.println("Child Window Title -> "+ driver.getTitle());
                driver.switchTo().frame("heatmap-iframe");
                WebElement clickmap=driver.findElement(By.xpath("//div[@data-qa='liqokuxuba']"));
                clickmap.click();
            }
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.switchTo().window(parentWindowHandle);
       // driver.switchTo().defaultContent();
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
