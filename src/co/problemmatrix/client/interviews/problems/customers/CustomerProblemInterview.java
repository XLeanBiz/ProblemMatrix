package co.problemmatrix.client.interviews.problems.customers;

import co.problemmatrix.client.interviews.problems.edit.EditProblemInterview;
import co.problemmatrix.client.interviews.problems.edit.EditProblemInterviewPage;
import co.problemmatrix.client.interviews.problems.edit.EditProblemInterviewQuestions;
import co.problemmatrix.client.utilities.FormField;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CustomerProblemInterview extends VerticalPanel {

	public CustomerProblemInterview(final boolean shortInterview) {

		this.setSpacing(20);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		String company = ConvertJson
				.convertToString(EditProblemInterviewPage.interview
						.get("company"));
		EditProblemInterview.companyField.setValue(company);
		EditProblemInterview.companyField
				.addClickHandler(EditProblemInterviewQuestions
						.getClickHandler());
		// this.add(FormField.getFormField("Interviewer's company",
		// EditProblemInterview.companyField));
		EditProblemInterview.companyField.setWidth("300px");

		String customerName = ConvertJson
				.convertToString(EditProblemInterviewPage.interview
						.get("customerName"));
		EditProblemInterview.customerNameField.setValue(customerName);
		EditProblemInterview.customerNameField
				.addClickHandler(EditProblemInterviewQuestions
						.getClickHandler());
		this.add(FormField.getFormField("Your Name",
				EditProblemInterview.customerNameField));
		EditProblemInterview.customerNameField.setWidth("300px");

		this.add(new EditProblemInterviewQuestions(shortInterview));

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.add(new ButtonSaveCustomerProblemInterview());
	}

}
