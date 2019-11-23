package com.hellofresh.challenge.pages;

import com.hellofresh.challenge.utils.PageUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

/**
 * Created by Rinat on 20.11.2019.
 */
@Component
public class MyAccountPage extends AbstractPage {

    private WebElement getMyAccountBody(){
        return getDriver().findElement(By.id("my-account"));
    }

    private WebElement getMyAccountName(){
        return getDriver().findElement(By.className("account"));
    }

    private WebElement getMyInfoAccount(){
        return getDriver().findElement(By.className("info-account"));
    }

    private WebElement getLogoutBtn(){
        return getDriver().findElement(By.className("logout"));
    }

    private WebElement getWomenLnk() {
        return getDriver().findElement(By.linkText("Women"));
    }

    public void clickWomenLnk(){
        PageUtils.waitForDomIsReady();
        PageUtils.clickIfEnabled(getWomenLnk());
    }

    public boolean checkAccount(String accountName, String infoAccountText){
        PageUtils.waitForDomIsReady();
        if(getMyAccountName().getText().equals(accountName)
                && getMyInfoAccount().getText().contains(infoAccountText)
                && getDriver().getCurrentUrl().contains("controller=my-account")){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkPage(){
        PageUtils.waitForDomIsReady();
        PageUtils.fluentWait(getMyAccountBody());
        if(getMyAccountBody().isDisplayed()
                && getMyAccountName().isDisplayed()
                && getMyInfoAccount().isDisplayed()
                && getLogoutBtn().isDisplayed()){
            return true;
        }
        return false;
    }
}
