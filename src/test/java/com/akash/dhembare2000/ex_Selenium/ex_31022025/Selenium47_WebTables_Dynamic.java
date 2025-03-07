package com.akash.dhembare2000.ex_Selenium.ex_31022025;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium47_WebTables_Dynamic {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions options= new EdgeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--InPrivate");

        driver= new EdgeDriver(options);
    }

    @Description("Verify WebTable Dynamics")
    @Test
    public void testWebtables(){
        driver.get("https://awesomeqa.com/webtable1.html");

        //table[@summary='Sample Table']/tbody

        WebElement table= driver.findElement(By.xpath("//table[@summary='Sample Table']/tbody"));

        // rows and columns
        List<WebElement> rows_tables= driver.findElements(By.tagName("tr"));
        for (int i = 0; i < rows_tables.size(); i++) {
            List<WebElement> col_tables= driver.findElements(By.tagName("td"));
            for(WebElement c: col_tables){
                System.out.println(c.getText());
            }
        }

    }

    @AfterTest
    public void closeBroswer(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
