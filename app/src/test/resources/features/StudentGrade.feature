Feature: StudentGrade


  Scenario Outline: Scenario 1
    Given I am on "<screen1>" screen
    And I rotate "<screen1>" screen
    And I am on "<screen2>" screen and see "<val0>" value on "<view0>" view
    When I am on "<screen1>" screen and press "<button>" button
    Then I am on "<screen2>" screen
    And I am on "<screen2>" screen and see "<val1>" value on "<view1>" view
    And I am on "<screen2>" screen and see "<val2>" value on "<view2>" view

    Examples:
      | screen1 | val0 | view0 | button      | screen2 | val1 | view1 | val2 | view2  |
      | student | 0    | grade | outstanding | grade   | 9    | lower | 10   | higher |
      | student | 0    | grade | mention     | grade   | 7    | lower | 8    | higher |
      | student | 0    | grade | pass        | grade   | 5    | lower | 6    | higher |


  Scenario Outline: Scenario 2
    Given I am on "<screen2>" screen
    And I rotate "<screen2>" screen
    And I am on "<screen2>" screen and see "<val1>" value on "<view1>" view
    And I am on "<screen2>" screen and see "<val2>" value on "<view2>" view
    When I am on "<screen2>" screen and press "<button>" button
    Then I back on "<screen1>" screen
    And I am on "<screen1>" screen and see "<val0>" value on "<view0>" view

    Examples:
      | screen2 | val1 | view1 | val2 | view2  | button | screen1 | val0 | view0 |
      | grade   | 9    | lower | 10   | higher | higher | student | 10   | grade |
      | grade   | 9    | lower | 10   | higher | lower  | student | 9    | grade |
      | grade   | 7    | lower | 8    | higher | higher | student | 8    | grade |
      | grade   | 7    | lower | 8    | higher | lower  | student | 7    | grade |
      | grade   | 5    | lower | 6    | higher | higher | student | 6    | grade |
      | grade   | 5    | lower | 6    | higher | lower  | student | 5    | grade |


  Scenario Outline: Scenario 3
    Given I am on "<screen2>" screen
    And I am on "<screen2>" screen and see "<val1>" value on "<view1>" view
    And I am on "<screen2>" screen and see "<val2>" value on "<view2>" view
    When I am on "<screen2>" screen and press "<button>" button
    Then I back on "<screen1>" screen
    And I am on "<screen1>" screen and see "<val0>" value on "<view0>" view

    Examples:
      | screen2 | val1 | view1 | val2 | view2  | button | screen1 | val0 | view0 |
      | grade   | 9    | lower | 10   | higher | back   | student | 0    | grade |
      | grade   | 7    | lower | 8    | higher | back   | student | 0    | grade |
      | grade   | 5    | lower | 6    | higher | back   | student | 0    | grade |
