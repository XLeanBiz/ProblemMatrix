package co.problemmatrix.client.persona;

import co.problemmatrix.client.home.ProblemMatrixPanel;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Button;

public class ButtonEditPersona extends Button {

	public ButtonEditPersona(final JSONObject personaJson) {

		this.setText("Edit");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				ProblemMatrixPanel.vpMain.clear();
				ProblemMatrixPanel.vpMain.add(new EditPersona(personaJson));
				
				ProblemMatrixPanel.hpButtons.clear();
				ProblemMatrixPanel.hpButtons.add(new ButtonShowPersona(
						personaJson));
			}
		});

	}

}
