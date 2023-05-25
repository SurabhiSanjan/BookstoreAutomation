package com.QapitolQA.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class AddressPage {
    WebDriver driver;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addAddress() {

        WebElement address1 = driver.findElement(By.xpath("//*[@id=\"addressLine1\"]"));
        address1.sendKeys("B 310, Raunak Capital Green");

        WebElement address2 = driver.findElement(By.xpath("//*[@id=\"addressLine2\"]"));
        address2.sendKeys("R. K. Puram");

        WebElement city = driver.findElement(By.xpath("//*[@id=\"city\"]"));
        city.sendKeys("Patna");

        WebElement state = driver.findElement(By.xpath("//*[@id=\"state\"]"));
        state.sendKeys("Bihar");

        WebElement country = driver.findElement(By.xpath("//*[@id=\"country\"]"));
        Select sc = new Select(country);
        sc.selectByValue("IN");

        WebElement pinCode = driver.findElement(By.xpath("//*[@id=\"postalCode\"]"));
        pinCode.sendKeys("801503");

        WebElement mobile = driver.findElement(By.xpath("//*[@id=\"phone\"]"));
        mobile.sendKeys("8544370256");

        WebElement addButton = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[3]/div[2]/form/div[2]/button"));
        addButton.click();

        WebElement delAddress = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[3]/div[1]/div[2]/div/div/div[3]/button/i"));
        delAddress.click();
        WebElement proceedBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[4]/button"));
        proceedBtn.click();
    }

    public void proceedToPay() throws InterruptedException {
        WebElement radio = driver.findElement(By.xpath("//input[@class='form-check-input position-static']"));
        radio.click();
        WebElement proceed = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[4]/button"));
        proceed.click();
        Thread.sleep(2000);
    }

    public void pageValidate() {
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "http://139.59.27.246:3000/shipping");
    }
}
