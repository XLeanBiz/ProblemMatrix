package co.problemmatrix.client.interviews.persona.edit;

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

				ConvertJson.setStringValue(interview,
						EditPersonaInterview.interviewerField.getValue(),
						"interviewer");

				ConvertJson
						.setStringValue(interview,
								EditPersonaInterview.personaField.getValue(),
								"persona");

				ConvertJson.setStringValue(interview, Long
						.toString(EditPersonaInterview.dateTime.getValue()
								.getTime()), "datetime");

				ConvertJson.setStringValue(interview,
						EditPersonaInterview.customerNameField.getValue(),
						"customerName");

				ConvertJson.setStringValue(interview,
						EditPersonaInterview.customerUniqueIDField.getValue(),
						"customerUniqueID");

				ConvertJson.setStringValue(interview,
						EditPersonaInterview.videoURLField.getValue(),
						"videoURL");

				ConvertJson.setStringValue(interview,
						EditPersonaInterview.notes.getHTML(), "notes");

				getInterviewQuesitons(interview);

				SavePersonaInterview.save(interview);
			}
		});

	}

	private void getInterviewQuesitons(JSONObject interview) {

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
