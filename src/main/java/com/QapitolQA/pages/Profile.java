package com.QapitolQA.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Profile {
    WebDriver driver;

    public Profile(WebDriver driver) {
        this.driver = driver;
    }

    public void update() throws AWTException, InterruptedException {
        WebElement user = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        user.click();
        WebElement profile = driver.findElement(By.partialLinkText("Profile"));
        profile.click();

        WebElement lastname = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        lastname.clear();
        Thread.sleep(200);
        lastname.sendKeys("sanjan");

        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys("Theend@123");

        WebElement confirm = driver.findElement(By.id("confirmPassword"));
        confirm.sendKeys("Theend@123");

        Robot button = new Robot();
        button.keyPress(KeyEvent.VK_PAGE_DOWN);
        button.keyRelease(KeyEvent.VK_PAGE_DOWN);
        button.keyPress(KeyEvent.VK_ENTER);
        button.keyRelease(KeyEvent.VK_ENTER);
    }

    public void details() throws InterruptedException {
        WebElement user = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        user.click();
        WebElement profile = driver.findElement(By.partialLinkText("Profile"));
        profile.click();
        Thread.sleep(2000);
        WebElement orderDetail = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/div[2]/div/table/tbody/tr[1]/td[6]/a"));
        orderDetail.click();
        Thread.sleep(2000);
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "http://139.59.27.246:3000/order/00e00429-b98b-4024-bb26-d51d72feea34");
    }
}
