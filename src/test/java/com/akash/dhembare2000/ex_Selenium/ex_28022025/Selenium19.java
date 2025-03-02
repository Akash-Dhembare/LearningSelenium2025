package com.akash.dhembare2000.ex_Selenium.ex_28022025;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenium19 {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");

        driver.close();
        // Close the Current Browser Window
        // Session ID != NULL
        // Not the full browser

        driver.quit();
        // Close all the /sessions/windows and stop the browser
        // Session = null, Error - Session ID is null


    }
}
