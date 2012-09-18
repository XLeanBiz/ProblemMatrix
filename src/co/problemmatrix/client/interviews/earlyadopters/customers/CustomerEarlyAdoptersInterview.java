package co.problemmatrix.client.interviews.earlyadopters.customers;

import co.problemmatrix.client.interviews.earlyadopters.edit.EditEarlyAdoptersInterview;
import co.problemmatrix.client.interviews.earlyadopters.edit.EditEarlyAdoptersInterviewPage;
import co.problemmatrix.client.interviews.earlyadopters.edit.EditEarlyAdoptersInterviewQuestions;
import co.problemmatrix.client.utilities.FormField;
import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CustomerEarlyAdoptersInterview extends VerticalPanel {

	public CustomerEarlyAdoptersInterview(final boolean shortInterview) {

		this.setSpacing(20);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		String company = ConvertJson
				.convertToString(UniqueIDGlobalVariables.companyUniqueID
						.get("ID"));
		ConvertJson.setStringValue(EditEarlyAdoptersInterviewPage.interview,
				company, "company");
		EditEarlyAdoptersInterview.companyField.setValue(company);

		String customerName = ConvertJson
				.convertToString(EditEarlyAdoptersInterviewPage.interview
						.get("customerName"));
		EditEarlyAdoptersInterview.customerNameField.setValue(customerName);
		EditEarlyAdoptersInterview.customerNameField
				.addClickHandler(EditEarlyAdoptersInterviewQuestions
						.getClickHandler());
		this.add(FormField.getFormField("Customer's Name",
				EditEarlyAdoptersInterview.customerNameField));
		EditEarlyAdoptersInterview.customerNameField.setWidth("300px");

		this.add(new EditEarlyAdoptersInterviewQuestions(
				EditEarlyAdoptersInterviewPage.interview, shortInterview));

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.add(new ButtonSaveCustomerEarlyAdoptersInterview());
	}

}
