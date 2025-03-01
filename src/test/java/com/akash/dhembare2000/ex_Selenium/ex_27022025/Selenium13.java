package com.akash.dhembare2000.ex_Selenium.ex_27022025;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium13 {
    @Test
    public void testHerokuApp(){
        EdgeOptions options= new EdgeOptions();
        options.addArguments("--start-maximized");

        WebDriver driver= new EdgeDriver(options);
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/");
        Assert.assertEquals(driver.getTitle(), "CURA Healthcare Service");
//        if(driver.getPageSource().contains("Make Appointment")){
//            System.out.println("Verified");
//            Assert.assertTrue(true);
//        }
//        else{
//            System.out.println("Not Verified");
//            Assert.assertTrue(false);
//        }

        Assert.assertTrue(driver.getPageSource().contains("Make Appointment"));

        driver.quit();


    }
}
