package co.problemmatrix.client.interviews.problems.customers;

import co.problemmatrix.client.interviews.problems.edit.EditProblemInterviewPage;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CustomerProblemInterviewPage extends VerticalPanel {

	public CustomerProblemInterviewPage(final String problemName) {

		EditProblemInterviewPage.interview = new JSONObject();

		ConvertJson.setStringValue(EditProblemInterviewPage.interview,
				problemName, "problem");

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.setWidth("100%");

		VerticalPanel vp = new VerticalPanel();

		FlexTable table = new FlexTable();
		table.setCellPadding(0);
		table.setCellSpacing(0);
		table.setStyleName("flextable");
		table.setWidget(0, 0, vp);

		vp.add(new CustomerProblemInterview());

		this.add(table);
	}
}
