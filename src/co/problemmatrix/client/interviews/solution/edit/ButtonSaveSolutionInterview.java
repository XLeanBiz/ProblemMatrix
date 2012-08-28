package co.problemmatrix.client.interviews.solution.edit;

import java.util.Date;

import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

public class ButtonSaveSolutionInterview extends Button {

	public ButtonSaveSolutionInterview() {

		this.setText("Save Interview");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				prepareInterviewJson();

				getInterviewQuestions();

				SaveSolutionInterview.save(EditSolutionInterviewPage.interview);
			}
		});
	}

	public static void prepareInterviewJson() {

		if (UniqueIDGlobalVariables.companyUniqueID != null) {

			String companyUniqueID = ConvertJson
					.convertToString(UniqueIDGlobalVariables.companyUniqueID
							.get("ID"));

			ConvertJson.setStringValue(EditSolutionInterviewPage.interview,
					companyUniqueID, "company");
		}

		ConvertJson.setStringValue(EditSolutionInterviewPage.interview,
				EditSolutionInterview.interviewerField.getValue(),
				"interviewer");

		if (EditSolutionInterview.dateTime.getValue() != null) {

			ConvertJson.setStringValue(EditSolutionInterviewPage.interview,
					Long.toString(EditSolutionInterview.dateTime.getValue()
							.getTime()), "datetime");
		} else {

			ConvertJson.setStringValue(EditSolutionInterviewPage.interview,
					Long.toString((new Date()).getTime()), "datetime");
		}

		ConvertJson.setStringValue(EditSolutionInterviewPage.interview,
				EditSolutionInterview.customerNameField.getValue(),
				"customerName");

		ConvertJson.setStringValue(EditSolutionInterviewPage.interview,
				EditSolutionInterview.customerUniqueIDField.getValue(),
				"customerUniqueID");

		ConvertJson.setStringValue(EditSolutionInterviewPage.interview,
				EditSolutionInterview.videoURLField.getValue(), "videoURL");

		ConvertJson.setStringValue(EditSolutionInterviewPage.interview,
				EditSolutionInterview.notes.getHTML(), "notes");
	}

	public static void getInterviewQuestions() {

		ConvertJson.setStringValue(EditSolutionInterviewPage.interview,
				EditSolutionInterviewQuestions.solutionField.getValue(),
				"solution");

		ConvertJson.setStringValue(EditSolutionInterviewPage.interview,
				EditSolutionInterviewQuestions.solutionUnderstand.getHTML(),
				"solutionUnderstand");

		ConvertJson.setStringValue(EditSolutionInterviewPage.interview,
				EditSolutionInterviewQuestions.whyHaveSolution.getHTML(),
				"whyHaveSolution");

		ConvertJson
				.setStringValue(
						EditSolutionInterviewPage.interview,
						EditSolutionInterviewQuestions.solutionRateField
								.getValue(EditSolutionInterviewQuestions.solutionRateField
										.getSelectedIndex()), "solutionRate");

		ConvertJson.setStringValue(EditSolutionInterviewPage.interview,
				EditSolutionInterviewQuestions.makeMustHaveSolution.getHTML(),
				"makeMustHaveSolution");

		ConvertJson.setStringValue(EditSolutionInterviewPage.interview,
				EditSolutionInterviewQuestions.howTryingSolution.getHTML(),
				"howTryingSolution");

		ConvertJson.setStringValue(EditSolutionInterviewPage.interview,
				EditSolutionInterviewQuestions.openComments.getHTML(),
				"openComments");
	}

}
