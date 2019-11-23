package com.hellofresh.challenge.pages;

import com.hellofresh.challenge.utils.PageUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;


/**
 * Created by Rinat on 20.11.2019.
 */
@Component
public class CategoryPage extends AbstractPage {

    private WebElement getProduct(String productName) {
        return getDriver().findElement(By.xpath("//a[@title='"+productName+"']/.."));
    }

    private WebElement getFrame(){
        By overLaylocator = By.xpath("//*[contains(@class,'fancybox-overlay')]");
        PageUtils.fluentWait(overLaylocator);
        By locator = By.xpath("//*[contains(@class,'fancybox-overlay')]//iframe[@class='fancybox-iframe']");
        PageUtils.fluentWait(locator);
        return getDriver().findElement(locator);
    }

    private WebElement getAddToChartBtn(){
        By tempLocator = By.xpath("//*[@id='buy_block']");
        PageUtils.fluentWait(tempLocator);
        tempLocator = By.xpath("//*[@id='add_to_cart']");
        PageUtils.fluentWait(tempLocator);
        By locator = By.xpath("//*[@id='add_to_cart']//*[@name='Submit']");
        PageUtils.fluentWait(locator);
        return getDriver().findElement(locator);
    }

    private WebElement getProceedToCheckOutBtn(){
        By tempLocator = By.xpath("//*[@id='add_to_cart']");
        PageUtils.fluentWait(tempLocator);
        By locator = By.xpath("//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']");
        PageUtils.fluentWait(locator);
        return getDriver().findElement(locator);
    }

    public void clickGetProduct(String productName) {
        PageUtils.waitForDomIsReady();
        PageUtils.clickIfEnabled(getProduct(productName));
    }

    public void clickProceedToCheckOutBtn() {
        PageUtils.waitForDomIsReady();
        PageUtils.clickIfEnabled(getProceedToCheckOutBtn());
    }

    public void clickAddToChartBtn() {
        PageUtils.waitForPageLoading();
        PageUtils.waitForDomIsReady();
        PageUtils.switchToFrame(getFrame());
        PageUtils.waitForDomIsReady();
        PageUtils.clickIfEnabled(getAddToChartBtn());
    }

    @Override
    public boolean checkPage(){
        PageUtils.waitForDomIsReady();
        PageUtils.fluentWait(getPageContainer());
        if(getPageContainer().isDisplayed()
                && getDriver().getCurrentUrl().contains("controller=category")){
            return true;
        }
        return false;
    }
}
