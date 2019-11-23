package com.hellofresh.challenge.objects;

import com.hellofresh.challenge.enums.AccPersonalInfoLabelsEnum;
import com.hellofresh.challenge.utils.PageUtils;

import java.util.Map;

/**
 * Created by Rinat on 20.11.2019.
 */
public class AccPersonalInfo {
    private String firstName, lastName, email, password;
    private int dayOfBirth;
    private String monthOfBirth;
    private int yearOfBirth;

    public AccPersonalInfo(Map<String,String> inputData){
        setFirstName(PageUtils.setObjectMethodWithStr(inputData, AccPersonalInfoLabelsEnum.First_Name.name()));
        setLastName(PageUtils.setObjectMethodWithStr(inputData,AccPersonalInfoLabelsEnum.Last_Name.name()));
        setEmail(PageUtils.setObjectMethodWithStr(inputData,AccPersonalInfoLabelsEnum.Email.name()));
        setPassword(PageUtils.setObjectMethodWithStr(inputData,AccPersonalInfoLabelsEnum.Password.name()));
        setDayOfBirth(Integer.valueOf(PageUtils.setObjectMethodWithStr(inputData,AccPersonalInfoLabelsEnum
                .Day_Of_Birth.name())));
        setMonthOfBirth(PageUtils.setObjectMethodWithStr(inputData,AccPersonalInfoLabelsEnum
                .Month_Of_Birth.name()));
        setYearOfBirth(Integer.valueOf(PageUtils.setObjectMethodWithStr(inputData,AccPersonalInfoLabelsEnum
                .Year_Of_Birth.name())));
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(int dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getMonthOfBirth() {
        return monthOfBirth;
    }

    public void setMonthOfBirth(String monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

}
