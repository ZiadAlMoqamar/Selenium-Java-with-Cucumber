package stepsdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks{
    protected WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }

    public void setUp() {
        driver = new ChromeDriver();
    }


    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
