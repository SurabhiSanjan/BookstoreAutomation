package com.QapitolQA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectBook() throws InterruptedException {

        WebElement book1 = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[1]/div[1]/div/div/a/div/strong"));
        book1.click();

    }

    public void pageValidate() {
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "http://139.59.27.246:3000/");
    }
}
