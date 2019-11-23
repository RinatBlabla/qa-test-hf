package com.hellofresh.challenge.objects;

import com.hellofresh.challenge.enums.AccPersonalInfoLabelsEnum;
import com.hellofresh.challenge.enums.ExistingUserDataEnum;
import com.hellofresh.challenge.utils.PageUtils;

import java.util.Map;

/**
 * Created by Rinat on 21.11.2019.
 */
public class ExistingUserData {

    private String email, password, first_name, last_name;

    public ExistingUserData(Map<String,String> inputData) {
        setEmail(PageUtils.setObjectMethodWithStr(inputData, ExistingUserDataEnum.email.name()));
        setPassword(PageUtils.setObjectMethodWithStr(inputData, ExistingUserDataEnum.password.name()));
        setFirst_name(PageUtils.setObjectMethodWithStr(inputData, ExistingUserDataEnum.first_name.name()));
        setLast_name(PageUtils.setObjectMethodWithStr(inputData, ExistingUserDataEnum.last_name.name()));
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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
