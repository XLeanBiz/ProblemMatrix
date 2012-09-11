package co.problemmatrix.client.interviews.earlyadopters.edit;

import co.problemmatrix.client.home.ProblemMatrixPanel;
import co.problemmatrix.client.interviews.earlyadopters.ListEarlyAdoptersInterviewButton;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EditEarlyAdoptersInterviewPage extends VerticalPanel {

	public static JSONObject interview = new JSONObject();

	public EditEarlyAdoptersInterviewPage(JSONObject interviewParameter) {

		interview = interviewParameter;

		this.setSpacing(20);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		HorizontalPanel hp = new HorizontalPanel();

		hp.add(new EditEarlyAdoptersInterview(interview));

		hp.add(new EditEarlyAdoptersInterviewQuestions(interview, false));

		this.add(hp);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.add(new ButtonSaveEarlyAdoptersInterview());
	}

	public static void showButtons(final JSONObject interviewJson) {

		ProblemMatrixPanel.hpButtons.clear();

		ProblemMatrixPanel.hpButtons
				.add(new RefreshEarlyAdoptersInterviewButton(interviewJson));

		ProblemMatrixPanel.hpButtons
				.add(new ListEarlyAdoptersInterviewButton());
	}
}
