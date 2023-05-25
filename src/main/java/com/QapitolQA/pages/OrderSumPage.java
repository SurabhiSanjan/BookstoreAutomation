package com.QapitolQA.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class OrderSumPage {
    WebDriver driver;

    public OrderSumPage(WebDriver driver) {
        this.driver = driver;
    }

    public void getOrderID() {
        WebElement orderID = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/h1"));
        System.out.println("Payment Receipt :" + orderID.getText());

        WebElement receipt = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/div[1]/div/div[2]/p[2]/a"));
        System.out.println("Payment Receipt :" + receipt.getText());
    }

    public void pageValidate() {
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "http://139.59.27.246:3000/placeorder");
    }
}
