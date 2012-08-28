package co.problemmatrix.client.interviews.solution.customers;

import co.problemmatrix.client.interviews.solution.edit.EditSolutionInterviewPage;
import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CustomerSolutionInterviewPage extends VerticalPanel {

	public CustomerSolutionInterviewPage(final String solutionName,
			final boolean shortInterview) {

		EditSolutionInterviewPage.interview = new JSONObject();

		if (UniqueIDGlobalVariables.companyUniqueID != null) {

			String companyUniqueID = ConvertJson
					.convertToString(UniqueIDGlobalVariables.companyUniqueID
							.get("ID"));

			ConvertJson.setStringValue(EditSolutionInterviewPage.interview,
					companyUniqueID, "company");
		}

		ConvertJson.setStringValue(EditSolutionInterviewPage.interview,
				solutionName, "solution");

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.setWidth("100%");

		VerticalPanel vp = new VerticalPanel();

		FlexTable table = new FlexTable();
		table.setCellPadding(0);
		table.setCellSpacing(0);
		table.setStyleName("flextable");
		table.setWidget(0, 0, vp);

		vp.add(new CustomerSolutionInterview(shortInterview));

		this.add(table);
	}
}
