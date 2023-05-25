package com.QapitolQA.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void productCheckout() {

        WebElement checkout = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/div[2]/div/div/div[3]/button"));
        checkout.click();
    }

    public void pageValidate() {
        WebElement bookName = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[1]/h1"));
        Assert.assertEquals(bookName.getText(), "Shopping Cart");
    }
}

