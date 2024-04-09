package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LandingPage {
    private static final String CLICKING_SCRIPT = "arguments[0].click();";
    private static final By COURSES_BUTTON_BY = By.id("btnMyCoursesList");
    WebDriver driver;

    public LandingPage(WebDriver driver){
        this.driver = driver;
    }

    public CoursesPage clickOnCoursesButton(){
        WebElement coursesButton = driver.findElement(COURSES_BUTTON_BY);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript(CLICKING_SCRIPT, coursesButton);
        return new CoursesPage(driver);
    }
}