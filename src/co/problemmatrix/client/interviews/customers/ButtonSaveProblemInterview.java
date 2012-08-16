package co.problemmatrix.client.interviews.customers;

import java.util.Date;

import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
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

				prepareInterviewJson();
				SaveProblemInterview.save();
			}
		});

	}

	public static void prepareInterviewJson() {

		String companyUniqueID = ConvertJson
				.convertToString(UniqueIDGlobalVariables.companyUniqueID
						.get("ID"));

		ConvertJson.setStringValue(CustomerProblemInterview.interview,
				companyUniqueID, "company");

		ConvertJson.setStringValue(CustomerProblemInterview.interview,
				Long.toString((new Date()).getTime()), "datetime");

		ConvertJson.setStringValue(CustomerProblemInterview.interview,
				CustomerProblemInterview.customerNameField.getText(),
				"customerName");

		ConvertJson.setStringValue(CustomerProblemInterview.interview,
				CustomerProblemInterview.problemNameField.getText(), "problem");

		getInterviewQuesitons();

	}

	private static void getInterviewQuesitons() {

		ConvertJson.setStringValue(CustomerProblemInterview.interview,
				CustomerProblemInterview.problemUnderstand.getHTML(),
				"problemUnderstand");

		ConvertJson.setStringValue(CustomerProblemInterview.interview,
				CustomerProblemInterview.haveProblem.getHTML(), "haveProblem");

		ConvertJson.setStringValue(CustomerProblemInterview.interview,
				CustomerProblemInterview.whyHaveProblem.getHTML(),
				"whyHaveProblem");

		ConvertJson.setStringValue(CustomerProblemInterview.interview,
				CustomerProblemInterview.problemRateField
						.getValue(CustomerProblemInterview.problemRateField
								.getSelectedIndex()), "problemRate");

		ConvertJson.setStringValue(CustomerProblemInterview.interview,
				CustomerProblemInterview.howSolvingProblem.getHTML(),
				"howSolvingProblem");

		ConvertJson.setStringValue(CustomerProblemInterview.interview,
				CustomerProblemInterview.howLikeSolvingProblem.getHTML(),
				"howLikeSolvingProblem");

		ConvertJson
				.setStringValue(CustomerProblemInterview.interview,
						CustomerProblemInterview.make5Problem.getHTML(),
						"make5Problem");

		ConvertJson
				.setStringValue(CustomerProblemInterview.interview,
						CustomerProblemInterview.openComments.getHTML(),
						"openComments");
	}

}
