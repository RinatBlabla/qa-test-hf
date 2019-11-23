package com.hellofresh.challenge.objects;

import com.hellofresh.challenge.enums.AccAddressInfoLabelsEnum;
import com.hellofresh.challenge.utils.PageUtils;

import java.util.Map;

/**
 * Created by Rinat on 20.11.2019.
 */
public class AccAddressInfo {

    private String firstName, lastName, company, adress1, adress2, city, state;
    private long zipcode;
    private String country, additionalInfo;
    private long homePhone, mobilePhone;
    private String aliasAssign;

    public AccAddressInfo(Map<String,String> inputData) {
        setFirstName(PageUtils.setObjectMethodWithStr(inputData, AccAddressInfoLabelsEnum.First_Name.name()));
        setLastName(PageUtils.setObjectMethodWithStr(inputData, AccAddressInfoLabelsEnum.Last_Name.name()));
        setCompany(PageUtils.setObjectMethodWithStr(inputData, AccAddressInfoLabelsEnum.Company.name()));
        setAdress1(PageUtils.setObjectMethodWithStr(inputData, AccAddressInfoLabelsEnum.Address1.name()));
        setAdress2(PageUtils.setObjectMethodWithStr(inputData, AccAddressInfoLabelsEnum.Address2.name()));
        setCity(PageUtils.setObjectMethodWithStr(inputData, AccAddressInfoLabelsEnum.City.name()));
        setState(PageUtils.setObjectMethodWithStr(inputData, AccAddressInfoLabelsEnum.State.name()));
        setZipcode(Long.valueOf(PageUtils.setObjectMethodWithStr(inputData,AccAddressInfoLabelsEnum
                .ZipCode.name())));
        setCountry(PageUtils.setObjectMethodWithStr(inputData, AccAddressInfoLabelsEnum.Country.name()));
        setAdditionalInfo(PageUtils.setObjectMethodWithStr(inputData, AccAddressInfoLabelsEnum.Additional_Info.name()));
        setHomePhone(Long.valueOf(PageUtils.setObjectMethodWithStr(inputData,AccAddressInfoLabelsEnum
                .HomePhone.name())));
        setMobilePhone(Long.valueOf(PageUtils.setObjectMethodWithStr(inputData,AccAddressInfoLabelsEnum
                .MobilePhone.name())));
        setAliasAssign(PageUtils.setObjectMethodWithStr(inputData, AccAddressInfoLabelsEnum.Address_Alias.name()));

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAdress1() {
        return adress1;
    }

    public void setAdress1(String adress1) {
        this.adress1 = adress1;
    }

    public String getAdress2() {
        return adress2;
    }

    public void setAdress2(String adress2) {
        this.adress2 = adress2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getZipcode() {
        return zipcode;
    }

    public void setZipcode(long zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public long getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(long homePhone) {
        this.homePhone = homePhone;
    }

    public long getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(long mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getAliasAssign() {
        return aliasAssign;
    }

    public void setAliasAssign(String aliasAssign) {
        this.aliasAssign = aliasAssign;
    }
}
