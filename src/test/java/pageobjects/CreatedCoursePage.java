package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreatedCoursePage {
    WebDriver driver;

    public CreatedCoursePage(WebDriver driver){
        this.driver = driver;
    }

    public CoursesPage clickOnCoursesButton(){
        WebElement coursesButton = driver.findElement(By.cssSelector("#btnMyCoursesList"));
        coursesButton.click();
        return new CoursesPage(driver);
    }
}
