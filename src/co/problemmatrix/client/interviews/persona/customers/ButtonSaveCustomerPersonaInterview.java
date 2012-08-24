package co.problemmatrix.client.interviews.persona.customers;

import java.util.Date;

import co.problemmatrix.client.interviews.persona.edit.ButtonSavePersonaInterview;
import co.problemmatrix.client.interviews.persona.edit.EditPersonaInterview;
import co.problemmatrix.client.interviews.persona.edit.EditPersonaInterviewPage;
import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

public class ButtonSaveCustomerPersonaInterview extends Button {

	public ButtonSaveCustomerPersonaInterview() {

		this.setText("Save Interview");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				prepareInterviewJson();
				ButtonSavePersonaInterview.getInterviewQuestions();
				SavePersonaInterview.save();
			}
		});

	}

	public static void prepareInterviewJson() {

		if (UniqueIDGlobalVariables.companyUniqueID != null) {

			String companyUniqueID = ConvertJson
					.convertToString(UniqueIDGlobalVariables.companyUniqueID
							.get("ID"));

			ConvertJson.setStringValue(EditPersonaInterviewPage.interview,
					companyUniqueID, "company");
		}

		ConvertJson.setStringValue(EditPersonaInterviewPage.interview,
				Long.toString((new Date()).getTime()), "datetime");

		ConvertJson.setStringValue(EditPersonaInterviewPage.interview,
				EditPersonaInterview.customerNameField.getText(),
				"customerName");
	}

}
