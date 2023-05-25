package com.QapitolQA.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PlaceOrderPage {
    WebDriver driver;

    public PlaceOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void placeOrder() {
        WebElement orderButton = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/div[2]/div/div/div[6]/button"));
        orderButton.click();
    }

    public void pageValidate() {
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "http://139.59.27.246:3000/placeorder");
    }
}
