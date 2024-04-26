package stepsdefinition;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobjects.LoginPage;

import static org.junit.Assert.assertEquals;


public class LandingTheWebsite{
    private final CreateCourse createCourseObj;
    WebDriver driver;
    LoginPage loginPage;

    public LandingTheWebsite(TestContext context){
        createCourseObj = new CreateCourse(context);
        this.driver = createCourseObj.driver;
    }

    @When("user goes to the website")
    public void userGoesOnTheWebsite(){
        loginPage = createCourseObj.userWasOnTheWebsite();
    }

    @Then("User will be on the login page")
    public void userWillBeOnTheLoginPage(){
        final String LOGIN_HEADER = "Login";
        assertEquals(loginPage.getLoginPageHeader(),LOGIN_HEADER);
    }

}
