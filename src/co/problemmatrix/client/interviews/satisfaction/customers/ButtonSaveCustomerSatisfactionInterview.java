package co.problemmatrix.client.interviews.satisfaction.customers;

import java.util.Date;

import co.problemmatrix.client.interviews.satisfaction.edit.ButtonSaveSatisfactionInterview;
import co.problemmatrix.client.interviews.satisfaction.edit.EditSatisfactionInterview;
import co.problemmatrix.client.interviews.satisfaction.edit.EditSatisfactionInterviewPage;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

public class ButtonSaveCustomerSatisfactionInterview extends Button {

	public ButtonSaveCustomerSatisfactionInterview() {

		this.setText("Save Interview");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				prepareInterviewJson();
				SaveSatisfactionInterview.save();
			}
		});

	}

	public static void prepareInterviewJson() {

		ConvertJson.setStringValue(EditSatisfactionInterviewPage.interview,
				Long.toString((new Date()).getTime()), "datetime");

		ConvertJson.setStringValue(EditSatisfactionInterviewPage.interview,
				EditSatisfactionInterview.customerNameField.getText(),
				"customerName");

		ButtonSaveSatisfactionInterview.getInterviewQuestions();

	}

}
