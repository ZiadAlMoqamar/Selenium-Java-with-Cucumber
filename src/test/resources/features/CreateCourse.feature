Feature: Create course

 Scenario Outline: User can create course
    Given user was on the website
    And user was logged in with "testregister@aaa.com" as email and "Wakram_123" as password
    When user goes to courses page
    And user creates new course with "<courseName>" as course name and "<grade>" as grade and "<ownerEmail>" as owner email
    Then course with "<courseName>" as course name will be created successfully

   Examples:
    | courseName| grade           | ownerEmail                 |
    | ziad      | 1               | nada.rehan@aaa.com         |
    | mai       | Higher Education| Test.teacher@mailinator.com|
