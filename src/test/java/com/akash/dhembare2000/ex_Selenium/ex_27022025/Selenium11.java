package com.akash.dhembare2000.ex_Selenium.ex_27022025;

import org.openqa.selenium.edge.EdgeDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Selenium11 {

    // get() vs navigate.to()

    public static void main(String[] args) throws MalformedURLException {
        EdgeDriver driver= new EdgeDriver();
        driver.get("https://bing.com");

        driver.navigate().to("https://app.vwo.com");
        driver.navigate().to(new URL("https://google.com"));
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        driver.quit();
    }
}
