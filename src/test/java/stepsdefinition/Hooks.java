package stepsdefinition;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hooks{
    protected ThreadLocal<WebDriver> driver  = new ThreadLocal<>();

    protected WebDriver getDriver() {
        return driver.get();
    }
    protected void setUp() {
        driver.set(new ChromeDriver());
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }


    protected void tearDown() {
        if (driver != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}