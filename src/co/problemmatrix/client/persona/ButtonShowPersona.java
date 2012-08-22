package co.problemmatrix.client.persona;

import co.problemmatrix.client.home.ProblemMatrixPanel;
import co.problemmatrix.client.interviews.persona.ListPersonaInterviewButton;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Button;

public class ButtonShowPersona extends Button {

	public ButtonShowPersona(final String personaID) {

		this.setText("Show Persona");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				GetPersona.get(personaID);
			}
		});

	}

	public ButtonShowPersona(final JSONObject personaJson) {

		this.setText("Show Persona");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				ProblemMatrixPanel.vpMain.clear();
				ProblemMatrixPanel.vpMain.add(new ShowPersona(personaJson));

				String personaID = ConvertJson.convertToString(personaJson
						.get("ID"));

				ProblemMatrixPanel.hpButtons.clear();
				ProblemMatrixPanel.hpButtons.add(new ButtonEditPersona(
						personaJson));
				ProblemMatrixPanel.hpButtons
						.add(new ListPersonaInterviewButton(personaID));

			}
		});

	}

}
