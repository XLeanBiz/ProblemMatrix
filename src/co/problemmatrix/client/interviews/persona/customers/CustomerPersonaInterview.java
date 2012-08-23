package co.problemmatrix.client.interviews.persona.customers;

import co.problemmatrix.client.interviews.persona.edit.EditPersonaInterview;
import co.problemmatrix.client.interviews.persona.edit.EditPersonaInterviewPage;
import co.problemmatrix.client.interviews.persona.edit.EditPersonaInterviewQuestions;
import co.problemmatrix.client.interviews.problems.customers.ButtonSaveCustomerProblemInterview;
import co.problemmatrix.client.utilities.FormField;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CustomerPersonaInterview extends VerticalPanel {

	public CustomerPersonaInterview(final String persona) {

		EditPersonaInterviewPage.interview = new JSONObject();

		this.setSpacing(20);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		ConvertJson.setStringValue(EditPersonaInterviewPage.interview, persona,
				"persona");

		String customerName = ConvertJson
				.convertToString(EditPersonaInterviewPage.interview
						.get("customerName"));
		EditPersonaInterview.customerNameField.setValue(customerName);
		EditPersonaInterview.customerNameField
				.addClickHandler(EditPersonaInterviewQuestions
						.getClickHandler());
		this.add(FormField.getFormField("Interviewee",
				EditPersonaInterview.customerNameField));
		EditPersonaInterview.customerNameField.setWidth("300px");

		this.add(new EditPersonaInterviewQuestions(
				EditPersonaInterviewPage.interview));

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.add(new ButtonSaveCustomerProblemInterview());
	}

}
