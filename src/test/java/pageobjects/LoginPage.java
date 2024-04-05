package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private static final String URL = "https://swinji.azurewebsites.net";
    private static final By EMAIL_TEXT_FIELD_BY = By.cssSelector("#Email");
    private static final By PASSOWRD_TEXT_FIELD_BY = By.cssSelector("#inputPassword");
    private static final By LOGIN_BUTTON_BY = By.cssSelector("#btnLogin");
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        driver.get(URL);
    }

    public LoginPage enterEmail(String email){
        WebElement emailTextField = driver.findElement(EMAIL_TEXT_FIELD_BY);
        emailTextField.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password){
        WebElement passwordTextField = driver.findElement(PASSOWRD_TEXT_FIELD_BY);
        passwordTextField.sendKeys(password);
        return this;
    }

    public LandingPage pressLoginButton(){
        WebElement loginButton = driver.findElement(LOGIN_BUTTON_BY);
        loginButton.click();
        return new LandingPage(driver);
    }
}
