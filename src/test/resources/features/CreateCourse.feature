Feature: Create course

  Scenario: User can create course
    Given user was on the website
    And user was logged in
    When user goes to courses page
    And user creates new course
    Then course will be created successfully
