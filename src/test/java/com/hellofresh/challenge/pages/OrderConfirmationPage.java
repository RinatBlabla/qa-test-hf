package com.hellofresh.challenge.pages;

import com.hellofresh.challenge.utils.PageUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

/**
 * Created by Rinat on 20.11.2019.
 */
@Component
public class OrderConfirmationPage extends AbstractPage {

    private WebElement getOrderStatus(){
        return getDriver().findElement(By.xpath("//*[@class='cheque-indent']/strong"));
    }

    private WebElement getPageHeading(){
        return getDriver().findElement(By.cssSelector("h1"));
    }

    private WebElement getPreviousStepPnl(){
        return getDriver().findElement(By.xpath("//li[@class='step_done step_done_last four']"));
    }

    private WebElement getCurrentStepPnl(){
        return getDriver().findElement(By.xpath("//li[@id='step_end' and @class='step_current last']"));
    }

    public boolean checkAccount(String orderStatus, String pageHeadingName){
        PageUtils.waitForDomIsReady();
        if(getOrderStatus().getText().contains(orderStatus)
                && getPageHeading().getText().equals(pageHeadingName)
                && getDriver().getCurrentUrl().contains("controller=order-confirmation")){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkPage(){
        PageUtils.waitForDomIsReady();
        PageUtils.fluentWait(getPageHeading());
        if(getPageHeading().isDisplayed()
                && getOrderStatus().isDisplayed()
                && getPreviousStepPnl().isDisplayed()
                && getCurrentStepPnl().isDisplayed()){
            return true;
        }
        return false;
    }
}
