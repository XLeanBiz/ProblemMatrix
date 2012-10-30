package co.problemmatrix.client.interviews.satisfaction.edit;

import java.util.Date;

import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

public class ButtonSaveSatisfactionInterview extends Button {

	public ButtonSaveSatisfactionInterview() {

		this.setText("Save Interview");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				prepareInterviewJson();

				getInterviewQuestions();

				SaveSatisfactionInterview
						.save(EditSatisfactionInterviewPage.interview);
			}
		});
	}

	public static void prepareInterviewJson() {

		ConvertJson.setStringValue(EditSatisfactionInterviewPage.interview,
				EditSatisfactionInterview.companyField.getValue(), "company");

		ConvertJson.setStringValue(EditSatisfactionInterviewPage.interview,
				EditSatisfactionInterview.personaField.getValue(), "persona");

		ConvertJson.setStringValue(EditSatisfactionInterviewPage.interview,
				EditSatisfactionInterview.interviewerField.getValue(),
				"interviewer");

		if (EditSatisfactionInterview.dateTime.getValue() != null) {

			ConvertJson.setStringValue(EditSatisfactionInterviewPage.interview,
					Long.toString(EditSatisfactionInterview.dateTime.getValue()
							.getTime()), "datetime");
		} else {

			ConvertJson.setStringValue(EditSatisfactionInterviewPage.interview,
					Long.toString((new Date()).getTime()), "datetime");
		}

		ConvertJson.setStringValue(EditSatisfactionInterviewPage.interview,
				EditSatisfactionInterview.customerNameField.getValue(),
				"customerName");

		ConvertJson.setStringValue(EditSatisfactionInterviewPage.interview,
				EditSatisfactionInterview.customerUniqueIDField.getValue(),
				"customerUniqueID");

		ConvertJson.setStringValue(EditSatisfactionInterviewPage.interview,
				EditSatisfactionInterview.videoURLField.getValue(), "videoURL");

		ConvertJson.setStringValue(EditSatisfactionInterviewPage.interview,
				EditSatisfactionInterview.notes.getHTML(), "notes");
	}

	public static void getInterviewQuestions() {

		ConvertJson.setStringValue(EditSatisfactionInterviewPage.interview,
				EditSatisfactionInterviewQuestions.featureField.getValue(),
				"feature");

		ConvertJson
				.setStringValue(
						EditSatisfactionInterviewPage.interview,
						EditSatisfactionInterviewQuestions.satisfactionRateField
								.getValue(EditSatisfactionInterviewQuestions.satisfactionRateField
										.getSelectedIndex()),
						"satisfactionRate");

		ConvertJson.setStringValue(EditSatisfactionInterviewPage.interview,
				EditSatisfactionInterviewQuestions.whyFeature.getHTML(),
				"whyFeature");

		ConvertJson.setStringValue(EditSatisfactionInterviewPage.interview,
				EditSatisfactionInterviewQuestions.improveFeature.getHTML(),
				"improveFeature");

		ConvertJson.setStringValue(EditSatisfactionInterviewPage.interview,
				EditSatisfactionInterviewQuestions.disappointedNoFeature
						.getHTML(), "disappointedNoFeature");

		ConvertJson.setStringValue(EditSatisfactionInterviewPage.interview,
				EditSatisfactionInterviewQuestions.openComments.getHTML(),
				"openComments");
	}

}
