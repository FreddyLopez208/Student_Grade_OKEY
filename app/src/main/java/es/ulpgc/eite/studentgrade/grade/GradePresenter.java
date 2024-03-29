package es.ulpgc.eite.studentgrade.grade;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.studentgrade.app.AppMediator;
import es.ulpgc.eite.studentgrade.app.GradeToStudentState;
import es.ulpgc.eite.studentgrade.app.StudentToGradeState;

/**
 * Created by Luis on marzo, 2022
 */
public class GradePresenter implements GradeContract.Presenter {

  public static String TAG = "StudentGrade.GradePresenter";

  private WeakReference<GradeContract.View> view;
  private GradeState state;
  private GradeContract.Model model;
  private AppMediator mediator;

  public GradePresenter(AppMediator mediator) {
    this.mediator = mediator;
    state = mediator.getGradeState();
  }

  @Override
  public void onStart() {
    // Log.e(TAG, "onStart()");

    // TODO: include code here if is necessary

    // Debemos crear un nuevo StudentState y guardarlo en nuestro estado.

    // Conectamos al modelo para que este nos de sus datos y lo guardamos
    // dentro de nuestro estado en data.
    state.data = model.getStoredData();

    // A diferencia de la anterior pantalla, aqui si es probable que recibamos
    // un estado de la otra pantalla tras iniciar por primera vez.
    // use passed state if is necessary
    StudentToGradeState savedState = getStateFromPreviousScreen();
    if (savedState != null) {

      // TODO: include code here if is necessary

      // Actualizamos el modelo si es necesario
      //model.onDataFromPreviousScreen(savedState.data);

      // Actualizamos nuestro estado
      state.data = savedState.data;

    }

    // TODO: include code here if is necessary
     view.get().onDataUpdated(state);
  }

  @Override
  public void onRestart() {
    // Log.e(TAG, "onRestart()");

    // TODO: include code here if is necessary
    StudentToGradeState savedState = getStateFromPreviousScreen();
    if (savedState != null) {

      // TODO: include code here if is necessary

      // Actualizamos nuestro estado
      state.data = savedState.data;
    }


    // Actualizamos la vista.
    view.get().onDataUpdated(state);  }

  @Override
  public void onResume() {
    // Log.e(TAG, "onResume()");

    // TODO: include code here if is necessary

  }

  @Override
  public void onBackPressed() {
    // Log.e(TAG, "onBackPressed()");

    // TODO: include code here if is necessary
  }

  @Override
  public void onPause() {
    // Log.e(TAG, "onPause()");

    // TODO: include code here if is necessary
  }

  @Override
  public void onDestroy() {
    // Log.e(TAG, "onDestroy()");

    // TODO: include code here if is necessary
  }


  @Override
  public void onHigherGradeBtnClicked() {

    // TODO: include code here if is necessary
    // Eliminamos la coma y guardamos las notas de nuestro estado en un array.
    String data [] = state.data.split(",");

    //-------------------SE REPITE CADA VEZ QUE SE PULSA UN BOTÓN------------------------

   // Creamos un nuevo estado copia para pasar a la pantalla anterior.
    GradeToStudentState newState = new GradeToStudentState();
    // Guardamos en nuestro estado temporal la posicion 1 de nuestro array de notas
    // que tiene la nota mayor.
    newState.data = data[1];

    // Pasamos nuestro estado copia al mediador para poderlo coger en la otra pantalla.
    passStateToPreviousScreen(newState);

    // Navegamos a la pantalla anterior.
    view.get().navigateToPreviousScreen();
  }

  @Override
  public void onLowerGradeBtnClicked() {

    // TODO: include code here if is necessary

    // Eliminamos la coma y guardamos las notas de nuestro estado en un array.
    String data [] = state.data.split(",");

    //-------------------SE REPITE CADA VEZ QUE SE PULSA UN BOTÓN------------------------

    // Creamos un nuevo estado copia para pasar a la pantalla anterior.
    GradeToStudentState newState = new GradeToStudentState();
    // Guardamos en nuestro estado temporal la posicion 0 de nuestro array de notas
    // que tiene la nota menor.
    newState.data = data[0];

    // Pasamos nuestro estado copia al mediador para poderlo coger en la otra pantalla.
    passStateToPreviousScreen(newState);

    // Navegamos a la pantalla anterior.
    view.get().navigateToPreviousScreen();

  }

  private void passStateToPreviousScreen(GradeToStudentState state) {
    mediator.setPreviousGradeScreenState(state);
  }

  private StudentToGradeState getStateFromPreviousScreen() {
    return mediator.getPreviousGradeScreenState();
  }

  @Override
  public void injectView(WeakReference<GradeContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(GradeContract.Model model) {
    this.model = model;
  }

}
