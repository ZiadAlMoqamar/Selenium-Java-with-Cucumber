package utils.interfaces;

import pageobjects.AddCoursePage;
import utils.parameters.CourseParameters;

public interface CoursePageUtility {
    AddCoursePage createCourse(CourseParameters parameters);
}

