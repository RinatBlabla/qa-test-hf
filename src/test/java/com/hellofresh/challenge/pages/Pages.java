package com.hellofresh.challenge.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Rinat on 19.11.2019.
 */
@Component
public class Pages {

    @Autowired
    MainPage mainPage;

    @Autowired
    AuthenticationPage authenticationPage;

    @Autowired
    MyAccountPage myAccountPage;

    @Autowired
    CategoryPage categoryPage;

    @Autowired
    OrderPage orderPage;

    @Autowired
    BankWirePage bankWirePage;

    @Autowired
    OrderConfirmationPage orderConfirmationPage;

    public CategoryPage getCategoryPage() {
        return categoryPage;
    }

    public  MainPage getMainPage() {
        return mainPage;
    }

    public AuthenticationPage getAuthenticationPage(){
        return authenticationPage;
    }

    public MyAccountPage getMyAccountPage(){
        return myAccountPage;
    }

    public OrderPage getOrderPage(){
        return orderPage;
    }

    public BankWirePage getBankWirePage(){
        return bankWirePage;
    }

    public OrderConfirmationPage getOrderConfirmationPage(){
        return orderConfirmationPage;
    }
}

