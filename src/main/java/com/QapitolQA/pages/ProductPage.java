package com.QapitolQA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.awt.*;
import java.awt.event.KeyEvent;

public class ProductPage {
    WebDriver driver;
    static String comment1 = "Just testing Review functionality";
    static String comment2 = "Testing Edit Review functionality";

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProduct() {
        WebElement cartButton = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[1]/div[3]/div/div/div[4]/button"));
        cartButton.click();
    }

    public void addReview() {
        WebElement rating = driver.findElement(By.xpath("//*[@id=\"rating\"]"));
        Select sc = new Select(rating);
        sc.selectByValue("4");
        WebElement review = driver.findElement(By.xpath("/html/body/div/main/div/div[2]/div[2]/div/form/div[2]/textarea"));
        Actions act = new Actions(driver);
        act.moveToElement(review).perform();
        review.sendKeys(comment1);
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/div[2]/div/form/button"));
        submit.click();
    }

    public void reviewValidate() throws AWTException, InterruptedException {
        Robot bot = new Robot();
        for (int i = 1; i <= 23; i++) {
            bot.keyPress(KeyEvent.VK_DOWN);
            bot.keyRelease(KeyEvent.VK_DOWN);
            Thread.sleep(50);
        }
    }

    public void editReview_Rating() {
        WebElement rating = driver.findElement(By.xpath("//*[@id=\"rating\"]"));
        Select sc = new Select(rating);
        sc.selectByValue("2");
        WebElement review = driver.findElement(By.xpath("/html/body/div/main/div/div[2]/div[2]/div/form/div[2]/textarea"));
        Actions act = new Actions(driver);
        act.moveToElement(review).perform();
        review.clear();
        review.sendKeys(comment2);
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/div[2]/div/form/button"));
        submit.click();
    }

    public void editedReviewValidate() throws AWTException, InterruptedException {
        Robot bot = new Robot();
        for (int i = 1; i <= 23; i++) {
            bot.keyPress(KeyEvent.VK_DOWN);
            bot.keyRelease(KeyEvent.VK_DOWN);
            Thread.sleep(50);
        }
    }

    public void changeQty() {
        WebElement qty = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[1]/div[3]/div/div/div[3]/div/div[2]/select"));
        Select sel = new Select(qty);
        sel.selectByValue("4");
        sel.selectByValue("10");
        sel.selectByValue("5");
        sel.selectByValue("8");
    }

    public void pageBack() {
        WebElement backButton = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/a"));
        backButton.click();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "http://139.59.27.246:3000/");
    }

    public void bookValidate() {
        WebElement bookName = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[1]/div[2]/div/div[1]/h4"));
        Assert.assertEquals(bookName.getText(), "Modern Indian Literature: Poems and Short Stories");
    }
}
