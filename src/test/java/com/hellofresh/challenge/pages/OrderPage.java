package com.hellofresh.challenge.pages;

import com.hellofresh.challenge.utils.PageUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

/**
 * Created by Rinat on 20.11.2019.
 */
@Component
public class OrderPage extends AbstractPage {

    private WebElement getProceedToCheckOutBtn(){
        return getDriver().findElement(By.xpath("//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']"));
    }

    private WebElement getAddressProceedToCheckOutBtn(){
        return getDriver().findElement(By.name("processAddress"));
    }

    private WebElement getAgreeToTermsChk(){
        return getDriver().findElement(By.id("uniform-cgv"));
    }

    private WebElement getShippingProceedToCheckOutBtn(){
        return getDriver().findElement(By.name("processCarrier"));
    }

    private WebElement getPayByBankWireLnk(){
        return getDriver().findElement(By.className("bankwire"));
    }

    public void clickPayByBankWireLnk() {
        PageUtils.waitForDomIsReady();
        PageUtils.clickIfEnabled(getPayByBankWireLnk());
    }

    public void agreeToTerms(){
        PageUtils.waitForDomIsReady();
        PageUtils.clickIfEnabled(getAgreeToTermsChk());
    }

    public void clickShippingProceedToCheckOutBtn() {
        PageUtils.waitForDomIsReady();
        PageUtils.clickIfEnabled(getShippingProceedToCheckOutBtn());
    }

    public void clickProceedToCheckOutBtn() {
        PageUtils.waitForDomIsReady();
        PageUtils.clickIfEnabled(getProceedToCheckOutBtn());
    }

    public void clickAddressProceedToCheckOutBtn() {
        PageUtils.waitForDomIsReady();
        PageUtils.clickIfEnabled(getAddressProceedToCheckOutBtn());
    }

    @Override
    public boolean checkPage(){
        PageUtils.waitForDomIsReady();
        PageUtils.fluentWait(getPageContainer());
        if(getPageContainer().isDisplayed()
                && getDriver().getCurrentUrl().contains("controller=order")){
            return true;
        }
        return false;
    }
}
