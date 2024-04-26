package stepsdefinition;

import org.openqa.selenium.WebDriver;

public class TestContext {
    private final ThreadLocal<WebDriver> driver  = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driver.get();
    }
    public void setDriver(WebDriver inputDriver){
        driver.set(inputDriver);
    }
}