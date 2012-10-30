package co.problemmatrix.client.interviews.satisfaction.customers;

import co.problemmatrix.client.interviews.satisfaction.edit.EditSatisfactionInterviewPage;
import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CustomerSatisfactionInterviewPage extends VerticalPanel {

	public CustomerSatisfactionInterviewPage(final String featureName,
			final boolean shortInterview) {

		EditSatisfactionInterviewPage.interview = new JSONObject();

		if (UniqueIDGlobalVariables.companyUniqueID != null) {

			String companyUniqueID = ConvertJson
					.convertToString(UniqueIDGlobalVariables.companyUniqueID
							.get("ID"));

			ConvertJson.setStringValue(EditSatisfactionInterviewPage.interview,
					companyUniqueID, "company");
		}

		ConvertJson.setStringValue(EditSatisfactionInterviewPage.interview,
				featureName, "feature");

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.setWidth("100%");

		VerticalPanel vp = new VerticalPanel();

		FlexTable table = new FlexTable();
		table.setCellPadding(0);
		table.setCellSpacing(0);
		table.setStyleName("flextable");
		table.setWidget(0, 0, vp);

		vp.add(new CustomerSatisfactionInterview(shortInterview));

		this.add(table);
	}
}
