package es.ulpgc.eite.studentgrade.student;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.studentgrade.app.AppMediator;
import es.ulpgc.eite.studentgrade.app.GradeToStudentState;
import es.ulpgc.eite.studentgrade.app.StudentToGradeState;

/**
 * Created by Luis on marzo, 2022
 */
public class StudentPresenter implements StudentContract.Presenter {

  public static String TAG = "StudentGrade.StudentPresenter";

  private WeakReference<StudentContract.View> view;
  private StudentState state;
  private StudentContract.Model model;
  private AppMediator mediator;

  public StudentPresenter(AppMediator mediator) {
    this.mediator = mediator;
    state = mediator.getStudentState();
  }

  @Override
  public void onStart() {
    Log.e(TAG, "onStart()");

    // TODO: include code here if is necessary

    // Debemos crear un nuevo StudentState y guardarlo en nuestro estado.

    // Conectamos al modelo para que este nos de sus datos y lo guardamos
    // dentro de nuestro estado en data.
    state.data = model.getStoredData();
  }

  @Override
  public void onRestart() {
    Log.e(TAG, "onRestart()");

    // TODO: include code here if is necessary

    // Ponemos en nuestro modelo el valor que tengamos en nuestro estado.

    GradeToStudentState savedState = getStateFromNextScreen();
    if (savedState != null) {

      // TODO: include code here if is necessary

      // Actualizamos nuestro estado
      state.data = savedState.data;
    }


    // Actualizamos la vista.
    view.get().onDataUpdated(state);

  }

  @Override
  public void onResume() {
    Log.e(TAG, "onResume()");

    // use passed state if is necessary
    GradeToStudentState savedState = getStateFromNextScreen();
    if (savedState != null) {

      // TODO: include code here if is necessary



      // Actualizamos nuestro estado
      state.data = savedState.data;
    }

    // TODO: include code here if is necessary

    // Actualizamos la vista
    view.get().onDataUpdated(state);
  }

  @Override
  public void onBackPressed() {
    // Log.e(TAG, "onBackPressed()");

    // TODO: include code here if is necessary
  }

  @Override
  public void onPause() {
    Log.e(TAG, "onPause()");

    // TODO: include code here if is necessary

  }

  @Override
  public void onDestroy() {
    // Log.e(TAG, "onDestroy()");

    // TODO: include code here if is necessary

  }

  @Override
  public void onOutstandingGradeBtnClicked() {

    // TODO: include code here if is necessary

    //Maxima nota que es un 9 o 10
    String nota = "9,10";

//-------------------SE REPITE CADA VEZ QUE SE PULSA UN BOTÓN------------------------

    // Creamos un nuevo estado copia que se pasara a la otra pantalla.
    StudentToGradeState newState = new StudentToGradeState();

    // A ese estado copia le metemos nuestra nota que aqui es 9 o 10
    newState.data = nota;

    // Pasamos al mediador el estado de la pantalla actual.
    passStateToNextScreen(newState);

    // Navegamos a la otra pantalla
    view.get().navigateToNextScreen();
  }

  @Override
  public void onMentionGradeBtnClicked() {

    // TODO: include code here if is necessary

    String nota = "7,8";

    //-------------------SE REPITE CADA VEZ QUE SE PULSA UN BOTÓN------------------------

    // Creamos un nuevo estado copia que se pasara a la otra pantalla.
    StudentToGradeState newState = new StudentToGradeState();

    // A ese estado copia le metemos nuestra nota que aqui es 9 o 10
    newState.data = nota;

    // Pasamos al mediador el estado de la pantalla actual.
    passStateToNextScreen(newState);

    // Navegamos a la otra pantalla
    view.get().navigateToNextScreen();
  }

  @Override
  public void onPassGradeBtnClicked() {

    // TODO: include code here if is necessary

    String nota = "5,6";

    //-------------------SE REPITE CADA VEZ QUE SE PULSA UN BOTÓN------------------------

    // Creamos un nuevo estado copia que se pasara a la otra pantalla.
    StudentToGradeState newState = new StudentToGradeState();

    // A ese estado copia le metemos nuestra nota que aqui es 9 o 10
    newState.data = nota;

    state.data = nota;

    // Pasamos al mediador el estado de la pantalla actual.
    passStateToNextScreen(newState);

    // Navegamos a la otra pantalla
    view.get().navigateToNextScreen();

  }

  private GradeToStudentState getStateFromNextScreen() {
    return mediator.getNextStudentScreenState();
  }

  private void passStateToNextScreen(StudentToGradeState state) {
    mediator.setNextStudentScreenState(state);
  }


  @Override
  public void injectView(WeakReference<StudentContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(StudentContract.Model model) {
    this.model = model;
  }

}
