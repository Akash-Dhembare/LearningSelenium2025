package com.akash.dhembare2000.ex_Selenium.ex_31022025;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium46_1 {
    WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
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

        WebElement Terminated_Employee= driver.findElement(By.xpath("//div[@class='oxd-table-body']/div[@class='oxd-table-card']/div//div[contains(text(),'Terminated')]/following::button"));
        Terminated_Employee.click();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        WebElement closePopUp=driver.findElement(By.xpath("//div[@role='document']/button"));
        closePopUp.click();


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
