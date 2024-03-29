package es.ulpgc.eite.studentgrade.app;

import es.ulpgc.eite.studentgrade.grade.GradeState;
import es.ulpgc.eite.studentgrade.student.StudentState;

/**
 * Created by Luis on marzo, 2022
 */
@SuppressWarnings("unused")
public class AppMediator {

  private static AppMediator INSTANCE;

  private  GradeState mGradeState;
  private StudentState mStudentState;

  private StudentToGradeState mStudentToGradeState;
  private GradeToStudentState mGradeToStudentState;

  private AppMediator() {
    mStudentState = new StudentState();
    mGradeState = new GradeState();
  }

  public static AppMediator getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new AppMediator();
    }

    return INSTANCE;
  }

  // to reset the state when testing
  public static void resetInstance() {
    INSTANCE = null;
  }

  public StudentState getStudentState() {
    return mStudentState;
  }


  public GradeState getGradeState() {
    return mGradeState;
  }

  public GradeToStudentState getNextStudentScreenState() {
    GradeToStudentState state = mGradeToStudentState;
    mGradeToStudentState=null;
    return state;
  }

  public void setNextStudentScreenState(StudentToGradeState state) {
    mStudentToGradeState=state;
  }


  public void setPreviousGradeScreenState(GradeToStudentState state) {
    mGradeToStudentState=state;
  }

  public StudentToGradeState getPreviousGradeScreenState() {
    StudentToGradeState state = mStudentToGradeState;
    mStudentToGradeState=null;
    return state;
  }

}
