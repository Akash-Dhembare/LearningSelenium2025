package com.akash.dhembare2000.ex_Selenium.ex_27022025;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class Selenium10 {
    @Test
    public void testQuitVsClose(){
        EdgeDriver driver= new EdgeDriver();
        driver.get("https://sdet.live");
        // driver.close();
        // Close the Current Browser Window - not the Full browser
        // Close the window, Session ID != null, Error - Invalid Session ID

        driver.quit();
        // Close all the Sessions / Windows and Stop the browser
        // Close the window, Session ID = null, Error - Session ID is null
    }
}
