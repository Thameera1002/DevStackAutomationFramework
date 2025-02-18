package com.devstack.automation.functions.commons;

import com.devstack.automation.functions.FunctionBase;
import com.devstack.automation.pages.commons.LoginPage;
import org.openqa.selenium.WebDriver;

public class LIB_Common extends FunctionBase {
    public LoginPage loginPage;

    public LIB_Common(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
    }

    public void bc_login(String username, String password) {
        loginPage.fillUserName(username);
    }


}
