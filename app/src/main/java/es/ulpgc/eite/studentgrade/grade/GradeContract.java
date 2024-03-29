package es.ulpgc.eite.studentgrade.grade;

import java.lang.ref.WeakReference;

/**
 * Created by Luis on marzo, 2022
 */
public interface GradeContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void onDataUpdated(GradeViewModel viewModel);

    void navigateToPreviousScreen();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void onResume();

    void onStart();

    void onRestart();

    void onBackPressed();

    void onPause();

    void onDestroy();

    void onHigherGradeBtnClicked();

    void onLowerGradeBtnClicked();
  }

  interface Model {
    String getStoredData();

    void onRestartScreen(String data);

    void onDataFromPreviousScreen(String data);
  }

}
