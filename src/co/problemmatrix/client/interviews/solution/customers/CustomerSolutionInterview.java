package co.problemmatrix.client.interviews.solution.customers;

import co.problemmatrix.client.interviews.problems.edit.EditProblemInterview;
import co.problemmatrix.client.interviews.solution.edit.EditSolutionInterview;
import co.problemmatrix.client.interviews.solution.edit.EditSolutionInterviewPage;
import co.problemmatrix.client.interviews.solution.edit.EditSolutionInterviewQuestions;
import co.problemmatrix.client.utilities.FormField;
import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CustomerSolutionInterview extends VerticalPanel {

	public CustomerSolutionInterview(final boolean shortInterview) {

		this.setSpacing(20);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		String company = ConvertJson
				.convertToString(UniqueIDGlobalVariables.companyUniqueID
						.get("ID"));
		ConvertJson.setStringValue(EditSolutionInterviewPage.interview,
				company, "company");
		EditSolutionInterview.companyField.setValue(company);

		String customerName = ConvertJson
				.convertToString(EditSolutionInterviewPage.interview
						.get("customerName"));
		EditSolutionInterview.customerNameField.setValue(customerName);
		EditSolutionInterview.customerNameField
				.addClickHandler(EditSolutionInterviewQuestions
						.getClickHandler());
		this.add(FormField.getFormField("Customer's Name",
				EditSolutionInterview.customerNameField));
		EditSolutionInterview.customerNameField.setWidth("300px");

		this.add(new EditSolutionInterviewQuestions(
				EditSolutionInterviewPage.interview, shortInterview));

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.add(new ButtonSaveCustomerSolutionInterview());
	}

}
