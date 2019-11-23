package com.hellofresh.challenge.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Rinat on 19.11.2019.
 */
public class DriverProvider {

    private static Logger logger = LoggerFactory.getLogger(DriverProvider.class);
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (!isDriverAlive()){
            initDriver();
        }
        return driver;
    }

    public static WebDriver initDriver() {
        WebDriver browser = null;
        String browserName = System.getProperty("browser.name");
        logger.debug("Test will be executed with {} browser", browserName);

        switch (browserName) {

            case "chrome":
                System.setProperty("webdriver.chrome.driver",
                        System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");
                browser = new ChromeDriver();
                break;

            default:
                logger.info("Please enter browser name -Dbrowser");
        }
        driver=browser;
        driver.manage().window().maximize();
        return browser;
    }

    private static boolean isDriverAlive() {
        return (driver != null && ((RemoteWebDriver) driver).getSessionId() != null);
    }
}
