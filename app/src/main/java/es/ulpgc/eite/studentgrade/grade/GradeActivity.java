package es.ulpgc.eite.studentgrade.grade;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.eite.studentgrade.R;

/**
 * Created by Luis on marzo, 2022
 */
public class GradeActivity
    extends AppCompatActivity implements GradeContract.View {

  public static String TAG = "StudentGrade.GradeActivity";

  private GradeContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_grade);
    getSupportActionBar().setTitle(R.string.title_grade_screen);


    Log.e(TAG, "onCreate()");

    // do the setup
    GradeScreen.configure(this);

    if (savedInstanceState == null) {
      presenter.onStart();

    } else {
      presenter.onRestart();
    }
  }

  @Override
  protected void onResume() {
    super.onResume();
    Log.e(TAG, "onResume()");

    // load the data
    presenter.onResume();
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    Log.e(TAG, "onBackPressed()");

    presenter.onBackPressed();
  }

  @Override
  protected void onPause() {
    super.onPause();
    Log.e(TAG, "onPause()");

    presenter.onPause();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    Log.e(TAG, "onDestroy()");

    presenter.onDestroy();
  }


  public void onHigherGradeBtnClicked(View view) {
    presenter.onHigherGradeBtnClicked();
  }

  public void onLowerGradeBtnClicked(View view) {
    presenter.onLowerGradeBtnClicked();

  }

  @Override
  public void onDataUpdated(GradeViewModel viewModel) {
    Log.e(TAG, "onDataUpdated()");

    // deal with the data
    String[] data = viewModel.data.split(",");
    ((TextView) findViewById(R.id.btnLowerGrade)).setText(data[0]);
    ((TextView) findViewById(R.id.btnHigherGrade)).setText(data[1]);
  }

  @Override
  public void navigateToPreviousScreen() {
    Log.e(TAG, "navigateToPreviousScreen()");

    finish();
  }


  @Override
  public void injectPresenter(GradeContract.Presenter presenter) {
    this.presenter = presenter;
  }
}
