package co.problemmatrix.client.interviews.problems.customers;

import co.problemmatrix.client.interviews.problems.edit.EditProblemInterview;
import co.problemmatrix.client.interviews.problems.edit.EditProblemInterviewPage;
import co.problemmatrix.client.interviews.problems.edit.EditProblemInterviewQuestions;
import co.problemmatrix.client.utilities.FormField;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CustomerProblemInterview extends VerticalPanel {

	public CustomerProblemInterview() {

		this.setSpacing(20);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		String customerName = ConvertJson
				.convertToString(EditProblemInterviewPage.interview
						.get("customerName"));
		EditProblemInterview.customerNameField.setValue(customerName);
		EditProblemInterview.customerNameField
				.addClickHandler(EditProblemInterviewQuestions
						.getClickHandler());
		this.add(FormField.getFormField("Interviewee",
				EditProblemInterview.customerNameField));
		EditProblemInterview.customerNameField.setWidth("300px");

		this.add(new EditProblemInterviewQuestions());

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.add(new ButtonSaveCustomerProblemInterview());
	}

}
