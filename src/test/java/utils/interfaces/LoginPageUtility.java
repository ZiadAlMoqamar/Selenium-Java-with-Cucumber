package utils.interfaces;

import org.openqa.selenium.WebDriver;
import pageobjects.LoginPage;

public interface LoginPageUtility {
    LoginPage loggingIn(String email, String password);
}
