package co.problemmatrix.client.interviews.satisfaction.customers;

import co.problemmatrix.client.interviews.satisfaction.edit.EditSatisfactionInterview;
import co.problemmatrix.client.interviews.satisfaction.edit.EditSatisfactionInterviewPage;
import co.problemmatrix.client.interviews.satisfaction.edit.EditSatisfactionInterviewQuestions;
import co.problemmatrix.client.utilities.FormField;
import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CustomerSatisfactionInterview extends VerticalPanel {

	public CustomerSatisfactionInterview(final boolean shortInterview) {

		this.setSpacing(20);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		String company = ConvertJson
				.convertToString(UniqueIDGlobalVariables.companyUniqueID
						.get("ID"));
		ConvertJson.setStringValue(EditSatisfactionInterviewPage.interview,
				company, "company");
		EditSatisfactionInterview.companyField.setValue(company);

		String customerName = ConvertJson
				.convertToString(EditSatisfactionInterviewPage.interview
						.get("customerName"));
		EditSatisfactionInterview.customerNameField.setValue(customerName);
		EditSatisfactionInterview.customerNameField
				.addClickHandler(EditSatisfactionInterviewQuestions
						.getClickHandler());
		this.add(FormField.getFormField("Customer's Name",
				EditSatisfactionInterview.customerNameField));
		EditSatisfactionInterview.customerNameField.setWidth("300px");

		this.add(new EditSatisfactionInterviewQuestions(
				EditSatisfactionInterviewPage.interview, shortInterview));

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.add(new ButtonSaveCustomerSatisfactionInterview());
	}

}
