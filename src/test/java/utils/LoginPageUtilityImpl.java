package utils;

import pageobjects.LoginPage;
import utils.interfaces.LoginPageUtility;

public class LoginPageUtilityImpl implements LoginPageUtility {
    private final LoginPage loginPage;

    public LoginPageUtilityImpl(LoginPage loginPage){
        this.loginPage = loginPage;
    }

    @Override
    public LoginPage loggingIn(String email, String password){
        return loginPage
                .enterEmail(email)
                .enterPassword(password);
    }
}
