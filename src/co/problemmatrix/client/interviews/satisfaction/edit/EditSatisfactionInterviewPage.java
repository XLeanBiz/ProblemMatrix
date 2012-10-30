package co.problemmatrix.client.interviews.satisfaction.edit;

import co.problemmatrix.client.home.ProblemMatrixPanel;
import co.problemmatrix.client.interviews.satisfaction.ListSatisfactionInterviewButton;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EditSatisfactionInterviewPage extends VerticalPanel {

	public static JSONObject interview = new JSONObject();

	public EditSatisfactionInterviewPage(JSONObject interviewParameter) {

		interview = interviewParameter;

		this.setSpacing(20);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		HorizontalPanel hp = new HorizontalPanel();

		hp.add(new EditSatisfactionInterview(interview));

		hp.add(new EditSatisfactionInterviewQuestions(interview, false));

		this.add(hp);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.add(new ButtonSaveSatisfactionInterview());
	}

	public static void showButtons(final JSONObject interviewJson) {

		ProblemMatrixPanel.hpButtons.clear();

		//ProblemMatrixPanel.hpButtons
			//	.add(new RefreshSatisfactionInterviewButton(interviewJson));

		ProblemMatrixPanel.hpButtons
				.add(new ListSatisfactionInterviewButton());
	}
}
