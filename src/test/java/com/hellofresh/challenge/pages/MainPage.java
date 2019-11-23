package com.hellofresh.challenge.pages;

import com.hellofresh.challenge.utils.PageUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

/**
 * Created by Rinat on 19.11.2019.
 */
@Component
public class MainPage extends AbstractPage {

    private WebElement getSignInBtn(){
        return getDriver().findElement(By.className("login"));
    }

    private WebElement getSliderDiv(){
        return getDriver().findElement(By.id("slider_row"));
    }

    public void clickSignInBtn(){
        PageUtils.waitForDomIsReady();
        PageUtils.clickIfEnabled(getSignInBtn());
    }

    @Override
    public boolean checkPage(){
        PageUtils.waitForDomIsReady();
        PageUtils.fluentWait(getSliderDiv());
        if(getSliderDiv().isDisplayed()){
            return true;
        }
        return false;
    }
}
