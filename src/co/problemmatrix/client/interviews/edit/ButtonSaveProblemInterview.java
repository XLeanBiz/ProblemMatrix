package co.problemmatrix.client.interviews.edit;

import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;

public class ButtonSaveProblemInterview extends Button {

	public ButtonSaveProblemInterview(final JSONObject interview) {

		this.setText("Save Interview");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				if (UniqueIDGlobalVariables.uniqueID != null) {

					getInterviewInformation(interview);

					getInterviewQuesitons(interview);

					SaveProblemInterview.save(interview);

				} else {

					Window.alert("Please login.");
				}
			}
		});

	}

	private void getInterviewInformation(JSONObject interview) {

		ConvertJson.setStringValue(interview,
				EditProblemInterview.personaField.getValue(), "persona");

		ConvertJson.setStringValue(interview, Long
				.toString(EditProblemInterview.dateTime.getValue().getTime()),
				"datetime");

		ConvertJson.setStringValue(interview,
				EditProblemInterview.customerNameField.getValue(),
				"customerName");

		ConvertJson.setStringValue(interview,
				EditProblemInterview.customerUniqueIDField.getValue(),
				"customerUniqueID");

		ConvertJson.setStringValue(interview,
				EditProblemInterview.videoURLField.getValue(), "videoURL");

		ConvertJson.setStringValue(interview,
				EditProblemInterview.notes.getHTML(), "notes");
	}

	private void getInterviewQuesitons(JSONObject interview) {

		ConvertJson.setStringValue(interview,
				EditProblemInterviewQuestions.problemField.getValue(),
				"problem");

		ConvertJson.setStringValue(interview,
				EditProblemInterviewQuestions.problemUnderstand.getHTML(),
				"problemUnderstand");

		ConvertJson.setStringValue(interview,
				EditProblemInterviewQuestions.haveProblem.getHTML(),
				"haveProblem");

		ConvertJson.setStringValue(interview,
				EditProblemInterviewQuestions.whyHaveProblem.getHTML(),
				"whyHaveProblem");

		ConvertJson
				.setStringValue(
						interview,
						EditProblemInterviewQuestions.problemRateField
								.getValue(EditProblemInterviewQuestions.problemRateField
										.getSelectedIndex()), "problemRate");

		ConvertJson.setStringValue(interview,
				EditProblemInterviewQuestions.make5Problem.getHTML(),
				"make5Problem");

		ConvertJson.setStringValue(interview,
				EditProblemInterviewQuestions.howSolvingProblem.getHTML(),
				"howSolvingProblem");

		ConvertJson.setStringValue(interview,
				EditProblemInterviewQuestions.howLikeSolvingProblem.getHTML(),
				"howLikeSolvingProblem");

		ConvertJson.setStringValue(interview,
				EditProblemInterviewQuestions.openComments.getHTML(),
				"openComments");
	}

}
