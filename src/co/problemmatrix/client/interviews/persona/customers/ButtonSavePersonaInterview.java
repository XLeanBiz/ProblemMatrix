package co.problemmatrix.client.interviews.persona.customers;

import java.util.Date;

import co.problemmatrix.client.interviews.persona.edit.EditPersonaInterviewQuestions;
import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Button;

public class ButtonSavePersonaInterview extends Button {

	public ButtonSavePersonaInterview(final JSONObject interview) {

		this.setText("Save Interview");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				prepareInterviewJson();
				SavePersonaInterview.save();
			}
		});

	}

	public static void prepareInterviewJson() {

		String companyUniqueID = ConvertJson
				.convertToString(UniqueIDGlobalVariables.companyUniqueID
						.get("ID"));

		ConvertJson.setStringValue(CustomerPersonaInterview.interview,
				companyUniqueID, "company");

		ConvertJson.setStringValue(CustomerPersonaInterview.interview,
				Long.toString((new Date()).getTime()), "datetime");

		ConvertJson.setStringValue(CustomerPersonaInterview.interview,
				CustomerPersonaInterview.customerNameField.getText(),
				"customerName");

		getInterviewQuestions(CustomerPersonaInterview.interview);

	}

	private static void getInterviewQuestions(JSONObject interview) {

		ConvertJson.setStringValue(interview,
				EditPersonaInterviewQuestions.describeYourself.getHTML(),
				"describeYourself");

		ConvertJson.setStringValue(interview,
				EditPersonaInterviewQuestions.routine.getHTML(), "routine");

		ConvertJson.setStringValue(interview,
				EditPersonaInterviewQuestions.goals.getHTML(), "goals");

		ConvertJson.setStringValue(interview,
				EditPersonaInterviewQuestions.mainProblems.getHTML(),
				"mainProblems");

		ConvertJson.setStringValue(interview,
				EditPersonaInterviewQuestions.findOthers.getHTML(),
				"findOthers");

		ConvertJson.setStringValue(interview,
				EditPersonaInterviewQuestions.openComments.getHTML(),
				"openComments");
	}

}
