package com.QapitolQA.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class SignUpPage {
    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void registerPage(){

        driver.findElement(By.xpath("//*[@id=\"basic-navbar-nav\"]/div/a[2]")).click();

        WebElement registerButton = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/div/div/div/div/div/a"));
        registerButton.click();
    }

    public void registration() {
        WebElement userName = driver.findElement(By.xpath("//*[@id=\"userName\"]"));
        userName.sendKeys("surabhisanjan");

        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        userName.sendKeys("KUMARI SURABHI");

        WebElement emailID = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        emailID.sendKeys("surabhisanjan@gmail.com");

        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys("Theend@123");

        WebElement confPassword = driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div/form/div[5]/input"));
        confPassword.sendKeys("Theend@123");

        WebElement register = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/div/div/div/div/div/a"));
        register.click();
    }

    public void negativeRegister(String username, String name, String email, String pass, String confirm) {
        WebElement userName = driver.findElement(By.xpath("//*[@id=\"userName\"]"));
        userName.sendKeys(username);

        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        firstName.sendKeys(name);

        WebElement emailID = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        emailID.sendKeys(email);

        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys(pass);

        WebElement confPassword = driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div/form/div[5]/input"));
        confPassword.sendKeys(confirm);

        WebElement register = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/div/div/div/form/button"));
        register.click();
    }

    public void pageValidate() {
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "http://139.59.27.246:3000/register?redirect=/");
    }
}
