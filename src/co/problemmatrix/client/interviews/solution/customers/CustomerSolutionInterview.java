package co.problemmatrix.client.interviews.solution.customers;

import co.problemmatrix.client.interviews.problems.edit.EditProblemInterview;
import co.problemmatrix.client.interviews.solution.edit.EditSolutionInterview;
import co.problemmatrix.client.interviews.solution.edit.EditSolutionInterviewPage;
import co.problemmatrix.client.interviews.solution.edit.EditSolutionInterviewQuestions;
import co.problemmatrix.client.utilities.FormField;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CustomerSolutionInterview extends VerticalPanel {

	public CustomerSolutionInterview(final boolean shortInterview) {

		this.setSpacing(20);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		String customerName = ConvertJson
				.convertToString(EditSolutionInterviewPage.interview
						.get("customerName"));
		EditSolutionInterview.customerNameField.setValue(customerName);
		EditSolutionInterview.customerNameField
				.addClickHandler(EditSolutionInterviewQuestions
						.getClickHandler());
		this.add(FormField.getFormField("Interviewee",
				EditSolutionInterview.customerNameField));
		EditProblemInterview.customerNameField.setWidth("300px");

		this.add(new EditSolutionInterviewQuestions(
				EditSolutionInterviewPage.interview, shortInterview));

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.add(new ButtonSaveCustomerSolutionInterview());
	}

}
