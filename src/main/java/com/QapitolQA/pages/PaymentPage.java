package com.QapitolQA.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
public class PaymentPage {
    WebDriver driver;
    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addCard() {
        WebElement card = driver.findElement(By.id("pm_1N7xNIG9R9y827ntKvhYFiKl"));
        card.click();
        WebElement selectCard = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[3]/div[1]/div/div/div[2]/div/p[1]"));
        selectCard.click();
        WebElement proceedButton = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[4]/button"));
        proceedButton.click();
    }

    public void pageValidate() {
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "http://139.59.27.246:3000/payment");
    }
}
