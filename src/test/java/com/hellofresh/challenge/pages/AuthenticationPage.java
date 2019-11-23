package com.hellofresh.challenge.pages;

import com.hellofresh.challenge.objects.AccAddressInfo;
import com.hellofresh.challenge.objects.AccPersonalInfo;
import com.hellofresh.challenge.utils.PageUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Rinat on 19.11.2019.
 */
@Component
public class AuthenticationPage extends AbstractPage {

    private static Logger logger = LoggerFactory.getLogger(AuthenticationPage.class);

    private WebElement getAuthenticationBody(){
        return getDriver().findElement(By.xpath("//*[@id='authentication']//*[@id='columns']"));
    }

    private WebElement getEmailCreateTxt(){
        return getDriver().findElement(By.id("email_create"));
    }

    private WebElement getSubmitCreateBtn(){
        return getDriver().findElement(By.id("SubmitCreate"));
    }

    private WebElement getEmailLoginTxt(){
        return getDriver().findElement(By.id("email"));
    }

    private WebElement getPasswordTxt(){
        return getDriver().findElement(By.id("passwd"));
    }

    private WebElement getSubmitAccountBtn(){
        return getDriver().findElement(By.id("submitAccount"));
    }

    private WebElement getSubmitLoginBtn(){
        return getDriver().findElement(By.id("SubmitLogin"));
    }

    private WebElement getPersonalFirstNameTxt(){
        By locator = By.id("customer_firstname");
        PageUtils.fluentWait(locator);
        return getDriver().findElement(locator);
    }

    private WebElement getPersonalLastNameTxt(){
        return getDriver().findElement(By.id("customer_lastname"));
    }

    private WebElement getPersonalPasswordTxt(){
        return getDriver().findElement(By.id("passwd"));
    }

    private WebElement getDayOfBirthPopUp(){
        return getDriver().findElement(By.id("days"));
    }

    private WebElement getMonthOfBirthPopUp(){
        return getDriver().findElement(By.id("months"));
    }

    private WebElement getYearOfBirthPopUp(){
        return getDriver().findElement(By.id("years"));
    }

    private WebElement getAddressFirstNameTxt(){
        return getDriver().findElement(By.id("firstname"));
    }

    private WebElement getAddressLastNameTxt(){
        return getDriver().findElement(By.id("lastname"));
    }

    private WebElement getCompanyTxt(){
        return getDriver().findElement(By.id("company"));
    }

    private WebElement getAddress1Txt(){
        return getDriver().findElement(By.id("address1"));
    }

    private WebElement getAddress2Txt(){
        return getDriver().findElement(By.id("address2"));
    }

    private WebElement getAddressCityTxt(){
        return getDriver().findElement(By.id("city"));
    }

    private WebElement getAddressStatePopUp(){
        return getDriver().findElement(By.id("id_state"));
    }

    private WebElement getAddressZipCodeTxt(){
        return getDriver().findElement(By.id("postcode"));
    }

    private WebElement getAddressCountryPopUp(){
        return getDriver().findElement(By.id("id_country"));
    }

    private WebElement getAdditionalInfoTxt(){
        return getDriver().findElement(By.id("other"));
    }

    private WebElement getAddressHomePhoneTxt(){
        return getDriver().findElement(By.id("phone"));
    }

    private WebElement getAddressMobilePhoneTxt(){
        return getDriver().findElement(By.id("phone_mobile"));
    }

    private WebElement getAddressAliasAssignTxt(){
        return getDriver().findElement(By.id("alias"));
    }

    public void enterSignInData(String email){
        PageUtils.waitForDomIsReady();
        PageUtils.setValueForInputFields(getEmailCreateTxt(), email);
    }

    public void enterLogInData(String email,String password){
        PageUtils.waitForDomIsReady();
        PageUtils.setValueForInputFields(getEmailLoginTxt(), email);
        PageUtils.setValueForInputFields(getPasswordTxt(), password);
    }

    public void clickSubmitCreateBtn(){
        PageUtils.waitForDomIsReady();
        PageUtils.clickIfEnabled(getSubmitCreateBtn());
    }

    public void clickSubmitAccountBtn(){
        PageUtils.waitForDomIsReady();
        PageUtils.clickIfEnabled(getSubmitAccountBtn());
    }

    public void clickSubmitLoginBtn(){
        PageUtils.waitForDomIsReady();
        PageUtils.clickIfEnabled(getSubmitLoginBtn());
    }

    public void fillPersonalInfoForm(AccPersonalInfo personalInfo){
        PageUtils.waitForPageLoading();
        PageUtils.waitForDomIsReady();
        PageUtils.setValueForInputFields(getPersonalFirstNameTxt(),personalInfo.getFirstName());
        PageUtils.setValueForInputFields(getPersonalLastNameTxt(),personalInfo.getLastName());
        PageUtils.setValueForInputFields(getPersonalPasswordTxt(),personalInfo.getPassword());
        PageUtils.selectElemByValIfInputValueNull(getDayOfBirthPopUp(), personalInfo.getDayOfBirth() +"");
        PageUtils.customSelectElemByValIfInputValueNotNull(getMonthOfBirthPopUp(), personalInfo.getMonthOfBirth());
        PageUtils.selectElemByValIfInputValueNull(getYearOfBirthPopUp(), personalInfo.getYearOfBirth() + "");
    }

    public void fillAddressInfoForm(AccAddressInfo addressInfo){
        PageUtils.waitForDomIsReady();
        PageUtils.setValueForInputFields(getAddressFirstNameTxt(),addressInfo.getFirstName());
        PageUtils.setValueForInputFields(getAddressLastNameTxt(),addressInfo.getLastName());
        PageUtils.setValueForInputFields(getCompanyTxt(),addressInfo.getCompany());
        PageUtils.setValueForInputFields(getAddress1Txt(),addressInfo.getAdress1());
        PageUtils.setValueForInputFields(getAddress2Txt(),addressInfo.getAdress2());
        PageUtils.setValueForInputFields(getAddressCityTxt(),addressInfo.getCity());
        PageUtils.selectElemByTextIfInputValueNull(getAddressStatePopUp(),addressInfo.getState());
        PageUtils.setValueForInputFields(getAddressZipCodeTxt(),addressInfo.getZipcode() + "");
        PageUtils.selectElemByTextIfInputValueNull(getAddressCountryPopUp(),addressInfo.getCountry());
        PageUtils.setValueForInputFields(getAdditionalInfoTxt(),addressInfo.getAdditionalInfo());
        PageUtils.setValueForInputFields(getAddressHomePhoneTxt(),addressInfo.getHomePhone()+ "");
        PageUtils.setValueForInputFields(getAddressMobilePhoneTxt(),addressInfo.getMobilePhone()+ "");
        PageUtils.setValueForInputFields(getAddressAliasAssignTxt(),addressInfo.getAliasAssign());
    }

    @Override
    public boolean checkPage(){
        PageUtils.waitForDomIsReady();
        PageUtils.fluentWait(getAuthenticationBody());
        if(getAuthenticationBody().isDisplayed()){
            return true;
        }
        return false;
    }
}
