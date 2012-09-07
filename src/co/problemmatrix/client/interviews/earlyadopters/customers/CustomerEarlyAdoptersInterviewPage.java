package co.problemmatrix.client.interviews.earlyadopters.customers;

import co.problemmatrix.client.interviews.earlyadopters.edit.EditEarlyAdoptersInterviewPage;
import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CustomerEarlyAdoptersInterviewPage extends VerticalPanel {

	public CustomerEarlyAdoptersInterviewPage(final String solutionName,
			final boolean shortInterview) {

		EditEarlyAdoptersInterviewPage.interview = new JSONObject();

		if (UniqueIDGlobalVariables.companyUniqueID != null) {

			String companyUniqueID = ConvertJson
					.convertToString(UniqueIDGlobalVariables.companyUniqueID
							.get("ID"));

			ConvertJson.setStringValue(
					EditEarlyAdoptersInterviewPage.interview, companyUniqueID,
					"company");
		}

		ConvertJson.setStringValue(EditEarlyAdoptersInterviewPage.interview,
				solutionName, "solution");

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.setWidth("100%");

		VerticalPanel vp = new VerticalPanel();

		FlexTable table = new FlexTable();
		table.setCellPadding(0);
		table.setCellSpacing(0);
		table.setStyleName("flextable");
		table.setWidget(0, 0, vp);

		vp.add(new CustomerEarlyAdoptersInterview(shortInterview));

		this.add(table);
	}
}
