package co.problemmatrix.client.interviews.persona.edit;

import co.problemmatrix.client.home.ProblemMatrixPanel;
import co.problemmatrix.client.interviews.persona.ListPersonaInterviewButton;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EditPersonaInterviewPage extends VerticalPanel {

	public static JSONObject interview = new JSONObject();

	public EditPersonaInterviewPage(JSONObject interviewParameter) {

		interview = interviewParameter;

		this.setSpacing(20);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		HorizontalPanel hp = new HorizontalPanel();

		hp.add(new EditPersonaInterview(interview));

		hp.add(new EditPersonaInterviewQuestions(interview, false));

		this.add(hp);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.add(new ButtonSavePersonaInterview());
	}

	public static void showButtons(final JSONObject interviewJson,
			final String persona) {

		ProblemMatrixPanel.hpButtons.clear();

		ProblemMatrixPanel.hpButtons.add(new RefreshPersonaInterviewButton(
				interviewJson, persona));

		ProblemMatrixPanel.hpButtons
				.add(new ListPersonaInterviewButton(persona));
	}
}
