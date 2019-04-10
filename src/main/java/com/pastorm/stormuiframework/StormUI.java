package com.pastorm.stormuiframework;

import com.pastorm.stormuiframework.annotations.UseBrowser;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class StormUI {

    private WebDriver driver;

    public void initWithContext(UseBrowser context) throws Exception {
        Capabilities capabilities = new DesiredCapabilities(context.browser(), context.version(), context.platform());
        driver = new RemoteWebDriver(new URL(context.url()), capabilities);

        System.out.println("New test context initialized");
        System.out.println("\t- Browser : " + context.browser());
        System.out.println("\t- Version : " + context.version());
        System.out.println("\t- Platform : " + context.platform());
        System.out.println("\t- Remote url : " + context.url());
    }


    protected WebDriver getDriver() {
        return driver;
    }
}
