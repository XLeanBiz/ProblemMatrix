package co.problemmatrix.client.persona;

import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;

public class ButtonSavePersona extends Button {

	public ButtonSavePersona(final JSONObject personaJson) {

		this.setText("Save");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				if (EditPersona.customerSegment.getValue() != null
						&& !"".equals(EditPersona.customerSegment.getValue())) {

					ConvertJson.setStringValue(personaJson,
							EditPersona.customerSegment.getValue(), "ID");
					ConvertJson.setStringValue(personaJson,
							EditPersona.name.getValue(), "name");
					ConvertJson.setStringValue(personaJson,
							EditPersona.imageURL.getValue(), "imageURL");
					ConvertJson.setStringValue(personaJson,
							EditPersona.behaviors.getHTML(), "behaviors");
					ConvertJson.setStringValue(personaJson,
							EditPersona.demographics.getHTML(), "demographics");
					ConvertJson.setStringValue(personaJson,
							EditPersona.goals.getHTML(), "goals");
					ConvertJson.setStringValue(personaJson,
							EditPersona.needs.getHTML(), "needs");
					ConvertJson.setStringValue(personaJson,
							EditPersona.problems.getHTML(), "problems");
					ConvertJson.setStringValue(personaJson,
							EditPersona.whereToFind.getHTML(), "whereToFind");

					SavePersona.save(personaJson);
				} else {

					Window.alert("Please, enter the Type of the persona.");
				}
			}
		});
	}

}
