package co.problemmatrix.client.interviews.problems.customers;

import java.util.Date;

import co.problemmatrix.client.interviews.problems.edit.ButtonSaveProblemInterview;
import co.problemmatrix.client.interviews.problems.edit.EditProblemInterview;
import co.problemmatrix.client.interviews.problems.edit.EditProblemInterviewPage;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

public class ButtonSaveCustomerProblemInterview extends Button {

	public ButtonSaveCustomerProblemInterview() {

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

		ConvertJson.setStringValue(EditProblemInterviewPage.interview,
				EditProblemInterview.companyField.getText(), "company");

		ConvertJson.setStringValue(EditProblemInterviewPage.interview,
				Long.toString((new Date()).getTime()), "datetime");

		ConvertJson.setStringValue(EditProblemInterviewPage.interview,
				EditProblemInterview.customerNameField.getText(),
				"customerName");

		ButtonSaveProblemInterview.getInterviewQuestions();

	}

}
