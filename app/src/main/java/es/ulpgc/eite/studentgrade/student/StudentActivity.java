package es.ulpgc.eite.studentgrade.student;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.eite.studentgrade.R;
import es.ulpgc.eite.studentgrade.grade.GradeActivity;

/**
 * Created by Luis on marzo, 2022
 */
public class StudentActivity
    extends AppCompatActivity implements StudentContract.View {

  public static String TAG = "StudentGrade.StudentActivity";

  private StudentContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_student);
    getSupportActionBar().setTitle(R.string.title_student_screen);

    Log.e(TAG, "onCreate()");

    // do the setup
    StudentScreen.configure(this);

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
    //Log.e(TAG, "onDestroy()");

    presenter.onDestroy();
  }


  public void onOutstandingGradeBtnClicked(View view) {
    presenter.onOutstandingGradeBtnClicked();
  }

  public void onMentionGradeBtnClicked(View view) {
    presenter.onMentionGradeBtnClicked();
  }

  public void onPassGradeBtnClicked(View view) {
    presenter.onPassGradeBtnClicked();
  }

  @Override
  public void onDataUpdated(StudentViewModel viewModel) {
    Log.e(TAG, "onDataUpdated()");

    // deal with the data
    ((TextView) findViewById(R.id.tvStudentGrade)).setText(viewModel.data);
  }


  @Override
  public void navigateToNextScreen() {
    Log.e(TAG, "navigateToNextScreen()");

    Intent intent = new Intent(this, GradeActivity.class);
    startActivity(intent);
  }

  @Override
  public void injectPresenter(StudentContract.Presenter presenter) {
    this.presenter = presenter;
  }


}
