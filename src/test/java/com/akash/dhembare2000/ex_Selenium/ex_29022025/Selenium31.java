package com.akash.dhembare2000.ex_Selenium.ex_29022025;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium31 {
    @Description("Verify that Flipkart prints the Prices (I Phone 15)")
    @Test
    public void test_verify_print_imac_prices(){

        EdgeOptions edgeOptions= new EdgeOptions();
        edgeOptions.addArguments("--InPrivate");
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver= new EdgeDriver(edgeOptions);
        driver.get("https://www.flipkart.com/");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement searchBox= driver.findElement(By.xpath("//input[@class='Pke_EE']"));
        searchBox.sendKeys("I Phone 15");

        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
        searchButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<WebElement> searchTitles = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));

        List<WebElement> IPhonePrice= driver.findElements(By.xpath("//div[@class='Nx9bqj _4b5DiR']"));

        int Size = Math.min(searchTitles.size(), IPhonePrice.size());

        for (int i = 0; i < Size; i++) {
            System.out.println("Title: "+searchTitles.get(i).getText()+ " ||   Price: "+IPhonePrice.get(i).getText());
            System.out.println();

        }

        
        driver.quit();
    }
}
