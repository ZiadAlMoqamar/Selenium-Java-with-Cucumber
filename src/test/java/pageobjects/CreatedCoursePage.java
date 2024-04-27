package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CreatedCoursePage {
    private static final By COURSES_BUTTON_BY = By.cssSelector("#btnMyCoursesList");
    private static final String CLICKING_SCRIPT = "arguments[0].click();";
    WebDriver driver;

    public CreatedCoursePage(WebDriver driver){
        this.driver = driver;
    }

    public CoursesPage clickOnCoursesButton(){
        WebElement coursesButton = driver.findElement(COURSES_BUTTON_BY);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript(CLICKING_SCRIPT, coursesButton);
        return new CoursesPage(driver);
    }
}