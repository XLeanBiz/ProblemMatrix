package co.problemmatrix.client.interviews.persona;

import java.util.Date;

import co.problemmatrix.client.home.ProblemMatrixPanel;
import co.problemmatrix.client.interviews.persona.edit.AddPersonaInterviewButton;
import co.problemmatrix.client.interviews.persona.edit.EditPersonaInterviewPage;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

public class PersonaInterviewsListPanel extends VerticalPanel {

	public PersonaInterviewsListPanel(JSONArray interviews) {

		this.setSpacing(20);

		for (int i = 0; i < interviews.size(); i++) {

			final JSONObject interviewJson = (JSONObject) interviews.get(i);

			final String datetime = ConvertJson.getStringValue(interviewJson,
					"datetime");

			final String customerName = ConvertJson.getStringValue(
					interviewJson, "customerName");

			final String personaID = ConvertJson.getStringValue(interviewJson,
					"persona");

			HTML html = new HTML(new Date(new Long(datetime))
					+ " - <a href=#><b>" + " " + customerName + "</b></a>");
			html.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {

					ProblemMatrixPanel.vpMain.clear();
					ProblemMatrixPanel.vpMain.add(new EditPersonaInterviewPage(
							interviewJson));

					ProblemMatrixPanel.hpButtons.clear();
					ProblemMatrixPanel.hpButtons
							.add(new AddPersonaInterviewButton(personaID));
				}
			});

			this.add(html);
		}
	}
}
