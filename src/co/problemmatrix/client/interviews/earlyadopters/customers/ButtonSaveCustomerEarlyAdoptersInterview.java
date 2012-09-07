package co.problemmatrix.client.interviews.earlyadopters.customers;

import java.util.Date;

import co.problemmatrix.client.interviews.earlyadopters.edit.ButtonSaveEarlyAdoptersInterview;
import co.problemmatrix.client.interviews.earlyadopters.edit.EditEarlyAdoptersInterview;
import co.problemmatrix.client.interviews.earlyadopters.edit.EditEarlyAdoptersInterviewPage;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

public class ButtonSaveCustomerEarlyAdoptersInterview extends Button {

	public ButtonSaveCustomerEarlyAdoptersInterview() {

		this.setText("Save Interview");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				prepareInterviewJson();
				SaveEarlyAdoptersInterview.save();
			}
		});

	}

	public static void prepareInterviewJson() {

		ConvertJson.setStringValue(EditEarlyAdoptersInterviewPage.interview,
				Long.toString((new Date()).getTime()), "datetime");

		ConvertJson.setStringValue(EditEarlyAdoptersInterviewPage.interview,
				EditEarlyAdoptersInterview.customerNameField.getText(),
				"customerName");

		ButtonSaveEarlyAdoptersInterview.getInterviewQuestions();

	}

}
