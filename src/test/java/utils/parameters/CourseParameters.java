package utils.parameters;

public class CourseParameters {
    private String courseName;
    private String randomCourseName;
    private String grade;
    private String ownerEmail;

    // getters
    public String getCourseName() {
        return courseName;
    }

    public String getRandomCourseName() {
        return randomCourseName;
    }

    public String getGrade() {
        return grade;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    // setters
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setRandomCourseName(String randomCourseName) {
        this.randomCourseName = randomCourseName;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }
}
