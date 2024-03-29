package es.ulpgc.eite.studentgrade.student;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.studentgrade.R;
import es.ulpgc.eite.studentgrade.app.AppMediator;

/**
 * Created by Luis on marzo, 2022
 */
public class StudentScreen {

  public static void configure(StudentContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = AppMediator.getInstance();
    StudentContract.Presenter presenter = new StudentPresenter(mediator);

    String data = context.get().getString(R.string.default_student_grade);
    StudentContract.Model model = new StudentModel(data);

    presenter.injectModel(model);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
