package co.problemmatrix.client.interviews.persona.customers;

import co.problemmatrix.client.interviews.persona.edit.EditPersonaInterview;
import co.problemmatrix.client.interviews.persona.edit.EditPersonaInterviewPage;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CustomerPersonaInterviewPage extends VerticalPanel {

	public CustomerPersonaInterviewPage(final String personaID) {

		EditPersonaInterviewPage.interview = new JSONObject();

		ConvertJson.setStringValue(EditPersonaInterviewPage.interview,
				personaID, "persona");
		EditPersonaInterview.personaField.setValue(personaID);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.setWidth("100%");

		VerticalPanel vp = new VerticalPanel();

		FlexTable table = new FlexTable();
		table.setCellPadding(0);
		table.setCellSpacing(0);
		table.setStyleName("flextable");
		table.setWidget(0, 0, vp);

		vp.add(new CustomerPersonaInterview(personaID));

		this.add(table);
	}
}
