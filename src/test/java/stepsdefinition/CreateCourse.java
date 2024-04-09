package stepsdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobjects.*;

import static org.junit.Assert.*;


public class CreateCourse extends Hooks {
    WebDriver driver;
    LoginPage loginPage;
    LandingPage landingPage;
    CoursesPage coursesPage;
    AddCoursePage addCoursePage;
    CreatedCoursePage createdCoursePage;
    String randomCourseName = "ziad" + (int) (Math.random() * 1000);

    @Before
    public void init(){
        super.setUp();
        this.driver = getDriver();
    }

    @After
    public void cleanUp(){
        super.tearDown();
    }
    @Given("user was on the website")
    public void userWasOnTheWebsite(){
        loginPage = new LoginPage(driver);
    }

    @And("user was logged in with {string} as email and {string} as password")
    public void userWasLoggedInWithAnd(String email, String password) {
        loginPage = loginPage
                .enterEmail(email)
                .enterPassword(password);
        landingPage = loginPage.pressLoginButton();
    }

    @When("user goes to courses page")
    public void userGoesToCoursesPage() {
        coursesPage = landingPage.clickOnCoursesButton();
    }

    @And("user creates new course with {string} as course name and {string} as grade and {string} as owner email")
    public void userCreatesNewCourseWithCourseNameAndGradeAndTeacherName(String courseName, String grade, String ownerEmail) {
        addCoursePage = coursesPage.clickOnAddCoursePage()
                .enterCourseName(courseName,randomCourseName)
                .enterCourseGrade(grade)
                .enterCourseTeacher(ownerEmail);
        createdCoursePage = addCoursePage.clickOnCreateCourseButton();
    }

    @Then("course with {string} as course name will be created successfully")
    public void courseWithAsCourseNameWillBeCreatedSuccessfully(String courseName) {
        coursesPage = createdCoursePage.clickOnCoursesButton()
                .enterSearchCourseName(courseName,randomCourseName)
                .selectCreationDateDescendingOrder()
                .clickOnSearchIcon();
        String usedName = courseName;
        if(courseName.equals("ziad")){
            usedName = randomCourseName;
        }
        assertTrue(coursesPage.getCreatedCourseName().contains(usedName));
    }
}