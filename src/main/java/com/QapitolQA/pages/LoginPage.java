package com.QapitolQA.pages;
import com.QapitolQA.base.ReadProperties;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.*;
import java.io.FileNotFoundException;
public class LoginPage extends ReadProperties {
    WebDriver driver;

    public LoginPage(WebDriver driver) throws FileNotFoundException {
        this.driver = driver;
    }

    public void login() throws InterruptedException {

        WebElement userId = driver.findElement(By.xpath("//*[@id=\"userNameOrEmail\"]"));
        userId.sendKeys(properties.getProperty("userID"));

        WebElement password = driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div/form/div[2]/input"));
        password.sendKeys(properties.getProperty("password"));

        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/div/div/div/form/button"));
        signInButton.click();
        Thread.sleep(2000);
    }

    public void logout() {
        WebElement profile = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        profile.click();
        WebElement logout = driver.findElement(By.partialLinkText("Logout"));
        logout.click();
    }

    public void pageValidate() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "React App");
    }
}
