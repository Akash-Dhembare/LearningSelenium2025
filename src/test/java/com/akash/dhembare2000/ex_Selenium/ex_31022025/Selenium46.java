package com.akash.dhembare2000.ex_Selenium.ex_31022025;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium46 {
   WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions options= new EdgeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--InPrivate");
        //options.setPageLoadStrategy(PageLoadStrategy.EAGER);

        driver = new EdgeDriver(options);
    }

    @Description("Verify orange hrm delete terminated employee")
    @Test
    public void testOrangeHrm(){

        driver.get("https://awesomeqa.com/hr/web/auth/login");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement username= driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("admin");

        WebElement password= driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("Hacker@4321");

        WebElement loginBtn= driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //div[@class='oxd-table-body']/div[@class='oxd-table-card'][1]/div/div[6]
        int row= driver.findElements(By.xpath("//div[@class='oxd-table-body']/div[@class='oxd-table-card']")).size();
        int col= driver.findElements(By.xpath("//div[@class='oxd-table-body']/div[@class='oxd-table-card'][1]/div/div")).size();

        System.out.println(row);
        System.out.println(col);

        String firstpart="//div[@class='oxd-table-body']/div[@class='oxd-table-card'][";
        String secondpart="]/div/div[";
        String thirdpart="]";

        for (int i = 1; i <=row ; i++) {
            for (int j = 1; j <=col ; j++) {
                String dynamic_xpath=firstpart+i+secondpart+j+thirdpart;
                String data = driver.findElement(By.xpath(dynamic_xpath)).getText();

                System.out.println(data);

                if(data.contains("Terminated")){

                    String deleteEmp_xpath=firstpart+i+secondpart+9+thirdpart+"/div/button[1]";
                    WebElement deleteEmp= driver.findElement(By.xpath(deleteEmp_xpath));
                    deleteEmp.click();

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }


                    WebElement closePopUp=driver.findElement(By.xpath("//div[@role='document']/button"));
                    closePopUp.click();
                }

            }
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
