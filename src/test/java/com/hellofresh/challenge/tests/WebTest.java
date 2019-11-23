package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.configuration.MainConfiguration;
import com.hellofresh.challenge.driver.DriverProvider;
import com.hellofresh.challenge.objects.AccAddressInfo;
import com.hellofresh.challenge.objects.AccPersonalInfo;
import com.hellofresh.challenge.objects.ExistingUserData;
import com.hellofresh.challenge.pages.AuthenticationPage;
import com.hellofresh.challenge.pages.OrderPage;
import com.hellofresh.challenge.pages.Pages;
import com.hellofresh.challenge.utils.InputReader;
import com.hellofresh.challenge.utils.PageUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static junit.framework.TestCase.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MainConfiguration.class)
public class WebTest {

    private static Logger logger = LoggerFactory.getLogger(WebTest.class);

    @Autowired
    Pages pages;

    @Before
    public void setUp() {
        logger.info("========================== 	@BeforeSuite  ================");
        DriverProvider.initDriver();
    }

    public void reloadBrowser() {
        logger.info("========================== 	@BeforeMethod  ================");
        if (DriverProvider.getDriver() != null) {
            WebDriver driver = DriverProvider.getDriver();
            driver.manage().deleteAllCookies();
            driver.navigate().refresh();
        }
        logger.debug("Start url: " + System.getProperty("start.url"));
        DriverProvider.getDriver().get(System.getProperty("start.url"));
    }

//    @Test
    public void signInTest() {

        reloadBrowser();
        assertTrue(pages.getMainPage().checkPage());
        pages.getMainPage().clickSignInBtn();

        AuthenticationPage authenticationPage = pages.getAuthenticationPage();
        assertTrue(authenticationPage.checkPage());
        authenticationPage.enterSignInData(PageUtils.generateNewEmail());
        authenticationPage.clickSubmitCreateBtn();
        AccPersonalInfo accPersonalInfo = new AccPersonalInfo(InputReader
                .fillMapFromFile("src\\test\\resources\\testdata\\PersonalInfoForm.txt"));
        assertTrue(authenticationPage.checkPage());
        authenticationPage.fillPersonalInfoForm(accPersonalInfo);
        authenticationPage.fillAddressInfoForm(new AccAddressInfo(InputReader
                .fillMapFromFile("src\\test\\resources\\testdata\\AddressInfoForm.txt")));
        authenticationPage.clickSubmitAccountBtn();

        assertTrue(pages.getMyAccountPage().checkPage());
        assertTrue(pages.getMyAccountPage().checkAccount(accPersonalInfo.getFirstName()
                        + " " + accPersonalInfo.getLastName(),
                "Welcome to your account."));
    }

  //  @Test
    public void logInTest() {

        reloadBrowser();
        assertTrue(pages.getMainPage().checkPage());
        pages.getMainPage().clickSignInBtn();

        AuthenticationPage authenticationPage = pages.getAuthenticationPage();
        assertTrue(authenticationPage.checkPage());
        ExistingUserData userData = new ExistingUserData(InputReader
                .fillMapFromFile("src\\test\\resources\\testdata\\ExistingUserData.txt"));
        authenticationPage.enterLogInData(userData.getEmail(),userData.getPassword());
        authenticationPage.clickSubmitLoginBtn();

        assertTrue(pages.getMyAccountPage().checkPage());
        assertTrue(pages.getMyAccountPage().checkAccount(userData.getFirst_name()
                        + " " + userData.getLast_name(),
                "Welcome to your account."));
    }

    @Test
    public void checkoutTest() {

        logInTest();

        pages.getMyAccountPage().clickWomenLnk();
        assertTrue(pages.getCategoryPage().checkPage());
        pages.getCategoryPage().clickGetProduct("Faded Short Sleeve T-shirts");
        assertTrue(pages.getCategoryPage().checkPage());
        pages.getCategoryPage().clickAddToChartBtn();
        assertTrue(pages.getCategoryPage().checkPage());
        pages.getCategoryPage().clickProceedToCheckOutBtn();

        OrderPage orderPage = pages.getOrderPage();
        assertTrue(orderPage.checkPage());
        orderPage.clickProceedToCheckOutBtn();
        orderPage.clickAddressProceedToCheckOutBtn();
        orderPage.agreeToTerms();
        orderPage.clickShippingProceedToCheckOutBtn();
        orderPage.clickPayByBankWireLnk();

        assertTrue(pages.getBankWirePage().checkPage());
        pages.getBankWirePage().clickCofirmOrderBtn();

        assertTrue(pages.getOrderConfirmationPage().checkPage());
        pages.getOrderConfirmationPage().checkAccount("Your order on My Store is complete.",
                "ORDER CONFIRMATION");
    }

    @After
    public void cleanUp() {
        DriverProvider.getDriver().close();
        DriverProvider.getDriver().quit();
        logger.info("========================== 	@AfterSuite  ================");
    }
}
