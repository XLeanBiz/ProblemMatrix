package co.problemmatrix.client.interviews.solution.customers;

import java.util.Date;

import co.problemmatrix.client.interviews.solution.edit.ButtonSaveSolutionInterview;
import co.problemmatrix.client.interviews.solution.edit.EditSolutionInterview;
import co.problemmatrix.client.interviews.solution.edit.EditSolutionInterviewPage;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

public class ButtonSaveCustomerSolutionInterview extends Button {

	public ButtonSaveCustomerSolutionInterview() {

		this.setText("Save Interview");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				prepareInterviewJson();
				SaveSolutionInterview.save();
			}
		});

	}

	public static void prepareInterviewJson() {

		ConvertJson.setStringValue(EditSolutionInterviewPage.interview,
				Long.toString((new Date()).getTime()), "datetime");

		ConvertJson.setStringValue(EditSolutionInterviewPage.interview,
				EditSolutionInterview.customerNameField.getText(),
				"customerName");

		ButtonSaveSolutionInterview.getInterviewQuestions();

	}

}
