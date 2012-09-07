package co.problemmatrix.client.interviews.problems.edit;

import co.problemmatrix.client.home.ProblemMatrixPanel;
import co.problemmatrix.client.interviews.problems.ListProblemsInterviewButton;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EditProblemInterviewPage extends VerticalPanel {

	public static JSONObject interview = new JSONObject();

	public EditProblemInterviewPage(final JSONObject interviewParameter) {

		interview = interviewParameter;

		this.setSpacing(20);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		HorizontalPanel hp = new HorizontalPanel();

		hp.add(new EditProblemInterview());

		hp.add(new EditProblemInterviewQuestions(false));

		this.add(hp);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.add(new ButtonSaveProblemInterview());
	}

	public static void showButtons(final JSONObject interviewJson) {

		ProblemMatrixPanel.hpButtons.clear();

		ProblemMatrixPanel.hpButtons.add(new RefreshProblemInterviewButton(
				interviewJson));

		ProblemMatrixPanel.hpButtons.add(new ListProblemsInterviewButton());
	}
}
