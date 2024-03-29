package es.ulpgc.eite.studentgrade;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.robolectric.RobolectricTestRunner;

/**
 * Created by Luis on marzo, 2022
 */
@RunWith(RobolectricTestRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentGradeTests {

  StudentGradeSteps steps = new StudentGradeSteps();


  @Test
  public void test01Scenario012A() {

    // Given
    steps.iAmOnScreen("student");
    steps.iAmOnScreenAndSeeValueOnView("student", "0", "grade");

    // When
    steps.iAmOnScreenAndPressButton("student", "outstanding");

    // Then
    steps.iAmOnScreen("grade");
    steps.iAmOnScreenAndSeeValueOnView("grade", "9", "lower");
    steps.iAmOnScreenAndSeeValueOnView("grade", "10", "higher");
  }

  @Test
  public void test02Scenario023A() {

    // Given
    steps.iAmOnScreen("student");
    steps.iAmOnScreenAndSeeValueOnView("student", "0", "grade");

    // When
    steps.iAmOnScreenAndPressButton("student", "mention");

    // Then
    steps.iAmOnScreen("grade");
    steps.iAmOnScreenAndSeeValueOnView("grade", "7", "lower");
    steps.iAmOnScreenAndSeeValueOnView("grade", "8", "higher");
  }

  @Test
  public void test03Scenario034A() {

    // Given
    steps.iAmOnScreen("student");
    steps.iAmOnScreenAndSeeValueOnView("student", "0", "grade");

    // When
    steps.iAmOnScreenAndPressButton("student", "pass");

    // Then
    steps.iAmOnScreen("grade");
    steps.iAmOnScreenAndSeeValueOnView("grade", "5", "lower");
    steps.iAmOnScreenAndSeeValueOnView("grade", "6", "higher");
  }

  // -----

  @Test
  public void test04Scenario0421A() {

    // Given
    steps.iAmOnScreen("student");
    steps.iAmOnScreenAndSeeValueOnView("student", "0", "grade");
    steps.iAmOnScreenAndPressButton("student", "outstanding");
    steps.iAmOnScreen("grade");
    steps.iAmOnScreenAndSeeValueOnView("grade", "9", "lower");
    steps.iAmOnScreenAndSeeValueOnView("grade", "10", "higher");

    // When
    steps.iAmOnScreenAndPressButton("grade", "lower");

    // Then
    steps.iBackOnScreen("student");
    steps.iAmOnScreenAndSeeValueOnView("student", "9", "grade");
  }

  @Test
  public void test05Scenario0522A() {

    // Given
    steps.iAmOnScreen("student");
    steps.iAmOnScreenAndSeeValueOnView("student", "0", "grade");
    steps.iAmOnScreenAndPressButton("student", "outstanding");
    steps.iAmOnScreen("grade");
    steps.iAmOnScreenAndSeeValueOnView("grade", "9", "lower");
    steps.iAmOnScreenAndSeeValueOnView("grade", "10", "higher");

    // When
    steps.iAmOnScreenAndPressButton("grade", "higher");

    // Then
    steps.iBackOnScreen("student");
    steps.iAmOnScreenAndSeeValueOnView("student", "10", "grade");
  }

  // -----


  @Test
  public void test06Scenario0631A() {

    // Given
    steps.iAmOnScreen("student");
    steps.iAmOnScreenAndSeeValueOnView("student", "0", "grade");
    steps.iAmOnScreenAndPressButton("student", "mention");
    steps.iAmOnScreen("grade");
    steps.iAmOnScreenAndSeeValueOnView("grade", "7", "lower");
    steps.iAmOnScreenAndSeeValueOnView("grade", "8", "higher");

    // When
    steps.iAmOnScreenAndPressButton("grade", "higher");

    // Then
    steps.iBackOnScreen("student");
    steps.iAmOnScreenAndSeeValueOnView("student", "8", "grade");
  }

  @Test
  public void test07Scenario0732A() {

    // Given
    steps.iAmOnScreen("student");
    steps.iAmOnScreenAndSeeValueOnView("student", "0", "grade");
    steps.iAmOnScreenAndPressButton("student", "mention");
    steps.iAmOnScreen("grade");
    steps.iAmOnScreenAndSeeValueOnView("grade", "7", "lower");
    steps.iAmOnScreenAndSeeValueOnView("grade", "8", "higher");

    // When
    steps.iAmOnScreenAndPressButton("grade", "lower");

    // Then
    steps.iBackOnScreen("student");
    steps.iAmOnScreenAndSeeValueOnView("student", "7", "grade");
  }

  // -----

  @Test
  public void test08Scenario0841A() {

    // Given
    steps.iAmOnScreen("student");
    steps.iAmOnScreenAndSeeValueOnView("student", "0", "grade");
    steps.iAmOnScreenAndPressButton("student", "pass");
    steps.iAmOnScreen("grade");
    steps.iAmOnScreenAndSeeValueOnView("grade", "5", "lower");
    steps.iAmOnScreenAndSeeValueOnView("grade", "6", "higher");

    // When
    steps.iAmOnScreenAndPressButton("grade", "higher");

    // Then
    steps.iBackOnScreen("student");
    steps.iAmOnScreenAndSeeValueOnView("student", "6", "grade");
  }


  @Test
  public void test09Scenario0942A() {

    // Given
    steps.iAmOnScreen("student");
    steps.iAmOnScreenAndSeeValueOnView("student", "0", "grade");
    steps.iAmOnScreenAndPressButton("student", "pass");
    steps.iAmOnScreen("grade");
    steps.iAmOnScreenAndSeeValueOnView("grade", "5", "lower");
    steps.iAmOnScreenAndSeeValueOnView("grade", "6", "higher");

    // When
    steps.iAmOnScreenAndPressButton("grade", "lower");

    // Then
    steps.iBackOnScreen("student");
    steps.iAmOnScreenAndSeeValueOnView("student", "5", "grade");
  }


  // ---------------

  @Test
  public void test10Scenario102B() {

    // Given
    steps.iAmOnScreen("student");
    steps.iAmOnScreenAndSeeValueOnView("student", "0", "grade");
    steps.iAmOnScreenAndPressButton("student", "outstanding");
    steps.iAmOnScreen("grade");

    // When
    steps.iRotateScreen("grade");

    // Then
    steps.iAmOnScreenAndSeeValueOnView("grade", "9", "lower");
    steps.iAmOnScreenAndSeeValueOnView("grade", "10", "higher");
  }

  @Test
  public void test11Scenario113B() {

    // Given
    steps.iAmOnScreen("student");
    steps.iAmOnScreenAndSeeValueOnView("student", "0", "grade");
    steps.iAmOnScreenAndPressButton("student", "mention");
    steps.iAmOnScreen("grade");

    // When
    steps.iRotateScreen("grade");

    // Then
    steps.iAmOnScreenAndSeeValueOnView("grade", "7", "lower");
    steps.iAmOnScreenAndSeeValueOnView("grade", "8", "higher");
  }

  @Test
  public void test12Scenario124B() {

    // Given
    steps.iAmOnScreen("student");
    steps.iAmOnScreenAndSeeValueOnView("student", "0", "grade");
    steps.iAmOnScreenAndPressButton("student", "pass");
    steps.iAmOnScreen("grade");

    // When
    steps.iRotateScreen("grade");

    // Then
    steps.iAmOnScreenAndSeeValueOnView("grade", "5", "lower");
    steps.iAmOnScreenAndSeeValueOnView("grade", "6", "higher");
  }


  // -----

  @Test
  public void test13Scenario1321B() {

    // Given
    steps.iAmOnScreen("student");
    steps.iAmOnScreenAndSeeValueOnView("student", "0", "grade");
    steps.iAmOnScreenAndPressButton("student", "outstanding");
    steps.iAmOnScreen("grade");
    steps.iRotateScreen("grade");
    steps.iAmOnScreenAndSeeValueOnView("grade", "9", "lower");
    steps.iAmOnScreenAndSeeValueOnView("grade", "10", "higher");
    steps.iAmOnScreenAndPressButton("grade", "lower");
    steps.iBackOnScreen("student");

    // When
    steps.iRotateScreen("student");

    // Then
    steps.iAmOnScreenAndSeeValueOnView("student", "9", "grade");
  }

  @Test
  public void test14Scenario1422B() {

    // Given
    steps.iAmOnScreen("student");
    steps.iAmOnScreenAndSeeValueOnView("student", "0", "grade");
    steps.iAmOnScreenAndPressButton("student", "outstanding");
    steps.iAmOnScreen("grade");
    steps.iRotateScreen("grade");
    steps.iAmOnScreenAndSeeValueOnView("grade", "9", "lower");
    steps.iAmOnScreenAndSeeValueOnView("grade", "10", "higher");
    steps.iAmOnScreenAndPressButton("grade", "higher");
    steps.iBackOnScreen("student");

    // When
    steps.iRotateScreen("student");

    // Then
    steps.iAmOnScreenAndSeeValueOnView("student", "10", "grade");
  }

  // -----


  @Test
  public void test15Scenario1531B() {

    // Given
    steps.iAmOnScreen("student");
    steps.iAmOnScreenAndSeeValueOnView("student", "0", "grade");
    steps.iAmOnScreenAndPressButton("student", "mention");
    steps.iAmOnScreen("grade");
    steps.iRotateScreen("grade");
    steps.iAmOnScreenAndSeeValueOnView("grade", "7", "lower");
    steps.iAmOnScreenAndSeeValueOnView("grade", "8", "higher");
    steps.iAmOnScreenAndPressButton("grade", "higher");
    steps.iBackOnScreen("student");

    // When
    steps.iRotateScreen("student");

    // Then
    steps.iAmOnScreenAndSeeValueOnView("student", "8", "grade");
  }

  @Test
  public void test16Scenario1632B() {

    // Given
    steps.iAmOnScreen("student");
    steps.iAmOnScreenAndSeeValueOnView("student", "0", "grade");
    steps.iAmOnScreenAndPressButton("student", "mention");
    steps.iAmOnScreen("grade");
    steps.iRotateScreen("grade");
    steps.iAmOnScreenAndSeeValueOnView("grade", "7", "lower");
    steps.iAmOnScreenAndSeeValueOnView("grade", "8", "higher");
    steps.iAmOnScreenAndPressButton("grade", "lower");
    steps.iBackOnScreen("student");

    // When
    steps.iRotateScreen("student");

    // Then
    steps.iAmOnScreenAndSeeValueOnView("student", "7", "grade");
  }

  // -----

  @Test
  public void test17Scenario1741B() {

    // Given
    steps.iAmOnScreen("student");
    steps.iAmOnScreenAndSeeValueOnView("student", "0", "grade");
    steps.iAmOnScreenAndPressButton("student", "pass");
    steps.iAmOnScreen("grade");
    steps.iRotateScreen("grade");
    steps.iAmOnScreenAndSeeValueOnView("grade", "5", "lower");
    steps.iAmOnScreenAndSeeValueOnView("grade", "6", "higher");
    steps.iAmOnScreenAndPressButton("grade", "higher");
    steps.iBackOnScreen("student");

    // When
    steps.iRotateScreen("student");

    // Then
    steps.iAmOnScreenAndSeeValueOnView("student", "6", "grade");
  }


  @Test
  public void test18Scenario1842B() {

    // Given
    steps.iAmOnScreen("student");
    steps.iAmOnScreenAndSeeValueOnView("student", "0", "grade");
    steps.iAmOnScreenAndPressButton("student", "pass");
    steps.iAmOnScreen("grade");
    steps.iRotateScreen("grade");
    steps.iAmOnScreenAndSeeValueOnView("grade", "5", "lower");
    steps.iAmOnScreenAndSeeValueOnView("grade", "6", "higher");
    steps.iAmOnScreenAndPressButton("grade", "lower");
    steps.iBackOnScreen("student");

    // When
    steps.iRotateScreen("student");

    // Then
    steps.iAmOnScreenAndSeeValueOnView("student", "5", "grade");
  }


  // -----


  @Test
  public void test19Scenario195A() {

    // Given
    steps.iAmOnScreen("student");
    steps.iAmOnScreenAndSeeValueOnView("student", "0", "grade");
    steps.iAmOnScreenAndPressButton("student", "pass");
    steps.iAmOnScreen("grade");
    steps.iAmOnScreenAndSeeValueOnView("grade", "5", "lower");
    steps.iAmOnScreenAndSeeValueOnView("grade", "6", "higher");

    steps.iAmOnScreenAndPressButton("grade", "lower");
    steps.iBackOnScreen("student");
    steps.iAmOnScreenAndSeeValueOnView("student", "5", "grade");
    steps.iAmOnScreenAndPressButton("student", "mention");
    steps.iAmOnScreen("grade");
    steps.iRotateScreen("grade");
    steps.iAmOnScreenAndSeeValueOnView("grade", "7", "lower");
    steps.iAmOnScreenAndSeeValueOnView("grade", "8", "higher");

    // When
    steps.iAmOnScreenAndPressButton("grade", "back");

    // Then
    steps.iBackOnScreen("student");
    // Then
    steps.iAmOnScreenAndSeeValueOnView("student", "5", "grade");
  }

  @Test
  public void test20Scenario205B() {

    // Given
    steps.iAmOnScreen("student");
    steps.iAmOnScreenAndSeeValueOnView("student", "0", "grade");
    steps.iAmOnScreenAndPressButton("student", "pass");
    steps.iAmOnScreen("grade");
    steps.iAmOnScreenAndSeeValueOnView("grade", "5", "lower");
    steps.iAmOnScreenAndSeeValueOnView("grade", "6", "higher");
    steps.iAmOnScreenAndPressButton("grade", "lower");
    steps.iBackOnScreen("student");
    steps.iAmOnScreenAndSeeValueOnView("student", "5", "grade");
    steps.iAmOnScreenAndPressButton("student", "mention");
    steps.iAmOnScreen("grade");
    steps.iRotateScreen("grade");
    steps.iAmOnScreenAndSeeValueOnView("grade", "7", "lower");
    steps.iAmOnScreenAndSeeValueOnView("grade", "8", "higher");
    steps.iAmOnScreenAndPressButton("grade", "back");
    steps.iBackOnScreen("student");

    // When
    steps.iRotateScreen("student");

    // Then
    steps.iAmOnScreenAndSeeValueOnView("student", "5", "grade");
  }

}
