package co.problemmatrix.client.interviews.problems.edit;

import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

public class ButtonSaveProblemInterview extends Button {

	public ButtonSaveProblemInterview() {

		this.setText("Save Interview");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				// if (UniqueIDGlobalVariables.uniqueID != null) {

				getInterviewInformation();

				getInterviewQuestions();

				SaveProblemInterview.save(EditProblemInterviewPage.interview);

				// } else {

				// Window.alert("Please login.");
				// }
			}
		});

	}

	public static void getInterviewInformation() {

		ConvertJson.setStringValue(EditProblemInterviewPage.interview,
				EditProblemInterview.companyField.getValue(), "company");
		
		ConvertJson.setStringValue(EditProblemInterviewPage.interview,
				EditProblemInterview.personaField.getValue(), "persona");
		
		ConvertJson.setStringValue(EditProblemInterviewPage.interview,
				EditProblemInterview.interviewerField.getValue(),
				"interviewer");

		if (EditProblemInterview.dateTime.getValue() != null) {

			ConvertJson.setStringValue(EditProblemInterviewPage.interview, Long
					.toString(EditProblemInterview.dateTime.getValue()
							.getTime()), "datetime");
		}

		ConvertJson.setStringValue(EditProblemInterviewPage.interview,
				EditProblemInterview.customerNameField.getValue(),
				"customerName");

		ConvertJson.setStringValue(EditProblemInterviewPage.interview,
				EditProblemInterview.customerUniqueIDField.getValue(),
				"customerUniqueID");

		ConvertJson.setStringValue(EditProblemInterviewPage.interview,
				EditProblemInterview.videoURLField.getValue(), "videoURL");

		ConvertJson.setStringValue(EditProblemInterviewPage.interview,
				EditProblemInterview.notes.getHTML(), "notes");
	}

	public static void getInterviewQuestions() {

		ConvertJson.setStringValue(EditProblemInterviewPage.interview,
				EditProblemInterviewQuestions.problemField.getValue(),
				"problem");

		ConvertJson.setStringValue(EditProblemInterviewPage.interview,
				EditProblemInterviewQuestions.problemUnderstand.getHTML(),
				"problemUnderstand");

		ConvertJson.setStringValue(EditProblemInterviewPage.interview,
				EditProblemInterviewQuestions.haveProblem.getHTML(),
				"haveProblem");

		ConvertJson.setStringValue(EditProblemInterviewPage.interview,
				EditProblemInterviewQuestions.whyHaveProblem.getHTML(),
				"whyHaveProblem");

		ConvertJson
				.setStringValue(
						EditProblemInterviewPage.interview,
						EditProblemInterviewQuestions.problemRateField
								.getValue(EditProblemInterviewQuestions.problemRateField
										.getSelectedIndex()), "problemRate");

		ConvertJson.setStringValue(EditProblemInterviewPage.interview,
				EditProblemInterviewQuestions.make5Problem.getHTML(),
				"make5Problem");

		ConvertJson.setStringValue(EditProblemInterviewPage.interview,
				EditProblemInterviewQuestions.howSolvingProblem.getHTML(),
				"howSolvingProblem");

		ConvertJson.setStringValue(EditProblemInterviewPage.interview,
				EditProblemInterviewQuestions.howLikeSolvingProblem.getHTML(),
				"howLikeSolvingProblem");

		ConvertJson.setStringValue(EditProblemInterviewPage.interview,
				EditProblemInterviewQuestions.openComments.getHTML(),
				"openComments");
	}

}
