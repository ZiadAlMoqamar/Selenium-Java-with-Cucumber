package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://swinji.azurewebsites.net");

        WebElement emailTextField = driver.findElement(By.cssSelector("#Email"));
        emailTextField.sendKeys("testregister@aaa.com");

        WebElement passwordTextField = driver.findElement(By.cssSelector("#inputPassword"));
        passwordTextField.sendKeys("Wakram_123");

        WebElement loginButton = driver.findElement(By.cssSelector("#btnLogin"));
        loginButton.click();

        WebElement coursesButton = driver.findElement(By.cssSelector("#btnMyCoursesList"));
        coursesButton.click();

        WebElement addCourseButton = driver.findElement(By.cssSelector("#btnListAddCourse"));
        addCourseButton.click();

        String courseName = "ziad" + (int) (Math.random() * 1000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement courseNameTextField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#txtCourseName")));
       // WebElement courseNameTextField = driver.findElement(By.cssSelector("#txtCourseName"));
        courseNameTextField.sendKeys(courseName);

        WebElement courseGradeDropDown = driver.findElement(By.cssSelector("#courseGrade"));
        courseGradeDropDown.click();

        Select courseGradeSelect = new Select(courseGradeDropDown);

        // Select the option by visible text
        courseGradeSelect.selectByVisibleText("2");

        WebElement courseTeacherDropDown = driver.findElement(By.xpath("//*[@id='teacherOnBehalf']/div[1]/span"));
        courseTeacherDropDown.click();
        WebElement box = driver.findElement(By.cssSelector(".ui-select-choices.ui-select-choices-content.ui-select-dropdown.dropdown-menu"));

        List<WebElement> options = box.findElements(By.id("UserRole"));
        options.getFirst().click();


        WebElement createCourseButton = driver.findElement(By.cssSelector("#btnSaveAsDraftCourse"));
        createCourseButton.click();


        try {
            coursesButton.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            coursesButton = driver.findElement(By.cssSelector("#btnMyCoursesList"));
            coursesButton.click();
        }

        WebElement searchTextField = driver.findElement(By.cssSelector("#txtCourseSearch"));
        searchTextField.sendKeys(courseName);

        WebElement searchIcon = driver.findElement(By.xpath("//em[@class='fa fa-search fa-lg']"));
        searchIcon.click();

        WebDriverWait searchResultsWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        searchResultsWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='lnkListCourseSelcted']")));
        List<WebElement> searchResults = driver.findElements(By.xpath("//*[@id='lnkListCourseSelcted']"));

        System.out.println(searchResults.getFirst().getText().contains(courseName));

    }
}