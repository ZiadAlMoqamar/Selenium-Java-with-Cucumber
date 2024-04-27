package utils;

import pageobjects.AddCoursePage;
import pageobjects.CoursesPage;
import utils.interfaces.CoursePageUtility;
import utils.parameters.CourseParameters;

public class CoursePageUtilityImpl implements CoursePageUtility {
    private final CoursesPage coursesPage;

    public CoursePageUtilityImpl(CoursesPage coursesPage) {
        this.coursesPage = coursesPage;
    }

    @Override
    public AddCoursePage createCourse(CourseParameters parameters) {
        return coursesPage.clickOnAddCoursePage()
                .enterCourseName(parameters.getCourseName(), parameters.getRandomCourseName())
                .enterCourseGrade(parameters.getGrade())
                .enterCourseTeacher(parameters.getOwnerEmail());
    }
}

