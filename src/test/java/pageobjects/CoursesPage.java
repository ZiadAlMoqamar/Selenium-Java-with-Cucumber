package pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CoursesPage {
    private static final By ADD_COURSE_BUTTON_BY = By.cssSelector("#btnListAddCourse");
    private static final By SEARCH_TEXT_FIELD_BY = By.cssSelector("#txtCourseSearch");
    private static final By SEARCH_ICON_BY = By.xpath("//em[@class='fa fa-search fa-lg']");
    private static final By SEARCH_RESULT_BY = By.xpath("//*[@id='lnkListCourseSelcted']");
    private static final By COURSES_ORDER_DROP_DOWN_BY = By.id("CoursesOrderBy");
    private static final String CREATION_DATE_DESCENDING_OPTION ="Creation Date Descending";
    WebDriver driver;

    public CoursesPage(WebDriver driver){
        this.driver = driver;
    }

    public AddCoursePage clickOnAddCoursePage(){
        WebElement addCourseButton = driver.findElement(ADD_COURSE_BUTTON_BY);
        addCourseButton.click();
        return new AddCoursePage(driver);
    }

    public CoursesPage enterSearchCourseName(String courseName, String randomCourseName){
        WebElement searchTextField = driver.findElement(SEARCH_TEXT_FIELD_BY);
        String usedName = courseName;
        if(courseName.equals("ziad")){
            usedName = randomCourseName;
        }
        searchTextField.sendKeys(usedName);

        return this;
    }

    public CoursesPage selectCreationDateDescendingOrder(){
        WebElement coursesOrderByDropDown = driver.findElement(COURSES_ORDER_DROP_DOWN_BY);
        Select coursesOrderSelect = new Select(coursesOrderByDropDown);
        coursesOrderSelect.selectByVisibleText(CREATION_DATE_DESCENDING_OPTION);
        return this;
    }
    public CoursesPage clickOnSearchIcon(){
        WebElement searchIcon = driver.findElement(SEARCH_ICON_BY);
        searchIcon.click();
        return this;
    }

    public String getCreatedCourseName(){
        WebDriverWait searchResultsWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        searchResultsWait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_RESULT_BY));
        List<WebElement> searchResults = driver.findElements(SEARCH_RESULT_BY);
        return searchResults.get(0).getText();
    }
}