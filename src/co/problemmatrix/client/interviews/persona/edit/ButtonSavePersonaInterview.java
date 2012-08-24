package co.problemmatrix.client.interviews.persona.edit;

import java.util.Date;

import co.problemmatrix.client.interviews.problems.edit.EditProblemInterviewPage;
import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

public class ButtonSavePersonaInterview extends Button {

	public ButtonSavePersonaInterview() {

		this.setText("Save Interview");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				prepareInterviewJson();

				getInterviewQuestions();

				SavePersonaInterview.save(EditPersonaInterviewPage.interview);
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

		ConvertJson
				.setStringValue(EditPersonaInterviewPage.interview,
						EditPersonaInterview.interviewerField.getValue(),
						"interviewer");

		ConvertJson.setStringValue(EditPersonaInterviewPage.interview,
				EditPersonaInterview.personaField.getValue(), "persona");

		if (EditPersonaInterview.dateTime.getValue() != null) {

			ConvertJson.setStringValue(EditPersonaInterviewPage.interview, Long
					.toString(EditPersonaInterview.dateTime.getValue()
							.getTime()), "datetime");
		} else {
			
			ConvertJson.setStringValue(EditPersonaInterviewPage.interview,
					Long.toString((new Date()).getTime()), "datetime");
		}

		ConvertJson.setStringValue(EditPersonaInterviewPage.interview,
				EditPersonaInterview.customerNameField.getValue(),
				"customerName");

		ConvertJson.setStringValue(EditPersonaInterviewPage.interview,
				EditPersonaInterview.customerUniqueIDField.getValue(),
				"customerUniqueID");

		ConvertJson.setStringValue(EditPersonaInterviewPage.interview,
				EditPersonaInterview.videoURLField.getValue(), "videoURL");

		ConvertJson.setStringValue(EditPersonaInterviewPage.interview,
				EditPersonaInterview.notes.getHTML(), "notes");
	}

	public static void getInterviewQuestions() {

		ConvertJson.setStringValue(EditPersonaInterviewPage.interview,
				EditPersonaInterviewQuestions.describeYourself.getHTML(),
				"describeYourself");

		ConvertJson.setStringValue(EditPersonaInterviewPage.interview,
				EditPersonaInterviewQuestions.routine.getHTML(), "routine");

		ConvertJson.setStringValue(EditPersonaInterviewPage.interview,
				EditPersonaInterviewQuestions.goals.getHTML(), "goals");

		ConvertJson.setStringValue(EditPersonaInterviewPage.interview,
				EditPersonaInterviewQuestions.mainProblems.getHTML(),
				"mainProblems");

		ConvertJson.setStringValue(EditPersonaInterviewPage.interview,
				EditPersonaInterviewQuestions.findOthers.getHTML(),
				"findOthers");

		ConvertJson.setStringValue(EditPersonaInterviewPage.interview,
				EditPersonaInterviewQuestions.openComments.getHTML(),
				"openComments");
	}

}
