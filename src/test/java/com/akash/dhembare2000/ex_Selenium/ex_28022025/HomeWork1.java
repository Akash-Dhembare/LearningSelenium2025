package com.akash.dhembare2000.ex_Selenium.ex_28022025;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeWork1 {
    @Test
    public void testRegisterAwsomeQA(){
        EdgeOptions edgeOptions= new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--InPrivate");

        WebDriver driver= new EdgeDriver(edgeOptions);
        driver.get("https://awesomeqa.com/ui/index.php?route=account/register");

        WebElement firstname = driver.findElement(By.name("firstname"));
        firstname.sendKeys("Akash");

        WebElement lastname = driver.findElement(By.id("input-lastname"));
        lastname.sendKeys("Dhembare");

        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("akas@outook.com");

        WebElement telephone = driver.findElement(By.name("telephone"));
        telephone.sendKeys("9876543210");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("akash@123");

        WebElement conf_password = driver.findElement(By.id("input-confirm"));
        conf_password.sendKeys("akash@123");

        List<WebElement> newsletter_yes= driver.findElements(By.className("radio-inline"));
        newsletter_yes.get(0).click();

        WebElement agree= driver.findElement(By.name("agree"));
        agree.click();

        WebElement submitBtn= driver.findElement(By.className("btn-primary"));
        submitBtn.click();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement successMsg = driver.findElement(By.className("col-sm-9"));
        System.out.println(successMsg.getText());
        Assert.assertEquals(successMsg.getText(), "Your Account Has Been Created!\n" +
                "Congratulations! Your new account has been successfully created!\n" +
                "You can now take advantage of member privileges to enhance your online shopping experience with us.\n" +
                "If you have ANY questions about the operation of this online shop, please e-mail the store owner.\n" +
                "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.\n" +
                "Continue");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();

    }
}
