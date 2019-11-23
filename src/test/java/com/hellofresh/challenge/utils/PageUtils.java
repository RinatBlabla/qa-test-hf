package com.hellofresh.challenge.utils;

import com.google.common.base.Function;
import com.hellofresh.challenge.configuration.JsScripts;
import com.hellofresh.challenge.driver.DriverProvider;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Date;
import java.util.Map;
import static com.hellofresh.challenge.configuration.JsScripts.JS_SCRIPT_CURRENT_FRAME;
import static com.hellofresh.challenge.configuration.JsScripts.JS_SCRIPT_EXEC;
import static com.hellofresh.challenge.configuration.JsScripts.JS_SCRIPT_FOR_SCROLL_INTO;
import static com.hellofresh.challenge.configuration.TimeConstants.*;

/**
 * Created by Rinat on 19.11.2019.
 */
public class PageUtils {

    private static Logger logger = LoggerFactory.getLogger(PageUtils.class);

    public static void waitForPageLoading() {
        new WebDriverWait(DriverProvider.getDriver(), TIMEOUT_SEC)
                .until((ExpectedCondition<Boolean>) driver1 -> {
                    JavascriptExecutor js = (JavascriptExecutor) driver1;
                    return (Boolean) js.executeScript("return jQuery.active == 0");
                });
    }

    public static void clickIfEnabled(WebElement element) {
        logger.debug("clickIfEnabled.before wait = " + System.currentTimeMillis());
        fluentWait(element);
        logger.debug("clickIfEnabled.after wait = " + System.currentTimeMillis());
        scrollToElement(element);
        logger.debug("element tag = " + element.getTagName());
        element.click();
    }

    public static void switchToFrame(WebElement element){
        PageUtils.waitForDomIsReady();
         new WebDriverWait(DriverProvider.getDriver(), LONG_WAIT_SEC)
                .withTimeout(Duration.ofSeconds(LONG_WAIT_SEC)).
                pollingEvery(Duration.ofMillis(POLLING_WAIT_MILISEC)).
                ignoring(WebDriverException.class).
                until((ExpectedCondition<Boolean>) Boolean -> {
                    String expectedFrameId = element.getAttribute("id");
                    DriverProvider.getDriver().switchTo().frame(expectedFrameId);
                    JavascriptExecutor js = (JavascriptExecutor) DriverProvider.getDriver();
                    String currentFrame = (String)js.executeScript(JS_SCRIPT_CURRENT_FRAME);
                    logger.debug("currentFrame: "+currentFrame + "; input frame: " + expectedFrameId);
                    return currentFrame.equals(expectedFrameId);
                });
    }

    public static void waitForDomIsReady() {
        WebDriverWait wait = new WebDriverWait(DriverProvider.getDriver(), LONG_WAIT_SEC);
        wait.withTimeout(Duration.ofSeconds(LONG_WAIT_SEC)).
                pollingEvery(Duration.ofMillis(POLLING_WAIT_MILISEC)).
                ignoring(WebDriverException.class).
                until(Boolean -> ((JavascriptExecutor) Boolean).executeScript(JS_SCRIPT_EXEC).equals("complete"));
    }

    public static void fluentWait(By locator) {
        try{
            new FluentWait<>(locator).
                    withTimeout(Duration.ofSeconds(LONG_WAIT_SEC)).
                    pollingEvery(Duration.ofMillis(POLLING_WAIT_MILISEC)).
                    ignoring(WebDriverException.class).
                    until((Function<By, Boolean>) locator1 -> {
                        try{
                            if (DriverProvider.getDriver().findElement(locator1)!=null) {
                                logger.debug("In true"+ "\n");
                                return true;
                            } else {
                                return false;
                            }
                        } catch (NoSuchElementException nse) {
                            logger.info("fluentWaitForElementToBeInvisible: element is not attached due to " + nse);
                            return false;
                        } catch (StaleElementReferenceException ser) {
                            logger.info("fluentWaitForElementToBeInvisible: element is not attached due to " + ser);
                            return false;
                        }
                    });
        } catch (Exception e) {
            logger.error("fluentWait error message: " + e.getMessage());
        }
    }

    public static void fluentWait(WebElement element) {

        logger.debug("In fluentWait"+ "\n");
        new FluentWait<>(element).
                withTimeout(Duration.ofSeconds(LONG_WAIT_SEC)).
                pollingEvery(Duration.ofMillis(POLLING_WAIT_MILISEC)).
                ignoring(WebDriverException.class).
                until((Function<WebElement, Boolean>) element1 -> {
                        try{
                            if (element1.getSize().getHeight() != 0
                                        && element1.getSize().getWidth() != 0
                                        && element1.isDisplayed()
                                        && element1.isEnabled()) {
                                return true;
                        } else {
                            return false;
                        }
                    } catch (NoSuchElementException nse) {
                        logger.info("fluentWaitForElementToBeInvisible: element is not attached due to " + nse);
                        return false;
                    } catch (StaleElementReferenceException ser) {
                        logger.info("fluentWaitForElementToBeInvisible: element is not attached due to " + ser);
                        return false;
                    }
                });
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) DriverProvider.getDriver()).executeScript(JS_SCRIPT_FOR_SCROLL_INTO, element);
    }

    public static String generateNewEmail(){
        String timestamp = String.valueOf(new Date().getTime());
        return "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
    }

    public static void setValueForInputFields(WebElement element,String value){
        if(value!=null) {
            clickIfEnabled(element);
            element.clear();
            element.sendKeys(value);
        }
    }

    public static void selectElemByTextIfInputValueNull(WebElement element,String value) {
        if (!value.equals("")) {
            Select select = new Select(element);
            select.selectByVisibleText(value);
        }
    }

    public static void selectElemByValIfInputValueNull(WebElement element,String value) {
        if (!value.equals("")) {
            Select select = new Select(element);
            select.selectByValue(value);
        }
    }

    public static void customSelectElemByValIfInputValueNotNull(WebElement selectElement,String value) {
        if (!value.equals("")) {
            selectElement.click();
            waitForDomIsReady();
            selectElement.findElement(By.xpath(".//option[contains(text(),'"+value+"')]")).click();
        }
    }

    public static String setObjectMethodWithStr(Map<String,String> inputData, String key) {
        if(inputData.get(key)==null){
            return "";
        }
        return inputData.get(key);
    }
}
