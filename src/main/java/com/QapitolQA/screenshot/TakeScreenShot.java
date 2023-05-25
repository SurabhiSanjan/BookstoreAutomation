package com.QapitolQA.screenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static com.QapitolQA.base.BaseClass.driver;

public class TakeScreenShot {
    public void screenshot() throws IOException {
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File("C:\\Users\\kumarisurabhi.sanjan\\IdeaProjects\\BookStore-Test-Assignment\\ScreenshotsStore/screenshot" + System.currentTimeMillis() + ".png");
        FileUtils.copyFile(src, destination);
    }
}
