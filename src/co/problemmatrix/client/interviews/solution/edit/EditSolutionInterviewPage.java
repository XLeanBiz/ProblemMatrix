package co.problemmatrix.client.interviews.solution.edit;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EditSolutionInterviewPage extends VerticalPanel {

	public static JSONObject interview = new JSONObject();

	public EditSolutionInterviewPage(JSONObject interviewParameter) {

		interview = interviewParameter;

		this.setSpacing(20);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		HorizontalPanel hp = new HorizontalPanel();

		hp.add(new EditSolutionInterview(interview));

		hp.add(new EditSolutionInterviewQuestions(interview, false));

		this.add(hp);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.add(new ButtonSaveSolutionInterview());
	}
}
