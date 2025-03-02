package com.akash.dhembare2000.ex_Selenium.ex_28022025;


import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.net.MalformedURLException;

public class Selenium22 {
    public static void main(String[] args)  {

        EdgeOptions options = new EdgeOptions();
//        options.addArguments("--start-maximized");
//        options.addArguments("--window-size=800,600");
//        options.addArguments("--guest");

        Proxy proxy = new Proxy();
        proxy.setHttpProxy("188.255.245.205:1080");
        options.setCapability("proxy", proxy);


        WebDriver driver = new EdgeDriver(options);
        driver.get("https://whatismyipaddress.com/");
        driver.manage().window().maximize();

    }
}
