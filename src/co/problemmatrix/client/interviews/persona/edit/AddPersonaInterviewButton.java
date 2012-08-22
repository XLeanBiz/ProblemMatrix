package co.problemmatrix.client.interviews.persona.edit;

import co.problemmatrix.client.home.ProblemMatrixPanel;
import co.problemmatrix.client.interviews.persona.ListPersonaInterviewButton;
import co.problemmatrix.client.utilities.UseTracking;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Button;

public class AddPersonaInterviewButton extends Button {

	public AddPersonaInterviewButton(final String persona) {

		this.setText("Add Interview");

		this.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				new UseTracking(this.getClass().getName());

				JSONObject interview = new JSONObject();

				ConvertJson.setStringValue(interview, persona, "persona");

				ProblemMatrixPanel.vpMain.clear();
				ProblemMatrixPanel.vpMain.add(new EditPersonaInterviewPage(
						interview));

				ProblemMatrixPanel.hpButtons.clear();
				ProblemMatrixPanel.hpButtons
						.add(new ListPersonaInterviewButton(persona));
			}
		});
	}

}
