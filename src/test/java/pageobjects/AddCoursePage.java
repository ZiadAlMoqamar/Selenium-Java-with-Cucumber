package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AddCoursePage {
    private static final String CLICKING_SCRIPT = "arguments[0].click();";
    private static final By COURSE_NAME_TEXT_FIELD_BY = By.cssSelector("#txtCourseName");
    private static final By COURSE_GRADE_DROP_DOWN_BY = By.cssSelector("#courseGrade");
    private static final By COURSE_TEACHER_DROP_DOWN_BY = By.xpath("//*[@id='teacherOnBehalf']/div[1]/span");
    private static final By COURSE_TEACHER_DROP_DOWN_TILE_BY = By.cssSelector(".ui-select-choices.ui-select-choices-content.ui-select-dropdown.dropdown-menu");
    private static final By COURSE_TEACHER_DROP_DOWN_MAIL_BY = By.id("lnkCourseOwnerMail");
    private static final By CREATE_COURSE_BUTTON_BY = By.cssSelector("#btnSaveAsDraftCourse");
    WebDriver driver;

    public AddCoursePage(WebDriver driver){
        this.driver = driver;
    }

    public AddCoursePage enterCourseName(String courseName, String randomCourseName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement courseNameTextField = wait.until(ExpectedConditions.visibilityOfElementLocated(COURSE_NAME_TEXT_FIELD_BY));
        String usedName = courseName;
        if(courseName.equals("ziad")){
            usedName = randomCourseName;
        }
        courseNameTextField.sendKeys(usedName);
        return this;
    }

    public AddCoursePage enterCourseGrade(String grade){
        WebElement courseGradeDropDown = driver.findElement(COURSE_GRADE_DROP_DOWN_BY);
        courseGradeDropDown.click();

        Select courseGradeSelect = new Select(courseGradeDropDown);
        courseGradeSelect.selectByVisibleText(grade);
        return this;
    }

    public AddCoursePage enterCourseTeacher(String ownerEmail){
        WebElement courseTeacherDropDown = driver.findElement(COURSE_TEACHER_DROP_DOWN_BY);
        courseTeacherDropDown.click();
        WebElement courseTeacherDropDownOptionsTile = driver.findElement(COURSE_TEACHER_DROP_DOWN_TILE_BY);
        List<WebElement> options = courseTeacherDropDownOptionsTile.findElements(COURSE_TEACHER_DROP_DOWN_MAIL_BY);
        int chosenIndex = 0;
        for (int i = 0; i < options.size(); i++) {
            String optionText = options.get(i).getText();
            if(optionText.contains(ownerEmail)){
                chosenIndex = i;
                break;
            }
        }
        WebElement desiredOption = options.get(chosenIndex);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript(CLICKING_SCRIPT, desiredOption);
        return this;
    }

    public CreatedCoursePage clickOnCreateCourseButton(){
        WebElement createCourseButton = driver.findElement(CREATE_COURSE_BUTTON_BY);
        createCourseButton.click();
        return new CreatedCoursePage(driver);
    }

}