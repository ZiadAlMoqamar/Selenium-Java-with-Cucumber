package stepsdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;

import java.time.Duration;
import java.util.List;

public class CreateCourse {
    WebDriver driver = new ChromeDriver();
    String randomCourseName = "ziad" + (int) (Math.random() * 1000);

    public CreateCourse(){}

    @Given("user was on the website")
    public void userWasOnTheWebsite(){
        driver.get("https://swinji.azurewebsites.net");
    }

    @And("user was logged in")
    @And("user was logged in with {string} as email and {string} as password")
    public void userWasLoggedInWithAnd(String email, String password) {
        WebElement emailTextField = driver.findElement(By.cssSelector("#Email"));
        emailTextField.sendKeys("testregister@aaa.com");

        WebElement passwordTextField = driver.findElement(By.cssSelector("#inputPassword"));
        passwordTextField.sendKeys("Wakram_123");

        WebElement loginButton = driver.findElement(By.cssSelector("#btnLogin"));
        loginButton.click();
    }

    @When("user goes to courses page")
    public void userGoesToCoursesPage() {
        WebElement coursesButton = driver.findElement(By.cssSelector("#btnMyCoursesList"));
        coursesButton.click();
    }

    @And("user creates new course with {string} as course name and {string} as grade and {string} as owner email")
    public void userCreatesNewCourseWithAsCourseNameAndAsGradeAndAsTeacherName(String courseName, String grade, String teacherName) {
        WebElement addCourseButton = driver.findElement(By.cssSelector("#btnListAddCourse"));
        addCourseButton.click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement courseNameTextField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#txtCourseName")));
        String usedName = courseName;
        if(courseName.equals("ziad")){
            usedName = randomCourseName;
        }
        courseNameTextField.sendKeys(usedName);

        WebElement courseGradeDropDown = driver.findElement(By.cssSelector("#courseGrade"));
        courseGradeDropDown.click();

        Select courseGradeSelect = new Select(courseGradeDropDown);
        courseGradeSelect.selectByVisibleText(grade);

        WebElement courseTeacherDropDown = driver.findElement(By.xpath("//*[@id='teacherOnBehalf']/div[1]/span"));
        courseTeacherDropDown.click();
        WebElement box = driver.findElement(By.cssSelector(".ui-select-choices.ui-select-choices-content.ui-select-dropdown.dropdown-menu"));

        List<WebElement> options = box.findElements(By.id("lnkCourseOwnerMail"));
        int chosenIndex = 0;
        for (int i = 0; i < options.size(); i++) {
            String optionText = options.get(i).getText();
            if(optionText.contains(teacherName)){
               chosenIndex = i;
               break;
            }
        }
        options.get(chosenIndex).click();


        WebElement createCourseButton = driver.findElement(By.cssSelector("#btnSaveAsDraftCourse"));
        createCourseButton.click();
    }

    @Then("course with {string} as course name will be created successfully")
    public void courseWithAsCourseNameWillBeCreatedSuccessfully(String courseName) {
        try {
            WebElement coursesButton = driver.findElement(By.cssSelector("#btnMyCoursesList"));
            coursesButton.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebElement coursesButton = driver.findElement(By.cssSelector("#btnMyCoursesList"));
            coursesButton.click();
        }

        WebElement searchTextField = driver.findElement(By.cssSelector("#txtCourseSearch"));
        String usedName = courseName;
        if(courseName.equals("ziad")){
            usedName = randomCourseName;
        }
        searchTextField.sendKeys(usedName);

        WebElement searchIcon = driver.findElement(By.xpath("//em[@class='fa fa-search fa-lg']"));
        searchIcon.click();

        WebDriverWait searchResultsWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        searchResultsWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='lnkListCourseSelcted']")));
        List<WebElement> searchResults = driver.findElements(By.xpath("//*[@id='lnkListCourseSelcted']"));
        assertTrue(searchResults.getFirst().getText().contains(usedName));

        driver.quit();
    }

}
