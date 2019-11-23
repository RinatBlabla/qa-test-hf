package com.hellofresh.challenge.pages;

import com.hellofresh.challenge.utils.PageUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

/**
 * Created by Rinat on 20.11.2019.
 */
@Component
public class BankWirePage extends AbstractPage {

    private WebElement getCofirmOrderBtn(){
        return getDriver().findElement(By.xpath("//*[@id='cart_navigation']/button"));
    }

    public void clickCofirmOrderBtn() {
        PageUtils.waitForDomIsReady();
        PageUtils.clickIfEnabled(getCofirmOrderBtn());
    }

    @Override
    public boolean checkPage(){
        PageUtils.waitForDomIsReady();
        PageUtils.fluentWait(getPageContainer());
        if(getPageContainer().isDisplayed()
                && getDriver().getCurrentUrl().contains("module=bankwire&controller=payment")){
            return true;
        }
        return false;
    }
}
