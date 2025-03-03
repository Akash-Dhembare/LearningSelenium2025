package com.akash.dhembare2000.ex_Selenium.ex_29022025;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium30 {
    @Description("Verify that Ebay prints the Prices (iMac)")
    @Test
    public void test_verify_print_imac_prices(){

        EdgeOptions edgeOptions= new EdgeOptions();
        edgeOptions.addArguments("--InPrivate");
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver= new EdgeDriver(edgeOptions);
        driver.get("https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement searchBox= driver.findElement(By.xpath("//input[@id='gh-ac']"));
        searchBox.sendKeys("macmini");

        WebElement searchButton = driver.findElement(By.xpath("//button[@id='gh-search-btn']"));
        searchButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<WebElement> searchTitles = driver.findElements(By.xpath("//div[@class='s-item__title']/span"));

        List<WebElement> macPrice= driver.findElements(By.xpath("//span[@class='s-item__price']"));

        int Size = Math.min(searchTitles.size(), macPrice.size());

        for (int i = 0; i < Size; i++) {
            System.out.println("Title: "+searchTitles.get(i).getText()+ " ||   Price: "+macPrice.get(i).getText());
            System.out.println();

            // Max or Min Price
        }


        driver.quit();
    }
}
