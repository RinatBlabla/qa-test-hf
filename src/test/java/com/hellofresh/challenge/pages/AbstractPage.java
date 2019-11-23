package com.hellofresh.challenge.pages;

import com.hellofresh.challenge.driver.DriverProvider;
import com.hellofresh.challenge.utils.PageUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Rinat on 19.11.2019.
 */
public class AbstractPage {

    public WebDriver getDriver(){
        return DriverProvider.getDriver();
    }

    protected WebElement getPageContainer(){

        By locator = By.id("page");
        PageUtils.fluentWait(locator);
        return getDriver().findElement(locator);
    }

    public boolean checkPage(){
        return false;
    }
}
