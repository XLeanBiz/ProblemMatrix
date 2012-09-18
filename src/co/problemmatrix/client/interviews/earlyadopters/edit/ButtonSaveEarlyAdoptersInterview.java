package co.problemmatrix.client.interviews.earlyadopters.edit;

import java.util.Date;

import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

public class ButtonSaveEarlyAdoptersInterview extends Button {

	public ButtonSaveEarlyAdoptersInterview() {

		this.setText("Save Interview");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				prepareInterviewJson();

				getInterviewQuestions();

				SaveEarlyAdoptersInterview
						.save(EditEarlyAdoptersInterviewPage.interview);
			}
		});
	}

	public static void prepareInterviewJson() {

		ConvertJson.setStringValue(EditEarlyAdoptersInterviewPage.interview,
				EditEarlyAdoptersInterview.companyField.getValue(), "company");
		
		ConvertJson.setStringValue(EditEarlyAdoptersInterviewPage.interview,
				EditEarlyAdoptersInterview.personaField.getValue(), "persona");

		ConvertJson.setStringValue(EditEarlyAdoptersInterviewPage.interview,
				EditEarlyAdoptersInterview.interviewerField.getValue(),
				"interviewer");

		if (EditEarlyAdoptersInterview.dateTime.getValue() != null) {

			ConvertJson.setStringValue(
					EditEarlyAdoptersInterviewPage.interview, Long
							.toString(EditEarlyAdoptersInterview.dateTime
									.getValue().getTime()), "datetime");
		} else {

			ConvertJson.setStringValue(
					EditEarlyAdoptersInterviewPage.interview,
					Long.toString((new Date()).getTime()), "datetime");
		}

		ConvertJson.setStringValue(EditEarlyAdoptersInterviewPage.interview,
				EditEarlyAdoptersInterview.customerNameField.getValue(),
				"customerName");

		ConvertJson.setStringValue(EditEarlyAdoptersInterviewPage.interview,
				EditEarlyAdoptersInterview.customerUniqueIDField.getValue(),
				"customerUniqueID");

		ConvertJson
				.setStringValue(EditEarlyAdoptersInterviewPage.interview,
						EditEarlyAdoptersInterview.videoURLField.getValue(),
						"videoURL");

		ConvertJson.setStringValue(EditEarlyAdoptersInterviewPage.interview,
				EditEarlyAdoptersInterview.notes.getHTML(), "notes");
	}

	public static void getInterviewQuestions() {

		ConvertJson.setStringValue(EditEarlyAdoptersInterviewPage.interview,
				EditEarlyAdoptersInterviewQuestions.solutionField.getValue(),
				"solution");

		ConvertJson
				.setStringValue(
						EditEarlyAdoptersInterviewPage.interview,
						EditEarlyAdoptersInterviewQuestions.earlyAdopterRateField
								.getValue(EditEarlyAdoptersInterviewQuestions.earlyAdopterRateField
										.getSelectedIndex()),
						"earlyAdopterRate");

		ConvertJson.setStringValue(EditEarlyAdoptersInterviewPage.interview,
				EditEarlyAdoptersInterviewQuestions.whyEarlyAdopter.getHTML(),
				"whyEarlyAdopter");

		ConvertJson.setStringValue(EditEarlyAdoptersInterviewPage.interview,
				EditEarlyAdoptersInterviewQuestions.threeMeetings.getHTML(),
				"threeMeetings");

		ConvertJson.setStringValue(EditEarlyAdoptersInterviewPage.interview,
				EditEarlyAdoptersInterviewQuestions.emailEarlyAdopter
						.getValue(), "emailEarlyAdopter");
		
		ConvertJson.setStringValue(EditEarlyAdoptersInterviewPage.interview,
				EditEarlyAdoptersInterviewQuestions.mustHaveFeatures.getHTML(),
				"mustHaveFeatures");

		ConvertJson.setStringValue(EditEarlyAdoptersInterviewPage.interview,
				EditEarlyAdoptersInterviewQuestions.openComments.getHTML(),
				"openComments");
	}

}
