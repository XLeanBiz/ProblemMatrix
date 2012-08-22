package co.problemmatrix.client.interviews.problems.edit;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EditProblemInterviewPage extends VerticalPanel {

	public EditProblemInterviewPage(JSONObject interview) {
		
		this.setSpacing(20);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		HorizontalPanel hp = new HorizontalPanel();

		hp.add(new EditProblemInterview(interview));

		hp.add(new EditProblemInterviewQuestions(interview));

		this.add(hp);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.add(new ButtonSaveProblemInterview(interview));
	}
}
