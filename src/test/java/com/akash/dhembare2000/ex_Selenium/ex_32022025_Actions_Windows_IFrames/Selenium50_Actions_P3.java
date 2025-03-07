package com.akash.dhembare2000.ex_Selenium.ex_32022025_Actions_Windows_IFrames;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Selenium50_Actions_P3 {
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
        driver.get("https://www.makemytrip.com/");

        // Close the Popup
        //span[@data-cy='closeModal']



        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']")));

        WebElement closePopup = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
        Actions actions= new Actions(driver);
        actions.moveToElement(closePopup).click().build().perform();

        //input[@data-cy='fromCity']
        WebElement fromCity=driver.findElement(By.xpath("//input[@data-cy='fromCity']"));
        actions.moveToElement(fromCity).click().sendKeys(fromCity, "Mumbai").build().perform();

//        List<WebElement> list_auto_complete = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li"));
//
//        for(WebElement e : list_auto_complete){
//            if(e.getText().contains("Mumbai")){
//                e.click();
//                break;
//            }
//        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        actions.moveToElement(fromCity).click().keyDown(Keys.DOWN).keyDown(Keys.ENTER).build().perform();

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
