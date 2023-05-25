package com.QapitolQA.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BaseClass {
    public static WebDriver driver = null;
    Logger log;
    public void setup(){
        log = Logger.getLogger(BaseClass.class.getName());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        log.info("Browser Launched");
        driver =new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
    }
    public void closeWindow(){
        driver.quit();
        log.info("Quit Browser");
    }
}
