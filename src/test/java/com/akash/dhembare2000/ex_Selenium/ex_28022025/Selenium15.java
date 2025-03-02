package com.akash.dhembare2000.ex_Selenium.ex_28022025;


import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Selenium15 {
    @Test
    public void vwoLogin() {
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://sdet.live");
        driver.quit();

    }
}
