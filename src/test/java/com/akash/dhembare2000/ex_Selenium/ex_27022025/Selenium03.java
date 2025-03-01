package com.akash.dhembare2000.ex_Selenium.ex_27022025;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Selenium03 {
    @Test
    public void test_001(){
        FirefoxDriver driver= new FirefoxDriver();
        driver.get("https://sdet.live");
        driver.quit();
    }
}
