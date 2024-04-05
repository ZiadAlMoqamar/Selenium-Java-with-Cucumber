package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LandingPage {
    private static final By COURSES_BUTTON_BY = By.cssSelector("#btnMyCoursesList");
    WebDriver driver;

    public LandingPage(WebDriver driver){
        this.driver = driver;
    }

    public CoursesPage clickOnCoursesButton(){
        WebElement coursesButton = driver.findElement(COURSES_BUTTON_BY);
        coursesButton.click();
        return new CoursesPage(driver);
    }
}