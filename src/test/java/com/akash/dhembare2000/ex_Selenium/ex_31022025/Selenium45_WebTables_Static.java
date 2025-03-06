
package com.akash.dhembare2000.ex_Selenium.ex_31022025;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Collection;

public class Selenium45_WebTables_Static {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--start-maximized");
        options.addArguments("--InPrivate");
        driver= new EdgeDriver(options);
    }

    @Description("Verify Web Tables")
    @Test
    public void test_web_tables(){
        driver.get("https://awesomeqa.com/webtable.html");

        // Row- //table/tbody/tr
        // Col- //table/tbody/tr[2]/td

        int row = driver.findElements(By.xpath("//table/tbody/tr")).size();
        int col = driver.findElements(By.xpath("//table/tbody/tr[2]/td")).size();

       // System.out.println(row);
      //  System.out.println(col);

        //table/tbody/tr[2]/td[3]
       // Part 1 : //table/tbody/tr[
       // i
       // Part 2:  ]/td[
        // j
        //Part 3: ]

        String first_part="//table/tbody/tr[";
        String second_part="]/td[";
        String third_part="]";

        // i = 1 to 7
        // j = 1,2,3

        for (int i=2; i<=row; i++){
            for (int j = 1; j <=col ; j++) {
                String dynamic_xpath= first_part+i+second_part+j+third_part;
                String data= driver.findElement(By.xpath(dynamic_xpath)).getText();
               // System.out.println(data);

                if(data.contains("Helen Bennett")){
                    String country_path=dynamic_xpath+"/following-sibling::td";
                    String company_path=dynamic_xpath+"/preceding-sibling::td";

                    String countryOfHelen=driver.findElement(By.xpath(country_path)).getText();
                    String companyOfHelen= driver.findElement(By.xpath(company_path)).getText();

                    System.out.println("Helen Bennett is living in: "+countryOfHelen);
                    System.out.println("And she is working in: "+companyOfHelen);
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
